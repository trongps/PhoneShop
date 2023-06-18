package trongps.model;

/**
 *
 * @author Trong Phan Sy
 */
public class DanhMuc {
    private String maDM;
    private String tenDM;
    private boolean trangThai;
    private String dactinh;

    public DanhMuc() {
    }

    public DanhMuc(String maDM, String tenDM, boolean trangThai, String dactinh) {
        this.maDM = maDM;
        this.tenDM = tenDM;
        this.trangThai = trangThai;
        this.dactinh = dactinh;
    }



    /**
     * @return the maDM
     */
    public String getMaDM() {
        return maDM;
    }

    /**
     * @param maDM the maDM to set
     */
    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    /**
     * @return the tenDM
     */
    public String getTenDM() {
        return tenDM;
    }

    /**
     * @param tenDM the tenDM to set
     */
    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
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
     * @return the dactinh
     */
    public String getDactinh() {
        return dactinh;
    }

    /**
     * @param dactinh the dactinh to set
     */
    public void setDactinh(String dactinh) {
        this.dactinh = dactinh;
    }
    
    
}
