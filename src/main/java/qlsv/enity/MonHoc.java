package qlsv.enity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonHoc {
    private String maMH;
    private String tenMH;
    private int soTinChi;
    private String maGV;
    private String maKhoa;
    private String maHK; 
}