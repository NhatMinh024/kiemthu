package qlsv.dao;

import java.util.List;
import qlsv.enity.Diem;

public interface DiemDAO {
    List<Diem> getBangDiem(String maHK, String maLop, String maMH);
    boolean nhapDiem(Diem diem);
}