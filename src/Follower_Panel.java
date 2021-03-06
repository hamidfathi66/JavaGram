import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Follower_Panel extends javax.swing.JPanel {
    public Follower_Panel() {
        initComponents();
        
        Integer FollowerNumber = 0;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
            String sql="SELECT * FROM tbl_follow WHERE user_name2 = ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1,Login_Panel.user_name);
            ResultSet rs = ps.executeQuery();
            
            while (tbl_followers.getRowCount() > 0)
                ((DefaultTableModel)tbl_followers.getModel()).removeRow(0);
            
            while (rs.next()) {
                FollowerNumber++;
                lbl_follower_number.setText(FollowerNumber.toString());
                
                ((DefaultTableModel)tbl_followers.getModel()).addRow(new Object[] {
                    rs.getString("user_name1")
                });
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbl_follower_number = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_followers = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();

        setBackground(new java.awt.Color(198, 217, 230));

        jLabel1.setForeground(new java.awt.Color(9, 0, 49));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/followers.png"))); // NOI18N
        jLabel1.setText("Follower ");

        lbl_follower_number.setForeground(new java.awt.Color(9, 0, 49));
        lbl_follower_number.setText("0");

        tbl_followers.setBackground(new java.awt.Color(255, 248, 218));
        tbl_followers.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        tbl_followers.setForeground(new java.awt.Color(9, 0, 49));
        tbl_followers.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_followers.setRowHeight(24);
        tbl_followers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_followersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_followers);

        jLabel5.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(9, 0, 49));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/send_message.png"))); // NOI18N
        jLabel5.setText("Java Gram");

        btn_back.setText("Back");
        btn_back.setActionCommand("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_back))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1)
                                .addGap(40, 40, 40)
                                .addComponent(lbl_follower_number))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_follower_number))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_back)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_followersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_followersMouseClicked
        DefaultTableModel model = (DefaultTableModel)tbl_followers.getModel();
        int selectedRow = tbl_followers.getSelectedRow();
        String user_name = model.getValueAt(selectedRow, 0).toString();
        
        Profile_Panel.Followers_JFrame.setVisible(false);
        //JFrame frame = create_JFrame(new User_Panel(user_name), "Profile of " + user_name, 460, 500);
        //frame.setVisible(true);
        Search_Panel.user_JFrame = create_JFrame(new User_Panel(user_name), "User Panel: " + Login_Panel.user_name, 460, 500);
        Search_Panel.user_JFrame.setVisible(true);
    }//GEN-LAST:event_tbl_followersMouseClicked

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        Profile_Panel.Followings_JFrame.setVisible(false);
        Login_Panel.Profile_Frame.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_follower_number;
    private javax.swing.JTable tbl_followers;
    // End of variables declaration//GEN-END:variables
}