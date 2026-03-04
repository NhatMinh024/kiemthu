package qlsv.dao;

import qlsv.enity.NhanVien;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NhanVienDAO {
    
    // Authentication - Giống UserDAO của PolyCafe
    NhanVien findById(String maNV);
    NhanVien login(String maNV, String matKhau);
    boolean changePassword(String maNV, String matKhauCu, String matKhauMoi);
    
    // CRUD operations
    boolean insert(NhanVien nv);
    boolean update(NhanVien nv);
    boolean delete(String maNV);
    List<NhanVien> selectAll();
    
    // Search & Filter
    List<NhanVien> searchByName(String hoTen);
    List<NhanVien> filterByVaiTro(boolean vaiTro);

    public NhanVien selectById(String maNV);
    
}