package trongps.model;

/**
 *
 * @author Trong Phan Sy
 */
public class NhomTaiKhoan {
    private String nhomTK;
    private String moTa;
    private boolean trangThai;

    public NhomTaiKhoan() {
    }

    public NhomTaiKhoan(String nhomTK, String moTa, boolean trangThai) {
        this.nhomTK = nhomTK;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    /**
     * @return the nhomTK
     */
    public String getNhomTK() {
        return nhomTK;
    }

    /**
     * @param nhomTK the nhomTK to set
     */
    public void setNhomTK(String nhomTK) {
        this.nhomTK = nhomTK;
    }

    /**
     * @return the moTa
     */
    public String getMoTa() {
        return moTa;
    }

    /**
     * @param moTa the moTa to set
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @return the trangThai
     */
    public boolean isTrangThai() {
        return trangThai;
    }

    /**
     * @param trangThai the trangThai to set
     */
    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
