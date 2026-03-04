package qlsv.dao.impl;

import qlsv.enity.ThongKe;
import qlsv.util.XJDBC;
import java.sql.*;
import java.util.*;

public class ThongKeDAOImpl {
    public List<ThongKe> getThongKe() {
        List<ThongKe> list = new ArrayList<>();
        String sql = "SELECT k.TenKhoa, l.TenLop, COUNT(sv.MaSV) AS SoSinhVien, " +
                     "SUM(CASE WHEN sv.GioiTinh = 1 THEN 1 ELSE 0 END) AS Nam, " +
                     "SUM(CASE WHEN sv.GioiTinh = 0 THEN 1 ELSE 0 END) AS Nu, " +
                     "SUM(CASE WHEN d.DiemTB >= 8 THEN 1 ELSE 0 END) AS Gioi, " +
                     "SUM(CASE WHEN d.DiemTB >= 6.5 AND d.DiemTB < 8 THEN 1 ELSE 0 END) AS Kha, " +
                     "SUM(CASE WHEN d.DiemTB < 6.5 THEN 1 ELSE 0 END) AS TrungBinh " +
                     "FROM Lop l " +
                     "JOIN Khoa k ON l.MaKhoa = k.MaKhoa " +
                     "JOIN SinhVien sv ON sv.MaLop = l.MaLop " +
                     "LEFT JOIN Diem d ON d.MaSV = sv.MaSV " +
                     "GROUP BY k.TenKhoa, l.TenLop " +
                     "ORDER BY k.TenKhoa, l.TenLop";
        try (
            Connection con = XJDBC.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setKhoa(rs.getString("TenKhoa"));
                tk.setLop(rs.getString("TenLop"));
                tk.setSoSinhVien(rs.getInt("SoSinhVien"));
                tk.setNam(rs.getInt("Nam"));
                tk.setNu(rs.getInt("Nu"));
                tk.setGioi(rs.getInt("Gioi"));
                tk.setKha(rs.getInt("Kha"));
                tk.setTrungBinh(rs.getInt("TrungBinh"));
                list.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}