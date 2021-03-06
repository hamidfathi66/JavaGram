import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Sign_Up_Panel extends javax.swing.JPanel {
    public Sign_Up_Panel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_last_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_sign_up = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_user_name = new javax.swing.JTextField();
        txt_pass = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_country = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(198, 217, 230));

        jPanel1.setBackground(new java.awt.Color(198, 217, 230));
        jPanel1.setLayout(null);

        txt_last_name.setToolTipText("User Name");
        txt_last_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_last_nameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_last_name);
        txt_last_name.setBounds(120, 160, 180, 20);

        jLabel1.setForeground(new java.awt.Color(9, 0, 49));
        jLabel1.setText("Last Name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 160, 70, 20);

        jLabel3.setForeground(new java.awt.Color(9, 0, 49));
        jLabel3.setText("Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 120, 70, 20);

        jLabel4.setFont(new java.awt.Font("Lucida Calligraphy", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(9, 0, 49));
        jLabel4.setText("Java Gram");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 30, 240, 50);

        jLabel5.setForeground(new java.awt.Color(9, 0, 49));
        jLabel5.setText("User Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 200, 70, 20);

        jLabel6.setForeground(new java.awt.Color(9, 0, 49));
        jLabel6.setText("Password");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 240, 70, 20);

        jLabel7.setForeground(new java.awt.Color(9, 0, 49));
        jLabel7.setText("Email");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 280, 70, 20);

        btn_sign_up.setText("Sign Up");
        btn_sign_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sign_upActionPerformed(evt);
            }
        });
        jPanel1.add(btn_sign_up);
        btn_sign_up.setBounds(40, 370, 260, 23);

        jLabel8.setForeground(new java.awt.Color(9, 0, 49));
        jLabel8.setText("Country");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(40, 320, 70, 20);

        txt_user_name.setToolTipText("User Name");
        txt_user_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_user_nameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_user_name);
        txt_user_name.setBounds(120, 200, 180, 20);

        txt_pass.setToolTipText("User Name");
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        jPanel1.add(txt_pass);
        txt_pass.setBounds(120, 240, 180, 20);

        txt_email.setToolTipText("User Name");
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel1.add(txt_email);
        txt_email.setBounds(120, 280, 180, 20);

        txt_country.setToolTipText("User Name");
        txt_country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_countryActionPerformed(evt);
            }
        });
        jPanel1.add(txt_country);
        txt_country.setBounds(120, 320, 180, 20);

        txt_name.setToolTipText("User Name");
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_name);
        txt_name.setBounds(120, 120, 180, 20);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(40, 400, 260, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_last_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_last_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_last_nameActionPerformed

    private void btn_sign_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sign_upActionPerformed
        if (txt_last_name.getText().trim().isEmpty() ||
                txt_last_name.getText().trim().isEmpty() ||
                txt_user_name.getText().trim().isEmpty() ||
                txt_pass.getText().trim().isEmpty() ||
                txt_email.getText().trim().isEmpty() ||
                txt_country.getText().trim().isEmpty())
            JOptionPane.showMessageDialog(null, "Fill all of Fields !");
        else {
            //user_name is unique or not
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
                String sql = "select user_name from tbl_users where user_name = ?";
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1, txt_user_name.getText());
                ResultSet rs = ps.executeQuery();
                
                boolean isExist = false;
                if (rs.next())
                    isExist = true;
                
                //user name ghablan sabt nashude
                if (isExist) {
                    //connection be database ghablan anjam shude ast
                    String sql2 = "INSERT INTO tbl_users(name, last_name, user_name, pass, email, country) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(sql2);
                    ps2.setString(1, txt_name.getText());
                    ps2.setString(2, txt_last_name.getText());
                    ps2.setString(3, txt_user_name.getText());
                    ps2.setString(4, txt_pass.getText());
                    ps2.setString(5, txt_email.getText());
                    ps2.setString(6, txt_country.getText());
                    ps2.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Welcome to JavaGram and Thanks For Joining Us " + txt_user_name.getText());
                    
                    Login_Panel.sign_up_frame.setVisible(false);
                    JavaGram.login_frmae.setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "User Name is Not Valid (Duplicate username)");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btn_sign_upActionPerformed

    private void txt_user_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_user_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_user_nameActionPerformed

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_countryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_countryActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Login_Panel.sign_up_frame.setVisible(false);
        JavaGram.login_frmae.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sign_up;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_country;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_last_name;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_pass;
    private javax.swing.JTextField txt_user_name;
    // End of variables declaration//GEN-END:variables
}
