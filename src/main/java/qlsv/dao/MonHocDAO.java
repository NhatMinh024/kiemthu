/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package qlsv.dao;

import java.util.List;
import qlsv.enity.MonHoc;

/**
 *
 * @author ADMIN
 */
public interface MonHocDAO {
    List<MonHoc> selectAll();
    void delete(String maMH);
    void insert(MonHoc monHoc);    
    void update(MonHoc monHoc);
    int countByMaKhoa(String khoa);
    int countDiemByMaMH(String maMH);
    int countTKBByMaMH(String maMH);  
}
