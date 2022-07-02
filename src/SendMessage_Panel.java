import com.mysql.jdbc.Connection;
import com.mysql.jdbc.NonRegisteringDriver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class SendMessage_Panel extends javax.swing.JPanel {
    public static String SENDER;
    public static String RECEIVER;
	
    public SendMessage_Panel(String sender, String receiver) {
        initComponents();
        
        SENDER = sender;
        RECEIVER = receiver;
        
        lbl_receiver.setText(RECEIVER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txta_message = new javax.swing.JTextArea();
        btn_send_message = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_receiver = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(198, 217, 230));

        txta_message.setColumns(20);
        txta_message.setLineWrap(true);
        txta_message.setRows(5);
        jScrollPane1.setViewportView(txta_message);

        btn_send_message.setIcon(new javax.swing.ImageIcon(getClass().getResource("/share.png"))); // NOI18N
        btn_send_message.setText("Send");
        btn_send_message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_send_messageActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(9, 0, 49));
        jLabel1.setText("Send Message to ");

        lbl_receiver.setForeground(new java.awt.Color(9, 0, 49));
        lbl_receiver.setText("Receiver");

        jLabel5.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(9, 0, 49));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/send_message.png"))); // NOI18N
        jLabel5.setText("Java Gram");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                    .addComponent(btn_send_message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_receiver)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_receiver)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_send_message)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_send_messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_send_messageActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db","root","");
            String sql = "INSERT INTO tbl_private_messages (user_name1, user_name2, message_txt) VALUES(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, SENDER); //Sender
            ps.setString(2, RECEIVER); //Receiver
            ps.setString(3, txta_message.getText());
            ps.executeUpdate();
            conn.close();
            
            JOptionPane.showMessageDialog(null, "OK.Message was sent to " + User_Panel.USERNAME);
            
            Direct_Message_Panel.SendMessage_Panel.setVisible(false);
            Profile_Panel.Direct_Message_JFrame = Profile_Panel.create_JFrame(new Direct_Message_Panel(), "Direct Message Panel: " + Login_Panel.user_name, 418, 470);
            Profile_Panel.Direct_Message_JFrame.setVisible(true); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_send_messageActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Direct_Message_Panel.SendMessage_Panel.setVisible(false);
        Profile_Panel.Direct_Message_JFrame = Profile_Panel.create_JFrame(new Direct_Message_Panel(), "Direct Message Panel: " + Login_Panel.user_name, 418, 470);
        Profile_Panel.Direct_Message_JFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_send_message;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_receiver;
    private javax.swing.JTextArea txta_message;
    // End of variables declaration//GEN-END:variables
}