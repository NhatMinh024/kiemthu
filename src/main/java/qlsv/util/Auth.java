package qlsv.util;

import qlsv.enity.NhanVien;
public class Auth {
    
    /**
     * Đối tượng này chứa thông tin của người sử dụng sau khi đăng nhập
     */
    public static NhanVien user = null;
    
    /**
     * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void clear() {
        Auth.user = null;
    }
   
    public static boolean isLogin() {
        return Auth.user != null;
    }
    public static boolean isManager() {
        return Auth.isLogin() && Auth.user.getVaiTro(); 
    }
    
    /**
     * Kiểm tra xem có phải là giáo viên hay không
     */
    public static boolean isTeacher() {
        return Auth.isLogin() && !Auth.user.getVaiTro(); 
    }
}