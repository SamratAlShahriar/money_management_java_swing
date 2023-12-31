/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shorna.moneymanagement.view.auth;

import java.text.SimpleDateFormat;
import java.util.Date;
import shorna.moneymanagement.model.UserModel;
import shorna.moneymanagement.repository.UserRepository;
import shorna.moneymanagement.utils.PopUpMessage;

/**
 *
 * @author Mst. Taslima Aktar Shorna
 */
public class SignupPage extends javax.swing.JFrame {

    /**
     * Creates new form registration
     */
    public SignupPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftSide = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        image = new javax.swing.JPanel();
        bgImage = new javax.swing.JLabel();
        formSide = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSignup = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMobileNo = new javax.swing.JTextField();
        lblMsg = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(512, 512));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        leftSide.setBackground(new java.awt.Color(255, 255, 255));
        leftSide.setPreferredSize(new java.awt.Dimension(800, 640));
        leftSide.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(62, 195, 212));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Your daily cost tracker");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        leftSide.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        image.setBackground(new java.awt.Color(255, 255, 255));
        image.setLayout(new java.awt.CardLayout());

        bgImage.setBackground(new java.awt.Color(255, 255, 255));
        bgImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shorna/moneymanagement/images/moneybag.jpg"))); // NOI18N
        bgImage.setPreferredSize(new java.awt.Dimension(100, 300));
        image.add(bgImage, "card2");

        leftSide.add(image, java.awt.BorderLayout.CENTER);

        getContentPane().add(leftSide);

        formSide.setBackground(new java.awt.Color(191, 219, 238));
        formSide.setPreferredSize(new java.awt.Dimension(400, 640));
        formSide.setLayout(null);

        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        txtName.setCaretColor(new java.awt.Color(204, 204, 204));
        txtName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtName.setPreferredSize(new java.awt.Dimension(100, 17));
        formSide.add(txtName);
        txtName.setBounds(60, 140, 300, 36);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Name");
        formSide.add(jLabel1);
        jLabel1.setBounds(60, 120, 300, 17);

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Password");
        formSide.add(jLabel2);
        jLabel2.setBounds(60, 330, 300, 17);

        btnSignup.setBackground(new java.awt.Color(0, 153, 153));
        btnSignup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSignup.setForeground(new java.awt.Color(255, 255, 255));
        btnSignup.setText("Sign Up");
        btnSignup.setBorder(null);
        btnSignup.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });
        formSide.add(btnSignup);
        btnSignup.setBounds(60, 430, 300, 36);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(10, 96, 106));
        jLabel4.setText("New here?");
        formSide.add(jLabel4);
        jLabel4.setBounds(60, 20, 290, 50);

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(62, 195, 212));
        jLabel5.setText("Signup Now");
        formSide.add(jLabel5);
        jLabel5.setBounds(60, 60, 280, 43);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("© Mst. Taslima Aktar Shorna");
        formSide.add(jLabel7);
        jLabel7.setBounds(190, 550, 160, 14);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Have an account?");
        formSide.add(jLabel8);
        jLabel8.setBounds(180, 480, 120, 30);

        btnLogin.setBackground(new java.awt.Color(191, 219, 238));
        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 153, 153));
        btnLogin.setText("Login");
        btnLogin.setBorder(null);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        formSide.add(btnLogin);
        btnLogin.setBounds(300, 480, 60, 30);

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        txtEmail.setCaretColor(new java.awt.Color(204, 204, 204));
        txtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEmail.setPreferredSize(new java.awt.Dimension(100, 17));
        formSide.add(txtEmail);
        txtEmail.setBounds(60, 210, 300, 36);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Email");
        formSide.add(jLabel3);
        jLabel3.setBounds(60, 190, 300, 17);

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Mobile No.");
        formSide.add(jLabel9);
        jLabel9.setBounds(60, 260, 300, 17);

        txtMobileNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMobileNo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        txtMobileNo.setCaretColor(new java.awt.Color(204, 204, 204));
        txtMobileNo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtMobileNo.setPreferredSize(new java.awt.Dimension(100, 17));
        formSide.add(txtMobileNo);
        txtMobileNo.setBounds(60, 280, 300, 36);

        lblMsg.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        lblMsg.setForeground(new java.awt.Color(204, 0, 0));
        formSide.add(lblMsg);
        lblMsg.setBounds(60, 400, 300, 20);

        txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        formSide.add(txtPassword);
        txtPassword.setBounds(60, 350, 300, 36);

        getContentPane().add(formSide);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        String name = txtName.getText().trim();
        String email = txtEmail.getText().trim();
        String phoneNo = txtMobileNo.getText().trim();
        String password = String.valueOf(txtPassword.getPassword());

        try {
            UserRepository userRepository = new UserRepository();
            if (email.matches(".*[a-zA-Z0-9].*") || password.length() > 0) {
                boolean isUserExist = userRepository.isUserAlreadyExist(email);

                if (isUserExist) {
                    lblMsg.setText("User Already Exist");
                } else {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss");
                    Date date = new Date();
                    String insertTime = dateFormat.format(date);
                    String updateTime = dateFormat.format(date);
                    UserModel model = new UserModel(name, email, phoneNo, password, insertTime, updateTime);
                    boolean result = userRepository.signup(model);

                    if (result) {
                        PopUpMessage.popUpMsgBox("User Created Successfully!", "Succcess", WIDTH);
                        
                        new LoginPage().setVisible(true);
                        this.setVisible(false);
                    } else {
                        lblMsg.setText("Could not create User");
                    }

                }

            } else {
                lblMsg.setText("Fill all fields to continue");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }//GEN-LAST:event_btnSignupActionPerformed

    void clearMsg() {
        lblMsg.setText("");
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        this.dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgImage;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignup;
    private javax.swing.JPanel formSide;
    private javax.swing.JPanel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JPanel leftSide;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobileNo;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
