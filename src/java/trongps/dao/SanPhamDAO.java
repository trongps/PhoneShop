package trongps.dao;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import trongps.model.SanPham;
import trongps.utils.DBContext;

/**
 *
 * @author Trong Phan Sy
 */
public class SanPhamDAO {

    private final String TABLE_NAME = "SanPham";
    private final String FIELD_1 = "MaSP";
    private final String FIELD_2 = "TenSP";
    private final String FIELD_3 = "MoTa";
    private final String FIELD_4 = "SoLuong";
    private final String FIELD_5 = "DonGia";
    private final String FIELD_6 = "HinhAnh";
    private final String FIELD_7 = "TrangThai";
    private final String FIELD_8 = "MaDM";
    private final int elemsInPage = 8;

    private DBContext db;

    public SanPhamDAO() {
        db = new DBContext();
    }

    public SanPhamDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public boolean create(SanPham newSP) {
        boolean result = false;
        try {
            String sql = "INSERT INTO " + TABLE_NAME + " ("
                    + FIELD_1 + ", "
                    + FIELD_2 + ", "
                    + FIELD_3 + ", "
                    + FIELD_4 + ", "
                    + FIELD_5 + ", "
                    + FIELD_6 + ", "
                    + FIELD_7 + ", "
                    + FIELD_8 + ") "
                    + "VALUES ("
                    + "?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newSP.getMaSP());
            stmt.setString(2, newSP.getTenSP());
            stmt.setString(3, newSP.getMoTa());
            stmt.setInt(4, newSP.getSoLuong());
            stmt.setFloat(5, newSP.getDonGia());
            stmt.setString(6, newSP.getHinhAnh());
            stmt.setBoolean(7, newSP.isTrangThai());
            stmt.setString(8, newSP.getMaDM());
            int effectRow = stmt.executeUpdate();
            if (effectRow > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<SanPham> read() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<SanPham> sanphams = new ArrayList<>();

        try {
            String sql = "SELECT * FROM " + TABLE_NAME;
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _maSP = rs.getString(FIELD_1);
                String _tenSP = rs.getString(FIELD_2);
                String _moTa = rs.getString(FIELD_3);
                int _soLuong = rs.getInt(FIELD_4);
                float _donGia = rs.getFloat(FIELD_5);
                String _hinhAnh = rs.getString(FIELD_6);
                boolean _trangThai = rs.getBoolean(FIELD_7);
                String _maDM = rs.getString(FIELD_8);
                SanPham item = new SanPham(_maSP, _tenSP, _moTa, _soLuong, _donGia, _hinhAnh, _trangThai, _maDM);
                sanphams.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sanphams;
    }

    public boolean update(SanPham newSP) {
        boolean result = false;
        try {
            String sql = "UPDATE " + TABLE_NAME
                    + " SET " + FIELD_2 + "=?, "
                    + FIELD_3 + "=?, "
                    + FIELD_4 + "=?, "
                    + FIELD_5 + "=?, "
                    + FIELD_6 + "=?, "
                    + FIELD_7 + "=?, "
                    + FIELD_8 + "=? "
                    + "WHERE " + FIELD_1 + "=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(8, newSP.getMaSP());
            stmt.setString(1, newSP.getTenSP());
            stmt.setString(2, newSP.getMoTa());
            stmt.setInt(3, newSP.getSoLuong());
            stmt.setFloat(4, newSP.getDonGia());
            stmt.setString(5, newSP.getHinhAnh());
            stmt.setBoolean(6, newSP.isTrangThai());
            stmt.setString(7, newSP.getMaDM());
            int effectRow = stmt.executeUpdate();
            if (effectRow > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public boolean delete(String maSP) {
        boolean result = false;
        try {
            String sql = "DELETE FROM " + TABLE_NAME
                    + " WHERE " + FIELD_1 + "=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, maSP);
            int effectRow = stmt.executeUpdate();
            if (effectRow > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public boolean checkExist(String maSP) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TABLE_NAME
                    + " WHERE " + FIELD_1 + " = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, maSP);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _maSP = rs.getString(FIELD_1);
                String _tenSP = rs.getString(FIELD_2);
                String _moTa = rs.getString(FIELD_3);
                int _soLuong = rs.getInt(FIELD_4);
                float _donGia = rs.getFloat(FIELD_5);
                String _hinhAnh = rs.getString(FIELD_6);
                boolean _trangThai = rs.getBoolean(FIELD_7);
                String _maDM = rs.getString(FIELD_8);
                SanPham sanPham = new SanPham(maSP, _tenSP, _moTa, _soLuong, _donGia, _hinhAnh, _trangThai, _maDM);
                if(sanPham!=null){
                    result = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public SanPham details(String maSP) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        SanPham sanPham = null;
        try {
            String sql = "SELECT * FROM " + TABLE_NAME
                    + " WHERE " + FIELD_1 + " = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, maSP);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _maSP = rs.getString(FIELD_1);
                String _tenSP = rs.getString(FIELD_2);
                String _moTa = rs.getString(FIELD_3);
                int _soLuong = rs.getInt(FIELD_4);
                float _donGia = rs.getFloat(FIELD_5);
                String _hinhAnh = rs.getString(FIELD_6);
                boolean _trangThai = rs.getBoolean(FIELD_7);
                String _maDM = rs.getString(FIELD_8);
                sanPham = new SanPham(maSP, _tenSP, _moTa, _soLuong, _donGia, _hinhAnh, _trangThai, _maDM);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sanPham;
    }

    public int getTotalPageSP() {
        int totalPage = 0;
        try {
            String sql = "SELECT Count(*) "
                    + "FROM " + TABLE_NAME + " ";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int totalRow = rs.getInt(1);
                if (totalRow != 0) {
                    totalPage = totalRow / elemsInPage;
                    if (totalRow % elemsInPage != 0) {
                        totalPage++;
                    }
                }
            }
        } catch (SQLException e) {
        }
        return totalPage;
    }

    public List<SanPham> list(int pageIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<SanPham> sanphams = new ArrayList<>();
        int offset = (pageIndex - 1) * elemsInPage;
        try {
            String sql = "SELECT * "
                    + "FROM " + TABLE_NAME + " "
                    + "ORDER BY " + FIELD_1 + " "
                    + "OFFSET ? ROWS "
                    + "FETCH NEXT ? ROWS ONLY;";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, offset);
            stmt.setInt(2, elemsInPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _maSP = rs.getString(FIELD_1);
                String _tenSP = rs.getString(FIELD_2);
                String _moTa = rs.getString(FIELD_3);
                int _soLuong = rs.getInt(FIELD_4);
                float _donGia = rs.getFloat(FIELD_5);
                String _hinhAnh = rs.getString(FIELD_6);
                boolean _trangThai = rs.getBoolean(FIELD_7);
                String _maDM = rs.getString(FIELD_8);
                SanPham item = new SanPham(_maSP, _tenSP, _moTa, _soLuong, _donGia, _hinhAnh, _trangThai, _maDM);
                sanphams.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sanphams;
    }

    public int getTotalPageSPByDM(String maDM) {
        int totalPage = 0;
        try {
            String sql = "SELECT Count(*) "
                    + "FROM " + TABLE_NAME + " "
                    + "WHERE " + FIELD_8 + "=? ";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, maDM);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int totalRow = rs.getInt(1);
                if (totalRow != 0) {
                    totalPage = totalRow / elemsInPage;
                    if (totalRow % elemsInPage != 0) {
                        totalPage++;
                    }
                }
            }
        } catch (SQLException e) {
        }
        return totalPage;
    }

    public List<SanPham> readByDM(String maDM, int pageIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<SanPham> sanPhams = new ArrayList<>();
        int offset = (pageIndex - 1) * elemsInPage;

        try {
            String sql = "SELECT * "
                    + "FROM (SELECT*FROM " + TABLE_NAME + " WHERE " + FIELD_8 + " = ?) tb "
                    + "ORDER BY tb.masp "
                    + "OFFSET ? ROWS "
                    + "FETCH NEXT ? ROWS ONLY;";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, maDM);
            stmt.setInt(2, offset);
            stmt.setInt(3, elemsInPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _maSP = rs.getString(FIELD_1);
                String _tenSP = rs.getString(FIELD_2);
                String _moTa = rs.getString(FIELD_3);
                int _soLuong = rs.getInt(FIELD_4);
                float _donGia = rs.getFloat(FIELD_5);
                String _hinhAnh = rs.getString(FIELD_6);
                boolean _trangThai = rs.getBoolean(FIELD_7);
                String _maDM = rs.getString(FIELD_8);
                SanPham sanpham = new SanPham(_maSP, _tenSP, _moTa, _soLuong, _donGia, _hinhAnh, _trangThai, _maDM);
                sanPhams.add(sanpham);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sanPhams;
    }

    public int getTotalPageSearch(String maDM, String key) {
        int totalPage = -1;
        try {
            PreparedStatement stmt = null;
            if (maDM.equals("all")) {
                String sql = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE " + FIELD_2 + " LIKE ? ";
                stmt = db.getConn().prepareStatement(sql);
                stmt.setString(1, "%" + key + "%");
            } else {
                String sql = "SELECT COUNT(*) FROM  " + TABLE_NAME + "  "
                        + "WHERE " + FIELD_2 + " LIKE ? AND " + FIELD_8 + " = ? ";
                stmt = db.getConn().prepareStatement(sql);
                stmt.setString(1, "%" + key + "%");
                stmt.setString(2, maDM);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int totalRow = rs.getInt(1);
                if (totalRow != 0) {
                    totalPage = totalRow / elemsInPage;
                    if (totalRow % elemsInPage != 0) {
                        totalPage++;
                    }
                }
            }
        } catch (SQLException e) {
        }
        return totalPage;
    }

    public List<SanPham> search(String maDM, int pageIndex, String key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<SanPham> sanPhams = new ArrayList<>();
        int offset = (pageIndex - 1) * elemsInPage;

        try {
            PreparedStatement stmt = null;
            if (maDM.equals("all")) {
                String sql = "SELECT * "
                        + "FROM ("
                        + "SELECT*FROM " + TABLE_NAME + " WHERE " + FIELD_2 + " LIKE ? ) tb  "
                        + "ORDER BY tb.masp "
                        + "OFFSET ? ROWS "
                        + "FETCH NEXT ? ROWS ONLY;";
                stmt = db.getConn().prepareStatement(sql);
                stmt.setString(1, "%" + key + "%");
                stmt.setInt(2, offset);
                stmt.setInt(3, elemsInPage);
            } else {
                String sql = "SELECT * "
                        + "FROM ( SELECT * FROM  " + TABLE_NAME + "  "
                        + "WHERE " + FIELD_2 + " LIKE ? AND " + FIELD_8 + " = ?) tb "
                        + "ORDER BY tb.masp "
                        + "OFFSET ? ROWS "
                        + "FETCH NEXT ? ROWS ONLY;";
                stmt = db.getConn().prepareStatement(sql);
                stmt.setString(1, "%" + key + "%");
                stmt.setString(2, maDM);
                stmt.setInt(3, offset);
                stmt.setInt(4, elemsInPage);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _maSP = rs.getString(FIELD_1);
                String _tenSP = rs.getString(FIELD_2);
                String _moTa = rs.getString(FIELD_3);
                int _soLuong = rs.getInt(FIELD_4);
                float _donGia = rs.getFloat(FIELD_5);
                String _hinhAnh = rs.getString(FIELD_6);
                boolean _trangThai = rs.getBoolean(FIELD_7);
                String _maDM = rs.getString(FIELD_8);
                SanPham sanpham = new SanPham(_maSP, _tenSP, _moTa, _soLuong, _donGia, _hinhAnh, _trangThai, _maDM);
                sanPhams.add(sanpham);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sanPhams;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        SanPhamDAO dao = new SanPhamDAO();
        dao.list(1);
        for (SanPham sanPham : dao.list(1)) {
            System.out.println(sanPham);
        }
    }
    //TEST DONE
}
