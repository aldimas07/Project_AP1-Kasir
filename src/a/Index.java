/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a;

import static a.Login.con;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import project_ap1_kasir.koneksi;

/**
 *
 * @author ACER
 */
public class Index extends javax.swing.JFrame {
    public static Connection con = new koneksi().ambil_koneksi();
    private String ld_kasir;

    /**
     * Creates new form Index
     */
    public Index() {
        initComponents();
    }
    public void setLd_kasir(String ld_kasir) {
        this.ld_kasir = ld_kasir;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_logout = new javax.swing.JLabel();
        lb_riwayatpesanan = new javax.swing.JLabel();
        lb_pesanmakanan = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        jDialog1.setModal(true);

        jLabel1.setText("nyobak");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_name.setForeground(new java.awt.Color(0, 0, 0));
        lbl_name.setText("XXXXX");
        getContentPane().add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Selamat Datang, ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        lb_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_logoutMouseClicked(evt);
            }
        });
        getContentPane().add(lb_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 350, 70));

        lb_riwayatpesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_riwayatpesananMouseClicked(evt);
            }
        });
        getContentPane().add(lb_riwayatpesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 350, 70));

        lb_pesanmakanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_pesanmakananMouseClicked(evt);
            }
        });
        getContentPane().add(lb_pesanmakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 350, 70));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tampilan awal setelah login.jpg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lb_pesanmakananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_pesanmakananMouseClicked
        //pindah ke form menu
        Menu m = new Menu();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lb_pesanmakananMouseClicked

    private void lb_riwayatpesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_riwayatpesananMouseClicked
        //pindah ke from riwayat pemesanan
//        riwayat_pesanan hitory = new riwayat_pesanan();
//        hitory.setVisible(true);
//        this.dispose();
        jDialog1.setVisible(true);
        jDialog1.dispose();
    }//GEN-LAST:event_lb_riwayatpesananMouseClicked

    private void lb_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_logoutMouseClicked
        //pindah ke form homepage
        jDialog1.setVisible(true);
        jDialog1.dispose();
        
//        Homepage home = new Homepage();
//        home.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_lb_logoutMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            // TODO add your handling code here:
            ResultSet res_user = con.prepareStatement("SELECT * from kasir where LD_KASIR='" + ld_kasir +"'").executeQuery();
            if (res_user.next()) {
                lbl_name.setText(res_user.getString("NAMA"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lb_logout;
    private javax.swing.JLabel lb_pesanmakanan;
    private javax.swing.JLabel lb_riwayatpesanan;
    private javax.swing.JLabel lbl_name;
    // End of variables declaration//GEN-END:variables
}
