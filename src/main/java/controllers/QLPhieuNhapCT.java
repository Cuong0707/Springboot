
package controllers;

import dao.PhieuNhapCTDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import model.PhieuNhapCT;
import utils.MsgBox;


public class QLPhieuNhapCT {
    
    public static PhieuNhapCTDAO dao = new PhieuNhapCTDAO();

    public static void insert(PhieuNhapCT entity) {
        if (dao.insert(entity) > 0) {
            MsgBox.alert(null, "Thêm mới thành công!");
        } else {
            MsgBox.alert(null, "Thêm mới thất bại!");
        }
    }

    public static void update(PhieuNhapCT entity) {
        if (dao.update(entity) > 0) {
            MsgBox.alert(null, "Cập nhật thành công!");
        } else {
            MsgBox.alert(null, "Cập nhật thất bại!");
        }
    }

    public static boolean detele(String ma) {
        if (dao.delete(ma)> 0) {
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
        List<PhieuNhapCT> list = dao.selectAll();
        model.addElement("Chưa chọn");
        for (PhieuNhapCT entity : list) {
            model.addElement(entity.getMaPhieuNhapCT());
        }
    }
    
    public static void fillToCboByMaPhieuNhap(JComboBox cbo, String maPhieuNhap) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        List<PhieuNhapCT> list = dao.selectAllByMaPhieuNhap(maPhieuNhap);
        model.addElement("Chưa chọn");
        for (PhieuNhapCT entity : list) {
            model.addElement(entity.getMaPhieuNhapCT());
        }
    }
}
