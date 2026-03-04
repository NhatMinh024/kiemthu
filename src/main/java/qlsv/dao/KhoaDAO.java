package qlsv.dao;

import java.util.List;
import qlsv.enity.Khoa;

public interface KhoaDAO {
    List<Khoa> selectAll();
    void delete(String maKhoa);
    List<Khoa> search(String keyword);
    void insert(Khoa khoa);
    void update(Khoa khoa);
    List<Khoa> selectByMaKhoa(String maKhoa);
    int countByMaKhoa(String maKhoa);
}