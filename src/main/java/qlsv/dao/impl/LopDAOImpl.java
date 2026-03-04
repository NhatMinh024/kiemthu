
package qlsv.dao.impl;

/**
 *
 * @author ADMIN
 */
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import qlsv.dao.LopDAO;
import qlsv.enity.Lop;
import qlsv.util.XJDBC;

public class LopDAOImpl implements LopDAO {
    @Override
public List<Lop> selectAll() {
    List<Lop> list = new ArrayList<>();
    String sql = "SELECT MaLop, TenLop, MaKhoa, MaGV, NienKhoa, SiSo, NgayBatDau, NgayKetThuc FROM Lop";
    try (ResultSet rs = XJDBC.executeQuery(sql)) {
        while (rs.next()) {
            Lop lop = new Lop();
            lop.setMaLop(rs.getString("MaLop"));
            lop.setTenLop(rs.getString("TenLop"));
            lop.setMaKhoa(rs.getString("MaKhoa"));
            lop.setMaGV(rs.getString("MaGV")); // lấy mã giáo viên
            lop.setNienKhoa(rs.getString("NienKhoa"));
            lop.setSiSo(rs.getInt("SiSo"));
            lop.setNgayBatDau(rs.getDate("NgayBatDau"));
            lop.setNgayKetThuc(rs.getDate("NgayKetThuc"));
            list.add(lop);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}

 @Override
public List<Lop> searchByMaLop(String maLop) {
    List<Lop> list = new ArrayList<>();
    String sql = "SELECT l.MaLop, l.TenLop, k.TenKhoa, nv.HoTen AS TenGV, l.NienKhoa, l.SiSo, l.NgayBatDau, l.NgayKetThuc " +
                 "FROM Lop l " +
                 "JOIN Khoa k ON l.MaKhoa = k.MaKhoa " +
                 "LEFT JOIN NhanVien nv ON l.MaGV = nv.MaNV " +
                 "WHERE l.MaLop = ?";
    try (ResultSet rs = XJDBC.executeQuery(sql, maLop)) {
        while (rs.next()) {
            Lop lop = new Lop();
            lop.setMaLop(rs.getString("MaLop"));
            lop.setTenLop(rs.getString("TenLop"));
            lop.setTenKhoa(rs.getString("TenKhoa"));
            lop.setTenGV(rs.getString("TenGV"));
            lop.setNienKhoa(rs.getString("NienKhoa"));
            lop.setSiSo(rs.getInt("SiSo"));
            lop.setNgayBatDau(rs.getDate("NgayBatDau"));
            lop.setNgayKetThuc(rs.getDate("NgayKetThuc"));
            list.add(lop);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
// xóa 
@Override
public void delete(String maLop) {
    String sql = "DELETE FROM Lop WHERE MaLop = ?";
    XJDBC.executeUpdate(sql, maLop);
}
// thêm mới 
@Override
public void insert(Lop lop) {
    String sql = "INSERT INTO Lop (MaLop, TenLop, MaKhoa, MaGV, NienKhoa, SiSo, NgayBatDau, NgayKetThuc) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    XJDBC.executeUpdate(sql,
        lop.getMaLop(),
        lop.getTenLop(),
        lop.getMaKhoa(), 
        lop.getMaGV(),  
        lop.getNienKhoa(),
        lop.getSiSo(),
        lop.getNgayBatDau(),
        lop.getNgayKetThuc()
    );
}
@Override
public void update(Lop lop) {
    String sql = "UPDATE Lop SET TenLop=?, MaKhoa=?, MaGV=?, NienKhoa=?, SiSo=?, NgayBatDau=?, NgayKetThuc=? WHERE MaLop=?";
    XJDBC.executeUpdate(sql,
        lop.getTenLop(),
        lop.getMaKhoa(),
        lop.getMaGV(),
        lop.getNienKhoa(),
        lop.getSiSo(),
        lop.getNgayBatDau(),
        lop.getNgayKetThuc(),
        lop.getMaLop()
    );
}

    @Override
    public List<Lop> selectAllWithTenKhoaAndTenGV() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
public int countByMaKhoa(String maKhoa) {
    String sql = "SELECT COUNT(*) FROM Lop WHERE MaKhoa = ?";
    try (java.sql.ResultSet rs = qlsv.util.XJDBC.executeQuery(sql, maKhoa)) {
        if (rs.next()) return rs.getInt(1);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}
@Override
public List<Lop> selectByMaKhoa(String maKhoa) {
    List<Lop> list = new ArrayList<>();
    String sql = "SELECT * FROM Lop WHERE MaKhoa = ?";
    try (ResultSet rs = qlsv.util.XJDBC.executeQuery(sql, maKhoa)) {
        while (rs.next()) {
            Lop lop = new Lop(
                rs.getString("MaLop"),
                rs.getString("TenLop"),
                rs.getString("MaKhoa"),
                null, // TenKhoa không có trong bảng Lop
                rs.getString("MaGV"),
                null, // TenGV không có trong bảng Lop
                rs.getString("NienKhoa"),
                rs.getInt("SiSo"),
                rs.getDate("NgayBatDau"),
                rs.getDate("NgayKetThuc")
            );
            list.add(lop);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
@Override
public Lop selectById(String maLop) {
    String sql = "SELECT * FROM Lop WHERE MaLop = ?";
    try (ResultSet rs = qlsv.util.XJDBC.executeQuery(sql, maLop)) {
        if (rs.next()) {
            Lop lop = new Lop();
            lop.setMaLop(rs.getString("MaLop"));
            // ...set các trường khác nếu cần
            return lop;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
// dư liệu lọc lớp của thơi khóa biểuu 
public List<String> getAllMaLop() {
    List<String> list = new ArrayList<>();
    String sql = "SELECT MaLop FROM Lop";
    try (ResultSet rs = qlsv.util.XJDBC.executeQuery(sql)) {
        while (rs.next()) {
            list.add(rs.getString("MaLop"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}

}
