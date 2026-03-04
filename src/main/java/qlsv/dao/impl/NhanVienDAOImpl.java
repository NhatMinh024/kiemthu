package qlsv.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import qlsv.dao.NhanVienDAO;
import qlsv.enity.NhanVien;
import qlsv.util.XJDBC;

public class NhanVienDAOImpl implements NhanVienDAO {

    @Override
    public NhanVien findById(String maNV) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
        try (ResultSet rs = XJDBC.executeQuery(sql, maNV)) {
            if (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setEmail(rs.getString("Email"));
                nv.setSdt(rs.getString("SDT"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setVaiTro(rs.getBoolean("VaiTro"));
                nv.setNgayTao(rs.getDate("NgayTao"));
                nv.setTrangThai(rs.getBoolean("TrangThai"));
                return nv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public NhanVien login(String maNV, String matKhau) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV = ? AND MatKhau = ? AND TrangThai = 1";
        try (ResultSet rs = XJDBC.executeQuery(sql, maNV, matKhau)) {
            if (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setEmail(rs.getString("Email"));
                nv.setSdt(rs.getString("SDT"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setVaiTro(rs.getBoolean("VaiTro"));
                nv.setNgayTao(rs.getDate("NgayTao"));
                nv.setTrangThai(rs.getBoolean("TrangThai"));
                return nv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean changePassword(String maNV, String matKhauCu, String matKhauMoi) {
        String sql = "UPDATE NhanVien SET MatKhau = ? WHERE MaNV = ? AND MatKhau = ?";
        int row = XJDBC.executeUpdate(sql, matKhauMoi, maNV, matKhauCu);
        return row > 0;
    }

    @Override
    public boolean insert(NhanVien nv) {
        String sql = "INSERT INTO NhanVien (MaNV, MatKhau, HoTen, Email, SDT, GioiTinh, DiaChi, VaiTro, NgayTao, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int row = XJDBC.executeUpdate(sql,
                nv.getMaNV(), nv.getMatKhau(), nv.getHoTen(), nv.getEmail(), nv.getSdt(),
                nv.getGioiTinh(), nv.getDiaChi(), nv.getVaiTro(), nv.getNgayTao(), nv.getTrangThai());
        return row > 0;
    }

    @Override
    public boolean update(NhanVien nv) {
        String sql = "UPDATE NhanVien SET MatKhau=?, HoTen=?, Email=?, SDT=?, GioiTinh=?, DiaChi=?, VaiTro=?, NgayTao=?, TrangThai=? WHERE MaNV=?";
        int row = XJDBC.executeUpdate(sql,
                nv.getMatKhau(), nv.getHoTen(), nv.getEmail(), nv.getSdt(),
                nv.getGioiTinh(), nv.getDiaChi(), nv.getVaiTro(), nv.getNgayTao(), nv.getTrangThai(),
                nv.getMaNV());
        return row > 0;
    }

    @Override
    public boolean delete(String maNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNV=?";
        int row = XJDBC.executeUpdate(sql, maNV);
        return row > 0;
    }

    @Override
    public List<NhanVien> selectAll() {
        List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien";
        try (ResultSet rs = XJDBC.executeQuery(sql)) {
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setEmail(rs.getString("Email"));
                nv.setSdt(rs.getString("SDT"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setVaiTro(rs.getBoolean("VaiTro"));
                nv.setNgayTao(rs.getDate("NgayTao"));
                nv.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<NhanVien> searchByName(String hoTen) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NhanVien> filterByVaiTro(boolean vaiTro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
public NhanVien selectById(String maNV) {
    String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
    try (ResultSet rs = qlsv.util.XJDBC.executeQuery(sql, maNV)) {
        if (rs.next()) {
            NhanVien nv = new NhanVien();
            nv.setMaNV(rs.getString("MaNV"));
            nv.setHoTen(rs.getString("HoTen"));
            // ...set các trường khác nếu cần
            return nv;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
}