import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Delete_Acc_Panel extends javax.swing.JPanel {
    public Delete_Acc_Panel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(198, 217, 230));

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jButton1.setText("Delete Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Are You Sure ?");

        jLabel5.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(9, 0, 49));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/send_message.png"))); // NOI18N
        jLabel5.setText("Java Gram");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(46, 46, 46))
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btn_back)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        Profile_Panel.Delete_Acc_JFrame.setVisible(false);
        Login_Panel.Profile_Frame.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");
            String sql = "DELETE FROM tbl_post WHERE user_name = ? ";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Login_Panel.user_name);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");
            String sql = "DELETE FROM tbl_comments WHERE user_name1 = ? OR user_name2 = ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Login_Panel.user_name);
            ps.setString(2, Login_Panel.user_name);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");
            String sql = "DELETE FROM tbl_follow WHERE user_name1 = ? OR user_name2 = ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Login_Panel.user_name);
            ps.setString(2, Login_Panel.user_name);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");
            String sql = "DELETE FROM tbl_like_post WHERE user_name1 = ? OR user_name2 = ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Login_Panel.user_name);
            ps.setString(2, Login_Panel.user_name);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
                
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");
            String sql = "DELETE FROM tbl_private_messages WHERE user_name1 = ? OR user_name2 = ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Login_Panel.user_name);
            ps.setString(2, Login_Panel.user_name);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");
            String sql = "DELETE FROM tbl_users WHERE user_name = ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Login_Panel.user_name);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Your account has been successfully deleted.");
            
            JavaGram.login_frmae.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}