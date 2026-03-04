package qlsv.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import qlsv.enity.NhanVien;

class NhanVienDAOImplTest {

    private NhanVienDAOImpl dao;

    @BeforeEach
    void setUp() {
        dao = new NhanVienDAOImpl();
    }

    @AfterEach
    void tearDown() {
        dao.delete("GV_TEST");
    }

    // ===== TC_NV_01 =====
    @Test
    void testFindById_Valid() {
        NhanVien nv = dao.findById("GV001");
        assertNotNull(nv);
        assertEquals("GV001", nv.getMaNV());
    }

    // ===== TC_NV_02 =====
    @Test
    void testFindById_NotFound() {
        NhanVien nv = dao.findById("GV999");
        assertNull(nv);
    }

    // ===== TC_NV_03 =====
    @Test
    void testFindById_Null() {
        NhanVien nv = dao.findById(null);
        assertNull(nv);
    }

    // ===== TC_NV_04 =====
    @Test
    void testLogin_Success() {
        NhanVien nv = dao.login("Thong", "1234");
        assertNotNull(nv);
        assertTrue(nv.getVaiTro()); // admin
    }

    // ===== TC_NV_05 =====
    @Test
    void testLogin_WrongPassword() {
        NhanVien nv = dao.login("GV001", "sai_mat_khau");
        assertNull(nv);
    }

    // ===== TC_NV_06 =====
    @Test
    void testLogin_NullInput() {
        NhanVien nv = dao.login(null, null);
        assertNull(nv);
    }

    // ===== TC_NV_07 =====
    @Test
    void testChangePassword_Success() {
        boolean result = dao.changePassword("GV001", "0123", "9999");
        assertTrue(result);

        // đổi lại cho DB 
        dao.changePassword("GV001", "9999", "0123");
    }


    // ===== TC_NV_08 =====
    @Test
    void testChangePassword_Fail() {
        boolean result = dao.changePassword("GV001", "sai", "1234");
        assertFalse(result);
    }

    // ===== TC_NV_09 =====
    @Test
    void testInsert_Success() {
        NhanVien nv = new NhanVien();
        nv.setMaNV("GV_TEST");
        nv.setMatKhau("123");
        nv.setHoTen("Thong Test");
        nv.setEmail("test@gmail.com");
        nv.setSdt("0900000000");
        nv.setGioiTinh(true);
        nv.setDiaChi("117 Dong Ke");
        nv.setVaiTro(true);
        nv.setNgayTao(new java.sql.Date(System.currentTimeMillis()));

        nv.setTrangThai(true);

        boolean result = dao.insert(nv);
        assertTrue(result);
    }

    // ===== TC_NV_10 =====
    @Test
    void testInsert_Fail_MissingData() {
        NhanVien nv = new NhanVien();
        nv.setMaNV("GV_TEST");   //

        assertThrows(RuntimeException.class, () -> {
            dao.insert(nv);
        });
    }


    // ===== TC_NV_11 =====
    @Test
    void testSelectAll() {
        List<NhanVien> list = dao.selectAll();
        assertNotNull(list);
    }

    // ===== TC_NV_12 =====
    @Test
    void testSelectById_NotExist() {
        NhanVien nv = dao.selectById("GV_NOT_EXIST");
        assertNull(nv);
    }
}
