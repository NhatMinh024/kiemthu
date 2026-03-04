package qlsv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import qlsv.enity.HocKy;
import qlsv.dao.HocKyD;
import qlsv.enity.MonHoc;
import qlsv.util.XJDBC;

public class HocKyDAOImpl implements HocKyD {

    @Override
    public List<HocKy> selectAll() {
        List<HocKy> list = new ArrayList<>();
        String sql = "SELECT MaHK, TenHK, NgayBatDau, NgayKetThuc, NamHoc, TrangThai FROM HocKy ORDER BY NgayBatDau DESC";
        try (ResultSet rs = XJDBC.executeQuery(sql)) {
            while (rs.next()) {
                HocKy hk = new HocKy(
                        rs.getString("MaHK"),
                        rs.getString("TenHK"),
                        rs.getDate("NgayBatDau"),
                        rs.getDate("NgayKetThuc"),
                        rs.getString("NamHoc"),
                        rs.getBoolean("TrangThai")
                );
                list.add(hk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
public void update(HocKy hocKy) {
    String sql = "UPDATE HocKy SET TenHK = ?, NgayBatDau = ?, NgayKetThuc = ?, NamHoc = ?, TrangThai = ? WHERE MaHK = ?";
    XJDBC.executeUpdate(sql,
        hocKy.getTenHK(),
        hocKy.getNgayBatDau(),
        hocKy.getNgayKetThuc(),
        hocKy.getNamHoc(),
        hocKy.isTrangThai(),
        hocKy.getMaHK()
    );
}
@Override
public void insert(HocKy hocKy) {
    String sql = "INSERT INTO HocKy (MaHK, TenHK, NgayBatDau, NgayKetThuc, NamHoc, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
    XJDBC.executeUpdate(sql,
        hocKy.getMaHK(),
        hocKy.getTenHK(),
        hocKy.getNgayBatDau(),
        hocKy.getNgayKetThuc(),
        hocKy.getNamHoc(),
        hocKy.isTrangThai()
    );
}
@Override
public void delete(String maHK) {
    String sql = "DELETE FROM HocKy WHERE MaHK = ?";
    XJDBC.executeUpdate(sql, maHK);
}
public int countMonHocByMaHK(String maHK) {
    String sql = "SELECT COUNT(*) FROM MonHoc WHERE MaHK = ?";
    try (ResultSet rs = XJDBC.executeQuery(sql, maHK)) {
        if (rs.next()) return rs.getInt(1);
    } catch (Exception e) { e.printStackTrace(); }
    return 0;
}
public int countDiemByMaHK(String maHK) {
    String sql = "SELECT COUNT(*) FROM Diem WHERE MaHK = ?";
    try (ResultSet rs = XJDBC.executeQuery(sql, maHK)) {
        if (rs.next()) return rs.getInt(1);
    } catch (Exception e) { e.printStackTrace(); }
    return 0;
}
public int countTKBByMaHK(String maHK) {
    String sql = "SELECT COUNT(*) FROM ThoiKhoaBieu WHERE MaHK = ?";
    try (ResultSet rs = XJDBC.executeQuery(sql, maHK)) {
        if (rs.next()) return rs.getInt(1);
    } catch (Exception e) { e.printStackTrace(); }
    return 0;
}
// môn học chi tiết theo học kỳ 
public List<MonHoc> selectMonHocByMaHK(String maHK) {
    List<MonHoc> list = new ArrayList<>();
   String sql = "SELECT MaMH, TenMH, SoTinChi, MaGV, MaKhoa, MaHK FROM MonHoc WHERE MaHK = ?";
    try (ResultSet rs = XJDBC.executeQuery(sql, maHK)) {
        while (rs.next()) {
            MonHoc mh = new MonHoc(
                rs.getString("MaMH"),
                rs.getString("TenMH"),
                rs.getInt("SoTinChi"),
                rs.getString("MaGV"),
                rs.getString("MaKhoa"),
                rs.getString("MaHK")
            );
            list.add(mh);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
// cbo học kỳ của diem 
 @Override
    public List<String> getAllMaHK() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT MaHK FROM HocKy";
        try (Connection con = XJDBC.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(rs.getString("MaHK"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}