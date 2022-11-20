package controllers;

import dao.KhuyenMaiDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import model.KhuyenMai;
import utils.MsgBox;

public class QLKhuyenMai{
    public static KhuyenMaiDAO dao = new KhuyenMaiDAO();

    public static void insert(KhuyenMai entity) {
        if (dao.insert(entity) > 0) {
            MsgBox.alert(null, "Thêm mới thành công!");
        } else {
            MsgBox.alert(null, "Thêm mới thất bại!");
        }
    }
    
    public static void update(KhuyenMai entity) {
        if (dao.update(entity) > 0) {
            MsgBox.alert(null, "Cập nhật thành công!");
        } else {
            MsgBox.alert(null, "Cập nhật thất bại!");
        }
    }

    public static boolean detele(String...id) {
        if (dao.delete(id) > 0) {
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
        List<KhuyenMai> list = dao.selectAll();
        model.addElement("Chưa chọn");
        for (KhuyenMai entity : list) {
            model.addElement(entity.getMaKhuyenMai());
        }
    }
    
    public static void fillToCboByToday(JComboBox cbo) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        List<KhuyenMai> list = dao.selectByToDay();
        model.addElement("Chưa chọn");
        for (KhuyenMai entity : list) {
            model.addElement(entity.getMaKhuyenMai());
        }
    }
}
