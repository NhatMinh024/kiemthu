/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package qlsv.dao;

import java.util.List;
import qlsv.enity.HocKy;

/**
 *
 * @author ADMIN
 */
public interface HocKyD {
    List<HocKy> selectAll();
    void update(HocKy hocKy); 
    void insert(HocKy hocKy);
    void delete(String maHK);
    List<String> getAllMaHK();

}
