/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package qlsv.dao;

import java.util.List;

import qlsv.enity.Lop;

/**
 *
 * @author ADMIN
 */
public interface LopDAO {

    List<Lop> selectAllWithTenKhoaAndTenGV();// hiển thị lên bảng 

    List<Lop> searchByMaLop(String maLop);// Tìm kiếm nề 

    List<Lop> selectAll();

    void delete(String maLop);

    void insert(Lop lop);

    void update(Lop lop);

    int countByMaKhoa(String maKhoa);

    List<Lop> selectByMaKhoa(String maKhoa);

    public Lop selectById(String maLop);

}
