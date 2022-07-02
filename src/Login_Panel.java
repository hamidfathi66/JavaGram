import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Login_Panel extends javax.swing.JPanel {
    public static JFrame Profile_Frame;
    public static JFrame sign_up_frame;
    public static String user_name;
    
    public Login_Panel() {
        initComponents();
        
        // must be removed
        txt_user_name.setText("hamidfathi");
        txt_pass.setText("12345");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_user_name = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_sign_up = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(198, 217, 230));
        setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login.gif"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(80, 400, 230, 70);

        txt_user_name.setToolTipText("User Name");
        txt_user_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_user_nameActionPerformed(evt);
            }
        });
        add(txt_user_name);
        txt_user_name.setBounds(120, 124, 180, 20);

        txt_pass.setToolTipText("PassWord");
        txt_pass.setToolTipText("PassWord");
        txt_pass.setName("pass"); // NOI18N
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        add(txt_pass);
        txt_pass.setBounds(120, 160, 180, 20);

        btn_login.setText("Log In");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        add(btn_login);
        btn_login.setBounds(40, 240, 260, 30);

        jCheckBox1.setBackground(new java.awt.Color(198, 217, 230));
        jCheckBox1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jCheckBox1.setToolTipText("");
        jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jCheckBox1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        add(jCheckBox1);
        jCheckBox1.setBounds(283, 195, 30, 30);

        jLabel1.setForeground(new java.awt.Color(9, 0, 49));
        jLabel1.setText("Password");
        add(jLabel1);
        jLabel1.setBounds(40, 160, 70, 20);

        jLabel3.setForeground(new java.awt.Color(9, 0, 49));
        jLabel3.setText("User Name");
        add(jLabel3);
        jLabel3.setBounds(40, 120, 70, 20);

        jLabel4.setFont(new java.awt.Font("Lucida Calligraphy", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(9, 0, 49));
        jLabel4.setText("Java Gram");
        add(jLabel4);
        jLabel4.setBounds(60, 30, 240, 50);

        jLabel5.setText("Dont't have an account?");
        add(jLabel5);
        jLabel5.setBounds(60, 360, 150, 20);

        btn_sign_up.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_sign_up.setText("Sign up");
        btn_sign_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sign_upActionPerformed(evt);
            }
        });
        add(btn_sign_up);
        btn_sign_up.setBounds(210, 360, 80, 20);

        jLabel6.setForeground(new java.awt.Color(9, 0, 49));
        jLabel6.setText("Show Password");
        add(jLabel6);
        jLabel6.setBounds(40, 200, 120, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        if (txt_user_name.getText().trim().isEmpty() || txt_pass.getText().trim().isEmpty())
            JOptionPane.showMessageDialog(null, "Please Fill all of Fields!");
        else {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
                String sql = "SELECT * FROM tbl_users WHERE user_name = ? AND pass = ?";
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1, txt_user_name.getText());
                ps.setString(2, txt_pass.getText());
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    user_name = txt_user_name.getText();
                    
                    JavaGram.login_frmae.setVisible(false);
                    Profile_Frame = create_JFrame(new Profile_Panel(), "Profile Panel: " + user_name, 930, 670);
                    Profile_Frame.setVisible(true);
                    
                    //System.out.println(user_name);
                } else
                    JOptionPane.showMessageDialog(null, "User Name Or Password is not Correct!");
                
                conn.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_user_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_user_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_user_nameActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected())
            txt_pass.setEchoChar('\0');
        else
            txt_pass.setEchoChar('*');
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passActionPerformed

    private void btn_sign_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sign_upActionPerformed
        JavaGram.login_frmae.setVisible(false);
        sign_up_frame = create_JFrame(new Sign_Up_Panel(), "Sign Up Panel", 350, 500);
        sign_up_frame.setVisible(true);
    }//GEN-LAST:event_btn_sign_upActionPerformed

    public static JFrame create_JFrame(JPanel panel, String title, int width, int height){
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);  
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        
        return frame;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_sign_up;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_user_name;
    // End of variables declaration//GEN-END:variables
}