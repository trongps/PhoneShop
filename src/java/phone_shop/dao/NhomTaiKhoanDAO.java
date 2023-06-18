package phone_shop.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import phone_shop.model.DanhMuc;
import phone_shop.model.NhomTaiKhoan;
import phone_shop.model.TaiKhoan;
import phone_shop.utils.DBContext;

/**
 *
 * @author Trong Phan Sy
 */
public class NhomTaiKhoanDAO {

    private DBContext db;

    public NhomTaiKhoanDAO() {
        db = new DBContext();
    }

    public NhomTaiKhoanDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    private final String TABLE_NAME = "NhomTaiKhoan";
    private final String FIELD_1 = "NhomTK";
    private final String FIELD_2 = "MoTa";
    private final String FIELD_3 = "TrangThai";
    
    public boolean create(NhomTaiKhoan newNTK) {
        boolean result = false;
        try {
            String sql = "INSERT INTO " + TABLE_NAME + " ("
                    + FIELD_1 + ", "
                    + FIELD_2 + ", "
                    + FIELD_3 + ") "
                    + "VALUES ("
                    + "?, ?, ?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newNTK.getNhomTK());
            stmt.setString(2, newNTK.getMoTa());
            stmt.setBoolean(3, newNTK.isTrangThai());          
            int effectRow = stmt.executeUpdate();
            if (effectRow > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public List<NhomTaiKhoan> read() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<NhomTaiKhoan> nhomTKs = new ArrayList<>();

        try {
            String sql = "SELECT * FROM " + TABLE_NAME;
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _nhomTK = rs.getString(FIELD_1);
                String _moTa = rs.getString(FIELD_2);
                boolean _trangThai = rs.getBoolean(FIELD_3);

                NhomTaiKhoan nhomTK = new NhomTaiKhoan(_nhomTK, _moTa, _trangThai);
                nhomTKs.add(nhomTK);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nhomTKs;
    }
    
    public boolean update(NhomTaiKhoan newNTK) {
        boolean result = false;
        try {
            String sql = "UPDATE "+ TABLE_NAME
                    + " SET "+FIELD_2+"=?, "
                    + FIELD_3+"=? "
                    + "WHERE "+FIELD_1+"=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newNTK.getMoTa());
            stmt.setBoolean(2, newNTK.isTrangThai());
            stmt.setString(3, newNTK.getNhomTK());
            int effectRow = stmt.executeUpdate();
            if (effectRow > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public NhomTaiKhoan details(String maNTK) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        NhomTaiKhoan ntk = null;
        try {
            String sql = "SELECT * FROM " + TABLE_NAME
                    + " WHERE " + FIELD_1 + " = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, maNTK);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _maNTK = rs.getString(FIELD_1);
                String _moTa = rs.getString(FIELD_2);
                boolean _trangThai = rs.getBoolean(FIELD_3);
                ntk = new NhomTaiKhoan(_maNTK, _moTa, _trangThai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ntk;
    }
    
    public boolean checkExist(String maNTK) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TABLE_NAME
                    + " WHERE " + FIELD_1 + " = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, maNTK);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _maNTK = rs.getString(FIELD_1);
                String _moTa = rs.getString(FIELD_2);
                boolean _trangThai = rs.getBoolean(FIELD_3);
                NhomTaiKhoan ntk = new NhomTaiKhoan(_maNTK, _moTa, _trangThai);
                if(ntk!=null){
                    result = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
     //TEST DONE!   
}
