/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;
import java.util.regex.*;
import java.sql.*;

public class signinfac extends javax.swing.JFrame {
static PreparedStatement ps;

static connect con;

    public signinfac() {
        con=new connect();
        initComponents();
       
        setVisible(true);
        Enter();
    }
    public static void Enter()
    {try
    {ps=con.cn.prepareStatement("insert into faculty values (?,?,?,?,?,?,?,?,?,?,?)");
    }
    catch(Exception e)
    { 
      
    }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        pg1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        teacher = new javax.swing.JCheckBox();
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
        qual = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dept = new javax.swing.JComboBox<>();
        phn = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        hod = new javax.swing.JCheckBox();
        deptdrop = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        wname = new javax.swing.JLabel();
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

        teacher.setText("Teacher");
        teacher.setToolTipText("If you are Teacher then plzz write your Qualification");
        teacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherActionPerformed(evt);
            }
        });

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
        jLabel9.setText("Faculty");

        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        qual.setToolTipText("Enter your Qualifications here");
        qual.setEnabled(false);
        qual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qualActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Dept :");

        dept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Related Domain", "Academics", "Faculty", "Administrative", "Practical Labs", "Ragging/Misbehaviour ", "Canteen/Shops", "Transport", "Sports ", "Library", "Hostel", "Medical", "Other Issues" }));
        dept.setEnabled(false);
        dept.setVerifyInputWhenFocusTarget(false);
        dept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptActionPerformed(evt);
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

        hod.setText("HOD");
        hod.setToolTipText("If you are HOD then plzz select respective domain");
        hod.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hodItemStateChanged(evt);
            }
        });
        hod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hodFocusGained(evt);
            }
        });
        hod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hodActionPerformed(evt);
            }
        });

        deptdrop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Deptt.", "CSE/IT", "ECE", "Civil E", "Mech. E", "Common" }));
        deptdrop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        deptdrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptdropActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("UID");

        uid.setToolTipText("UID Format : F@@@@@@@");
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
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addGroup(pg1Layout.createSequentialGroup()
                                .addComponent(phn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pg1Layout.createSequentialGroup()
                                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(teacher)
                                    .addComponent(hod))
                                .addGap(18, 18, 18)
                                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qual, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deptdrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(144, Short.MAX_VALUE))
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
                        .addGap(58, 58, 58)
                        .addComponent(wname, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pg1Layout.setVerticalGroup(
            pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pg1Layout.createSequentialGroup()
                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pg1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(deptdrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel16)
                .addGap(12, 12, 12)
                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hod)
                    .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacher))
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
                .addGap(18, 18, 18)
                .addComponent(wname, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
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
        jLabel13.setText("Faculty");

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
            .addGroup(pg2Layout.createSequentialGroup()
                .addGroup(pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pg2Layout.createSequentialGroup()
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
                        .addGroup(pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pg2Layout.createSequentialGroup()
                                .addGroup(pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pg2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pg2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(204, 204, 204)))
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pg2Layout.setVerticalGroup(
            pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pg2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pg2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
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
                .addComponent(msg, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(18, 18, 18)
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

public static boolean isValidMail(String s)
{String MailPatt="^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$";
Pattern pat=Pattern.compile(MailPatt);
if(s==null)
    return false;
return pat.matcher(s).matches();}
public static boolean isValidName(String s)
{String MailPatt="[a-zA-Z\\s]*";
Pattern pat=Pattern.compile(MailPatt);
if(s==null)
    return false;
return pat.matcher(s).matches();}
public static boolean isValidUID(String s)
{Pattern pt=Pattern.compile("[F]"+"[0-9]{7}");
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
     { msg.setText("Password mismatch");}
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
    if(hod.isSelected() && teacher.isSelected()==false)
    {
     ps.setString(4,"HOD");
    ps.setString(5,dept.getSelectedItem().toString());}
    else if(teacher.isSelected() && hod.isSelected()==false)
    {
     ps.setString(4,"Teacher");
    ps.setString(5,qual.getText());}
    else if(teacher.isSelected() && hod.isSelected())
    {
     ps.setString(4,"HOD & Teacher");
    ps.setString(5,"HOD of module : " +dept.getSelectedItem().toString());}
     //Gender
            if(male.isSelected())
            {
             ps.setString(6,"Male");
            }
            else
                ps.setString(6,"Female");
     ps.setString(7,phn.getText());
     ps.setString(8,mail.getText());
     ps.setString(9,add.getText());
     ps.setString(10,ps2.getText());
     ps.setString(11,"1");
           int i= ps.executeUpdate();
           if(i==1)
           {msg.setText("Details Submitted. Wait for verification by Admin");
           prev.setVisible(false);
           regt.setVisible(false);
           }
          
               
                }
     catch(Exception e)
     {
    
     msg.setText("You should have unique UID");}
     }
    }//GEN-LAST:event_regtActionPerformed

    private void deptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deptActionPerformed

    private void qualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qualActionPerformed

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
         else if(hod.isSelected()==false && teacher.isSelected()==false)
       {   wname.setText("Mention your Designation as a faculty");}
         else if( hod.isSelected() && dept.getSelectedItem().equals("Select Related Domain"))
            {  wname.setText("As an HOD , select your domain...");}
          else if( teacher.isSelected() && qual.getText().length()==0)
            {  wname.setText("Fill your Qualification details");}
          else if(isValidNo(phn.getText())==false || phn.getText().length()!=10)
          {wname.setText("Invalid Mobile No.");}
          else if(isValidMail(mail.getText())==false)
          {wname.setText("Invalid  E-mail address");}
           else if(isValidName(name.getText())==false)
          {wname.setText("Invalid  Name");}
          else if(isValidUID(uid.getText())==false)
                  {wname.setText("Invalid  UID");}
        else
     {  pg2.setVisible(true);
        pg1.setVisible(false);
        wname.setText("");
         
     }
        
       
    }//GEN-LAST:event_nextActionPerformed

    private void hodItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hodItemStateChanged
       // TODO add your handling code here:
    }//GEN-LAST:event_hodItemStateChanged

    private void hodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hodActionPerformed
        if(hod.isSelected())
        {dept.setEnabled(true);
        }
        else
        {dept.setEnabled(false);
        dept.setSelectedIndex(0);
        } 
    }//GEN-LAST:event_hodActionPerformed

    private void hodFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hodFocusGained
       // TODO add your handling code here:
    }//GEN-LAST:event_hodFocusGained

    private void teacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherActionPerformed
        if(teacher.isSelected())
        {qual.setEnabled(true);}
        else
        {qual.setEnabled(false);
        qual.setText("");}
    }//GEN-LAST:event_teacherActionPerformed

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  new signinfac();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea add;
    private javax.swing.JComboBox<String> dept;
    private javax.swing.JComboBox<String> deptdrop;
    private javax.swing.JRadioButton female;
    private javax.swing.JCheckBox hod;
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
    private javax.swing.JTextField qual;
    private javax.swing.JButton regt;
    private javax.swing.JCheckBox teacher;
    private javax.swing.JTextField uid;
    private javax.swing.JLabel wname;
    // End of variables declaration//GEN-END:variables
}
