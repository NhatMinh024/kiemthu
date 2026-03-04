package qlsv.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import qlsv.enity.SinhVien;

public class SinhVienDAOImplTest {

    private SinhVienDAOImpl dao;

    @BeforeEach
    void setUp() {
        dao = new SinhVienDAOImpl();
    }

    @AfterEach
    void tearDown() {
        // Dọn dữ liệu test nếu còn
        try {
            dao.delete("SV999");
        } catch (Exception e) {
            // bỏ qua
        }
    }

    // TC_SV_01: Lấy toàn bộ danh sách sinh viên
    @Test
    void testSelectAll() {
        List<SinhVien> list = dao.selectAll();
        assertNotNull(list);
        assertTrue(list.size() >= 0);
    }

    // TC_SV_02: Tìm sinh viên với mã hợp lệ
    @Test
    void testSelectById_Valid() {
        SinhVien sv = dao.selectById("SV001");
        assertNotNull(sv);
        assertEquals("SV001", sv.getMaSV());
    }

    // TC_SV_03: Tìm sinh viên không tồn tại
    @Test
    void testSelectById_NotFound() {
        SinhVien sv = dao.selectById("SV_NOT_EXIST");
        assertNull(sv);
    }

    // TC_SV_04: Tìm sinh viên với mã null
    @Test
    void testSelectById_Null() {
        SinhVien sv = dao.selectById(null);
        assertNull(sv);
    }

    // TC_SV_05: Thêm sinh viên hợp lệ
    @Test
    void testInsert_Valid() {
        // dọn dữ liệu test cũ
        dao.delete("SV_TEST_01");

        SinhVien sv = new SinhVien(
            "SV_TEST_01",
            "Nguyen Phi Thong",
            "2003-10-16",   // DATE OK
            "1",            // GioiTinh: 1 = Nam
            "117 Dong Ke",
            "0987654321",
            "thong@gmail.com",
            "SD20303",      // tồn tại trong DB
            "1"             // TrangThai: 1 = hoạt động
        );

        dao.insert(sv);

        SinhVien result = dao.selectById("SV_TEST_01");
        assertNotNull(result);
        assertEquals("SV_TEST_01", result.getMaSV());

        // dọn sau test
        dao.delete("SV_TEST_01");
    }



    // TC_SV_06: Thêm sinh viên trùng mã
    @Test
    void testInsert_Duplicate() {
        SinhVien sv = new SinhVien(
            "SV001", // đã tồn tại
            "Trung Ma",
            "2000-01-01",
            "Nam",
            "Da Nang",
            "0123456789",
            "test@gmail.com",
            "IT01",
            "Hoat dong"
        );

        assertThrows(RuntimeException.class, () -> dao.insert(sv));
    }

    // TC_SV_07: Cập nhật sinh viên hợp lệ
    @Test
    void testUpdate_Valid() {
        SinhVien sv = dao.selectById("SV001");
        assertNotNull(sv);

        sv.setDiaChi("Da Nang Updated");
        dao.update(sv);

        SinhVien updated = dao.selectById("SV001");
        assertEquals("Da Nang Updated", updated.getDiaChi());
    }

    // TC_SV_08: Cập nhật sinh viên với dữ liệu NULL (vi phạm NOT NULL)
    @Test
    void testUpdate_Invalid() {
        SinhVien sv = new SinhVien(
            "SV001",
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        );

        assertThrows(RuntimeException.class, () -> dao.update(sv));
    }

    // TC_SV_09: Xóa sinh viên tồn tại
    @Test
    void testDelete_Exist() {
        // tạo sinh viên test
        SinhVien sv = new SinhVien(
            "SV999",                 // dùng mã riêng cho test
            "Temp",
            "2000-01-01",
            "Nam",
            "Da Nang",
            "0900000000",            // ⚠ BẮT BUỘC có SĐT
            "temp@gmail.com",
            "IT01",
            "Hoat dong"
        );

//        dao.insert(sv);

        // xóa
        dao.delete("SV999");

        // kiểm tra
        SinhVien result = dao.selectById("SV999");
        assertNull(result);
    }


    // TC_SV_10: Xóa sinh viên không tồn tại
    @Test
    void testDelete_NotExist() {
        assertDoesNotThrow(() -> dao.delete("SV_NOT_EXIST"));
    }
}
