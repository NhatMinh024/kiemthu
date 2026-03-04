package qlsv.enity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HocKy {
    private String maHK;
    private String tenHK;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String namHoc;
    private boolean trangThai;
}