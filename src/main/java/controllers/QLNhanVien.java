package controllers;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import utils.MsgBox;
import dao.NhanVienDAO;
import model.NhanVien;

public class QLNhanVien {

    public static NhanVienDAO dao = new NhanVienDAO();

    public static void insert(NhanVien entity) {
        if (dao.insert(entity) > 0) {
            MsgBox.alert(null, "Thêm mới thành công!");
        } else {
            MsgBox.alert(null, "Thêm mới thất bại!");
        }
    }

    public static void update(NhanVien entity) {
        if (dao.update(entity) > 0) {
            MsgBox.alert(null, "Cập nhật thành công!");
        } else {
            MsgBox.alert(null, "Cập nhật thất bại!");
        }
    }

    public static boolean detele(String ma) {
        if (dao.delete(ma) > 0) {
            MsgBox.alert(null, "Xóa thành công!");
            return true;
        } else {
            MsgBox.alert(null, "Xóa thất bại!");
        }
        return false;
    }

    public static void fillToCbo(JComboBox cbo) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        List<NhanVien> list = dao.selectAll();
        model.addElement("Chưa chọn");
        for (NhanVien nv : list) {
            model.addElement(nv.getHoTenNV());
        }
    }
    
    public static void fillToCboByChucVu(JComboBox cbo, String chucVu) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        List<NhanVien> list = dao.selectByChucVu(chucVu);
        model.addElement("Chưa chọn");
        for (NhanVien nv : list) {
            model.addElement(nv.getHoTenNV());
        }
    }
    public static void fillTable(JTable tbl) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng trên JTable
        try {
            List<NhanVien> list = dao.selectAll(); // đọc dữ liệu từ CSDL
            for (NhanVien nv : list) {
                String chucVu = QLChucVu.dao.selectById(nv.getMaCV()).getChucVu();
                // MaNV, MatKhau, HoTenNV, GioiTinh, NgaySinh, SoDT, Email, DiaChi, HinhNV, MaCV
                Object[] row = 
                {
                    nv.getMaNV(), 
                    nv.getHoTenNV(), 
                    nv.getGioiTinh(), 
                    nv.getSoDT(), 
                    nv.getDiaChi(), 
                    chucVu, 
                    nv.getMatKhau()
                };
                
                model.addRow(row); // Thêm một hàng vào JTable
            }
        } catch (Exception e) {
            MsgBox.alert(null, "Lỗi truy vấn dữ liệu!");
        }
    }
}
