package qlsv.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien {
    private String maSV;
    private String hoTen;
    private String ngaySinh;    
    private String gioiTinh;
    private String diaChi;
    private String sdt;
    private String email;
    private String maLop;
    private String trangThai;

    @Override
    public String toString() {
        return maSV + " - " + hoTen;
    }
}