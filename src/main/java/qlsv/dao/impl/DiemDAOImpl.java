/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlsv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import qlsv.dao.DiemDAO;
import qlsv.enity.Diem;
import qlsv.util.XJDBC;

/**
 *
 * @author ADMIN
 */
public class DiemDAOImpl implements DiemDAO {

    // đổ dữ liệu lên bảng điểm
    @Override
    public List<Diem> getBangDiem(String maHK, String maLop, String maMH) {
        List<Diem> list = new ArrayList<>();
        String sql = "SELECT sv.MaSV, sv.HoTen, mh.MaMH, mh.TenMH, tkb.MaHK, "
                + "d.DiemLab, d.DiemQuiz, d.DiemAssignment, d.DiemFinal, "
                + "CASE WHEN d.DiemLab IS NOT NULL AND d.DiemQuiz IS NOT NULL AND d.DiemAssignment IS NOT NULL AND d.DiemFinal IS NOT NULL "
                + "THEN (d.DiemLab + d.DiemQuiz + d.DiemAssignment + d.DiemFinal) / 4 ELSE NULL END AS DiemTB, "
                + "d.NgayNhap "
                + "FROM SinhVien sv "
                + "JOIN ThoiKhoaBieu tkb ON sv.MaLop = tkb.MaLop "
                + "JOIN MonHoc mh ON tkb.MaMH = mh.MaMH "
                + "LEFT JOIN Diem d ON sv.MaSV = d.MaSV AND mh.MaMH = d.MaMH AND tkb.MaHK = d.MaHK "
                + "WHERE tkb.MaHK = ? AND tkb.MaLop = ? AND tkb.MaMH = ?";
        try (Connection con = XJDBC.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maHK);
            ps.setString(2, maLop);
            ps.setString(3, maMH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Diem diem = new Diem();
                diem.setMaSV(rs.getString("MaSV"));
                diem.setHoTen(rs.getString("HoTen"));
                diem.setMaMH(rs.getString("MaMH"));
                diem.setTenMH(rs.getString("TenMH"));
                diem.setMaHK(rs.getString("MaHK"));
                diem.setDiemLab(rs.getObject("DiemLab") == null ? null : rs.getFloat("DiemLab"));
                diem.setDiemQuiz(rs.getObject("DiemQuiz") == null ? null : rs.getFloat("DiemQuiz"));
                diem.setDiemAssignment(rs.getObject("DiemAssignment") == null ? null : rs.getFloat("DiemAssignment"));
                diem.setDiemFinal(rs.getObject("DiemFinal") == null ? null : rs.getFloat("DiemFinal"));
                diem.setDiemTB(rs.getObject("DiemTB") == null ? null : rs.getFloat("DiemTB"));
                diem.setNgayNhap(rs.getTimestamp("NgayNhap"));
                list.add(diem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // nhập điểm 
    @Override 
    public boolean nhapDiem(Diem diem) {
    String checkSql = "SELECT COUNT(*) FROM Diem WHERE MaSV = ? AND MaMH = ? AND MaHK = ?";
    String insertSql = "INSERT INTO Diem (MaSV, MaMH, MaHK, DiemLab, DiemQuiz, DiemAssignment, DiemFinal, NgayNhap) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection con = XJDBC.getConnection()) {
        // Kiểm tra đã có điểm chưa
        try (PreparedStatement psCheck = con.prepareStatement(checkSql)) {
            psCheck.setString(1, diem.getMaSV());
            psCheck.setString(2, diem.getMaMH());
            psCheck.setString(3, diem.getMaHK());
            ResultSet rs = psCheck.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count == 0) {
                // Chưa có điểm, insert mới
                Timestamp now = Timestamp.valueOf(LocalDateTime.now());
                try (PreparedStatement psInsert = con.prepareStatement(insertSql)) {
                    psInsert.setString(1, diem.getMaSV());
                    psInsert.setString(2, diem.getMaMH());
                    psInsert.setString(3, diem.getMaHK());
                    psInsert.setObject(4, diem.getDiemLab());
                    psInsert.setObject(5, diem.getDiemQuiz());
                    psInsert.setObject(6, diem.getDiemAssignment());
                    psInsert.setObject(7, diem.getDiemFinal());
                    psInsert.setTimestamp(8, now);
                    return psInsert.executeUpdate() > 0;
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
 // hàm sửa điểm 
 public boolean suaDiem(qlsv.enity.Diem diem) {
    String sql = "UPDATE Diem SET DiemLab = ?, DiemQuiz = ?, DiemAssignment = ?, DiemFinal = ?, NgayNhap = ? WHERE MaSV = ? AND MaMH = ? AND MaHK = ?";
    try (Connection con = qlsv.util.XJDBC.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setObject(1, diem.getDiemLab());
        ps.setObject(2, diem.getDiemQuiz());
        ps.setObject(3, diem.getDiemAssignment());
        ps.setObject(4, diem.getDiemFinal());
        ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
        ps.setString(6, diem.getMaSV());
        ps.setString(7, diem.getMaMH());
        ps.setString(8, diem.getMaHK());
        return ps.executeUpdate() > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
// xóa điểm 
public boolean xoaDiem(String maSV, String maMH, String maHK) {
    String sql = "DELETE FROM Diem WHERE MaSV = ? AND MaMH = ? AND MaHK = ?";
    try (Connection con = qlsv.util.XJDBC.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, maSV);
        ps.setString(2, maMH);
        ps.setString(3, maHK);
        return ps.executeUpdate() > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
}
