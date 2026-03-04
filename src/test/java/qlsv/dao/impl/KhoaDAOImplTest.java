package qlsv.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import qlsv.dao.KhoaDAO;
import qlsv.enity.Khoa;

class KhoaDAOImplTest {

    private KhoaDAO dao;

    @BeforeEach
    void setUp() {
        dao = new KhoaDAOImpl();
    }

    // ================= TC_KHOA_01 =================
    @Test
    void TC_KHOA_01_selectAll() {
        List<Khoa> list = dao.selectAll();
        assertNotNull(list);
    }

    // ================= TC_KHOA_02 =================
    @Test
    void TC_KHOA_02_selectAll_MapCorrect() {
        List<Khoa> list = dao.selectAll();
        if (!list.isEmpty()) {
            Khoa k = list.get(0);
            assertNotNull(k.getMaKhoa());
            assertNotNull(k.getTenKhoa());
        }
    }

    // ================= TC_KHOA_03 =================
    @Test
    void TC_KHOA_03_insert_Valid() {
        Khoa k = new Khoa(
            "TEST_KHOA",
            "Khoa Test",
            "2024-01-01",
            "GV001",
            "0123456789",
            "test@gmail.com",
            "Da Nang",
            "",
            1
        );

        assertDoesNotThrow(() -> dao.insert(k));
    }

    // ================= TC_KHOA_04 =================
    @Test
    void TC_KHOA_04_insert_Duplicate() {
        Khoa k = new Khoa(
            "CNTT", // đã tồn tại
            "Cong nghe thong tin",
            "2020-01-01",
            "GV001",
            null,
            null,
            null,
            null,
            1
        );

        assertThrows(RuntimeException.class, () -> dao.insert(k));
    }

    // ================= TC_KHOA_05 =================
    @Test
    void TC_KHOA_05_insert_MissingData() {
        Khoa k = new Khoa();
        k.setMaKhoa("TEST_NULL");

        assertThrows(RuntimeException.class, () -> dao.insert(k));
    }

    // ================= TC_KHOA_06 =================
    @Test
    void TC_KHOA_06_update_Valid() {
        Khoa k = new Khoa(
            "CNTT",
            "CNTT Updated",
            "2020-01-01",
            "GV001",
            null,
            null,
            null,
            null,
            1
        );

        assertDoesNotThrow(() -> dao.update(k));
    }

    // ================= TC_KHOA_07 =================
    @Test
    void TC_KHOA_07_update_Invalid() {
        Khoa k = new Khoa();
        k.setMaKhoa(null);

        assertThrows(RuntimeException.class, () -> dao.update(k));
    }

    // ================= TC_KHOA_08 =================
    @Test
    void TC_KHOA_08_delete_Success() {
        assertDoesNotThrow(() -> dao.delete("DL"));
    }

    // ================= TC_KHOA_09 =================
    @Test
    void TC_KHOA_09_delete_Fail_Constraint() {
        assertThrows(RuntimeException.class, () -> dao.delete("CNTT"));
    }

    // ================= TC_KHOA_10 =================
    @Test
    void TC_KHOA_10_findByMaKhoa_Valid() {
        List<Khoa> list = dao.selectByMaKhoa("CNTT");
        assertFalse(list.isEmpty());
    }

    // ================= TC_KHOA_11 =================
    @Test
    void TC_KHOA_11_findByMaKhoa_Null() {
        List<Khoa> list = dao.selectByMaKhoa(null);
        assertTrue(list.isEmpty());
    }

    // ================= TC_KHOA_12 =================
    @Test
    void TC_KHOA_12_findByMaKhoa_NotFound() {
        List<Khoa> list = dao.selectByMaKhoa("xyzabc");
        assertTrue(list.isEmpty());
    }
}
