package phone_shop.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author Trong Phan Sy
 */
public class SanPham {

    private String maSP;
    private String tenSP;
    private String moTa;
    private int soLuong;
    private float donGia;
    private String hinhAnh;
    private boolean trangThai;
    private String maDM;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String moTa, int soLuong, float donGia, String hinhAnh, boolean trangThai, String maDM) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
        this.maDM = maDM;
    }

    /**
     * @return the maSP
     */
    public String getMaSP() {
        return maSP;
    }

    /**
     * @param maSP the maSP to set
     */
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    /**
     * @return the tenSP
     */
    public String getTenSP() {
        return tenSP;
    }

    /**
     * @param tenSP the tenSP to set
     */
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
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
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    /**
     * @return the donGia
     */
    public float getDonGia() {
        return donGia;
    }

    /**
     * @return the donGiaStr
     */
    public String getDonGiaStr() {
        BigDecimal donGiaB = BigDecimal.valueOf(donGia);
        donGiaB = donGiaB.setScale(0, RoundingMode.HALF_UP);
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(donGiaB) + "₫";
    }
    public String getDonGiaNo() {
        BigDecimal donGiaB = BigDecimal.valueOf(donGia);
        donGiaB = donGiaB.setScale(0, RoundingMode.HALF_UP);
        DecimalFormat df = new DecimalFormat("#,###");
        return donGiaB.toString();
    }

    /**
     * @param donGia the donGia to set
     */
    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    /**
     * @return the hinhAnh
     */
    public String getHinhAnh() {
        return hinhAnh;
    }

    /**
     * @param hinhAnh the hinhAnh to set
     */
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
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

    @Override
    public String toString() {
        return maSP + " | " + tenSP + " | " + moTa + " | " + soLuong + " | " + donGia + " | " + hinhAnh + " | " + trangThai + " | " + maDM;
    }

}
