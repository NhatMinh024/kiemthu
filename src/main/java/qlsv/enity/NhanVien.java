package qlsv.enity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity cho bảng NhanVien
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NhanVien {
    private String maNV;
    private String matKhau;
    private String hoTen;
    private String email;
    private String sdt;
    private Boolean gioiTinh;      // true: Nam, false: Nữ
    private String diaChi;
    private Boolean vaiTro;        // true: Quản trị viên, false: Giáo viên
    private java.sql.Date ngayTao;
    private Boolean trangThai;     // true: Hoạt động, false: Không hoạt động

    public String getVaiTroText() {
        return Boolean.TRUE.equals(vaiTro) ? "Quản trị viên" : "Giáo viên";
    }
    public String getTrangThaiText() {
        return Boolean.TRUE.equals(trangThai) ? "Hoạt động" : "Không hoạt động";
    }
    public String getGioiTinhText() {
        return Boolean.TRUE.equals(gioiTinh) ? "Nam" : "Nữ";
    }
}