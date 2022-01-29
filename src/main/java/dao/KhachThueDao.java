/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.KhachThue;

/**
 *
 * @author Hoang Anh
 */
public class KhachThueDao { //chứa các phương thức cho phép thêm xoá sửa cập nhật với bảng quản lý khách thuê
    public boolean insert(KhachThue kt) throws Exception{
        
        String sql = "INSERT INTO [dbo].[QuanLyKhachThue]([MaGianHangTrungBay],[Ten],[DiaChi],[ThoiGianThue],[TienDatCoc])"
                + " values(?,?,?,?,?)";
                
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, kt.getMaGianHangTrungBay());
            pstmt.setString(2, kt.getTen());
            pstmt.setString(3, kt.getDiaChi());
            pstmt.setInt(4, kt.getThoiGianThue());
            pstmt.setFloat(5, kt.getTienDatCoc());
            return pstmt.executeUpdate()>0;
        }
    }  
    public boolean update(KhachThue kt) throws Exception{
        
      String sql = "UPDATE dbo.QuanLyKhachThue" +
              " SET Ten = ?,DiaChi = ?, ThoiGianThue = ?,TienDatCoc = ?" +
              " WHERE MaGianHangTrungBay = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(5, kt.getMaGianHangTrungBay());
            pstmt.setString(1, kt.getTen());
            pstmt.setString(2, kt.getDiaChi());
            pstmt.setInt(3, kt.getThoiGianThue());
            pstmt.setFloat(4, kt.getTienDatCoc());
            
            return pstmt.executeUpdate()>0; // cập nhật dữ liệu trong bảng khách thuê 
        }
    }  
    public boolean deleteByMaGianHang(String MaGianHang) throws Exception{
        
      String sql = "delete from QuanLyKhachThue" +
              " where MaGianHangTrungBay = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, MaGianHang);
            
            return pstmt.executeUpdate()>0;
        }
    } 
//    public KhachThue findByMaGianHang(String MaGianHang) throws Exception{
//        
//      String sql = "select * from QuanLyKhachThue where MaGianHang = ?";            
//        try(
//                Connection con = DatabaseHelper.openConnection();
//                PreparedStatement pstmt = con.prepareStatement(sql);
//            ){
//            pstmt.setString(1, MaGianHang);
//            try(ResultSet rs = pstmt.executeQuery();){
//               if (rs.next()){
//                  KhachThue kt = new KhachThue();
//                  kt.setMa(rs.getInt("Ma"));
//                  kt.setMaGianHangTrungBay(rs.getString("MaGianHang"));
//                  kt.setTen(rs.getString("Ten"));
//                  kt.setDiaChi(rs.getString("DiaChi"));
//                  kt.setThoiGianThue(rs.getInt("ThoiGianThue"));
//                  kt.setTienDatCoc(rs.getFloat("TienDatCoc"));
//                  
//                  return kt;
//               }
//            }
//           return null; // trả về null nếu không tìm thấy khách trong bảng quản lý khách thuê
//        }
//    } 
    public List<KhachThue> findAll() throws Exception{
        String sql = "select * from QuanLyKhachThue";            
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<KhachThue> list = new ArrayList<>();
                while (rs.next()){
                  KhachThue kt = new KhachThue();
                  kt.setMa(rs.getInt("Ma"));
                  kt.setMaGianHangTrungBay(rs.getString("MaGianHangTrungBay"));
                  kt.setTen(rs.getString("Ten"));
                  kt.setDiaChi(rs.getString("DiaChi"));
                  kt.setThoiGianThue(rs.getInt("ThoiGianThue"));
                  kt.setTienDatCoc(rs.getFloat("TienDatCoc"));
                  list.add(kt);
               }
               return list;
            }  
        }
    }
}
