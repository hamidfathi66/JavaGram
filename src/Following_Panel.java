import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Following_Panel extends javax.swing.JPanel {
    public Following_Panel() {
        initComponents();
        
        Integer FollowingNumber=0;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
            String sql="SELECT * FROM tbl_follow WHERE user_name1 = ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Login_Panel.user_name);
            ResultSet rs = ps.executeQuery();
            
            while (tbl_following.getRowCount() > 0)
                ((DefaultTableModel)tbl_following.getModel()).removeRow(0);
            
            while(rs.next()){
                FollowingNumber++;
                lbl_following_number.setText(FollowingNumber.toString());
                
                ((DefaultTableModel)tbl_following.getModel()).addRow(new Object[] {
                    rs.getString("user_name2")
                });
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbl_following_number = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_following = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(198, 217, 230));

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(9, 0, 49));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/followings.png"))); // NOI18N
        jLabel2.setText("Followings");

        lbl_following_number.setForeground(new java.awt.Color(9, 0, 49));
        lbl_following_number.setText("0");

        tbl_following.setBackground(new java.awt.Color(255, 248, 218));
        tbl_following.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        tbl_following.setForeground(new java.awt.Color(9, 0, 49));
        tbl_following.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_following.setPreferredSize(new java.awt.Dimension(219, 349));
        tbl_following.setRowHeight(24);
        tbl_following.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_followingMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_following);

        jLabel5.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(9, 0, 49));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/send_message.png"))); // NOI18N
        jLabel5.setText("Java Gram");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(178, Short.MAX_VALUE)
                        .addComponent(btn_back))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(lbl_following_number)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_following_number))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_back)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        Profile_Panel.Followings_JFrame.setVisible(false);
        Login_Panel.Profile_Frame.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void tbl_followingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_followingMouseClicked
        DefaultTableModel model = (DefaultTableModel)tbl_following.getModel();
        int selectedRow = tbl_following.getSelectedRow();
        String user_name = model.getValueAt(selectedRow, 0).toString();
        
        Profile_Panel.Followers_JFrame.setVisible(false);
        //JFrame frame = create_JFrame(new User_Panel(user_name), "Profile of " + user_name, 460, 500);
        //frame.setVisible(true);
        Search_Panel.user_JFrame = create_JFrame(new User_Panel(user_name), "User Panel: " + Login_Panel.user_name, 460, 500);
        Search_Panel.user_JFrame.setVisible(true);
    }//GEN-LAST:event_tbl_followingMouseClicked

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_following_number;
    private javax.swing.JTable tbl_following;
    // End of variables declaration//GEN-END:variables
}