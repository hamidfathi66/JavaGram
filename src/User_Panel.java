import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class User_Panel extends javax.swing.JPanel {
    //public static JFrame send_Message_JFrame;
    //public static JFrame user_Posts_JFrame;
    public static String USERNAME;
	
    public User_Panel(String user_name) {
        initComponents();
        
        USERNAME = user_name;
        lbl_user_name.setText(user_name);
        
        Integer PostNumber = 0;
        Integer FollowerNumber = 0;
        Integer FollowingNumber = 0;
        
        //Display post
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
            String sql = "SELECT post_txt, sharing_date FROM tbl_post WHERE user_name = ? ORDER BY sharing_date DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user_name);
            ResultSet rs = ps.executeQuery();
            
            while(tbl_user_post.getRowCount()>0)
                ((DefaultTableModel)tbl_user_post.getModel()).removeRow(0);
            
            while(rs.next()){
                PostNumber++;
                lbl_post_number.setText(PostNumber.toString());
                ((DefaultTableModel)tbl_user_post.getModel()).addRow(new Object[]{
                    rs.getString("post_txt"),
                    rs.getString("sharing_date")
                });
            }
            
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        //btn
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
            String sql = "SELECT * FROM tbl_follow WHERE user_name1 = ? AND user_name2 = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Login_Panel.user_name);
            ps.setString(2, USERNAME);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
                btn_Follow.setEnabled(false);
            else
                btn_unFollow.setEnabled(false);
            
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        //followerNumber
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
            String sql="SELECT * FROM tbl_follow WHERE user_name2 = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, USERNAME);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
                FollowerNumber++;
            
            lbl_follower.setText(FollowerNumber.toString());
            
            conn.close();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }
        
        //followeingNumber
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
            String sql="SELECT * FROM tbl_follow WHERE user_name1 = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, USERNAME);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
                FollowingNumber++;

            lbl_following.setText(FollowingNumber.toString());
            
            conn.close();
        } catch(Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_user_name = new javax.swing.JLabel();
        lbl_post_number = new javax.swing.JLabel();
        lbl_follower = new javax.swing.JLabel();
        lbl_following = new javax.swing.JLabel();
        btn_Follow = new javax.swing.JButton();
        btn_unFollow = new javax.swing.JButton();
        btn_direct_message = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_user_post = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(198, 217, 230));

        btn_back.setText("Back");
        btn_back.setActionCommand("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(9, 0, 49));
        jLabel1.setText("User Name");

        jLabel2.setForeground(new java.awt.Color(9, 0, 49));
        jLabel2.setText("Posts");

        jLabel3.setForeground(new java.awt.Color(9, 0, 49));
        jLabel3.setText("Followers");

        jLabel4.setForeground(new java.awt.Color(9, 0, 49));
        jLabel4.setText("Followings");

        lbl_user_name.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_user_name.setForeground(new java.awt.Color(9, 0, 49));
        lbl_user_name.setText("User Name");

        lbl_post_number.setForeground(new java.awt.Color(9, 0, 49));
        lbl_post_number.setText("0");

        lbl_follower.setForeground(new java.awt.Color(9, 0, 49));
        lbl_follower.setText("0");

        lbl_following.setForeground(new java.awt.Color(9, 0, 49));
        lbl_following.setText("0");

        btn_Follow.setText("Follow");
        btn_Follow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FollowActionPerformed(evt);
            }
        });

        btn_unFollow.setText("UnFollow");
        btn_unFollow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_unFollowActionPerformed(evt);
            }
        });

        btn_direct_message.setIcon(new javax.swing.ImageIcon(getClass().getResource("/send_message.png"))); // NOI18N
        btn_direct_message.setText("Message");
        btn_direct_message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_direct_messageActionPerformed(evt);
            }
        });

        tbl_user_post.setBackground(new java.awt.Color(255, 248, 218));
        tbl_user_post.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        tbl_user_post.setForeground(new java.awt.Color(9, 0, 49));
        tbl_user_post.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Post Text", "Date Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_user_post.setRowHeight(24);
        tbl_user_post.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_user_postMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_user_post);

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
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_user_name))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Follow, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_unFollow)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(23, 23, 23))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_post_number)
                                    .addComponent(lbl_following)
                                    .addComponent(lbl_follower)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_direct_message, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_back, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_direct_message)
                    .addComponent(jLabel1)
                    .addComponent(lbl_user_name))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_post_number)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_follower)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_following)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Follow)
                            .addComponent(btn_unFollow))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_back)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        Search_Panel.user_JFrame.setVisible(false);
        Profile_Panel.Search_JFrame.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_FollowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FollowActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
            String sql = "INSERT INTO tbl_follow VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Login_Panel.user_name);
            ps.setString(2, USERNAME);
            ps.executeUpdate();
            
            btn_Follow.setEnabled(false);
            btn_unFollow.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_FollowActionPerformed

    private void btn_unFollowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_unFollowActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
            String sql="DELETE FROM tbl_follow WHERE user_name1 = ? AND user_name2 = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Login_Panel.user_name);
            ps.setString(2, USERNAME);
            ps.executeUpdate();
            
            btn_Follow.setEnabled(true);
            btn_unFollow.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_unFollowActionPerformed

    private void btn_direct_messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_direct_messageActionPerformed
        Search_Panel.user_JFrame.setVisible(false);        
        //send_Message_JFrame = create_JFrame(new SendMessage_Panel(Login_Panel.user_name, USERNAME), "Direct Message", 300, 318);
        //send_Message_JFrame.setVisible(true);
        Direct_Message_Panel.SendMessage_Panel = create_JFrame(new SendMessage_Panel(Login_Panel.user_name, USERNAME), "Send Message Panel: " + Login_Panel.user_name, 300, 340);
        Direct_Message_Panel.SendMessage_Panel.setVisible(true);
    }//GEN-LAST:event_btn_direct_messageActionPerformed

    private void tbl_user_postMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_user_postMouseClicked
        DefaultTableModel model = (DefaultTableModel)tbl_user_post.getModel();
        int selected_row = tbl_user_post.getSelectedRow();
        String post = model.getValueAt(selected_row, 0).toString();
        String date = model.getValueAt(selected_row, 1).toString();
        
        Search_Panel.user_JFrame.setVisible(false); 
        //user_Posts_JFrame = create_JFrame(new UserPosts_Panel(USERNAME, post, date), "JavaGram(Posts)", 400, 670);
        //user_Posts_JFrame.setVisible(true);
        Profile_Panel.UserPosts_Frame = create_JFrame(new UserPosts_Panel(USERNAME, post, date), "User Post Panel: " + Login_Panel.user_name, 400, 670);
        Profile_Panel.UserPosts_Frame.setVisible(true);    
    }//GEN-LAST:event_tbl_user_postMouseClicked

    public static JFrame create_JFrame(JPanel panel, String title, int width, int height){
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        
        return frame;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Follow;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_direct_message;
    private javax.swing.JButton btn_unFollow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_follower;
    private javax.swing.JLabel lbl_following;
    private javax.swing.JLabel lbl_post_number;
    private javax.swing.JLabel lbl_user_name;
    private javax.swing.JTable tbl_user_post;
    // End of variables declaration//GEN-END:variables
}
