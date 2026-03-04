package qlsv.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import qlsv.enity.Khoa;
import qlsv.dao.KhoaDAO;
import qlsv.util.XJDBC;

public class KhoaDAOImpl implements KhoaDAO {

    @Override
    public List<Khoa> selectAll() {
        List<Khoa> list = new ArrayList<>();
        String sql = "SELECT MaKhoa, TenKhoa, NgayThanhLap, TruongKhoa, SDT, Email, DiaChi, GhiChu, TrangThai FROM Khoa";
        try (ResultSet rs = XJDBC.executeQuery(sql)) {
            while (rs.next()) {
                Khoa k = new Khoa(
                        rs.getString("MaKhoa"),
                        rs.getString("TenKhoa"),
                        rs.getString("NgayThanhLap"),
                        rs.getString("TruongKhoa"),
                        rs.getString("SDT"),
                        rs.getString("Email"),
                        rs.getString("DiaChi"),
                        rs.getString("GhiChu"),
                        rs.getInt("TrangThai")
                );
                list.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(Khoa khoa) {
        String sql = "INSERT INTO Khoa (MaKhoa, TenKhoa, NgayThanhLap, TruongKhoa, SDT, Email, DiaChi, GhiChu, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        XJDBC.executeUpdate(sql,
                khoa.getMaKhoa(),
                khoa.getTenKhoa(),
                khoa.getNgayThanhLap(),
                khoa.getTruongKhoa(),
                khoa.getSDT(),
                khoa.getEmail(),
                khoa.getDiaChi(),
                khoa.getGhiChu(),
                khoa.getTrangThai()
        );
    }

    @Override
    public void update(Khoa khoa) {
        String sql = "UPDATE Khoa SET TenKhoa = ?, NgayThanhLap = ?, TruongKhoa = ?, SDT = ?, Email = ?, DiaChi = ?, GhiChu = ?, TrangThai = ? WHERE MaKhoa = ?";
        XJDBC.executeUpdate(sql,
                khoa.getTenKhoa(),
                khoa.getNgayThanhLap(),
                khoa.getTruongKhoa(),
                khoa.getSDT(),
                khoa.getEmail(),
                khoa.getDiaChi(),
                khoa.getGhiChu(),
                khoa.getTrangThai(),
                khoa.getMaKhoa()
        );
    }

    @Override
    public List<Khoa> search(String keyword) {
        List<Khoa> list = new ArrayList<>();
        String sql = "SELECT MaKhoa, TenKhoa, NgayThanhLap, TruongKhoa, SDT, Email, DiaChi, GhiChu, TrangThai FROM Khoa WHERE MaKhoa LIKE ? OR TenKhoa LIKE ?";
        String searchPattern = "%" + keyword + "%";
        try (ResultSet rs = XJDBC.executeQuery(sql, searchPattern, searchPattern)) {
            while (rs.next()) {
                Khoa k = new Khoa(
                        rs.getString("MaKhoa"),
                        rs.getString("TenKhoa"),
                        rs.getString("NgayThanhLap"),
                        rs.getString("TruongKhoa"),
                        rs.getString("SDT"),
                        rs.getString("Email"),
                        rs.getString("DiaChi"),
                        rs.getString("GhiChu"),
                        rs.getInt("TrangThai")
                );
                list.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

   @Override
public void delete(String maKhoa) {
    String sql = "DELETE FROM Khoa WHERE MaKhoa = ?";
    qlsv.util.XJDBC.executeUpdate(sql, maKhoa);
}
    @Override
    // Trong KhoaDAO và KhoaDAOImpl
public List<Khoa> selectByMaKhoa(String maKhoa) {
    List<Khoa> list = new ArrayList<>();
    String sql = "SELECT MaKhoa, TenKhoa, NgayThanhLap, TruongKhoa, SDT, Email, DiaChi, GhiChu, TrangThai FROM Khoa WHERE MaKhoa LIKE ?";
    try (ResultSet rs = XJDBC.executeQuery(sql, "%" + maKhoa + "%")) {
        while (rs.next()) {
            Khoa k = new Khoa(
                rs.getString("MaKhoa"),
                rs.getString("TenKhoa"),
                rs.getString("NgayThanhLap"),
                rs.getString("TruongKhoa"),
                rs.getString("SDT"),
                rs.getString("Email"),
                rs.getString("DiaChi"),
                rs.getString("GhiChu"),
                rs.getInt("TrangThai")
            );
            list.add(k);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
@Override
// đếm số lượng 
public int countByMaKhoa(String maKhoa) {
    String sql = "SELECT COUNT(*) FROM SinhVien sv JOIN Lop l ON sv.MaLop = l.MaLop WHERE l.MaKhoa = ?";
    try (java.sql.ResultSet rs = qlsv.util.XJDBC.executeQuery(sql, maKhoa)) {
        if (rs.next()) return rs.getInt(1);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}
}
