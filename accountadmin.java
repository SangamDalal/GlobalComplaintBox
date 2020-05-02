
package myproject;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class accountadmin extends javax.swing.JFrame{
connect con;
PreparedStatement ps_for_ad_log,ps_for_ad_dlt;
static Statement st_for_rsfac,st_for_rsstud,st_for_specifac,st_for_specistud,st_for_comp,st_for_complnr,stchngpswd,st_for_notify,st_for_stat; 
DefaultTableModel modtab1,modtab2,comptabmod,compstat;
ResultSet rs_for_fac,rs_for_stud,rs_for_comp,rs_for_complnr,rs_for_notify,rs_for_stat;

    public accountadmin() {
        initComponents();
        setVisible(true);
        con=new connect();
        open();
        notification();
        stat();
        modtab1=(DefaultTableModel)tab1.getModel();
        modtab2=(DefaultTableModel)tab2.getModel();
        comptabmod=(DefaultTableModel)comptab.getModel();
        compstat=(DefaultTableModel)stat.getModel();
    }
    public void viewcomp()
    {try
    {st_for_comp=con.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs_for_comp=st_for_comp.executeQuery("select * from complaint where issue='"+moddept.getSelectedItem().toString()+"'and department='"+deptdrop.getSelectedItem()+"' and status ='1'");
    DefaultTableModel dm=(DefaultTableModel)comptab.getModel();
       
       comptab.setModel(dm);
        while(rs_for_comp.next())
        {
      Object o[]={rs_for_comp.getInt("cid"),rs_for_comp.getString("description")};
      dm.addRow(o);
       }}
    catch(Exception e)
    {JOptionPane.showMessageDialog(rootPane,"Error in new complaint display"+e);}
    }
     public void notification()
     {
    try
    {   st_for_notify=con.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        for(int i=1;i<=12;i++)
    {int r=0;
    String is=moddept.getItemAt(i);
     rs_for_notify=st_for_notify.executeQuery("select * from complaint where status='1' and issue='"+is+"'");
     switch(is)
             {   case "Academics" :while(rs_for_notify.next()){r++;}nt1.setText("Academics : "+r);break;
                 case "Faculty":while(rs_for_notify.next()){r++;}nt2.setText("Faculty : "+r);break;
                 case "Administrative":while(rs_for_notify.next()){r++;}nt3.setText("Administrative : "+r);break;
                 case "Practical Labs":while(rs_for_notify.next()){r++;}nt4.setText("Practical Labs : "+r);break;
                 case "Ragging/Misbehaviour ":while(rs_for_notify.next()){r++;}nt5.setText("Ragging/Misbehaviour : "+r);break;
                 case "Canteen/Shops":while(rs_for_notify.next()){r++;}nt6.setText("Canteen/Shops : "+r);break;
                 case "Medical":while(rs_for_notify.next()){r++;}nt11.setText("Medical : "+r);break;
                 case "Transport" :while(rs_for_notify.next()){r++;}nt7.setText("Transport :"+r);break;
                 case "Sports " :while(rs_for_notify.next()){r++;}nt8.setText("Sports : "+r);break;
                 case "Library" :while(rs_for_notify.next()){r++;}nt9.setText("Library : "+r);break;
                 case "Hostel":while(rs_for_notify.next()){r++;}nt10.setText("Hostel : "+r);break;
                case "Other Issues": while(rs_for_notify.next()){r++;}nt12.setText("Other Issues : "+r);break;    
                          
             }
   
     }
    }
    catch(Exception e)
    {JOptionPane.showMessageDialog(rootPane, "Notifications not updated"+e);}
     
    
     }
     public void stat()
     {DefaultTableModel dm=(DefaultTableModel)stat.getModel();
     int rowCount=dm.getRowCount();
    for (int i = rowCount - 1; i >= 0; i--) {
    dm.removeRow(i);
} 
     stat.setModel(dm);
      String stat=null;
      try
      {st_for_stat=con.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
     rs_for_stat=st_for_stat.executeQuery("select * from complaint where status ='2' or status='3' or status='4' order by issue asc");
     while(rs_for_stat.next())
        {switch(rs_for_stat.getString("status"))
        {case "2":stat="Haven't Acknowledegd by HOD";break;
        case "3":stat="Working on issue";break;
        case "4":stat="Issue Resolved";break;        }
      Object o[]={rs_for_stat.getInt("cid"),rs_for_stat.getString("department"),rs_for_stat.getString("issue"),rs_for_stat.getString("description"),stat};
      dm.addRow(o);
      }
      
      }
      catch(Exception e)
      {JOptionPane.showMessageDialog(rootPane, "Error in all complaint display"+e);}
      
      
      }

public void open()
{ try
      {ps_for_ad_log=con.cn.prepareStatement("insert into admin values (?,?)");
      ps_for_ad_dlt=con.cn.prepareStatement("delete from admin where username=(?)");
      usnm.setText(main.rs.getString("username"));
      st_for_rsfac=con.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
       
        
        rs_for_fac=st_for_rsfac.executeQuery("select * from faculty where acstatus='1'");
        
        
        DefaultTableModel dm=(DefaultTableModel)tab1.getModel();
       
        tab1.setModel(dm);
        while(rs_for_fac.next())
        {
      Object o[]={rs_for_fac.getString("usid"),rs_for_fac.getString("name"),rs_for_fac.getString("department"),rs_for_fac.getString("designation"),rs_for_fac.getString("qualification")};
      dm.addRow(o);
        }
        
        
        st_for_rsstud=con.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
       rs_for_stud=st_for_rsstud.executeQuery("select * from student where acstatus='1'"); 
        DefaultTableModel dm2=(DefaultTableModel)tab2.getModel();
       dm2.setRowCount(0);
        tab2.setModel(dm2);
        while(rs_for_stud.next())
        {
      Object ob[]={rs_for_stud.getString("usid"),rs_for_stud.getString("name"),rs_for_stud.getString("department"),rs_for_stud.getString("semester")};
      dm2.addRow(ob);
        }
      }
      catch(Exception e)
      {JOptionPane.showMessageDialog(rootPane, "Accout Details not retreived"+e);}}

public void mainfac(String s)
{ 
    try
    {   
    
    st_for_specifac=con.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
    int i=st_for_specifac.executeUpdate("update faculty set acstatus='2' where usid='"+s+"'");
    if(i==1)
    {
   msg.setText("Verified");
int row=tab1.getSelectedRow();
modtab1.removeRow(row);    
    }
    }
catch(Exception e)
{JOptionPane.showMessageDialog(rootPane, "Error ocurred while verification"+e);}
}
public void mainstud(String s)
{ 
    try
{
    st_for_specistud=con.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
    int i=st_for_specistud.executeUpdate("update student set acstatus='2' where usid='"+s+"'");
if(i==1)
{
   msg2.setText("Verified");
int row=tab2.getSelectedRow();
modtab2.removeRow(row);    

}
}
catch(Exception e)
{JOptionPane.showMessageDialog(rootPane, "Error ocurred while verification"+e);}
}

public void maincomp(String s)
{ 
    try
{
int i=st_for_rsfac.executeUpdate("update complaint set status='2' where cid="+s);
if(i==1)
{   JOptionPane.showMessageDialog(rootPane, "Issue sent to HOD of this department");
   
int row=comptab.getSelectedRow();
comptabmod.removeRow(row);    
nm.setText("Name");
id.setText("UID");
phnno.setText("Phone no.");

}
}
catch(Exception e)
{JOptionPane.showMessageDialog(rootPane, "Error ocurred while sending forward"+e);}
}
public void removecomp(String s)
{ 
    try
{
int i=st_for_rsfac.executeUpdate("update complaint set status='0' where cid="+s);
if(i==1)
{
   JOptionPane.showMessageDialog(rootPane, "Complaint discarded");
int row=comptab.getSelectedRow();
comptabmod.removeRow(row);    
nm.setText("Name");
id.setText("UID");
phnno.setText("Phone no.");

}
}
catch(Exception e)
{JOptionPane.showMessageDialog(rootPane, "Error ocurred while discarding"+e);}
}
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        psold = new javax.swing.JPasswordField();
        psnew = new javax.swing.JPasswordField();
        psconf = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        lblmsg1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        comppg1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        lblmsg2 = new javax.swing.JLabel();
        moddept = new javax.swing.JComboBox<>();
        nt1 = new javax.swing.JLabel();
        nt2 = new javax.swing.JLabel();
        nt3 = new javax.swing.JLabel();
        nt4 = new javax.swing.JLabel();
        nt5 = new javax.swing.JLabel();
        nt6 = new javax.swing.JLabel();
        nt7 = new javax.swing.JLabel();
        nt8 = new javax.swing.JLabel();
        nt9 = new javax.swing.JLabel();
        nt10 = new javax.swing.JLabel();
        nt11 = new javax.swing.JLabel();
        nt12 = new javax.swing.JLabel();
        deptdrop = new javax.swing.JComboBox<>();
        comppg2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        nm = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        comptab = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        phnno = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stat = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        verifac = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tab1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tab2 = new javax.swing.JTable();
        veristud = new javax.swing.JButton();
        msg = new javax.swing.JLabel();
        discstud = new javax.swing.JButton();
        discfac = new javax.swing.JButton();
        msg2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblmsg = new javax.swing.JLabel();
        deltusnm = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        newusnm = new javax.swing.JTextField();
        ps1 = new javax.swing.JPasswordField();
        ps2 = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        usnm = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jTabbedPane3.setBackground(new java.awt.Color(0, 0, 0));
        jTabbedPane3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jTabbedPane3.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane3.setAlignmentX(2.0F);
        jTabbedPane3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 10, true));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Confirm Password");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Existing Password");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("New Password");

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setText("Change");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        lblmsg1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblmsg1.setForeground(new java.awt.Color(204, 0, 0));
        lblmsg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel20))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel18))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblmsg1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(psconf, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(psnew, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(psold, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblmsg1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(psold, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(psnew, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(psconf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel5);
        jPanel5.setBounds(90, 70, 388, 569);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Change Password ");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(190, 10, 170, 60);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/35.jpg"))); // NOI18N
        jPanel6.add(jLabel31);
        jLabel31.setBounds(0, 0, 1270, 779);

        jTabbedPane3.addTab("HOME", jPanel6);

        jPanel3.setBackground(new java.awt.Color(204, 153, 255));

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        comppg1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/icon.png"))); // NOI18N

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton4.setText("View Complaints");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        lblmsg2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        lblmsg2.setForeground(new java.awt.Color(204, 0, 0));
        lblmsg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        moddept.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        moddept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Module :", "Academics", "Faculty", "Practical Labs", "Administrative", "Ragging/Misbehaviour ", "Canteen/Shops", "Transport", "Sports ", "Library", "Hostel", "Medical", "Other Issues" }));
        moddept.setVerifyInputWhenFocusTarget(false);
        moddept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moddeptActionPerformed(evt);
            }
        });

        nt1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/nt1.png"))); // NOI18N
        nt1.setText("Academics : 0");

        nt2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nt2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/nt2.png"))); // NOI18N
        nt2.setText("Faculty : 0");

        nt3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nt3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/nt3.png"))); // NOI18N
        nt3.setText("Administrative : 0");

        nt4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nt4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/nt4.png"))); // NOI18N
        nt4.setText("Practical Labs : 0");

        nt5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nt5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/nt5.png"))); // NOI18N
        nt5.setText("Ragging/Misbehaviour : 0");

        nt6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nt6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/nt6.png"))); // NOI18N
        nt6.setText("Canteen/Shops : 0");

        nt7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nt7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/nt8.png"))); // NOI18N
        nt7.setText("Transport : 0");

        nt8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nt8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/nt9.png"))); // NOI18N
        nt8.setText("Sports : 0");

        nt9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nt9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/nt10.png"))); // NOI18N
        nt9.setText("Library : 0");

        nt10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nt10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/nt11.png"))); // NOI18N
        nt10.setText("Hostel : 0");

        nt11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nt11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/nt7.png"))); // NOI18N
        nt11.setText("Medical : 0");

        nt12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nt12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/nt12.png"))); // NOI18N
        nt12.setText("Other Issues : 0");

        deptdrop.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deptdrop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Common", "CSE/IT", "ECE", "Civil E", "Mech. E", " " }));
        deptdrop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        deptdrop.setEnabled(false);
        deptdrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptdropActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout comppg1Layout = new javax.swing.GroupLayout(comppg1);
        comppg1.setLayout(comppg1Layout);
        comppg1Layout.setHorizontalGroup(
            comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comppg1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(moddept, 0, 290, Short.MAX_VALUE)
                    .addComponent(deptdrop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(comppg1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(nt1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(comppg1Layout.createSequentialGroup()
                        .addGroup(comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(comppg1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nt2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nt3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(nt4, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nt7, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(comppg1Layout.createSequentialGroup()
                                .addGroup(comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nt6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nt11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nt5, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nt9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nt12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nt10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nt8, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(comppg1Layout.createSequentialGroup()
                .addGroup(comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(comppg1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblmsg2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(comppg1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        comppg1Layout.setVerticalGroup(
            comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comppg1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moddept, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(deptdrop, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(comppg1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblmsg2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(comppg1Layout.createSequentialGroup()
                        .addGroup(comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(comppg1Layout.createSequentialGroup()
                                .addGroup(comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nt5)
                                    .addComponent(nt1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nt8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nt9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(nt6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(228, 228, 228))
                    .addGroup(comppg1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(nt2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nt3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nt11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nt10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(comppg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nt4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nt7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nt12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(276, 276, 276))
        );

        jLayeredPane1.add(comppg1, "card2");

        comppg2.setBackground(new java.awt.Color(204, 204, 204));
        comppg2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comppg2PropertyChange(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setText("Complaint By :");

        nm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nm.setText("Name");

        id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        id.setText("UID");

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton5.setText("Assign To :");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Back");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        comptab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CID", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        comptab.setRowHeight(25);
        comptab.getTableHeader().setReorderingAllowed(false);
        comptab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comptabMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(comptab);

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 0, 0));
        jButton6.setText("Discard");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        phnno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phnno.setText("Phone no. ");

        javax.swing.GroupLayout comppg2Layout = new javax.swing.GroupLayout(comppg2);
        comppg2.setLayout(comppg2Layout);
        comppg2Layout.setHorizontalGroup(
            comppg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comppg2Layout.createSequentialGroup()
                .addGroup(comppg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(comppg2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(comppg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(comppg2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(comppg2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5))
                    .addGroup(comppg2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(phnno, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(comppg2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        comppg2Layout.setVerticalGroup(
            comppg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comppg2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(comppg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                    .addGroup(comppg2Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phnno, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 298, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLayeredPane1.add(comppg2, "card3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane3.addTab("VIEW COMPLAINTS", jPanel3);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        stat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CID", "Department", "Issue", "Description", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stat.setRowHeight(20);
        jScrollPane1.setViewportView(stat);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1242, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("COMPLAINT STATUS", jPanel7);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel2.setText("Teachers :");

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel3.setText("Students :");

        verifac.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        verifac.setText("Verify");
        verifac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifacActionPerformed(evt);
            }
        });

        tab1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UID", "Name", "Department", "Designation", "Module / Qualification"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab1.setEditingColumn(0);
        tab1.setEditingRow(0);
        tab1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tab1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tab1);

        jLabel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        tab2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UID", "Name", "Department", "Semester"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab2.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tab2);
        if (tab2.getColumnModel().getColumnCount() > 0) {
            tab2.getColumnModel().getColumn(1).setHeaderValue("Name");
            tab2.getColumnModel().getColumn(3).setHeaderValue("Semester");
        }

        veristud.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        veristud.setText("Verify");
        veristud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veristudActionPerformed(evt);
            }
        });

        msg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        msg.setForeground(new java.awt.Color(0, 102, 51));

        discstud.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        discstud.setText("Discard");
        discstud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discstudActionPerformed(evt);
            }
        });

        discfac.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        discfac.setText("Discard");
        discfac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discfacActionPerformed(evt);
            }
        });

        msg2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        msg2.setForeground(new java.awt.Color(0, 102, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 157, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(verifac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(discfac, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msg2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(veristud, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(discstud, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(msg2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(veristud)
                    .addComponent(discstud)
                    .addComponent(verifac)
                    .addComponent(discfac))
                .addGap(58, 58, 58))
        );

        jTabbedPane3.addTab("VERIFY ACCOUNTS", jPanel2);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel5.setText("Add Admin :");

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel6.setText("Delete Admin :");

        lblmsg.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        lblmsg.setForeground(new java.awt.Color(204, 0, 0));
        lblmsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        deltusnm.setToolTipText("Enter username here");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("New Username :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Password :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Confirm Password :");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("ADD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ps1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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

        ps2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ps2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ps2ActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/admin copy.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblmsg, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(newusnm)
                                    .addComponent(ps1)
                                    .addComponent(ps2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(435, 435, 435)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 131, Short.MAX_VALUE)))
                .addGap(156, 156, 156))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(deltusnm, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblmsg, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newusnm)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ps1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ps2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deltusnm, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(246, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("ADD ADMIN", jPanel1);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/imgSml.png"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/imgsicons/logo.png"))); // NOI18N
        jLabel4.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome Admin");

        jButton1.setText("LOG OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        usnm.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        usnm.setForeground(new java.awt.Color(255, 255, 255));
        usnm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(usnm, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTabbedPane3)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usnm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
int i=JOptionPane.showConfirmDialog(rootPane,"Sure LOG OUT ?", "Confirm", 1);
if(i==0)
{setVisible(false);
new main();}// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ps1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ps1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ps1ActionPerformed

    private void ps2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ps2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ps2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 if(!ps1.getText().equals(ps2.getText()))
     { lblmsg.setText("Password mismatch");}
else if(ps1.getText().length()<8)
     {lblmsg.setText("Password length too small");
     ps1.requestFocus();} 
 else
{try
{ps_for_ad_log.setString(1,newusnm.getText());
ps_for_ad_log.setString(2, ps2.getText());
int i=ps_for_ad_log.executeUpdate();
if(i==1)
{lblmsg.setText("Admin added successfully");

newusnm.setText("");ps1.setText("");ps2.setText("");}
}

catch(Exception e)
{lblmsg.setText("Already Registered Admin...create new Username");
newusnm.setText("");newusnm.requestFocus();}
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ps1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ps1FocusLost
  if(ps1.getText().length()<8)
     {lblmsg.setText("Password length too small");
     }       // TODO add your handling code here:
    }//GEN-LAST:event_ps1FocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
if(deltusnm.getText().equals(usnm.getText()))
{lblmsg.setText("In Use Admin...cannot delete");}
else
{try
{ps_for_ad_dlt.setString(1,deltusnm.getText()) ;  
int i=ps_for_ad_dlt.executeUpdate();
if(i==1)
lblmsg.setText("Admin deleted successfully");
else
lblmsg.setText("No such admin found");}
catch(Exception e)
{JOptionPane.showMessageDialog(rootPane, "Error :"+e);}
}

    }//GEN-LAST:event_jButton2ActionPerformed

    private void verifacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifacActionPerformed
try
{int row=tab1.getSelectedRow();
String ud=(modtab1.getValueAt(row,0)).toString() ; 
mainfac(ud);}
catch(Exception e)
    {msg.setText("Select atleast one account");}


    }//GEN-LAST:event_verifacActionPerformed

    private void veristudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veristudActionPerformed
     try
{int row=tab2.getSelectedRow();
String ud=(modtab2.getValueAt(row,0)).toString() ; 
mainstud(ud);}
catch(Exception e)
    {msg2.setText("Select atleast one account");}  
    }//GEN-LAST:event_veristudActionPerformed

    private void discfacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discfacActionPerformed
       try
{int row=tab1.getSelectedRow();
String ud=(modtab1.getValueAt(row,0)).toString() ;
modtab1.removeRow(row);    
int d=st_for_rsfac.executeUpdate("delete from faculty where usid='"+ud+"'");
if(d==1)
{msg.setText("Discarded");}
}
catch(Exception e)
    {msg.setText("Select atleast one account");}
    }//GEN-LAST:event_discfacActionPerformed

    private void discstudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discstudActionPerformed
       try
{int row=tab2.getSelectedRow();
String ud=(modtab2.getValueAt(row,0)).toString() ;
modtab2.removeRow(row);    
int d=st_for_rsstud.executeUpdate("delete from student where usid='"+ud+"'");
if(d==1)
{msg2.setText("Discarded");}
}
catch(Exception e)
    {msg2.setText("Select atleast one account");}
    }//GEN-LAST:event_discstudActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
if(moddept.getSelectedItem().equals("Select Module :"))
{lblmsg2.setText("Select complaint module");}
else if(moddept.getSelectedItem().equals("Academics") && deptdrop.getSelectedItem().equals("Common") 
        ||moddept.getSelectedItem().equals("Faculty") && deptdrop.getSelectedItem().equals("Common")
        ||moddept.getSelectedItem().equals("Practical Labs") && deptdrop.getSelectedItem().equals("Common") )
{lblmsg2.setText("Select Department for this module");}

else{
    
lblmsg2.setText("");
    viewcomp();
comppg1.setVisible(false);    
comppg2.setVisible(true);}

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
int x=comptabmod.getRowCount();
while(x>0)
{comptabmod.removeRow(x-1);
x--;}
nm.setText(("Name"));
id.setText(("UID"));
phnno.setText("Phone no.");
comppg2.setVisible(false);    
comppg1.setVisible(true); 
notification();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    private void moddeptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moddeptActionPerformed
if(moddept.getSelectedItem().equals("Academics")||moddept.getSelectedItem().equals("Faculty")||moddept.getSelectedItem().equals("Practical Labs"))
{deptdrop.setEnabled(true);}
else
{deptdrop.setSelectedIndex(0);
deptdrop.setEnabled(false);}
    }//GEN-LAST:event_moddeptActionPerformed

    private void comppg2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comppg2PropertyChange
       // TODO add your handling code here:
    }//GEN-LAST:event_comppg2PropertyChange

    private void comptabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comptabMouseClicked
int row=comptab.getSelectedRow();
int ud=Integer.parseInt(comptabmod.getValueAt(row,0).toString());

try
{st_for_complnr=con.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
    rs_for_complnr=st_for_complnr.executeQuery("select * from complaint where cid=" + ud);
 while(rs_for_complnr.next())
 {
nm.setText(rs_for_complnr.getString("name"));
id.setText(rs_for_complnr.getString("usid"));
phnno.setText(rs_for_complnr.getString("phone"));
 }
}
catch(Exception e)
{JOptionPane.showMessageDialog(rootPane, "Error :"+e);}          // TODO add your handling code here:
    }//GEN-LAST:event_comptabMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
  try
  {int row=comptab.getSelectedRow();
       String mod=(comptabmod.getValueAt(row,0)).toString() ;
maincomp(mod);
stat();
  }
catch(Exception e)
    {msg.setText("Select atleast one account");}
       
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      try
  {int row=comptab.getSelectedRow();
  String mod=(comptabmod.getValueAt(row,0)).toString() ;
removecomp(mod);
  stat();}
catch(Exception e)
    {msg.setText("Select atleast one account");}
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try
        {
            if(psold.getText().equals(main.rs.getString("password")))
            {   lblmsg1.setText("");
                if(!psnew.getText().equals(psconf.getText()))
                { lblmsg1.setText("Password mismatch");}
                else if(psnew.getText().length()<8)
                {lblmsg1.setText("Password length too small");
                    psnew.requestFocus();}
                else{
                    try
                    {stchngpswd=con.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                        int i=stchngpswd.executeUpdate("update admin set password='"+psnew.getText()+"' where username = '" +usnm.getText()+"'");
                        if(i==1)
                        {lblmsg1.setText("password changed");
                            psold.setText("");psnew.setText("");psconf.setText("");}
                    }
                    catch(Exception e)
                    {lblmsg1.setText("Error in changing password");
                        }
                }
            }
            else
            {lblmsg1.setText("Old password mismatch");}
        }
        catch(Exception e)
        {lblmsg1.setText("Old password mismatch");
            }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void deptdropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptdropActionPerformed

    }//GEN-LAST:event_deptdropActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(accountadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(accountadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(accountadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(accountadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accountadmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel comppg1;
    private javax.swing.JPanel comppg2;
    private javax.swing.JTable comptab;
    private javax.swing.JTextField deltusnm;
    private javax.swing.JComboBox<String> deptdrop;
    private javax.swing.JButton discfac;
    private javax.swing.JButton discstud;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lblmsg;
    private javax.swing.JLabel lblmsg1;
    private javax.swing.JLabel lblmsg2;
    private javax.swing.JComboBox<String> moddept;
    private javax.swing.JLabel msg;
    private javax.swing.JLabel msg2;
    private javax.swing.JTextField newusnm;
    private javax.swing.JLabel nm;
    private javax.swing.JLabel nt1;
    private javax.swing.JLabel nt10;
    private javax.swing.JLabel nt11;
    private javax.swing.JLabel nt12;
    private javax.swing.JLabel nt2;
    private javax.swing.JLabel nt3;
    private javax.swing.JLabel nt4;
    private javax.swing.JLabel nt5;
    private javax.swing.JLabel nt6;
    private javax.swing.JLabel nt7;
    private javax.swing.JLabel nt8;
    private javax.swing.JLabel nt9;
    private javax.swing.JLabel phnno;
    private javax.swing.JPasswordField ps1;
    private javax.swing.JPasswordField ps2;
    private javax.swing.JPasswordField psconf;
    private javax.swing.JPasswordField psnew;
    private javax.swing.JPasswordField psold;
    private javax.swing.JTable stat;
    private javax.swing.JTable tab1;
    private javax.swing.JTable tab2;
    private javax.swing.JLabel usnm;
    private javax.swing.JButton verifac;
    private javax.swing.JButton veristud;
    // End of variables declaration//GEN-END:variables
}
