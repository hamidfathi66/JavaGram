import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Post_Panel extends javax.swing.JPanel {
    public static JFrame NewPost_JFrame;
	
    public Post_Panel() {
        initComponents();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
            String sql = "SELECT post_txt, sharing_date FROM tbl_post WHERE user_name = ? ORDER BY sharing_date DESC";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1,Login_Panel.user_name);         
            ResultSet rs = ps.executeQuery();

            // aproach 2 : DefaultTableModel model = (DefaultTableModel) tbl_post.getModel();
            while (tbl_post.getRowCount() > 0)
                ((DefaultTableModel)tbl_post.getModel()).removeRow(0);

            while (rs.next())
                ((DefaultTableModel)tbl_post.getModel()).addRow(new Object[] {
                    rs.getString("post_txt"), 
                    rs.getString("sharing_date")
                });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_post = new javax.swing.JTable();
        btn_refresh = new javax.swing.JButton();
        btn_new_post = new javax.swing.JButton();
        btn_delete_post = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(198, 217, 230));

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        tbl_post.setBackground(new java.awt.Color(255, 248, 218));
        tbl_post.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        tbl_post.setForeground(new java.awt.Color(9, 0, 49));
        tbl_post.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_post.setRowHeight(24);
        tbl_post.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_postMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_post);

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.jpg"))); // NOI18N
        btn_refresh.setToolTipText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        btn_new_post.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newpost.png"))); // NOI18N
        btn_new_post.setText("New Post");
        btn_new_post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_new_postActionPerformed(evt);
            }
        });

        btn_delete_post.setIcon(new javax.swing.ImageIcon(getClass().getResource("/garbage.png"))); // NOI18N
        btn_delete_post.setText("Delete Message");
        btn_delete_post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_postActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(9, 0, 49));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/send_message.png"))); // NOI18N
        jLabel4.setText("Java Gram");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_new_post, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_delete_post)))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_back, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete_post)
                    .addComponent(btn_new_post))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(btn_back)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        Profile_Panel.Post_JFrame.setVisible(false);
        //JFrame frame = create_JFrame(new Profile_Panel(), "Profile of " + Login_Panel.user_name, 1100, 700);
        //frame.setVisible(true);
        Login_Panel.Profile_Frame.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        //JFrame frame = create_JFrame(new Post_Panel(), "Your Posts",  386, 460);
        //frame.setVisible(true);
        Profile_Panel.Post_JFrame.setVisible(false);
        Profile_Panel.Post_JFrame = create_JFrame(new Post_Panel(), "Post Panel: " + Login_Panel.user_name, 386, 460);   
        Profile_Panel.Post_JFrame.setVisible(true); 
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_new_postActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_new_postActionPerformed
        Profile_Panel.Post_JFrame.setVisible(false);
        NewPost_JFrame = create_JFrame(new NewPost_Panel(), "New Post Panel: " + Login_Panel.user_name, 365, 565);
        NewPost_JFrame.setVisible(true);
        
    }//GEN-LAST:event_btn_new_postActionPerformed

    private void btn_delete_postActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_postActionPerformed
        DefaultTableModel model = (DefaultTableModel)tbl_post.getModel();
        int selected_row = tbl_post.getSelectedRow();
        if (selected_row != -1) {
            String date = model.getValueAt(selected_row, 1).toString();
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
                String sql = "DELETE FROM tbl_post WHERE user_name = ? and sharing_date = ?";
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1, Login_Panel.user_name);
                ps.setString(2, date);
                ps.executeUpdate();
                conn.close();
                
                //JFrame frame = create_JFrame(new Post_Panel(), "Your Posts",  386, 460);
                //frame.setVisible(true);
                Profile_Panel.Post_JFrame.setVisible(false);
                Profile_Panel.Post_JFrame = create_JFrame(new Profile_Panel(), "Post Panel: " + Login_Panel.user_name, 930, 670);   
                Profile_Panel.Post_JFrame.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btn_delete_postActionPerformed

    private void tbl_postMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_postMouseClicked
        DefaultTableModel model = (DefaultTableModel)tbl_post.getModel();
        int selected_row = tbl_post.getSelectedRow();
        String post = model.getValueAt(selected_row, 0).toString();
        String date = model.getValueAt(selected_row, 1).toString();
        
        Profile_Panel.Post_JFrame.setVisible(false);
        //JFrame user_Posts_JFrame = create_JFrame(new UserPosts_Panel(Login_Panel.user_name, post, date), "JavaGram(Posts)", 400, 670);
        //user_Posts_JFrame.setVisible(true);
        Profile_Panel.UserPosts_Frame = create_JFrame(new UserPosts_Panel(Login_Panel.user_name, post, date), "User Post Panel: " + Login_Panel.user_name, 400, 670);
        Profile_Panel.UserPosts_Frame.setVisible(true);  
    }//GEN-LAST:event_tbl_postMouseClicked


    public static JFrame create_JFrame(JPanel panel, String title, int width, int height){
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        
        return frame;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_delete_post;
    private javax.swing.JButton btn_new_post;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_post;
    // End of variables declaration//GEN-END:variables
}