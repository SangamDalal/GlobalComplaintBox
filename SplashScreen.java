
package myproject;

import javax.swing.JOptionPane;


public class SplashScreen extends javax.swing.JDialog implements Runnable {
static SplashScreen dialog;
Thread t;   
    public SplashScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
        t=new Thread(this);
        t.start();
   
    }


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prog = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prog.setForeground(new java.awt.Color(0, 153, 51));
        prog.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(51, 153, 0), new java.awt.Color(0, 153, 102)));
        prog.setIndeterminate(true);
        prog.setOpaque(true);
        prog.setStringPainted(true);
        getContentPane().add(prog, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 280, 20));

        jLabel2.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("Loading . . .");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 110, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/icon.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 170, 270));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/splshscrn.jpg"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 740, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar prog;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
    int i=0;
     try
     {
       while(i<=100) 
       { prog.setValue(i);
       i=i+10;
       t.sleep(370);
       if(i==100)
       {new main();
       dialog.setVisible(false);}}
     }
     catch(Exception e)
     {
       JOptionPane.showMessageDialog(rootPane, "Progress Bar loading failed"+e);  
     }
}}
