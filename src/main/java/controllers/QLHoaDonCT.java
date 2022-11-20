
package controllers;

import static controllers.QLMonAn.dao;
import dao.HoaDonCTDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import model.HoaDonCT;
import model.MonAn;
import utils.MsgBox;

public class QLHoaDonCT {
        
    public static HoaDonCTDAO dao = new HoaDonCTDAO();

    public static void insert(HoaDonCT entity) {
        if (dao.insert(entity) > 0) {
            MsgBox.alert(null, "Thêm mới thành công!");
        } else {
            MsgBox.alert(null, "Thêm mới thất bại!");
        }
    }

    public static void update(HoaDonCT entity) {
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
    
    public void fillToCbo(JComboBox cbo) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        List<HoaDonCT> list = dao.selectAll();
        model.addElement("Chưa chọn");
        for (HoaDonCT entity : list) {
            model.addElement(entity.getMaHoaDonCT());
        }
    }
}
