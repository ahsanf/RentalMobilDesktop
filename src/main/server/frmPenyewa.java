/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.server;
import main.login;
import main.server.MainServer;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.koneksi;

/**
 *
 * @author AHSAN
 */
public class frmPenyewa extends javax.swing.JFrame {
    private Connection con = null;
    private Statement st;
    private ResultSet RsPenyewa;
    private String sql="";
    private String idpenyewa,namapenyewa,alamat,hp,ktp,status,level,pass;
    /**
     * Creates new form frmPenyewa
     */
    public frmPenyewa() {
        initComponents();
        this.setLocationRelativeTo(null);
        con = koneksi.koneksi();
        TampilData(sql);
        jLabel8.setText("<html> BILA USER DIMASUKKAN DARI PANEL ADMIN <br><br>MAKA PASSWORD DEFAULT: 12345</html>");
       
    }
    
     
     private void TampilData (String sql){
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("NO");
        datalist.addColumn("ID PENYEWA");
        datalist.addColumn("NAMA PENYEWA");
        datalist.addColumn("ALAMAT");
        datalist.addColumn("NO HP");
        datalist.addColumn("NO KTP");
        datalist.addColumn("STATUS");
        try{
            int i = 1;
            st=con.createStatement();
            RsPenyewa=st.executeQuery("select * from tb_penyewa");
            while (RsPenyewa.next())
                datalist.addRow(new Object[]{
                (""+i++),
                RsPenyewa.getString(1), RsPenyewa.getString(2),
                RsPenyewa.getString(3), RsPenyewa.getString(4),
                RsPenyewa.getString(5), RsPenyewa.getString(6)});
            TABEL1.setModel(datalist);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Tampil \n"+e.getMessage());
        }
    }
     
