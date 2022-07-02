public class Splash_Panel extends javax.swing.JPanel {
    public Splash_Panel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bar = new javax.swing.JLabel();
        prog = new javax.swing.JProgressBar();
        lbl_logo2 = new javax.swing.JLabel();
        lbl_logo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        bar.setText("0%");
        add(bar);
        bar.setBounds(390, 530, 30, 14);
        add(prog);
        prog.setBounds(170, 510, 455, 14);

        lbl_logo2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbl_logo2.setForeground(new java.awt.Color(246, 152, 22));
        add(lbl_logo2);
        lbl_logo2.setBounds(20, 120, 130, 40);

        lbl_logo1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbl_logo1.setForeground(new java.awt.Color(161, 197, 252));
        lbl_logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_icon.png"))); // NOI18N
        add(lbl_logo1);
        lbl_logo1.setBounds(50, 10, 60, 110);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sn_gif.gif"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 490);

        jLabel2.setForeground(new java.awt.Color(9, 0, 49));
        jLabel2.setText("Development and Design By : Hamid Fathi");
        add(jLabel2);
        jLabel2.setBounds(300, 560, 200, 14);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel bar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_logo1;
    public static javax.swing.JLabel lbl_logo2;
    public static javax.swing.JProgressBar prog;
    // End of variables declaration//GEN-END:variables
}
