package controllers;

import dao.MonAnDAO;
import dao.ThongKeDAO;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utils.MsgBox;
import utils.XInit;

public class QLDatMon {

    public static void setColsForBillTable(JTable tbl) {
        String[] cols = {"Tên Món", "Số Lượng", "Đơn Vị", "Đơn Giá", "Giảm Giá", "Thành Tiền"};
        int[] widthCols = {450, 140, 100, 180, 150, 200};
        XInit.setCols(tbl, cols, widthCols);
    }

    public static void setColsForMenuTable(JTable tbl) {
        String[] cols = {"Tên Món", "Đơn Vị", "Đơn Giá"};
        int[] widthCols = {450, 100, 200};
        XInit.setCols(tbl, cols, widthCols);
    }

    // fill dữ liệu lên bảng từ list Object[], list được lấy theo điều kiện id
//    public static void fillToTbl(JTable tbl, List<Object[]> list) {
//        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
//        tblModel.setRowCount(0);
//        if (list != null) {
//            for (Object[] obj : list) {
//                Object[] rows = new Object[obj.length];
//                for (int i = 0; i < obj.length; i++) {
//                    rows[i] = obj[i];
//                }
//                tblModel.addRow(rows);
//            }
//        } else {
//            MsgBox.alert(tbl, "Không tìm thấy thông tin!");
//        }
//    }

    public static void fillToMenuTblById(String maLoaiMon, JTable tbl) {
        List<Object[]> list = QLThongKe.thongke.getThucDon(maLoaiMon);
        QLThongKe.fillToTbl(tbl, list);
    }

    public static void fillToBillTblByID(String maHoaDon, JTable tbl) {
        List<Object[]> list = QLThongKe.thongke.getHoaDonCT(maHoaDon);
        QLThongKe.fillToTbl(tbl, list);
    }

    private static int findIndex(String tenMon, DefaultTableModel tblModel) {
        int idx = 0;
        Vector all = tblModel.getDataVector();
//        if(all==null){
        while (idx < all.size()) {
            Vector mon = (Vector) all.elementAt(idx);
            if (mon.elementAt(0).toString().equals(tenMon)) {
                return idx;
            }
            idx++;
        }
        if (idx == all.size()) {
            MsgBox.alert(null, "Không tìm thấy thông tin cần tìm!");
            return 0;
        }
//        }
        return 0;
    }

    public static Object[] getFood(JTable tblThucDon) {
        int index = tblThucDon.getSelectedRow(); // Trả về vị trí được chọn trong bảng
        if (index < 0) {
            MsgBox.alert(null, "Chưa chọn món để thêm vào!");
            return null;
        }
        // "Tên Món", "Số Lượng", "ĐV", "Đơn Giá", "Thành Tiền"
        String tenMon = tblThucDon.getValueAt(index, 0).toString();
        float soLuong = 1;
        String donVi = tblThucDon.getValueAt(index, 1).toString();
        float donGia = Float.parseFloat(tblThucDon.getValueAt(index, 2).toString());
        float thanhTien = (float) donGia * soLuong;
        Object[] row = {tenMon, soLuong, donVi, donGia, thanhTien};
        return row;
    }

    public static void themMon(JTable tblHoaDon, Object[] row) {

        for (int i = 0; i < tblHoaDon.getRowCount(); i++) {
            String testMon = (String) tblHoaDon.getValueAt(i, 0);
            if (String.valueOf(row[0]).equals(testMon)) {
                tblHoaDon.setRowSelectionInterval(i, i);
                
                tangSoLuong(tblHoaDon, i);
                return;
            }
        }
        
        
        DefaultTableModel tblModel = (DefaultTableModel) tblHoaDon.getModel();
        tblModel.addRow(row);
        
        int idx = findIndex(row[0].toString(), tblModel);
        tblHoaDon.setRowSelectionInterval(idx, idx);
    }

    public static void xoaMon(JTable tblHoaDon) {
        int row = tblHoaDon.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel tblModel = (DefaultTableModel) tblHoaDon.getModel();
            tblModel.removeRow(row); // Xóa khỏi JTable trên form
            if (row >= 0) {
                --row;
            }
            if (row >= 0) {
                tblHoaDon.setRowSelectionInterval(row, row);
            }
        }
    }

    public static float tongHoaDon(JTable tblHoaDon) {
        float sum = 0;
        System.out.println(tblHoaDon.getRowCount());
        for (int i = 0; i < tblHoaDon.getRowCount(); i++) {
            sum = sum + Float.parseFloat(String.valueOf(tblHoaDon.getValueAt(i, 5)));
        }
        return sum;
    }
    public static float capNhatGiamGia(JTable tblHoaDon, int row, float giamGia ) {
        float soLuong = Float.parseFloat(String.valueOf(tblHoaDon.getValueAt(row, 1)));
        float donGia = Float.parseFloat(String.valueOf(tblHoaDon.getValueAt(row, 3)));
        tblHoaDon.setValueAt(donGia*giamGia*soLuong, row, 4);
        tblHoaDon.setValueAt((donGia * soLuong) - giamGia, row, 5);
        tongGiamGia(tblHoaDon);
        return donGia*giamGia*soLuong;
        
    }
    
    public static float tongGiamGia(JTable tblHoaDon) {
        float sum = 0;
        for (int i = 0; i < tblHoaDon.getRowCount(); i++) {
            sum = sum + Float.parseFloat(tblHoaDon.getValueAt(i, 4).toString());
        }
        return sum;
    }
    
    public static void tangSoLuong(JTable tblHoaDon, int row) {
        float soLuong = Float.parseFloat(String.valueOf(tblHoaDon.getValueAt(row, 1)));
        
        tblHoaDon.setValueAt(soLuong+1, row, 1);

        float donGia = Float.parseFloat(String.valueOf(tblHoaDon.getValueAt(row, 3)));
        float giamGia = capNhatGiamGia(tblHoaDon, row, Float.parseFloat(String.valueOf(tblHoaDon.getValueAt(row, 4))));
        
        tblHoaDon.setValueAt((donGia * soLuong) - giamGia, row, 5);
    }

    public static void giamSoLuong(JTable tblHoaDon) {
        int i = tblHoaDon.getSelectedRow();
        float soLuong = (float) tblHoaDon.getValueAt(i, 1);
        if (soLuong > 1) {
            soLuong = soLuong - 1;
        }
        else if(MsgBox.confirm(null, "Bạn có muốn xóa món này?")){
            xoaMon(tblHoaDon);
            return;
        }
        tblHoaDon.setValueAt(soLuong, i, 1);
        float donGia = (float) tblHoaDon.getValueAt(i, 3);
        float thanhTien = (float) donGia * soLuong;
        tblHoaDon.setValueAt(thanhTien, i, 4);
    }
}
