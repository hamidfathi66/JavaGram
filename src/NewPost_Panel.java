import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.DriverManager;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.omg.CORBA.portable.InputStream;

public class NewPost_Panel extends javax.swing.JPanel {
    public static String PATH;
	
    public NewPost_Panel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta_post = new javax.swing.JTextArea();
        btn_img = new javax.swing.JButton();
        btn_share = new javax.swing.JButton();
        lbl_img = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(198, 217, 230));

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        txta_post.setColumns(20);
        txta_post.setLineWrap(true);
        txta_post.setRows(5);
        txta_post.setPreferredSize(new java.awt.Dimension(206, 150));
        jScrollPane1.setViewportView(txta_post);

        btn_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tap.png"))); // NOI18N
        btn_img.setText("Chose Image");
        btn_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imgActionPerformed(evt);
            }
        });

        btn_share.setIcon(new javax.swing.ImageIcon(getClass().getResource("/share.png"))); // NOI18N
        btn_share.setText("Share");
        btn_share.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_shareActionPerformed(evt);
            }
        });

        lbl_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(9, 0, 49));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/send_message.png"))); // NOI18N
        jLabel4.setText("Java Gram");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_img)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_back, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                        .addComponent(btn_img, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_share, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_img)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_share)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        Post_Panel.NewPost_JFrame.setVisible(false);
        Profile_Panel.Post_JFrame.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_shareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_shareActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javagram_db", "root", "");
            String sql = "INSERT INTO tbl_post (user_name, post_txt, post_pic) Values (?, ?, ?)";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, Login_Panel.user_name);
            ps.setString(2, txta_post.getText());
            FileInputStream is = new FileInputStream(new File(PATH));
            ps.setBlob(3, is);
            ps.executeUpdate();
            conn.close();
            
            JOptionPane.showMessageDialog(null, "Sharing was successfuly.");
            
            Post_Panel.NewPost_JFrame.setVisible(false);
            Profile_Panel.Post_JFrame = Profile_Panel.create_JFrame(new Post_Panel(), "Post Panel: " + Login_Panel.user_name,  386, 460);
            Profile_Panel.Post_JFrame.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_shareActionPerformed

    private void btn_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imgActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "png", "ico");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selected_file = fileChooser.getSelectedFile();
            String path = selected_file.getAbsolutePath();
            PATH = path;
            try {
                FileInputStream is = new FileInputStream(new File(path));
                BufferedImage im = ImageIO.read(is);
                Image scaleImage = im.getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), WIDTH);
                ImageIcon icon = new ImageIcon(scaleImage);
                lbl_img.setIcon(icon);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btn_imgActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_img;
    private javax.swing.JButton btn_share;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JTextArea txta_post;
    // End of variables declaration//GEN-END:variables
}