/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package qlsv.dao;

import java.util.List;
import qlsv.enity.SinhVien;

/**
 *
 * @author ADMIN
 */
public interface SinhVienDAO {
    List<SinhVien> selectAll();
    List<SinhVien> selectByMaSV(String maSV);
    void insert(SinhVien sv);
    void delete(String maSV);
    void update(SinhVien sv);
    List<SinhVien> selectByMaLop(String maLop);
    List<SinhVien> selectByMaLopNull();
    int countByKhoa(String maKhoa); // Đếm số sinh viên theo mã khoa
     qlsv.enity.SinhVien selectById(String maSV);  
}
