package qlsv.enity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lop {
    private String maLop;
    private String tenLop;
    private String maKhoa;   // mã khoa để lưu DB
    private String tenKhoa;  // tên khoa để hiển thị
    private String maGV;     // mã giáo viên để lưu DB
    private String tenGV;    // tên giáo viên để hiển thị
    private String nienKhoa;
    private int siSo;
    private Date ngayBatDau;
    private Date ngayKetThuc;
}