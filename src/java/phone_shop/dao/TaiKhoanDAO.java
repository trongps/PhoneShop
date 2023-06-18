package phone_shop.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import phone_shop.model.TaiKhoan;
import phone_shop.utils.DBContext;

/**
 *
 * @author Trong Phan Sy
 */
public class TaiKhoanDAO {

    private DBContext db;

    public TaiKhoanDAO() {
        db = new DBContext();
    }

    public TaiKhoanDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    private final String TABLE_NAME = "TaiKhoan";
    private final String FIELD_1 = "TenTK";
    private final String FIELD_2 = "MatKhau";
    private final String FIELD_3 = "TrangThai";
    private final String FIELD_4 = "Email";
    private final String FIELD_5 = "NhomTK";

    
    public boolean create(TaiKhoan newTK) {
        boolean result = false;
        try {
            String sql = "INSERT INTO " + TABLE_NAME + " ("
                    + FIELD_1 + ", "
                    + FIELD_2 + ", "
                    + FIELD_3 + ", "
                    + FIELD_4 + ", "
                    + FIELD_5 + ") "
                    + "VALUES ("
                    + "?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newTK.getTenTK());
            stmt.setString(2, newTK.getMatKhau());
            stmt.setBoolean(3, newTK.isTrangThai());
            stmt.setString(4, newTK.getEmail());
            stmt.setString(5, newTK.getNhomTK());
            int effectRow = stmt.executeUpdate();
            if (effectRow > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<TaiKhoan> read() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<TaiKhoan> taiKhoans = new ArrayList<>();

        try {
            String sql = "SELECT * FROM " + TABLE_NAME;
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _tenTK = rs.getString(FIELD_1);
                String _matKhau = rs.getString(FIELD_2);
                boolean _trangThai = rs.getBoolean(FIELD_3);
                String _email = rs.getString(FIELD_4);
                String _nhomTK = rs.getString(FIELD_5);

                TaiKhoan taiKhoan = new TaiKhoan(_tenTK, _matKhau, _trangThai, _email, _nhomTK);
                taiKhoans.add(taiKhoan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return taiKhoans;
    }

    public boolean update(TaiKhoan newTK) {
        boolean result = false;
        try {
            String sql = "UPDATE "+ TABLE_NAME
                    + " SET "+FIELD_2+"=?, "
                    + FIELD_3+"=?, "
                    + FIELD_4+"=?, "
                    + FIELD_5+"=? "
                    + "WHERE "+FIELD_1+"=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newTK.getMatKhau());
            stmt.setBoolean(2, newTK.isTrangThai());
            stmt.setString(3, newTK.getEmail());
            stmt.setString(4, newTK.getNhomTK());
            stmt.setString(5, newTK.getTenTK());
            int effectRow = stmt.executeUpdate();
            if (effectRow > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean delete(String tenTK) {
        boolean result = false;
        try {
            String sql = "DELETE FROM "+TABLE_NAME
                    +" WHERE "+FIELD_1+"=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, tenTK);
            int effectRow = stmt.executeUpdate();
            if (effectRow > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
     public TaiKhoan checkLogin(String tenTK, String mk) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TaiKhoan taiKhoan = null;

        try {
            String sql = "SELECT * FROM " + TABLE_NAME
                    +" WHERE "+ FIELD_1 + "= ? AND " + FIELD_2 + "= ? " ;
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, tenTK);
            stmt.setString(2, mk);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _tenTK = rs.getString(FIELD_1);
                String _matKhau = rs.getString(FIELD_2);
                boolean _trangThai = rs.getBoolean(FIELD_3);
                String _email = rs.getString(FIELD_4);
                String _nhomTK = rs.getString(FIELD_5);
                taiKhoan = new TaiKhoan(_tenTK, _matKhau, _trangThai, _email, _nhomTK);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return taiKhoan;
    }
    
    public TaiKhoan details(String tenTK) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TaiKhoan taiKhoan = null;

        try {
            String sql = "SELECT * FROM " + TABLE_NAME
                    +" WHERE "+ FIELD_1 + "= ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, tenTK);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _tenTK = rs.getString(FIELD_1);
                String _matKhau = rs.getString(FIELD_2);
                boolean _trangThai = rs.getBoolean(FIELD_3);
                String _email = rs.getString(FIELD_4);
                String _nhomTK = rs.getString(FIELD_5);

                taiKhoan = new TaiKhoan(_tenTK, _matKhau, _trangThai, _email, _nhomTK);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return taiKhoan;
    }
    
    public boolean checkExist(String tenTK) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TABLE_NAME
                    +" WHERE "+ FIELD_1 + "= ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, tenTK);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _tenTK = rs.getString(FIELD_1);
                String _matKhau = rs.getString(FIELD_2);
                boolean _trangThai = rs.getBoolean(FIELD_3);
                String _email = rs.getString(FIELD_4);
                String _nhomTK = rs.getString(FIELD_5);

                TaiKhoan taiKhoan = new TaiKhoan(_tenTK, _matKhau, _trangThai, _email, _nhomTK);
                if(taiKhoan!=null){
                    result = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    
    //TEST DONE!   
    public static void main(String[] args) {
        TaiKhoanDAO dao = new TaiKhoanDAO();
        System.out.println(dao.checkLogin("admin", "12345!"));
    }
}
