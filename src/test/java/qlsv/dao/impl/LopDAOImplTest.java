package qlsv.dao.impl;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import qlsv.dao.impl.LopDAOImpl;
import qlsv.enity.Lop;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LopDAOImplTest {

    private static LopDAOImpl dao;

    @BeforeAll
    static void setUp() {
        dao = new LopDAOImpl();
    }

    // TC_Lop_01
    @Test
    @Order(1)
    void testSelectAll_NotEmpty() {
        List<Lop> list = dao.selectAll();
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    // TC_Lop_02
    @Test
    @Order(2)
    void testMappingData() {
        Lop lop = dao.selectAll().get(0);
        assertNotNull(lop.getMaLop());
        assertNotNull(lop.getTenLop());
        assertNotNull(lop.getMaKhoa());
        assertNotNull(lop.getMaGV());
        assertNotNull(lop.getNienKhoa());
        assertNotNull(lop.getSiSo());
    }

    // TC_Lop_03
    @Test
    @Order(3)
    void testFindByMaLop_Valid() {
        Lop lop = dao.selectAll()
                .stream()
                .filter(l -> l.getMaLop().equals("SD20303"))
                .findFirst()
                .orElse(null);

        assertNotNull(lop);
    }

 // TC_Lop_04
    @Test
    @Order(4)
    void testInsert_Valid() {
        Lop lop = new Lop();
        lop.setMaLop("SD1111");
        lop.setTenLop("CNTT");
        lop.setMaKhoa("CNTT");
        lop.setMaGV("GV001");
        lop.setNienKhoa("2024-2025");
        lop.setSiSo(20);

        dao.insert(lop);

        boolean exists = dao.selectAll()
                .stream()
                .anyMatch(l -> l.getMaLop().equals("SD1111"));

        assertTrue(exists);
    }

    // TC_Lop_05
    @Test
    @Order(5)
    void testInsert_Duplicate() {
        Lop lop = new Lop();
        lop.setMaLop("SD1111");
        lop.setTenLop("CNTT");
        lop.setMaKhoa("CNTT");
        lop.setMaGV("GV001");
        lop.setNienKhoa("2024-2025");
        lop.setSiSo(20);

        assertThrows(Exception.class, () -> dao.insert(lop));
    }

    @Test
    @Order(6)
    void testInsert_MissingData() {
        String maTest = "SD_TEST_06";

        // đảm bảo không tồn tại trước
        dao.delete(maTest);

        Lop lop = new Lop();
        lop.setMaLop(maTest);
        lop.setTenLop("CNTT");
        lop.setMaKhoa("CNTT");
        lop.setMaGV("GV001");
        lop.setNienKhoa("2024-2025");
        lop.setSiSo(-1); // dữ liệu không hợp lệ

        dao.insert(lop);

        boolean exists = dao.selectAll()
                .stream()
                .anyMatch(l -> l.getMaLop().equals(maTest));

        assertTrue(exists, 
        	    "DAO không kiểm tra nghiệp vụ, dữ liệu vẫn được thêm");

    }





    @Test
    @Order(7)
    void testUpdate_Valid() {
        Lop lop = new Lop();
        lop.setMaLop("SD1111");
        lop.setTenLop("CNTT Update");
        lop.setMaKhoa("CNTT");
        lop.setMaGV("GV001");
        lop.setNienKhoa("2024-2025");
        lop.setSiSo(25);

        dao.update(lop);

        Lop updated = dao.selectAll()
                .stream()
                .filter(l -> l.getMaLop().equals("SD1111"))
                .findFirst()
                .orElse(null);

        assertNotNull(updated);
        assertEquals(25, updated.getSiSo());
    }


    // TC_Lop_08
    @Test
    @Order(8)
    void testUpdate_Invalid() {
        Lop lop = new Lop();
        lop.setMaLop("SD1111");
        lop.setTenLop("CNTT");
        lop.setMaKhoa("CNTT");
        lop.setMaGV("GV001");
        lop.setNienKhoa("2024-2025");
        lop.setSiSo(-5); // dữ liệu sai

        dao.update(lop);

        Lop updated = dao.selectAll()
                .stream()
                .filter(l -> l.getMaLop().equals("SD1111"))
                .findFirst()
                .orElse(null);

        assertNotNull(updated);
        assertEquals(-5, updated.getSiSo(),
            "DAO không kiểm tra nghiệp vụ khi update");
    }



    // TC_Lop_09
    @Test
    @Order(9)
    void testDelete_NoStudent() {
        dao.delete("SD1111");

        boolean exists = dao.selectAll()
                .stream()
                .anyMatch(l -> l.getMaLop().equals("SD1111"));

        assertFalse(exists);
    }

    // TC_Lop_10
    @Test
    @Order(10)
    void testDelete_HasStudent() {
        assertThrows(Exception.class, () -> dao.delete("SD20303"));
    }

    // TC_Lop_11
    @Test
    @Order(11)
    void testDelete_HasTKB() {
        String maLop = "SD20301";

        dao.delete(maLop);

        boolean exists = dao.selectAll()
                .stream()
                .anyMatch(l -> l.getMaLop().equals(maLop));

        // DAO không kiểm tra ràng buộc TKB
        assertFalse(exists,
        	    "DAO cho phép xóa lớp dù có thời khóa biểu");

    }

}
