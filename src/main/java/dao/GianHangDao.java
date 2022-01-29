/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.GianHang;

/**
 *
 * @author Hoang Anh
 */
public class GianHangDao { // chứa các phương thức thêm, sửa, xoá, tìm kiếm, cập nhật từ sql lên bảng gian hàng
    public boolean insert(GianHang gh) throws Exception{
        
        String sql = "INSERT INTO dbo.GianTrungBay(MaGianHangTrungBay,GianTrungBay,DienTich,ViTriGianTrungBay,QuatLamMat,BanGhe)" +
                "values(?,?,?,?,?,?)";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, gh.getMaGianHangTrungBay());
            pstmt.setInt(2, gh.getGianTrungBay());
            pstmt.setInt(3, gh.getDienTich());
            pstmt.setString(4, gh.getViTriGianTrungBay());
            pstmt.setInt(5, gh.getQuatLamMat());
            pstmt.setInt(6, gh.getBanGhe());
            return pstmt.executeUpdate()>0;
        }
    }  
    public boolean update(GianHang gh) throws Exception{
        
      String sql = "UPDATE dbo.GianTrungBay" +
              " SET GianTrungBay = ?,DienTich = ?, ViTriGianTrungBay = ?,QuatLamMat = ?,BanGhe = ? " +
              " WHERE MaGianHangTrungBay = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(6, gh.getMaGianHangTrungBay());
            pstmt.setInt(1, gh.getGianTrungBay());
            pstmt.setInt(2, gh.getDienTich());
            pstmt.setString(3, gh.getViTriGianTrungBay());
            pstmt.setInt(4, gh.getQuatLamMat());
            pstmt.setInt(5, gh.getBanGhe());
            return pstmt.executeUpdate()>0;
        }
    }  
    public boolean delete(String MaGianHang) throws Exception{
        
      String sql = "delete from GianTrungBay" +
              " where MaGianHangTrungBay = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, MaGianHang);
            
            return pstmt.executeUpdate()>0;
        }
    } 
    public List<GianHang> findByID(String MaGianHang) throws Exception{
        
               List<GianHang> list = new ArrayList<>();
        try {
             String sql = "select * from GianTrungBay where MaGianHangTrungBay like '%"+MaGianHang+"%'";  
             Connection con = DatabaseHelper.openConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()){
                    GianHang gh = new GianHang();
                    gh.setMaGianHangTrungBay(rs.getString(1));
                    gh.setGianTrungBay(rs.getInt(2));
                    gh.setDienTich(rs.getInt(3));
                    gh.setViTriGianTrungBay(rs.getString(4));
                    gh.setQuatLamMat(rs.getInt(5));
                    gh.setBanGhe(rs.getInt(6));
                    list.add(gh) ;
                }
                stm.close();
                rs.close();
        } catch (Exception e) {
            
        }
        return list;
        }
    
    private GianHang createGianHang(final ResultSet rs) throws SQLException {
        GianHang gh = new GianHang();
        gh.setMaGianHangTrungBay(rs.getString("MaGianHangTrungBay"));
        gh.setGianTrungBay(rs.getInt("GianTrungBay"));
        gh.setDienTich(rs.getInt("DienTich"));
        gh.setViTriGianTrungBay(rs.getString("VitriGianTrungBay"));
        gh.setQuatLamMat(rs.getInt("QuatLamMat"));
        gh.setBanGhe(rs.getInt("BanGhe"));
        return gh;
    }
    public List<GianHang> findAll() throws Exception{
        String sql = "select * from GianTrungBay";            
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<GianHang> list = new ArrayList<>();
                while (rs.next()){
                   GianHang gh = createGianHang(rs);
                   list.add(gh);
               }
               return list;
            }    
        }
    }
    
}
