/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;
import java.util.regex.*;
import java.sql.*;
public class signinstud extends javax.swing.JFrame {
static PreparedStatement ps;
static connect con;
    public signinstud() {
        initComponents();
       con=new connect();
        setVisible(true);
        enter();
    }
 public static void enter()
    {try
    {ps=con.cn.prepareStatement("insert into student values (?,?,?,?,?,?,?,?,?,?)");
    }
    catch(Exception e)
    {System.out.println("BAD statement"+e);
    }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        pg1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        add = new javax.swing.JTextArea();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        female = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        sem = new javax.swing.JComboBox<>();
        phn = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        deptdrop = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        wname = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pg2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ps1 = new javax.swing.JPasswordField();
        ps2 = new javax.swing.JPasswordField();
        regt = new javax.swing.JButton();
        prev = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jLayeredPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jLayeredPane1.setLayout(new java.awt.CardLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Gender");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Phone");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/imgSml.png"))); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/logo.png"))); // NOI18N

        add.setColumns(20);
        add.setRows(5);
        jScrollPane1.setViewportView(add);

        name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameFocusLost(evt);
            }
        });
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Address");

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Student");

        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Dept :");

        sem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Semester", "I", "II", "III", "IV", "V", "VI", "VII", "VIII" }));
        sem.setVerifyInputWhenFocusTarget(false);
        sem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semActionPerformed(evt);
            }
        });

        phn.setToolTipText("Enter phone no. here");
        phn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phnKeyPressed(evt);
            }
        });

        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });

        deptdrop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Deptt.", "CSE/IT", "ECE", "Civil E", "Mech. E" }));
        deptdrop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        deptdrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptdropActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("UID");

        uid.setToolTipText("UID Format : S@@@@@@@");
        uid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                uidFocusLost(evt);
            }
        });
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("E Mail");

        wname.setBackground(new java.awt.Color(255, 0, 0));
        wname.setForeground(new java.awt.Color(255, 0, 0));
        wname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Sem. :");

        javax.swing.GroupLayout pg1Layout = new javax.swing.GroupLayout(pg1);
        pg1.setLayout(pg1Layout);
        pg1Layout.setHorizontalGroup(
            pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pg1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pg1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addComponent(wname, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addGroup(pg1Layout.createSequentialGroup()
                                .addComponent(phn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pg1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deptdrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(91, Short.MAX_VALUE))
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(15, 15, 15))))
            .addGroup(pg1Layout.createSequentialGroup()
                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(male)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(female))
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16))
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(uid, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pg1Layout.setVerticalGroup(
            pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pg1Layout.createSequentialGroup()
                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(wname, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(deptdrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(sem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(male)
                    .addComponent(female))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
        );

        jLayeredPane1.add(pg1, "card2");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Password :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Confirm Password :");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/logo.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Student");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/imgSml.png"))); // NOI18N

        ps1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ps1FocusLost(evt);
            }
        });
        ps1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ps1ActionPerformed(evt);
            }
        });

        ps2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ps2ActionPerformed(evt);
            }
        });

        regt.setText("Register");
        regt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regtActionPerformed(evt);
            }
        });

        prev.setFont(new java.awt.Font("Tunga", 1, 14)); // NOI18N
        prev.setText(" <  Previous");
        prev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prevMouseClicked(evt);
            }
        });

        msg.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        msg.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout pg2Layout = new javax.swing.GroupLayout(pg2);
        pg2.setLayout(pg2Layout);
        pg2Layout.setHorizontalGroup(
            pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pg2Layout.createSequentialGroup()
                .addGroup(pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pg2Layout.createSequentialGroup()
                        .addGroup(pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pg2Layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(regt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pg2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pg2Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ps1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                                    .addGroup(pg2Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ps2)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pg2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pg2Layout.createSequentialGroup()
                                .addGroup(pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(prev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pg2Layout.setVerticalGroup(
            pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pg2Layout.createSequentialGroup()
                .addGroup(pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pg2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pg2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addGroup(pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ps1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ps2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(regt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jLayeredPane1.add(pg2, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ps1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ps1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ps1ActionPerformed

    private void ps2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ps2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ps2ActionPerformed
public static boolean isValidNo(String s)
{Pattern p=Pattern.compile("(0/91)?[7-9][0-9]{9}");
    Matcher m=p.matcher(s);
    return (m.find()&& m.group().equals(s));}
public static boolean isValidName(String s)
{String MailPatt="[a-zA-Z\\s]*";
Pattern pat=Pattern.compile(MailPatt);
if(s==null)
    return false;
return pat.matcher(s).matches();}
public static boolean isValidMail(String s)
{String MailPatt="^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$";
Pattern pat=Pattern.compile(MailPatt);
if(s==null)
    return false;
return pat.matcher(s).matches();}

public static boolean isValidUID(String s)
{Pattern pt=Pattern.compile("[S]"+"[0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
Matcher m=pt.matcher(s);
return pt.matcher(s).matches();
}

    private void prevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevMouseClicked
        pg2.setVisible(false);
        pg1.setVisible(true);
   
     
      ps1.setText("");
      ps2.setText("");
      msg.setText("");
    }//GEN-LAST:event_prevMouseClicked

    private void regtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regtActionPerformed
if(!ps1.getText().equals(ps2.getText()))
{msg.setText("Password mismatch");}
else if(ps1.getText().length()<8)
     {msg.setText("Password length too small");
     ps1.requestFocus();}
else
     { 
    
     try
     { 
     ps.setString(1,name.getText());
     ps.setString(2,uid.getText());
    ps.setString(3,deptdrop.getSelectedItem().toString());
    ps.setString(4,sem.getSelectedItem().toString());
     //Gender
            if(male.isSelected())
            {
             ps.setString(5,"Male");
            }
            else
                ps.setString(5,"Female");
     ps.setString(6,phn.getText());
     ps.setString(7,mail.getText());
     ps.setString(8,add.getText());
     ps.setString(9,ps2.getText());
     ps.setString(10,"1");
           int i= ps.executeUpdate();
           if(i==1)
           {msg.setText("Details Submitted. Wait for verification by Admin");
           prev.setVisible(false);
           regt.setVisible(false);
           }
          
               
                }
     catch(Exception e)
     {
     System.out.println("Not working" +  e);
     msg.setText("You should have unique UID");}
     }
    }//GEN-LAST:event_regtActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
       if( 
       name.getText().length()==0 
        ||add.getText().length()==0
        )
        {wname.setText("Please fill all the necessary details ");}
        else if( 
       name.getText().length()>=20 
        ||add.getText().length()>=100
        )
        {wname.setText("Name or address may have exceeded their size");}
       else if(male.isSelected()==false && female.isSelected()==false)
       {wname.setText("Gender not selected ");}
       else if(deptdrop.getSelectedItem().equals("Select Deptt."))
       {wname.setText("Select your Department ");}
        else if(sem.getSelectedItem().equals("Select Semester"))
       {wname.setText("Select your Semester ");}
          else if(isValidNo(phn.getText())==false || phn.getText().length()!=10)
          {wname.setText("Invalid Mobile No.");}
          else if(isValidMail(mail.getText())==false)
          {wname.setText("Invalid  E-mail address");}
           else if(isValidName(name.getText())==false)
          {wname.setText("Invalid  Name");}
          else if(isValidUID(uid.getText())==false)
                  {wname.setText("Invalid  UID");}
        else
     {pg2.setVisible(true);
        pg1.setVisible(false);
        wname.setText("");}
       
    }//GEN-LAST:event_nextActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        if(male.isSelected())
        {female.setSelected(false);}
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        if(female.isSelected())
        {male.setSelected(false);}
    }//GEN-LAST:event_femaleActionPerformed

    private void nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusLost
        
    }//GEN-LAST:event_nameFocusLost

    private void deptdropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptdropActionPerformed
     
    }//GEN-LAST:event_deptdropActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
     
    }//GEN-LAST:event_nameActionPerformed

    private void phnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phnKeyPressed

    }//GEN-LAST:event_phnKeyPressed

    private void uidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uidFocusLost
 
    }//GEN-LAST:event_uidFocusLost

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void ps1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ps1FocusLost
        if(ps1.getText().length()<8)
     {msg.setText("Password length too small");
     ps1.requestFocus();}
        else
        {msg.setText("");}
    }//GEN-LAST:event_ps1FocusLost

    private void semActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  new signinstud();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea add;
    private javax.swing.JComboBox<String> deptdrop;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mail;
    private javax.swing.JRadioButton male;
    private javax.swing.JLabel msg;
    private javax.swing.JTextField name;
    private javax.swing.JButton next;
    private javax.swing.JPanel pg1;
    private javax.swing.JPanel pg2;
    private javax.swing.JTextField phn;
    private javax.swing.JLabel prev;
    private javax.swing.JPasswordField ps1;
    private javax.swing.JPasswordField ps2;
    private javax.swing.JButton regt;
    private javax.swing.JComboBox<String> sem;
    private javax.swing.JTextField uid;
    private javax.swing.JLabel wname;
    // End of variables declaration//GEN-END:variables
}
