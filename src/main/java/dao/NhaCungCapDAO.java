package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.XJdbc;
import model.NhaCungCap;

public class NhaCungCapDAO extends DAO<NhaCungCap, String> {

    String INSERT_SQL = "INSERT INTO NhaCungCap (MaCC, TenCC, MaSoThue, NguoiLienHe, SoDT, Email, DiaChi) VALUES (?, ?, ?, ?, ?, ?, ?);";
    String UPDATE_SQL = "UPDATE NhaCungCap SET TenCC = ?, MaSoThue = ?, NguoiLienHe = ?, SoDT = ?, Email = ?, DiaChi = ? WHERE MaCC = ?;";
    String DELETE_SQL = "DELETE FROM NhaCungCap WHERE MaCC = ?;";
    String SELECT_ALL_SQL = "SELECT * FROM NhaCungCap;";
    String SELECT_BY_ID_SQL = "SELECT * FROM NhaCungCap WHERE MaCC = ?;";
    String SELECT_BY_NAME_SQL = "SELECT * FROM NhaCungCap WHERE TenCC = ?";

    @Override
    public int insert(NhaCungCap entity) {
        Object args[]
                = {
                    entity.getMaCC(),
                    entity.getTenCC(),
                    entity.getMaSoThue(),
                    entity.getNguoiLienHe(),
                    entity.getSoDT(),
                    entity.getEmail(),
                    entity.getDiaChi()
                };
        return XJdbc.updateData(INSERT_SQL, args);
    }

    @Override
    public int update(NhaCungCap entity) {
        Object args[]
                = {
                    entity.getTenCC(),
                    entity.getMaSoThue(),
                    entity.getNguoiLienHe(),
                    entity.getSoDT(),
                    entity.getEmail(),
                    entity.getDiaChi(),
                    entity.getMaCC()
                };
        return XJdbc.updateData(UPDATE_SQL, args);
    }

    @Override
    public int delete(String...id) {
        return XJdbc.updateData(DELETE_SQL, id);
    }

    @Override
    public NhaCungCap selectById(String...id) {
        List<NhaCungCap> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhaCungCap> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<NhaCungCap> selectBySql(String sql, Object... args) {
        List<NhaCungCap> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.queryData(sql, args);
            while (rs.next()) {
                NhaCungCap entity = new NhaCungCap();
                entity.setMaCC(rs.getString("MaCC"));
                entity.setTenCC(rs.getString("TenCC"));
                entity.setMaSoThue(rs.getString("MaSoThue"));
                entity.setNguoiLienHe(rs.getString("NguoiLienHe"));
                entity.setSoDT(rs.getString("SoDT"));
                entity.setEmail(rs.getString("Email"));
                entity.setDiaChi(rs.getString("DiaChi"));
                list.add(entity);
            }
//            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception ex) {
            System.out.println("L???i selectBySql: " + ex);
            throw new RuntimeException(ex);
        }
    }

    public NhaCungCap selectByName(String name) {
        // S??? d???ng ???????c l???nh n??y v???i ??i???u ki???n, nh?? cung c???p kh??ng tr??ng t??n
        List<NhaCungCap> list = this.selectBySql(SELECT_BY_NAME_SQL, name);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
