/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hoang Anh
 */
public class KhachThue extends GianHang{
    private String Ten, DiaChi;
    private int ma, ThoiGianThue;
    private float TienDatCoc;

    public KhachThue() {
    }

    public KhachThue(String MaGianHangTrungBay, String Ten, String DiaChi, int ma, int ThoiGianThue, float TienDatCoc) {
        super();
        this.Ten = Ten;
        this.DiaChi = DiaChi;
        this.ma= ma;
        this.ThoiGianThue = ThoiGianThue;
        this.TienDatCoc = TienDatCoc;
    }

    public String getMaGianHangTrungBay() {
        return MaGianHangTrungBay;
    }

    public void setMaGianHangTrungBay(String MaGianHangTrungBay) {
        this.MaGianHangTrungBay = MaGianHangTrungBay;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getThoiGianThue() {
        return ThoiGianThue;
    }

    public void setThoiGianThue(int ThoiGianThue) {
        this.ThoiGianThue = ThoiGianThue;
    }

    public float getTienDatCoc() {
        return TienDatCoc;
    }

    public void setTienDatCoc(float TienDatCoc) {
        this.TienDatCoc = TienDatCoc;
    }
    
}
