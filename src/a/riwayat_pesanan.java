/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a;

import static a.Login.username;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project_ap1_kasir.koneksi;

/**
 *
 * @author ACER
 */
public class riwayat_pesanan extends javax.swing.JFrame {

    public static Connection con = new koneksi().ambil_koneksi();

    /**
     * Creates new form riwayat_pesanan
     */
    public riwayat_pesanan() {
        initComponents();
        tampil_table();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_back = new javax.swing.JLabel();
        lb_next = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_backMouseClicked(evt);
            }
        });
        getContentPane().add(lb_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 50, 20));

        lb_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_nextMouseClicked(evt);
            }
        });
        getContentPane().add(lb_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 50, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Pesanan", "No Antrian", "ID Pembayaran", "Status Pembayaran"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 720, 430));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/riwayat pesanan.jpg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lb_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_backMouseClicked
        // TODO add your handling code here:
        int opsi = JOptionPane.showConfirmDialog(this, "Apakah Anda ingin kembali ke halaman index?");
        if (opsi == JOptionPane.YES_OPTION) {
            
            try {
                String cek_username = "SELECT * FROM kasir WHERE USERNAME = '" + a.Login.username + "'";
                ResultSet res_cekuser = con.prepareStatement(cek_username).executeQuery();
                if (res_cekuser.next()) {
                    this.dispose();
                    Index i = new Index();
                    i.setLd_kasir(res_cekuser.getString("LD_KASIR"));
                    i.setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Perintah dibatalkan!");
        }
    }//GEN-LAST:event_lb_backMouseClicked

    private void lb_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_nextMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Halaman kosong!");
    }//GEN-LAST:event_lb_nextMouseClicked

    private void tampil_table() {
        try {
            String sql = "SELECT riwayat_pesanan.ID_PESANAN, riwayat_pesanan.NO_ANTRIAN, riwayat_pesanan.ID_BAYAR FROM riwayat_pesanan";
            PreparedStatement pstunggu_pesan = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pstunggu_pesan.executeQuery();
            DefaultTableModel tb_tunggupesanan = (DefaultTableModel) jTable1.getModel();
            tb_tunggupesanan.setRowCount(0);

            while (rs.next()) {
                Object data[] = new Object[4];
                data[0] = rs.getString("ID_PESANAN");
                data[1] = rs.getString("NO_ANTRIAN");
                data[2] = rs.getString("ID_BAYAR");
                PreparedStatement psterima = con.prepareStatement("select * from terima where ID_PESANAN = ?");
                psterima.setInt(1, rs.getInt("ID_PESANAN"));
                ResultSet rsTerima = psterima.executeQuery();
                if (rsTerima.isBeforeFirst() ) {    
                    data[3] = "Terima";
                } else {
                    PreparedStatement psttolak = con.prepareStatement("select * from tolak where ID_PESANAN = ?");
                    psttolak.setInt(1, rs.getInt("ID_PESANAN"));
                    ResultSet rsTolak = psttolak.executeQuery();
                    if (rsTolak.isBeforeFirst() ) {    
                        data[3] = "Tolak";
                    } else {
                        data[3] = "Menunggu";
                    }
                }
                
                tb_tunggupesanan.addRow(data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "- tampil_tabel_riwayat");
        }
    }

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
            java.util.logging.Logger.getLogger(riwayat_pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(riwayat_pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(riwayat_pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(riwayat_pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new riwayat_pesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb_back;
    private javax.swing.JLabel lb_next;
    // End of variables declaration//GEN-END:variables
}
