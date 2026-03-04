package qlsv.enity;

import lombok.Data;
import java.util.Date;

@Data
public class Diem {
    private String maSV;
    private String hoTen;
    private String maMH;
    private String tenMH;
    private String maHK;
    private Float diemLab;
    private Float diemQuiz;
    private Float diemAssignment;
    private Float diemFinal;
    private Float diemTB;
    private Date ngayNhap;
}