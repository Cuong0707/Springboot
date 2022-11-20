
package controllers;

import dao.ThongKeDAO;
import java.util.List;
import utils.XInit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utils.MsgBox;

public class QLThongKe {
    
    public static ThongKeDAO thongke = new ThongKeDAO();    
    
    public static void setColsForNhanVien(JTable tblNhanVien) {
        String[] cols = {"Mã NV", "Họ Tên NV", "Giới Tính", "Số ĐT", "Địa Chỉ", "Chức Vụ", "Lương", "Mật Khẩu"};
        int[] widthCols = {60, 180, 60, 120, 200, 100, 130, 100};
        XInit.setCols(tblNhanVien, cols, widthCols);
    }
    
    public static void setColsForHoaDon(JTable tblHoaDon) {
        String[] cols = {"Mã Hóa Đơn", "Ngày Lập", "Người Lập", "Tổng Tiền", "Thanh Toán"};
        int[] widthCols = {10, 100, 100, 60, 100};
        XInit.setCols(tblHoaDon, cols, widthCols);
    }
    
    public static void setColsForPhieuNhap(JTable tblPhieuNhap) {
        String[] cols = {"Mã Phiếu Nhập", "Ngày Nhập", "Người Nhập", "Tổng Chi"};
        int[] widthCols = {10, 100, 100, 60};
        XInit.setCols(tblPhieuNhap, cols, widthCols);
    }
    
    public static void setColsForNguyenLieu(JTable tblNguyenLieu) {
        String[] cols = {"Mã Nguyên Liệu", "Mã Loại", "Tên Nguyên Liệu", "Đơn Vị Tính", "Số Lượng"};
        int[] widthCols = {50, 50, 100, 50, 100};
        XInit.setCols(tblNguyenLieu, cols, widthCols);
    }
    
    public static void setColsForKhachHang(JTable tblKhachHang) {
        String[] cols = {"Mã KH", "Tên KH", "Số ĐT", "Địa Chỉ"};
        int[] widthCols = {10, 200, 100, 300};
        XInit.setCols(tblKhachHang, cols, widthCols);
    }
    
    public static void setColsForCaTruc(JTable tblCaTruc) {
        String[] cols = {"Ngày Trực", "Số lượng", "Mã Ca Trực", "Thời Gian Bắt Đầu", "Thời Gian Kết Thức"};
        int[] widthCols = {100, 100, 10, 100, 100};
        XInit.setCols(tblCaTruc, cols, widthCols);
    }
    
    // fill dữ liệu lên bảng từ list Object[]
    public static void fillToTbl(JTable tbl, List<Object[]> list) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        if (list != null) {
            for (Object[] obj : list) {
                Object[] rows = new Object[obj.length];
                for (int i = 0; i < obj.length; i++) {
                    rows[i] = obj[i];
                }
                tblModel.addRow(rows);
            }
        } else {
            MsgBox.alert(tbl, "Không tìm thấy thông tin!");
        }
    }
    
    // "Mã Hóa Đơn", "Ngày Lập", "Người Lập", "Tổng Tiền", "Thanh Toán"
    public static void fillToBillsTblById(JTable tbl) {
        List<Object[]> list = QLThongKe.thongke.getThongKeHoaDon();
        QLThongKe.fillToTbl(tbl, list);
    }
    
    // "Mã Phiếu Nhập", "Ngày Nhập", "Người Nhập", "Tổng Chi"
    public static void fillToPhieuNhapTblById(JTable tbl) {
        List<Object[]> list = QLThongKe.thongke.getThongKePhieuNhap();
        QLThongKe.fillToTbl(tbl, list);
    }
}
