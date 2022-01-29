/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hoang Anh
 */
public class GianHang {
    protected String MaGianHangTrungBay, ViTriGianTrungBay;
    protected int GianTrungBay, DienTich, QuatLamMat, BanGhe;

    public GianHang() {
    }

    public GianHang(String MaGianHangTrungBay, String ViTriGianTrungBay, int GianTrungBay, int DienTich, int QuatLamMat, int BanGhe) {
        this.MaGianHangTrungBay = MaGianHangTrungBay;
        this.ViTriGianTrungBay = ViTriGianTrungBay;
        this.GianTrungBay = GianTrungBay;
        this.DienTich = DienTich;
        this.QuatLamMat = QuatLamMat;
        this.BanGhe = BanGhe;
    }

    
    
    public String getMaGianHangTrungBay() {
        return MaGianHangTrungBay;
    }

    public String getViTriGianTrungBay() {
        return ViTriGianTrungBay;
    }

    public int getGianTrungBay() {
        GetGianHang();
        return GianTrungBay;
    }

    public int getDienTich() {
        return DienTich;
    }

    public int getQuatLamMat() {
        return QuatLamMat;
    }

    public int getBanGhe() {
        return BanGhe;
    }

    public void setMaGianHangTrungBay(String MaGianHangTrungBay) {
        this.MaGianHangTrungBay = MaGianHangTrungBay;
    }

    public void setViTriGianTrungBay(String ViTriGianTrungBay) {
        this.ViTriGianTrungBay = ViTriGianTrungBay;
    }

    public void setGianTrungBay(int GianTrungBay) {
        this.GianTrungBay = GianTrungBay;
    }

    public void setDienTich(int DienTich) {
        this.DienTich = DienTich;
    }

    public void setQuatLamMat(int QuatLamMat) {
        this.QuatLamMat = QuatLamMat;
    }

    public void setBanGhe(int BanGhe) {
        this.BanGhe = BanGhe;
    }
    public String GetGianHang(){
         if(GianTrungBay == 1){ 
            return "Tiêu chuẩn";
        }
        else{
            return "Cao cấp";
        }
    }
}
