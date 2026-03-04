package qlsv.enity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Khoa {
    private String maKhoa;
    private String tenKhoa;
    private String ngayThanhLap;
    private String truongKhoa;
    private String SDT;
    private String email;
    private String diaChi;
    private String ghiChu;
    private int trangThai;
}