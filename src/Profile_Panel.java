import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Profile_Panel extends javax.swing.JPanel {
    public static JFrame Direct_Message_JFrame;
    public static JFrame Post_JFrame;
    public static JFrame Search_JFrame;
    public static JFrame Followers_JFrame;
    public static JFrame Followings_JFrame;
    public static JFrame Delete_Acc_JFrame;
    public static JFrame UserPosts_Frame;
    
    public Profile_Panel() {
        initComponents();
        
        lbl_user_name.setText(Login_Panel.user_name);
        
        showTime();
        
        showNumberOfMessage();
        
        showPostTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_follower = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_post = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_direct_message = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btn_following = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lbl_time = new javax.swing.JLabel();
        lbl_number_of_message = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_user_name = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JButton();
        btn_delete_acc = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_post = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(12, 83, 118));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 72, 104));
        jPanel1.setLayout(null);

        jLabel4.setForeground(new java.awt.Color(213, 241, 210));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Followers");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 380, 110, 14);

        btn_follower.setIcon(new javax.swing.ImageIcon(getClass().getResource("/followers.png"))); // NOI18N
        btn_follower.setToolTipText("");
        btn_follower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_followerActionPerformed(evt);
            }
        });
        jPanel1.add(btn_follower);
        btn_follower.setBounds(30, 320, 60, 50);

        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        jPanel1.add(btn_search);
        btn_search.setBounds(30, 220, 60, 50);

        jLabel3.setForeground(new java.awt.Color(213, 241, 210));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Search");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 280, 110, 14);

        btn_post.setIcon(new javax.swing.ImageIcon(getClass().getResource("/post.png"))); // NOI18N
        btn_post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_postActionPerformed(evt);
            }
        });
        jPanel1.add(btn_post);
        btn_post.setBounds(30, 120, 60, 50);

        jLabel2.setForeground(new java.awt.Color(213, 241, 210));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Posts");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 180, 110, 14);

        btn_direct_message.setIcon(new javax.swing.ImageIcon(getClass().getResource("/direct.png"))); // NOI18N
        btn_direct_message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_direct_messageActionPerformed(evt);
            }
        });
        jPanel1.add(btn_direct_message);
        btn_direct_message.setBounds(30, 20, 60, 50);

        jLabel6.setForeground(new java.awt.Color(213, 241, 210));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Direct Message");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 80, 110, 14);

        btn_following.setIcon(new javax.swing.ImageIcon(getClass().getResource("/followings.png"))); // NOI18N
        btn_following.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_followingActionPerformed(evt);
            }
        });
        jPanel1.add(btn_following);
        btn_following.setBounds(30, 420, 60, 50);

        jLabel9.setForeground(new java.awt.Color(213, 241, 210));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Following");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 480, 110, 14);

        lbl_time.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        lbl_time.setForeground(new java.awt.Color(255, 255, 153));
        lbl_time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_time.setText("Date and Time");
        jPanel1.add(lbl_time);
        lbl_time.setBounds(0, 510, 120, 16);

        lbl_number_of_message.setBackground(new java.awt.Color(255, 255, 255));
        lbl_number_of_message.setForeground(new java.awt.Color(204, 255, 204));
        lbl_number_of_message.setText("0");
        lbl_number_of_message.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel1.add(lbl_number_of_message);
        lbl_number_of_message.setBounds(90, 10, 30, 16);

        add(jPanel1);
        jPanel1.setBounds(0, 100, 120, 600);

        jPanel2.setBackground(new java.awt.Color(182, 192, 242));
        jPanel2.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        jLabel1.setAutoscrolls(true);
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 10, 110, 60);

        lbl_user_name.setForeground(new java.awt.Color(9, 0, 49));
        lbl_user_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_user_name.setText("User Name");
        jPanel2.add(lbl_user_name);
        lbl_user_name.setBounds(1, 70, 120, 14);

        add(jPanel2);
        jPanel2.setBounds(0, 0, 120, 100);

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.jpg"))); // NOI18N
        btn_refresh.setToolTipText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        add(btn_refresh);
        btn_refresh.setBounds(870, 10, 40, 40);

        btn_delete_acc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete_ac.png"))); // NOI18N
        btn_delete_acc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_accActionPerformed(evt);
            }
        });
        add(btn_delete_acc);
        btn_delete_acc.setBounds(800, 540, 60, 50);

        jLabel7.setForeground(new java.awt.Color(213, 241, 210));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Delete Account");
        add(jLabel7);
        jLabel7.setBounds(780, 610, 100, 14);

        jLabel10.setForeground(new java.awt.Color(213, 241, 210));
        jLabel10.setText("Development and Design By : Hamid Fathi");
        add(jLabel10);
        jLabel10.setBounds(390, 610, 250, 20);

        tbl_post.setBackground(new java.awt.Color(12, 83, 118));
        tbl_post.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_post.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tbl_post.setForeground(new java.awt.Color(255, 242, 170));
        tbl_post.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Post Text", "Sharing Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_post.setRowHeight(30);
        tbl_post.getTableHeader().setReorderingAllowed(false);
        tbl_post.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_postMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_post);

        add(jScrollPane1);
        jScrollPane1.setBounds(180, 160, 680, 350);

        jLabel8.setFont(new java.awt.Font("Lucida Calligraphy", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/send_message34.png"))); // NOI18N
        jLabel8.setText("Java Gram");
        add(jLabel8);
        jLabel8.setBounds(320, 70, 330, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_direct_messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_direct_messageActionPerformed
        Login_Panel.Profile_Frame.setVisible(false);
        Direct_Message_JFrame = create_JFrame(new Direct_Message_Panel(), "Direct Message Panel: " + Login_Panel.user_name, 418, 470);
        Direct_Message_JFrame.setVisible(true);
    }//GEN-LAST:event_btn_direct_messageActionPerformed

    private void btn_postActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_postActionPerformed
        Login_Panel.Profile_Frame.setVisible(false);
        Post_JFrame = create_JFrame(new Post_Panel(), "Post Panel: " + Login_Panel.user_name,  386, 460);
        Post_JFrame.setVisible(true);
    }//GEN-LAST:event_btn_postActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        Login_Panel.Profile_Frame.setVisible(false);
        Search_JFrame = create_JFrame(new Search_Panel(), "Search Panel: " + Login_Panel.user_name, 350, 300);
        Search_JFrame.setVisible(true);
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        Login_Panel.Profile_Frame.setVisible(false);
        Login_Panel.Profile_Frame = create_JFrame(new Profile_Panel(), "Profile Panel: " + Login_Panel.user_name, 930, 670);       
        Login_Panel.Profile_Frame.setVisible(true);
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_followerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_followerActionPerformed
        Login_Panel.Profile_Frame.setVisible(false);
        Followers_JFrame = create_JFrame(new Follower_Panel(), "Follower Panel: " + Login_Panel.user_name, 250, 400);
        Followers_JFrame.setVisible(true);
    }//GEN-LAST:event_btn_followerActionPerformed

    private void btn_delete_accActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_accActionPerformed
        Login_Panel.Profile_Frame.setVisible(false);
        Delete_Acc_JFrame = create_JFrame(new Delete_Acc_Panel(), "Delete Account Panel: " + Login_Panel.user_name, 360, 230);
        Delete_Acc_JFrame.setVisible(true);
    }//GEN-LAST:event_btn_delete_accActionPerformed

    private void btn_followingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_followingActionPerformed
        Login_Panel.Profile_Frame.setVisible(false);
        Followings_JFrame = create_JFrame(new Following_Panel(), "Following Panel: " + Login_Panel.user_name, 250, 400);
        Followings_JFrame.setVisible(true);
    }//GEN-LAST:event_btn_followingActionPerformed

    private void tbl_postMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_postMouseClicked
        DefaultTableModel model = (DefaultTableModel)tbl_post.getModel();
        int selected_row = tbl_post.getSelectedRow();
        String user_name = model.getValueAt(selected_row, 0).toString();
        String post = model.getValueAt(selected_row, 1).toString();
        String date = model.getValueAt(selected_row, 2).toString();
        
        Login_Panel.Profile_Frame.setVisible(false); 
        /*JFrame user_Posts_JFrame = create_JFrame(new UserPosts_Panel(user_name, post, date), "User Post Panel: " + Login_Panel.user_name, 400, 670);
        user_Posts_JFrame.setVisible(true);*/
        UserPosts_Frame = create_JFrame(new UserPosts_Panel(user_name, post, date), "User Post Panel: " + Login_Panel.user_name, 400, 670);
        UserPosts_Frame.setVisible(true);           
    }//GEN-LAST:event_tbl_postMouseClicked

    void showTime(){
        new Timer (0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                
                Date date = new Date();
                
                lbl_time.setText(s.format(date));
            }
        }).start();
    }
    
    public void showNumberOfMessage(){
        Integer Number_of_Direct_Message = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
            String sql = "SELECT user_name2 FROM tbl_private_messages WHERE user_name2 = ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Login_Panel.user_name);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
                Number_of_Direct_Message++;
                
            lbl_number_of_message.setText(Number_of_Direct_Message.toString());
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void showPostTable(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
            String sql = "SELECT user_name, post_txt, sharing_date FROM tbl_post, tbl_follow WHERE tbl_post.user_name = tbl_follow.user_name2 AND tbl_follow.user_name1 = ? ORDER BY sharing_date DESC";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Login_Panel.user_name);
            ResultSet rs = ps.executeQuery();

            while (tbl_post.getRowCount() > 0)
                ((DefaultTableModel)tbl_post.getModel()).removeRow(0);

            while (rs.next())
                ((DefaultTableModel)tbl_post.getModel()).addRow(new Object[]{
                    rs.getString("user_name"),
                    rs.getString("post_txt"),
                    rs.getString("sharing_date")
                });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static JFrame create_JFrame(JPanel panel, String title, int width, int height){
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        
        return frame;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete_acc;
    private javax.swing.JButton btn_direct_message;
    private javax.swing.JButton btn_follower;
    private javax.swing.JButton btn_following;
    private javax.swing.JButton btn_post;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_number_of_message;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JLabel lbl_user_name;
    private javax.swing.JTable tbl_post;
    // End of variables declaration//GEN-END:variables
}
