package phone_shop.model;

/**
 *
 * @author Trong Phan Sy
 */
public class TaiKhoan {
    private String tenTK;
    private String matKhau;
    private boolean trangThai;
    private String email;
    private String nhomTK;

    public TaiKhoan(String tenTK, String matKhau, boolean trangThai, String email, String nhomTK) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
        this.email = email;
        this.nhomTK = nhomTK;
    }

    /**
     * @return the tenTK
     */
    public String getTenTK() {
        return tenTK;
    }

    /**
     * @param tenTK the tenTK to set
     */
    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    /**
     * @return the matKhau
     */
    public String getMatKhau() {
        return matKhau;
    }

    /**
     * @param matKhau the matKhau to set
     */
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
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

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
    
    
    
}
