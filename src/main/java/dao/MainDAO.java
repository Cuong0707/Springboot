
package dao;

import java.util.List;
import model.Main;

public class MainDAO extends DAO<Main, String> {

    @Override
    public int insert(Main entity) {
        return 0;
    }

    @Override
    public int update(Main entity) {
        return 0;
    }

    @Override
    public int delete(String... id) {
        return 0;
    }

    @Override
    public Main selectById(String... id) {
        return null;
    }

    @Override
    public List<Main> selectAll() {
        return null;
    }

    @Override
    protected List<Main> selectBySql(String sql, Object... args) {
        return null;
    }
    
}