    private void bersih(){
        Txt_alamat_penyewa.setText("");
        Txt_hp.setText("");
        Txt_id_penyewa.setText("");
        Txt_ktp.setText("");
        Txt_nama_penyewa.setText("");
        Cmb_status.setSelectedItem("PILIH");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Txt_id_penyewa = new javax.swing.JTextField();
        Cmb_status = new javax.swing.JComboBox();
        BTN_SIMPAN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABEL1 = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jLabel2 = new javax.swing.JLabel();
        BTN_EDIT = new javax.swing.JButton();
        BTN_BATAL = new javax.swing.JButton();
        BTN_HAPUS = new javax.swing.JButton();
        BTN_KELUAR = new javax.swing.JButton();
        Txt_nama_penyewa = new javax.swing.JTextField();
        Txt_hp = new javax.swing.JTextField();
        Txt_ktp = new javax.swing.JTextField();
        Txt_alamat_penyewa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("ID PENYEWA");

        Txt_id_penyewa.setEnabled(false);
        Txt_id_penyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_id_penyewaActionPerformed(evt);
            }
        });
        Txt_id_penyewa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txt_id_penyewaKeyPressed(evt);
            }
        });

        Cmb_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "READY", "NOT READY" }));
        Cmb_status.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Cmb_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_statusActionPerformed(evt);
            }
        });

        BTN_SIMPAN.setBackground(new java.awt.Color(255, 255, 255));
        BTN_SIMPAN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/save.png"))); // NOI18N
        BTN_SIMPAN.setText("TAMBAH");
        BTN_SIMPAN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_SIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SIMPANActionPerformed(evt);
            }
        });

        TABEL1.setBackground(new java.awt.Color(204, 204, 204));
        TABEL1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PENYEWA", "NAMA PENYEWA", "ALAMAT", "NO HP", "NO KTP", "STATUS"
            }
        ));
        TABEL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABEL1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABEL1);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/user_icon.png"))); // NOI18N

        BTN_EDIT.setBackground(new java.awt.Color(255, 255, 255));
        BTN_EDIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/edit.png"))); // NOI18N
        BTN_EDIT.setText("EDIT");
        BTN_EDIT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EDITActionPerformed(evt);
            }
        });

        BTN_BATAL.setBackground(new java.awt.Color(255, 255, 255));
        BTN_BATAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/save-and-close.png"))); // NOI18N
        BTN_BATAL.setText("BATAL");
        BTN_BATAL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_BATAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BATALActionPerformed(evt);
            }
        });

        BTN_HAPUS.setBackground(new java.awt.Color(255, 255, 255));
        BTN_HAPUS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/delete.png"))); // NOI18N
        BTN_HAPUS.setText("HAPUS");
        BTN_HAPUS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_HAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_HAPUSActionPerformed(evt);
            }
        });

        BTN_KELUAR.setBackground(new java.awt.Color(255, 255, 255));
        BTN_KELUAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/close.png"))); // NOI18N
        BTN_KELUAR.setText("KELUAR");
        BTN_KELUAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_KELUAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_KELUARActionPerformed(evt);
            }
        });

        Txt_nama_penyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_nama_penyewaActionPerformed(evt);
            }
        });

        Txt_hp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_hpActionPerformed(evt);
            }
        });

        Txt_ktp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_ktpActionPerformed(evt);
            }
        });

        Txt_alamat_penyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_alamat_penyewaActionPerformed(evt);
            }
        });

        jLabel3.setText("NAMA PENYEWA");

        jLabel4.setText("NO HP");

        jLabel5.setText("STATUS");

        jLabel6.setText("ALAMAT");

        jLabel7.setText("NO KTP");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/Home.png"))); // NOI18N
        jButton1.setText("KEMBALI");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cmb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txt_ktp, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_nama_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_id_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_hp, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_alamat_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(BTN_HAPUS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_EDIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_BATAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_SIMPAN, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(BTN_KELUAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel2)
                        .addGap(96, 96, 96))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Txt_id_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTN_SIMPAN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTN_BATAL)
                            .addComponent(Txt_nama_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTN_EDIT)
                            .addComponent(Txt_alamat_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTN_HAPUS)
                            .addComponent(Txt_hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_ktp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cmb_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(BTN_KELUAR)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void Txt_id_penyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_id_penyewaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_id_penyewaActionPerformed

    private void Txt_id_penyewaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_id_penyewaKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Txt_id_penyewaKeyPressed

    private void BTN_SIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SIMPANActionPerformed
        // TODO add your handling code here:
        
        namapenyewa=String.valueOf(Txt_nama_penyewa.getText());
        alamat=String.valueOf(Txt_alamat_penyewa.getText());
        hp=String.valueOf(Txt_hp.getText());
        ktp=String.valueOf(Txt_ktp.getText());
        status=String.valueOf(Cmb_status.getSelectedItem());
        level = "user";
        pass = "12345";
        if (Cmb_status.getSelectedItem().equals("PILIH")){
            JOptionPane.showMessageDialog(null, "STATUS BELUM DIPILIH");
        }
        else if (Cmb_status.getSelectedItem().equals("NOT READY")) {
            JOptionPane.showMessageDialog(null, "USER SUDAH MERENTAL");
        }else{
            try{
                sql="INSERT INTO tb_penyewa(nama_penyewa, "
                    + "alamat, no_hp, no_ktp, level, password,"
                    + "status)value"
                    + "('"+ namapenyewa  +"','"+ alamat +"','"+ hp +"',"
                    + "'"+ ktp +"','"+ level +"','"+ pass +"','"+ status +"')";
      
                st=con.createStatement();
                st.execute(sql);
                bersih();
                TampilData(sql);
                JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Data Gagal Disimpan \n"+e.getMessage());
            }
        }
    }//GEN-LAST:event_BTN_SIMPANActionPerformed

    private void BTN_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EDITActionPerformed
        // TODO add your handling code here:
        idpenyewa=String.valueOf(Txt_id_penyewa.getText());
        namapenyewa=String.valueOf(Txt_nama_penyewa.getText());
        alamat=String.valueOf(Txt_alamat_penyewa.getText());
        hp=String.valueOf(Txt_hp.getText());
        ktp=String.valueOf(Txt_ktp.getText());
        status=String.valueOf(Cmb_status.getSelectedItem());
        try {
            sql="update tb_penyewa set nama_penyewa='"+ namapenyewa +"',alamat='"+ alamat +"',no_hp='"+ hp +"',no_ktp='"+ ktp +"',status='"+ status +"' where id_penyewa = '"+ idpenyewa +"'";
            st=con.createStatement();
            st.execute(sql);
            bersih();
            TampilData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Edit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal di Edit \n"+e.getMessage());
        }
    }//GEN-LAST:event_BTN_EDITActionPerformed

    private void BTN_BATALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BATALActionPerformed
        // TODO add your handling code here:
        bersih();

    }//GEN-LAST:event_BTN_BATALActionPerformed

    private void BTN_HAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_HAPUSActionPerformed
        // TODO add your handling code here:
        idpenyewa=String.valueOf(Txt_id_penyewa.getText());
        try {
            sql="DELETE FROM tb_penyewa"
            +" where id_penyewa='"+ idpenyewa +"'";
            st=con.createStatement();
            st.execute(sql);
            bersih();
            TampilData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus"+e.getMessage());
        }
    }//GEN-LAST:event_BTN_HAPUSActionPerformed

    private void BTN_KELUARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_KELUARActionPerformed
        // TODO add your handling code here:
        login masuk = new login();
        masuk.setLocationRelativeTo(null);
        masuk.setVisible(true);
        dispose();
    }//GEN-LAST:event_BTN_KELUARActionPerformed

    private void Txt_nama_penyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_nama_penyewaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_nama_penyewaActionPerformed

    private void Txt_hpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_hpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_hpActionPerformed

    private void Txt_ktpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_ktpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_ktpActionPerformed

    private void Txt_alamat_penyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_alamat_penyewaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_alamat_penyewaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MainServer home = new MainServer();
        home.setLocationRelativeTo(null);
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Cmb_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cmb_statusActionPerformed

    private void TABEL1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABEL1MouseClicked
        // TODO add your handling code here:
        int baris = TABEL1.rowAtPoint(evt.getPoint());
        String id = TABEL1.getValueAt(baris, 1).toString();
        Txt_id_penyewa.setText(id);
        String nama = TABEL1.getValueAt(baris, 2).toString();
        Txt_nama_penyewa.setText(nama);
        String alamat = TABEL1.getValueAt(baris, 3).toString();
        Txt_alamat_penyewa.setText(alamat);
        String no_hp = TABEL1.getValueAt(baris, 4).toString();
        Txt_hp.setText(no_hp);
        String no_ktp = TABEL1.getValueAt(baris, 5).toString();
        Txt_ktp.setText(no_ktp);
        String status = TABEL1.getValueAt(baris, 6).toString();
        Cmb_status.setSelectedItem(status);
    }//GEN-LAST:event_TABEL1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPenyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPenyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPenyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPenyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPenyewa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_BATAL;
    private javax.swing.JButton BTN_EDIT;
    private javax.swing.JButton BTN_HAPUS;
    private javax.swing.JButton BTN_KELUAR;
    private javax.swing.JButton BTN_SIMPAN;
    private javax.swing.JComboBox Cmb_status;
    private javax.swing.JTable TABEL1;
    private javax.swing.JTextField Txt_alamat_penyewa;
    private javax.swing.JTextField Txt_hp;
    private javax.swing.JTextField Txt_id_penyewa;
    private javax.swing.JTextField Txt_ktp;
    private javax.swing.JTextField Txt_nama_penyewa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}