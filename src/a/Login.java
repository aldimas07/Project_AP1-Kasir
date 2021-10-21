/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import project_ap1_kasir.koneksi;

/**
 *
 * @author ACER
 */
public class Login extends javax.swing.JFrame {

    public static Connection con = new koneksi().ambil_koneksi();
    public static String username, password;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        txtuser.setBackground(new Color(0, 0, 0, 0));
        txtpass.setBackground(new Color(0, 0, 0, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        txtuser = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 4, 30, 20));

        jLabel1.setText(" ");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 300, 40));

        txtpass.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        txtpass.setForeground(new java.awt.Color(255, 255, 255));
        txtpass.setBorder(null);
        getContentPane().add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 290, 40));

        txtuser.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        txtuser.setForeground(new java.awt.Color(255, 255, 255));
        txtuser.setBorder(null);
        getContentPane().add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 290, 40));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/form login.jpg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        validasi();
    }//GEN-LAST:event_jLabel1MouseClicked

    public void deklarasi() {
        username = txtuser.getText();
        password = txtpass.getText();
    }

    private void validasi() {
        deklarasi();
        if (username.equals("")) {
            JOptionPane.showMessageDialog(this, "Username Harus Diisi!");
        }
        else if (password.equals("")) {
            JOptionPane.showMessageDialog(this, "Password Harus Terisi!");
        } else {
            try {
                //untuk mengecek username telah terdaftar di database atau tidak
                String cek_username = "SELECT * FROM kasir WHERE USERNAME = '" + username + "'";
                ResultSet res_cekuser = con.prepareStatement(cek_username).executeQuery();

                if (res_cekuser.next()) {
                    String cek_password = "SELECT * FROM kasir WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'";
                    ResultSet res_cekpass = con.prepareStatement(cek_password).executeQuery();

                    if (res_cekpass.next()) {//jika password benar
                        Index i = new Index();
                        i.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Cek kembali username atau password Anda!");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Data tidak terdaftar dalam database kami!");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For bg see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
