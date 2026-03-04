package qlsv.dao.impl;

import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import qlsv.dao.MonHocDAO;
import qlsv.enity.MonHoc;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MonHocDAOImplTest {

    private static MonHocDAO dao;

    @BeforeAll
    static void setUp() {
        dao = new MonHocDAOImpl();
    }

    // ===================== TC_MH_01 =====================
    @Test
    @Order(1)
    void TC_MH_01_selectAll() {
        List<MonHoc> list = dao.selectAll();
        assertNotNull(list);
    }

    // ===================== TC_MH_02 =====================
    @Test
    @Order(2)
    void TC_MH_02_selectAll_MapCorrect() {
        List<MonHoc> list = dao.selectAll();
        if (!list.isEmpty()) {
            MonHoc mh = list.get(0);
            assertNotNull(mh.getMaMH());
            assertNotNull(mh.getTenMH());
            assertTrue(mh.getSoTinChi() > 0);
            assertNotNull(mh.getMaGV());
//            assertNotNull(mh.getMaKhoa());
//            assertNotNull(mh.getMaHK());
        }
    }

    // ===================== TC_MH_03 =====================
    @Test
    @Order(3)
    void TC_MH_03_insert_Valid() {
        MonHoc mh = new MonHoc(
                "TEST_MH",
                "Kiểm thử",
                4,
                "GV001",
                "CNTT",
                "FA23"
        );

        assertDoesNotThrow(() -> dao.insert(mh));
    }

    // ===================== TC_MH_04 =====================
    @Test
    @Order(4)
    void TC_MH_04_insert_Duplicate() {
        MonHoc mh = new MonHoc(
                "TEST_MH",
                "Kiểm thử",
                4,
                "GV01",
                "KH01",
                "FA23"
        );

        assertThrows(RuntimeException.class, () -> dao.insert(mh));
    }

    // ===================== TC_MH_05 =====================
    @Test
    @Order(5)
    void TC_MH_05_insert_MissingData() {
        MonHoc mh = new MonHoc();
        mh.setMaMH("MH_NULL");

        assertThrows(RuntimeException.class, () -> dao.insert(mh));
    }

    // ===================== TC_MH_06 =====================
    @Test
    @Order(6)
    void TC_MH_06_update_Valid() {
        MonHoc mh = new MonHoc(
                "TEST_MH",
                "Kiểm thử UPDATED",
                3,
                "GV001",
                "CNTT",
                "FA23"
        );

        assertDoesNotThrow(() -> dao.update(mh));
    }

    // ===================== TC_MH_07 =====================
    @Test
    @Order(7)
    void TC_MH_07_update_Invalid() {
        MonHoc mh = new MonHoc();
        mh.setMaMH("TEST_MH");

        assertThrows(RuntimeException.class, () -> dao.update(mh));
    }

    // ===================== TC_MH_08 =====================
    @Test
    @Order(8)
    void TC_MH_08_delete_Success() {
        assertDoesNotThrow(() -> dao.delete("TEST_MH"));
    }

    // ===================== TC_MH_09 =====================
    @Test
    @Order(9)
    void TC_MH_09_delete_Fail_Constraint() {
        // Môn học đang có điểm / TKB
        if (dao.countDiemByMaMH("MH02") > 0 || dao.countTKBByMaMH("MH02") > 0) {
            assertThrows(RuntimeException.class, () -> dao.delete("MH02"));
        }
    }

    // ===================== TC_MH_10 =====================
    @Test
    @Order(10)
    void TC_MH_10_countByMaKhoa() {
        int count = dao.countByMaKhoa("KH01");
        assertTrue(count >= 0);
    }

    // ===================== TC_MH_11 =====================
    @Test
    @Order(11)
    void TC_MH_11_countByMaMH_Null() {
        int count = dao.countDiemByMaMH(null);
        assertEquals(0, count);
    }
}
