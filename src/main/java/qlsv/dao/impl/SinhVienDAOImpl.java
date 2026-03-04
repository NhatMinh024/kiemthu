/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlsv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import qlsv.dao.SinhVienDAO;
import qlsv.enity.SinhVien;


import qlsv.util.XJDBC;

/**
 *
 * @author ADMIN
 */
public class SinhVienDAOImpl  implements SinhVienDAO{
     @Override
    public List<SinhVien> selectAll() {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM SinhVien";
        try (ResultSet rs = XJDBC.executeQuery(sql)) {
            while (rs.next()) {
                SinhVien sv = new SinhVien(
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getString("NgaySinh"),
                    rs.getString("GioiTinh"),
                    rs.getString("DiaChi"),
                    rs.getString("SDT"),
                    rs.getString("Email"),
                    rs.getString("MaLop"),
                    rs.getString("TrangThai")
                );
                list.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
public List<SinhVien> selectByMaSV(String maSV) {
    List<SinhVien> list = new ArrayList<>();
    String sql = "SELECT * FROM SinhVien WHERE MaSV LIKE ?";
    try (ResultSet rs = XJDBC.executeQuery(sql, "%" + maSV + "%")) {
        while (rs.next()) {
            SinhVien sv = new SinhVien(
                rs.getString("MaSV"),
                rs.getString("HoTen"),
                rs.getString("NgaySinh"),
                rs.getString("GioiTinh"),
                rs.getString("DiaChi"),
                rs.getString("SDT"),
                rs.getString("Email"),
                rs.getString("MaLop"),
                rs.getString("TrangThai")
            );
            list.add(sv);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
@Override
public void insert(SinhVien sv) {
    String sql = "INSERT INTO SinhVien (MaSV, HoTen, NgaySinh, GioiTinh, DiaChi, Sdt, Email, MaLop, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    XJDBC.executeUpdate(sql,
        sv.getMaSV(),
        sv.getHoTen(),
        sv.getNgaySinh(),
        sv.getGioiTinh(),
        sv.getDiaChi(),
        sv.getSdt(),
        sv.getEmail(),
        sv.getMaLop(),
        sv.getTrangThai()
    );
}
@Override
public void delete(String maSV) {
    String sql = "DELETE FROM SinhVien WHERE MaSV = ?";
    XJDBC.executeUpdate(sql, maSV);
}
@Override
public void update(SinhVien sv) {
    String sql = "UPDATE SinhVien SET HoTen=?, NgaySinh=?, GioiTinh=?, DiaChi=?, Sdt=?, Email=?, MaLop=?, TrangThai=? WHERE MaSV=?";
    XJDBC.executeUpdate(sql,
        sv.getHoTen(),
        sv.getNgaySinh(),
        sv.getGioiTinh(),
        sv.getDiaChi(),
        sv.getSdt(),
        sv.getEmail(),
        sv.getMaLop(),
        sv.getTrangThai(),
        sv.getMaSV()
    );
    
}

@Override
public List<SinhVien> selectByMaLop(String maLop) {
    List<SinhVien> list = new ArrayList<>();
    String sql = "SELECT * FROM SinhVien WHERE MaLop = ?";
    try (ResultSet rs = XJDBC.executeQuery(sql, maLop)) {
        while (rs.next()) {
            SinhVien sv = new SinhVien(
                rs.getString("MaSV"),
                rs.getString("HoTen"),
                rs.getString("NgaySinh"),
                rs.getString("GioiTinh"),
                rs.getString("DiaChi"),
                rs.getString("SDT"),
                rs.getString("Email"),
                rs.getString("MaLop"),
                rs.getString("TrangThai")
            );
            list.add(sv);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
@Override
public List<SinhVien> selectByMaLopNull() {
    List<SinhVien> list = new ArrayList<>();
    String sql = "SELECT * FROM SinhVien WHERE MaLop IS NULL";
    try (ResultSet rs = XJDBC.executeQuery(sql)) {
        while (rs.next()) {
            SinhVien sv = new SinhVien(
                rs.getString("MaSV"),
                rs.getString("HoTen"),
                rs.getString("NgaySinh"),
                rs.getString("GioiTinh"),
                rs.getString("DiaChi"),
                rs.getString("SDT"),
                rs.getString("Email"),
                rs.getString("MaLop"),
                rs.getString("TrangThai")
            );
            list.add(sv);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
@Override
public int countByKhoa(String maKhoa) {
    String sql = "SELECT COUNT(*) FROM SinhVien sv JOIN Lop l ON sv.MaLop = l.MaLop WHERE l.MaKhoa = ?";
    try (java.sql.ResultSet rs = qlsv.util.XJDBC.executeQuery(sql, maKhoa)) {
        if (rs.next()) return rs.getInt(1);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}

    @Override
    public SinhVien selectById(String maSV) {
         String sql = "SELECT * FROM SinhVien WHERE MaSV = ?";
    try (ResultSet rs = XJDBC.executeQuery(sql, maSV)) {
        if (rs.next()) {
            return new SinhVien(
                rs.getString("MaSV"),
                rs.getString("HoTen"),
                rs.getString("NgaySinh"),
                rs.getString("GioiTinh"),
                rs.getString("DiaChi"),
                rs.getString("SDT"),
                rs.getString("Email"),
                rs.getString("MaLop"),
                rs.getString("TrangThai")
            );
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null; // Không tìm thấy sinh viên
    }
}
