/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package qlsv.ui;

/**
 *
 * @author ADMIN
 */
public class ThemSVJDialog extends javax.swing.JDialog {

    /**
     * Creates new form ThemSV2JDialog
     */
    private String maLop;
    public ThemSVJDialog(java.awt.Frame parent, boolean modal, String maLop) {
        super(parent, modal);
        this.maLop = maLop;
        initComponents();
        loadSinhVienChuaCoLop();
        setLocationRelativeTo(null); // Căn giữa
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icon/abc.png")).getImage());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cboMaSV = new javax.swing.JComboBox<>();
        btnLoc = new javax.swing.JButton();
        btnThen = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý sinh viên - Nguyễn Phi Thông");

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM SINH VIÊN");

        jLabel13.setIcon(new javax.swing.ImageIcon("D:\\ALL MÔN\\SUMMER_2025_BLOCK_2\\DUAN_1\\ANHDUAN\\CHINH.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ", "SDT", "Email", "Trạng thái", "Mã lớp ", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSinhVien);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Tìm kiếm sinh viên theo mã : ");

        cboMaSV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "SV", "PD", "MD" }));

        btnLoc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnLoc.setIcon(new javax.swing.ImageIcon("D:\\ALL MÔN\\SUMMER_2025_BLOCK_2\\DUAN_1\\ANHDUAN\\LOC.png")); // NOI18N
        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        btnThen.setIcon(new javax.swing.ImageIcon("D:\\ALL MÔN\\SUMMER_2025_BLOCK_2\\DUAN_1\\ANHDUAN\\THEM.png")); // NOI18N
        btnThen.setText("Thêm");
        btnThen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThenActionPerformed(evt);
            }
        });

        btnHuy.setIcon(new javax.swing.ImageIcon("D:\\ALL MÔN\\SUMMER_2025_BLOCK_2\\DUAN_1\\ANHDUAN\\Huy.png")); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThen)
                .addGap(31, 31, 31)
                .addComponent(btnHuy)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoc)
                        .addGap(0, 532, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThen)
                    .addComponent(btnHuy))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
        locSinhVienTheoMa();
    }//GEN-LAST:event_btnLocActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThenActionPerformed
        // TODO add your handling code here:
        them();
    }//GEN-LAST:event_btnThenActionPerformed

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // ... phần look and feel giữ nguyên ...

    /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            String maLop = "L01"; // Khai báo mã lớp mẫu ở đây, hoặc giá trị bạn muốn test
            ThemSVJDialog dialog = new ThemSVJDialog(new javax.swing.JFrame(), true, maLop);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        }
    });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnThen;
    private javax.swing.JComboBox<String> cboMaSV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSinhVien;
    // End of variables declaration//GEN-END:variables
    private void loadSinhVienChuaCoLop() {
    qlsv.dao.SinhVienDAO dao = new qlsv.dao.impl.SinhVienDAOImpl();// tạo đối tượng để truy xuất 
    java.util.List<qlsv.enity.SinhVien> list = dao.selectByMaLopNull();
    // chuẩn bi bảng đẻ hiển thị dữ liệu 
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblSinhVien.getModel();
    model.setRowCount(0);
    // duyệt qua từng sinh viên 
    for (qlsv.enity.SinhVien sv : list) {
        String trangThaiText = "Đang học";
        if ("1".equals(sv.getTrangThai())) trangThaiText = "Nghỉ học";
        else if ("2".equals(sv.getTrangThai())) trangThaiText = "Tốt nghiệp";

        model.addRow(new Object[]{
            sv.getMaSV(),
            sv.getHoTen(),
            sv.getNgaySinh(),
            sv.getGioiTinh().equals("1") ? "Nam" : "Nữ",
            sv.getDiaChi(),
            sv.getSdt(),
            sv.getEmail(),
            trangThaiText,
            sv.getMaLop(), // null
            Boolean.FALSE   // cột checkbox
        });
    }
}
private void locSinhVienTheoMa() {
    String filter = cboMaSV.getSelectedItem().toString();// lấy giá trị lọc từ cbo 
    qlsv.dao.SinhVienDAO dao = new qlsv.dao.impl.SinhVienDAOImpl();
    java.util.List<qlsv.enity.SinhVien> list = dao.selectByMaLopNull();

    // Nếu chọn hết thì không lọc
    if (!filter.equals("Tất cả")) {
        java.util.List<qlsv.enity.SinhVien> filtered = new java.util.ArrayList<>();
        for (qlsv.enity.SinhVien sv : list) {
            if (sv.getMaSV().startsWith(filter)) {
                filtered.add(sv);
            }
        }
        list = filtered;
    }

    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblSinhVien.getModel();
    model.setRowCount(0);
    for (qlsv.enity.SinhVien sv : list) {
        String trangThaiText = "Đang học";
        if ("1".equals(sv.getTrangThai())) trangThaiText = "Nghỉ học";
        else if ("2".equals(sv.getTrangThai())) trangThaiText = "Tốt nghiệp";

        model.addRow(new Object[]{
            sv.getMaSV(),
            sv.getHoTen(),
            sv.getNgaySinh(),
            sv.getGioiTinh().equals("1") ? "Nam" : "Nữ",// chuyển đối sang chữ 
            sv.getDiaChi(),
            sv.getSdt(),
            sv.getEmail(),
            trangThaiText,
            sv.getMaLop(),
            Boolean.FALSE
        });
    }
}
// thêm sinh viên từ bảng 
private void them() {
    // lấy mmodel của bảng sin viên 
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblSinhVien.getModel();
    qlsv.dao.SinhVienDAO dao = new qlsv.dao.impl.SinhVienDAOImpl();
    boolean daChon = false;// xem thử đã chọn sinh viên chưa 
    // kiểm tra thử đã chọn chưa nếu rồi thì lấy mã sinh viên ở cột 0 
    for (int i = 0; i < model.getRowCount(); i++) {
        Boolean checked = (Boolean) model.getValueAt(i, 9); // cột checkbox
        if (checked != null && checked) {
            String maSV = model.getValueAt(i, 0).toString();
            java.util.List<qlsv.enity.SinhVien> ds = dao.selectByMaSV(maSV);
            if (ds != null && !ds.isEmpty()) {
                qlsv.enity.SinhVien sv = ds.get(0);
                sv.setMaLop(maLop);
                dao.update(sv);
                daChon = true;
            }
        }
    }
    if (daChon) {
        javax.swing.JOptionPane.showMessageDialog(this, "Thêm sinh viên vào lớp thành công!");
        this.dispose();
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Hãy chọn sinh viên để thêm!");
    }
}
}

