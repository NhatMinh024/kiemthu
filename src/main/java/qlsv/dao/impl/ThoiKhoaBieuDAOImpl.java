package qlsv.dao.impl;

import java.util.ArrayList;
import java.util.List;
import qlsv.enity.ThoiKhoaBieu;
import qlsv.util.XJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import qlsv.dao.ThoiKhoaBieuDAO;

public class ThoiKhoaBieuDAOImpl implements ThoiKhoaBieuDAO{
    public List<ThoiKhoaBieu> selectByLop(String maLop) {
        
    List<ThoiKhoaBieu> list = new ArrayList<>();
    String sql = "SELECT tkb.*, mh.TenMH, mh.SoTinChi, nv.HoTen AS TenGV " +
             "FROM ThoiKhoaBieu tkb " +
             "JOIN MonHoc mh ON tkb.MaMH = mh.MaMH " +
             "LEFT JOIN NhanVien nv ON tkb.MaGV = nv.MaNV " +
             "WHERE tkb.MaLop = ? " +
             "ORDER BY CASE tkb.Thu " +
             "WHEN 'T2' THEN 1 WHEN 'T3' THEN 2 WHEN 'T4' THEN 3 " +
             "WHEN 'T5' THEN 4 WHEN 'T6' THEN 5 WHEN 'T7' THEN 6 END, tkb.TietBatDau";
    try (ResultSet rs = qlsv.util.XJDBC.executeQuery(sql, maLop)) {
        while (rs.next()) {
            ThoiKhoaBieu tkb = new ThoiKhoaBieu();
            tkb.setId(rs.getInt("ID"));
            tkb.setThu(rs.getString("Thu"));
            tkb.setTietBatDau(rs.getInt("TietBatDau"));
            tkb.setSoTiet(rs.getInt("SoTiet"));
            tkb.setMaMH(rs.getString("MaMH"));
            tkb.setTenMH(rs.getString("TenMH"));
            tkb.setSoTinChi(rs.getInt("SoTinChi"));
            tkb.setMaGV(rs.getString("MaGV"));
            tkb.setTenGV(rs.getString("TenGV"));
            tkb.setPhongHoc(rs.getString("PhongHoc"));
            tkb.setGhiChu(rs.getString("GhiChu"));
            list.add(tkb);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
// sửa dữ liệu 
 @Override
    public boolean update(ThoiKhoaBieu tkb) {
        String sql = "UPDATE ThoiKhoaBieu SET Thu=?, TietBatDau=?, SoTiet=?, PhongHoc=?, GhiChu=? WHERE ID=?";
        try {
            int result = qlsv.util.XJDBC.executeUpdate(sql,
                tkb.getThu(),           // Thứ (ví dụ: "T2")
                tkb.getTietBatDau(),    // Tiết bắt đầu
                tkb.getSoTiet(),        // Số tiết
                tkb.getPhongHoc(),      // Phòng học
                tkb.getGhiChu(),        // Ghi chú
                tkb.getId()             // ID của dòng cần sửa
            );
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
// thêm 
@Override 
public boolean insert(ThoiKhoaBieu tkb) {
    String sql = "INSERT INTO ThoiKhoaBieu (MaHK, MaMH, MaLop, MaGV, Thu, TietBatDau, SoTiet, PhongHoc, GhiChu, NgayTao) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, GETDATE())";
    try (
        Connection con = XJDBC.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {
        ps.setString(1, tkb.getMaHK());         // MaHK
        ps.setString(2, tkb.getMaMH());        // MaMH
        ps.setString(3, tkb.getMaLop());       // MaLop
        ps.setString(4, tkb.getMaGV());        // MaGV
        ps.setString(5, tkb.getThu());         // Thu
        ps.setInt(6, tkb.getTietBatDau());     // TietBatDau
        ps.setInt(7, tkb.getSoTiet());         // SoTiet
        ps.setString(8, tkb.getPhongHoc());    // PhongHoc
        ps.setString(9, tkb.getGhiChu());      // GhiChu
        int result = ps.executeUpdate();
        return result > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
// xem thử mã môn với mã gv tồn tại chưa a
public boolean isMaMonExist(String maMon) {
    String sql = "SELECT COUNT(*) FROM MonHoc WHERE MaMH = ?";
    try (
        java.sql.Connection con = qlsv.util.XJDBC.getConnection();
        java.sql.PreparedStatement ps = con.prepareStatement(sql)
    ) {
        ps.setString(1, maMon);
        java.sql.ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

public boolean isMaGVExist(String maGV) {
    String sql = "SELECT COUNT(*) FROM NHANVIEN WHERE MaNV = ?";
    try (
        java.sql.Connection con = qlsv.util.XJDBC.getConnection();
        java.sql.PreparedStatement ps = con.prepareStatement(sql)
    ) {
        ps.setString(1, maGV);
        java.sql.ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}// danh sách học kì được chọn 
public List<String> getAllMaHK() {
    List<String> list = new ArrayList<>();
    String sql = "SELECT MaHK FROM HocKy";
    try (
        Connection con = XJDBC.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()
    ) {
        while (rs.next()) {
            list.add(rs.getString("MaHK"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
 // xóa
 @Override
 public boolean delete(int id) {
    String sql = "DELETE FROM ThoiKhoaBieu WHERE ID = ?";
    try (
        java.sql.Connection con = qlsv.util.XJDBC.getConnection();
        java.sql.PreparedStatement ps = con.prepareStatement(sql)
    ) {
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        return result > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
// cbo của lớp 
public List<String> getLopByHocKy(String maHK) {
    List<String> list = new ArrayList<>();
    String sql = "SELECT DISTINCT MaLop FROM ThoiKhoaBieu WHERE MaHK = ?";
    try (Connection con = XJDBC.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, maHK);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(rs.getString("MaLop"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
// cbo của môn học 
public List<String> getMonByLopVaHocKy(String maLop, String maHK) {
    List<String> list = new ArrayList<>();
    String sql = "SELECT DISTINCT MaMH FROM ThoiKhoaBieu WHERE MaLop = ? AND MaHK = ?";
    try (Connection con = XJDBC.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, maLop);
        ps.setString(2, maHK);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(rs.getString("MaMH"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
}