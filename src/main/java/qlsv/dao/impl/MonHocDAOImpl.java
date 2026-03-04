package qlsv.dao.impl;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import qlsv.dao.MonHocDAO;
import qlsv.enity.MonHoc;
import qlsv.util.XJDBC;

public class MonHocDAOImpl implements MonHocDAO {
    @Override
    public List<MonHoc> selectAll() {
        List<MonHoc> list = new ArrayList<>();
        String sql = "SELECT MaMH, TenMH, SoTinChi, MaGV, MaKhoa, MaHK FROM MonHoc";
        try (ResultSet rs = XJDBC.executeQuery(sql)) {
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
    @Override
public void delete(String maMH) {
    String sql = "DELETE FROM MonHoc WHERE MaMH = ?";
    XJDBC.executeUpdate(sql, maMH);
}
@Override
    public void insert(MonHoc monHoc) {
        String sql = "INSERT INTO MonHoc (MaMH, TenMH, SoTinChi, MaHK, MaGV) VALUES (?, ?, ?, ?, ?)";
        XJDBC.executeUpdate(sql, monHoc.getMaMH(), monHoc.getTenMH(), monHoc.getSoTinChi(), monHoc.getMaHK(), monHoc.getMaGV());
    }


@Override
public void update(MonHoc monHoc) {
    String sql = "UPDATE MonHoc SET TenMH=?, SoTinChi=?, MaGV=?, MaKhoa=?, MaHK=? WHERE MaMH=?";
    XJDBC.executeUpdate(sql,
        monHoc.getTenMH(),
        monHoc.getSoTinChi(),
        monHoc.getMaGV(),
        monHoc.getMaKhoa(),
        monHoc.getMaHK(),
        monHoc.getMaMH()
    );
}
 @Override
public int countByMaKhoa(String maKhoa) {
    String sql = "SELECT COUNT(*) FROM MonHoc WHERE MaKhoa = ?";
    try (java.sql.ResultSet rs = qlsv.util.XJDBC.executeQuery(sql, maKhoa)) {
        if (rs.next()) return rs.getInt(1);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}


@Override
public int countDiemByMaMH(String maMH) {
    String sql = "SELECT COUNT(*) FROM Diem WHERE MaMH = ?";
    try (java.sql.ResultSet rs = qlsv.util.XJDBC.executeQuery(sql, maMH)) {
        if (rs.next()) return rs.getInt(1);
    } catch (Exception e) { e.printStackTrace(); }
    return 0;
}

@Override
public int countTKBByMaMH(String maMH) {
    String sql = "SELECT COUNT(*) FROM ThoiKhoaBieu WHERE MaMH = ?";
    try (java.sql.ResultSet rs = qlsv.util.XJDBC.executeQuery(sql, maMH)) {
        if (rs.next()) return rs.getInt(1);
    } catch (Exception e) { e.printStackTrace(); }
    return 0;
}
 // cbo của học kỳ 
 public List<String> getAllMaHK() {
    List<String> list = new ArrayList<>();
    String sql = "SELECT MaHK FROM HocKy";
    try (Connection con = qlsv.util.XJDBC.getConnection();
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