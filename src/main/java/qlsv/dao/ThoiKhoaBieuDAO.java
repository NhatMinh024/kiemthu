/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package qlsv.dao;

import java.util.List;
import qlsv.enity.ThoiKhoaBieu;

/**
 *
 * @author ADMIN
 */
public interface ThoiKhoaBieuDAO {
    boolean update(ThoiKhoaBieu tkb);
    boolean insert(ThoiKhoaBieu tkb);
    boolean delete(int id);
    List<String> getLopByHocKy(String maHK);
}
