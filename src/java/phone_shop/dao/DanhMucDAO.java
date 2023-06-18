package phone_shop.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import phone_shop.model.DanhMuc;
import phone_shop.model.SanPham;
import phone_shop.utils.DBContext;

/**
 *
 * @author Trong Phan Sy
 */
public class DanhMucDAO {

    private DBContext db;

    public DanhMucDAO() {
        db = new DBContext();
    }

    public DanhMucDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    private final String TABLE_NAME = "DanhMuc";
    private final String FIELD_1 = "MaDM";
    private final String FIELD_2 = "TenDM";
    private final String FIELD_3 = "TrangThai";
    private final String FIELD_4 = "DacTinh";

    public boolean create(DanhMuc newDM) {
        boolean result = false;
        try {
            String sql = "INSERT INTO " + TABLE_NAME + " ("
                    + FIELD_1 + ", "
                    + FIELD_2 + ", "
                    + FIELD_3 + ", "
                    + FIELD_4 +") "
                    + "VALUES ("
                    + "?, ?, ?, ?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newDM.getMaDM());
            stmt.setString(2, newDM.getTenDM());
            stmt.setBoolean(3, newDM.isTrangThai());
            stmt.setString(4, newDM.getDactinh());
            int effectRow = stmt.executeUpdate();
            if (effectRow > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<DanhMuc> read() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<DanhMuc> danhMucs = new ArrayList<>();

        try {
            String sql = "SELECT * FROM " + TABLE_NAME;
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _maDM = rs.getString(FIELD_1);
                String _tenDM = rs.getString(FIELD_2);
                boolean _trangThai = rs.getBoolean(FIELD_3);
                String _dactinh = rs.getString(FIELD_4);
                DanhMuc danhMuc = new DanhMuc(_maDM, _tenDM, _trangThai, _dactinh);
                danhMucs.add(danhMuc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return danhMucs;
    }

    public boolean update(DanhMuc newDM) {
        boolean result = false;
        try {
            String sql = "UPDATE " + TABLE_NAME
                    + " SET " + FIELD_2 + "=?, "
                    + FIELD_3 + "=? , "+FIELD_4+" = ? "
                    + "WHERE " + FIELD_1 + "=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newDM.getTenDM());
            stmt.setBoolean(2, newDM.isTrangThai());
            stmt.setString(4, newDM.getMaDM());
            stmt.setString(3, newDM.getDactinh());
            int effectRow = stmt.executeUpdate();
            if (effectRow > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public boolean delete(String maDM) {
        boolean result = false;
        try {
            String sql = "DELETE FROM " + TABLE_NAME
                    + " WHERE " + FIELD_1 + "=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, maDM);
            int effectRow = stmt.executeUpdate();
            if (effectRow > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public DanhMuc details(String maDM) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DanhMuc danhMuc = null;
        try {
            String sql = "SELECT * FROM " + TABLE_NAME
                    + " WHERE " + FIELD_1 + " = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, maDM);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _maDM = rs.getString(FIELD_1);
                String _tenDM = rs.getString(FIELD_2);
                boolean _trangThai = rs.getBoolean(FIELD_3);
                String _dactinh = rs.getString("dactinh");
                danhMuc = new DanhMuc(_maDM, _tenDM, _trangThai, _dactinh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhMuc;
    }

//    public boolean checkExist(String maDM){
//        boolean result = false;   
//        try {
//            String sql = "SELECT * FROM " + TABLE_NAME
//                    + " WHERE " + FIELD_1 + " = ?";
//            PreparedStatement stmt = db.getConn().prepareStatement(sql);
//            stmt.setString(1, maDM);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                String _maDM = rs.getString(FIELD_1);
//                String _tenDM = rs.getString(FIELD_2);
//                boolean _trangThai = rs.getBoolean(FIELD_3);
//                
//                DanhMuc danhMuc = new DanhMuc(_maDM, _tenDM, _trangThai);
//                if(danhMuc!=null){
//                    result = true;
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }        
//        return result;
//    }
    //TEST DONE!
    public static void main(String[] args) {
        DanhMucDAO dao = new DanhMucDAO();
//        System.out.println(dao.checkExist("DT01"));
    }
}
