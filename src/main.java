/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
 import java.sql.*;
 import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 import java.sql.DriverManager;
 import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.xmlbeans.SchemaProperty;

public class main extends javax.swing.JFrame
{
    //String username="";
    ArrayList<String> subarr=new ArrayList<String>();
    public main() 
    {    
        initComponents();
    }
    /*public main(String user)
    {
        username=user;
        initComponents();
        if(!(username.equalsIgnoreCase("Bharat")))
            mnuAdmin.setVisible(false);
    }*/
    public void CurrentDate()         
    { 
      Thread clock=new Thread()
    {
        int time;
        public void run()
        {
            Calendar cal1=new GregorianCalendar();
            int m = cal1.get(Calendar.MONTH)+1,y= cal1.get(Calendar.YEAR),d= cal1.get(Calendar.DAY_OF_MONTH),day=cal1.get(Calendar.DAY_OF_WEEK);
            for(;;)
            {
                Calendar cal = new GregorianCalendar();                
                int s= cal.get(Calendar.SECOND),h= cal.get(Calendar.HOUR_OF_DAY),min= cal.get(Calendar.MINUTE);
                date.setText("Date: "+d+"-"+m+"-"+y);            
                timee.setText("Time: "+h+":"+min+":"+s);
                f2date.setText("Date: "+d+"-"+m+"-"+y);
                f2time.setText("Time: "+h+":"+min+":"+s);
                if(h==13 && (min>=12 && min<15))
                      System.out.println("kbkhbk");
                try
                {
                    sleep(1000);
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    };
        clock.start();;
    }
    public void setdatatoanotherframe()
    {
        String subname = (String) cmbSubject.getSelectedItem();
        f2subject.setText(subname);
        String clname = (String) cmbClass.getSelectedItem();
        f2Class.setText(clname);
        String date1 = date.getText();
        f2date.setText(date1);
        String time = timee.getText();
        f2time.setText(time);
     }
    public void add_lecture()
    { 
        String cls=cmbClass.getSelectedItem().toString();
        String sub=cmbSubject.getSelectedItem().toString();
        try
        {
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
            Statement stmt2=con.createStatement();
            String add_lec="insert into "+cls+"_lectures values(sysdate(),'"+sub+"', 1) on duplicate key update lecture=lecture+1;";
            stmt2.executeUpdate(add_lec);
            stmt2.close();
            con.close();            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error In connection");
        }   
    }
    int i,rollno,lwr=0,upr=0;
    public void get_rollno()
    {
        // DefaultListModel lista= (DefaultListModel)absenties.getModel();
         DefaultListModel listp= (DefaultListModel)presenties.getModel();
         String cls=cmbClass.getSelectedItem().toString();   
         DefaultListModel listpname = (DefaultListModel)listNamePresent.getModel();
         String studname="";
        try
        {
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
            Statement stmt=con.createStatement();            
            String retrive_roll_no="select lowest_rollno,highest_rollno from total_strength where class='"+cls+"' ;";            
            ResultSet rs=stmt.executeQuery(retrive_roll_no);
            while(rs.next())
            {
                lwr=rs.getInt(1);
                upr=rs.getInt(2);      
            }
             for(i=lwr;i<=upr;i++)
            {
                    listp.addElement(i);
            }
            rs.close();
            stmt.close();
            Statement stmt1=con.createStatement();
            String retrive_name="select name from students where class = '"+cls+"' order by roll_no;";
            ResultSet rs1=stmt1.executeQuery(retrive_name);
            while(rs1.next())
            {
                studname=rs1.getString(1);
                listpname.addElement(studname);
            }
            rs1.close();
            stmt1.close();
            con.close();      
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error In connection");
        }
    }
  
    public void update_rollno_details()
    { 
        String cls =cmbclass2.getSelectedItem().toString();
        String ts = etstrength.getText();
        String lwr = esroll.getText();
        String upr = eeroll.getText();
        try
        {
           Class.forName("java.sql.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
           Statement stmt=con.createStatement();
           String update="update total_strength set total_students="+ts+" ,lowest_rollno="+lwr+" ,highest_rollno = "+upr+" where class='"+cls+"';"; 
           stmt.executeUpdate(update);
           stmt.close();
           con.close();
           JOptionPane.showMessageDialog(null,"Sucessfully done");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error In connection");
        }
    }
    public void add_student()
    {
        String cls=cmbclass.getSelectedItem().toString(),blood=(String)txtblood.getText();
        String name=txtname.getText();
        String address=txtaddress.getText();
        int count=0,select;
        try
        {
            int roll=Integer.parseInt(txtroll.getText());
            count++;
            long number=Long.parseLong(txtnumber.getText());
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
            Statement stmt=con.createStatement();
            String insert="insert into students values('"+roll+"','"+name+"','"+cls+"','"+address+"','"+number+"','"+blood+"');"; 
            select= JOptionPane.showConfirmDialog(null,"Do you want to insert these details?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(select==0) 
            {
                stmt.executeUpdate(insert);
                JOptionPane.showMessageDialog(null,"Sucessfully done");
                reset_stud_details();
            }
            stmt.close();
            con.close();
        }
        catch(NumberFormatException n)
        {
            JOptionPane.showMessageDialog(null,"Enter valid number");
            if(count==0)
            {
                txtroll.setText("");
                txtroll.requestFocus();
            }
            else
            {
                txtnumber.setText("");
                txtnumber.requestFocus();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    String semchange="";    
    public void getSubject(int i)
    {
        Calendar cal=new GregorianCalendar();
        int m=cal.get(Calendar.MONTH)+1;
        semchange="odd_sem_attendance";
        int j;
        if(m>6)
        {
            switch(i)
            {
                case 1:
                case 2:
                    subarr.removeAll(subarr);
                    for(j=0;j<7;j++)
                        subarr.add("CC_10"+(j+1));
                    subarr.addAll(Arrays.asList("EC","FC"));
                    break;
                case 3:
                case 4:
                    subarr.removeAll(subarr);
                    for(j=0;j<7;j++)
                        subarr.add("CC_20"+(j+1));
                    subarr.addAll(Arrays.asList("EC","FC"));
                    break;
                case 5:
                case 6:
                    subarr.removeAll(subarr);
                    for(j=0;j<6;j++)
        		subarr.add("CC_30"+(j+1));
                    subarr.addAll(Arrays.asList("EC","FC"));
                    break;
            }
        }
        else
        {
            semchange="even_sem_attendance";
            switch(i)
            {
                case 1:
                case 2:
                    subarr.removeAll(subarr);
                    subarr.addAll(Arrays.asList("CC_108","CC_109","CC_110","CC_111","CC_112","CC_113","CC_114","EC","FC"));
                    break;
                case 3:
                case 4:
                    subarr.removeAll(subarr);
                    subarr.addAll(Arrays.asList("CC_208","CC_209","CC_210","CC_211","CC_212","CC_213","CC_214","EC","FC"));
                    break;
                case 5:
                case 6:
                    subarr.removeAll(subarr);
                    subarr.addAll(Arrays.asList("CC_307","CC_308","CC_309","CC_310","CC_311","CC_312","EC","FC"));
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Select a value");
                    break;
            }
        }
    }
    
    public void insertAttendance()
    {
        int date=0;
        String cls = f2Class.getText()+"_attendance";
        String insertrow="";
        Calendar cal = new GregorianCalendar();        
        int d= cal.get(Calendar.DAY_OF_MONTH);   
        try
        {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/"+semchange+"","root","mash");
            Statement stmt1 = con.createStatement();
            String query = "select day(date) from "+cls+" where roll_no = "+upr+";";
            ResultSet rs = stmt1.executeQuery(query);
            while(rs.next())
            {
                date = Integer.parseInt(rs.getString(1));
            }
            rs.close();
            stmt1.close();
            if (!(date==d))
            {
                for(int i=lwr;i<=upr;i++)
                {                
                    Statement stmt2 = con.createStatement();
                    insertrow="insert into "+cls+" (date,roll_no) values(sysDate(),"+i+");";
                    stmt2.executeUpdate(insertrow);
                    stmt2.close();
                }
                con.close();  
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void updateAttendance()
    {
        int confirmValue=JOptionPane.showConfirmDialog(null, "Do you want to submit the attendance?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
        if(confirmValue==0)
        {
        String updateAttendance = "";
        String className = f2Class.getText()+"_attendance";
        String subjectName = f2subject.getText();
        ListModel model=absenties.getModel();  
        ListModel model2=presenties.getModel();
        int listsize = model.getSize();
        int listsize2 = model2.getSize();
        Object absentList[] = new Object[listsize];
        Object presentList[] = new Object[listsize2];
        for(int i=0;i<listsize;i++)
        {
            absentList[i]=model.getElementAt(i);
        }
         for(int i=0;i<listsize2;i++)
        {
            presentList[i]=model2.getElementAt(i);
        }
        try
        {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/"+semchange+"","root","mash");
            Statement stmt = con.createStatement();
            for(int i =0; i<listsize2;i++)
            {
             updateAttendance= "update "+className+" set "+subjectName+"=1 where roll_no ="+presentList[i]+" and date = date(sysdate()); ";
             stmt.executeUpdate(updateAttendance);
            }       
            stmt.close();
            Statement stmt2 = con.createStatement();
            for(int i =0; i<listsize;i++)
            {
             updateAttendance= "update "+className+" set "+subjectName+"=0 where roll_no ="+absentList[i]+" and date = date(sysdate()); ";
             stmt2.executeUpdate(updateAttendance);
            }
            JOptionPane.showMessageDialog(null, "Updated attendance successfully!");
            btnPrevious.setVisible(false);
            stmt2.close();
            con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        }   
    }
    int Roll_No=0;
    public void retrieve_details()
    {
        try
        {
            int rno=Integer.parseInt(utxtroll1.getText());
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
            Statement stmt = con.createStatement();
            String retrieve = "select * from students where roll_no = "+rno+";";
            ResultSet rs = stmt.executeQuery(retrieve);
            while(rs.next())
            {
                ucmbclass1.setSelectedItem(rs.getString(3));
                utxtname1.setText(rs.getString(2));
                utxtaddress1.setText(rs.getString(4));
                utxtnumber1.setText(rs.getString(5));
                utxtblood.setText(rs.getString(6));
                Roll_No=rs.getInt(1);
            }
            if(!(Roll_No==rno))
            {
                JOptionPane.showMessageDialog(null,"Please enter a valid roll number");
                utxtroll1.setText("");
                utxtroll1.requestFocus();
                utxtname1.setText("");
                utxtaddress1.setText("");
                utxtnumber1.setText("");
                utxtblood.setText("");
                ubtnstudupdate.setEnabled(false);
            }
            else
            {
                ucmbclass1.setEditable(true);
                utxtname1.setEditable(true);
                utxtnumber1.setEditable(true);
                utxtaddress1.setEditable(true);
                utxtblood.setEditable(true);
                ubtnstudupdate.setEnabled(true);
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(NumberFormatException n)
        {
            JOptionPane.showMessageDialog(null, "Enter a vaild roll number");
            utxtroll1.setText("");
            utxtroll1.requestFocus(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Cannot Retrieve!");
        }
    }
    
    public void update_student_details()
    {
        String name =(String)utxtname1.getText(), address=(String)utxtaddress1.getText(), className=(String)ucmbclass1.getSelectedItem(),blood=(String)utxtblood.getText();
        int rno;
        long phn;
        int count = 0;
        int confirm;
        try
        {
            rno=Integer.parseInt(utxtroll1.getText());
            count+=1;
            phn=Long.parseLong(utxtnumber1.getText());
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
            Statement stmt = con.createStatement();
            String update = "update students set roll_no = "+rno+", name = '"+name+"', class = '"+className+"', address = '"+address+"', phone = "+phn+",blood_group='"+blood+"' where roll_no = "+Roll_No+";";
            confirm=JOptionPane.showConfirmDialog(null, "Are you sure you want to update these details?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(confirm==0)
            {
                stmt.executeUpdate(update);
                JOptionPane.showMessageDialog(null, "Updated details successfully");
            }
            stmt.close();
            con.close();
            utxtroll1.setText("");
            utxtname1.setText("");
            utxtaddress1.setText("");
            utxtnumber1.setText("");
            ucmbclass1.setSelectedIndex(0);
        }
        catch(NumberFormatException n)
        {
            JOptionPane.showMessageDialog(null,"Please enter number");
            if(count==0)
            {
                utxtroll1.setText("");
                utxtroll1.requestFocus(true);
            }
            else
            {
                utxtnumber1.setText("");
                utxtnumber1.requestFocus(true);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Cannot Update!");
        }
    }
    String tname="";
    public void show_teacher_details()
    {       
        String t_name=utxttname.getText();      
	try
        {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
            Statement stmt = con.createStatement();
            String retrieve = "select * from  teacher_details where username= '"+t_name+"';";
            ResultSet rs = stmt.executeQuery(retrieve);
            while(rs.next())
            {
                tname=rs.getString(1);
                utxttemail.setText(rs.getString(3));
                utxttaddress.setText(rs.getString(4));
                utxttnumber.setText(rs.getString(5));                
                utxttblood.setText(rs.getString(6));           
            }
            if(!(tname.equalsIgnoreCase(t_name)))
            {
                JOptionPane.showMessageDialog(null,"Please enter a valid name");
                utxttname.setText("");
                utxttname.requestFocus();
                utxttaddress.setText("");
                utxttemail.setText("");
                utxttblood.setText("");
                utxttnumber.setText("");
                ubtntupdate.setEnabled(false);
                utxttname.requestFocus();
            }
            else
            {
                utxttemail.setEditable(true);
                utxttblood.setEditable(true);
                utxttnumber.setEditable(true);
                utxttaddress.setEditable(true);
                ubtntupdate.setEnabled(true);
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Cannot Retrieve!");
        }   
    }
    public void update_teacher_details()
    {
        String name =(String)utxttname.getText(),address=(String)utxttaddress.getText(),email = (String)utxttemail.getText(),blood =(String) utxttblood.getText();
        int confirm ;
        try
        {
            long phn=Long.parseLong(utxttnumber.getText());
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
            Statement stmt = con.createStatement();
            String update = "update teacher_details set username = '"+name+"' ,address = '"+address+"' , phone = "+phn+" ,blood_group = '"+blood+"' , email = '"+email+"' where username= '"+tname+"';";
            confirm=JOptionPane.showConfirmDialog(null, "Are you sure you want to update these details?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(confirm==0)
            {
                stmt.executeUpdate(update);
                JOptionPane.showMessageDialog(null, "Updated details successfully");
                utxttname.setText("");
                utxttaddress.setText("");
                utxttemail.setText("");
                utxttblood.setText("");
                utxttnumber.setText("");
            }
            stmt.close();
            con.close();            
        }
        catch(NumberFormatException n)
        {
            JOptionPane.showMessageDialog(null, "Enter valid phone number");
            utxttnumber.setText("");
            utxttnumber.requestFocus();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } 
    }
    
    public void generatesubwisereport()
    {
        int totallecture[] = new int[9] ;
        int i =0;
        getSubject(cmbSclass.getSelectedIndex()+1);
        String clsnamelec= cmbSclass.getSelectedItem().toString()+"_lectures";
        String gettotallec="";
        String clsnamereport= cmbSclass.getSelectedItem().toString()+"_report";
	String clsname= cmbSclass.getSelectedItem().toString()+"_attendance";
        String cls =  cmbSclass.getSelectedItem().toString();
        try
        {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
            Statement stmt = con.createStatement();
            gettotallec = "select sum(lecture) from "+clsnamelec+" group by subject;";
            ResultSet rs = stmt.executeQuery(gettotallec);
            while(rs.next())
            {
                totallecture[i]=rs.getInt(1);
                i++;
            }
            rs.close();
            stmt.close();
            con.close();         
	}	
        catch(Exception e)
	{
           JOptionPane.showMessageDialog(null,e.getMessage());
        }
        try
        {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/report","root","mash");
            Statement stmt = con.createStatement();
            gettotallec = "drop view "+clsnamereport+";";
            stmt.executeUpdate(gettotallec);
           
            stmt.close();
            con.close();        
	}
        catch(Exception e)
	{
           JOptionPane.showMessageDialog(null,e.getMessage());
        }
	try
        {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/report","root","mash");
            Statement stmt = con.createStatement();
            if(cmbSclass.getSelectedIndex()<=3)
            {
            gettotallec = "create view "+clsnamereport+" as "
                + "select roll_no,"
                + "sum("+subarr.get(0)+")/"+totallecture[0]+"*100 as "+subarr.get(0)+","
                + "sum("+subarr.get(1)+")/"+totallecture[1]+"*100 as "+subarr.get(1)+","
                + "sum("+subarr.get(2)+")/"+totallecture[2]+"*100 as "+subarr.get(2)+","
                + "sum("+subarr.get(3)+")/"+totallecture[3]+"*100 as "+subarr.get(3)+","
                + "sum("+subarr.get(4)+")/"+totallecture[4]+"*100 as "+subarr.get(4)+","
                + "sum("+subarr.get(5)+")/"+totallecture[5]+"*100 as "+subarr.get(5)+","
                + "sum("+subarr.get(6)+")/"+totallecture[6]+"*100 as "+subarr.get(6)+","
                + "sum("+subarr.get(7)+")/"+totallecture[7]+"*100 as "+subarr.get(7)+","
                + "sum("+subarr.get(8)+")/"+totallecture[8]+"*100 as "+subarr.get(8)+""
                + " from "+semchange+"."+clsname+" group by roll_no ;";
            stmt.executeUpdate(gettotallec);
            stmt.close();
            }
            else
            {
                gettotallec = "create view "+clsnamereport+" as "
                + "select roll_no,"
                + "sum("+subarr.get(0)+")/"+totallecture[0]+"*100 as "+subarr.get(0)+","
                + "sum("+subarr.get(1)+")/"+totallecture[1]+"*100 as "+subarr.get(1)+","
                + "sum("+subarr.get(2)+")/"+totallecture[2]+"*100 as "+subarr.get(2)+","
                + "sum("+subarr.get(3)+")/"+totallecture[3]+"*100 as "+subarr.get(3)+","
                + "sum("+subarr.get(4)+")/"+totallecture[4]+"*100 as "+subarr.get(4)+","
                + "sum("+subarr.get(5)+")/"+totallecture[5]+"*100 as "+subarr.get(5)+","
                + "sum("+subarr.get(6)+")/"+totallecture[6]+"*100 as "+subarr.get(6)+","
                + "sum("+subarr.get(7)+")/"+totallecture[7]+"*100 as "+subarr.get(7)+""
                + " from "+semchange+"."+clsname+" group by roll_no ;";
            stmt.executeUpdate(gettotallec);
            stmt.close();
            }
            con.close();
            JOptionPane.showMessageDialog(null,"Report Generated");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        } 
         try
        {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/report","root","mash");
            JasperDesign jd = JRXmlLoader.load("C:/Users/Sahil Chanchad/Desktop/Attendence/src/report format/"+cls+"_subjectwise.jrxml");
            String sql = "Select * from "+clsnamereport+"";
            JRDesignQuery newq = new JRDesignQuery();
            newq.setText(sql);
            jd.setQuery(newq);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
            JasperViewer.viewReport(jp);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } 
    }
    
    public void weeklyReport()
    {
        java.sql.Date fromDate=new java.sql.Date(fromDateChooser.getDate().getTime());
        java.sql.Date toDate=new java.sql.Date(toDateChooser.getDate().getTime());
        String clsname = cmbSclass1.getSelectedItem().toString();
        String clsnameweekly = cmbSclass1.getSelectedItem().toString()+ "_weeklyreport";
        int totalLecture=0,totalcol=0;
        String getColumncount = "select count(Column_name) from information_schema.columns where table_schema='report' and table_name='"+clsname+"_weeklyreport';";
        int week = Integer.parseInt(wkno.getText());
        String totalLec = "select sum(lecture) from admin."+clsname+"_lectures where date between '"+fromDate+"' and '"+toDate+"';";
        String addColumn="";
        try
        {
            Class.forName("java.sql.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/report","root","mash");
           /* Statement stmt2 = con.createStatement();
           ResultSet rs1 = stmt2.executeQuery(getColumncount);
            while(rs1.next())
            {
                totalcol=rs1.getInt(1);
            }
            stmt2.close();
            rs1.close();
           /* addColumn="alter table "+clsname+"_weeklyreport add week_"+totalcol+" int(3);";
            Statement stmt3=con.createStatement();
            stmt3.executeUpdate(addColumn);
            stmt3.close();*/
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(totalLec);
            while(rs.next())
            {
                totalLecture=rs.getInt(1);
            }
            rs.close();
            stmt.close();
            String studentAtt;
            if(cmbSclass1.getSelectedIndex()<=3)
            {
            if(totalcol==1)
                studentAtt = "insert into "+clsnameweekly+" select roll_no, "
                    + "(sum("+subarr.get(0)+")+sum("+subarr.get(1)+")+sum("+subarr.get(2)+")+sum("+subarr.get(3)+")+sum("+subarr.get(4)+")+sum("+subarr.get(5)+")+sum("+subarr.get(6)+")+sum("+subarr.get(7)+")+sum("+subarr.get(8)+"))/"+totalLecture+" *100 from "+semchange+"."+clsname+"_attendance group by roll_no;";

            else
            {
               studentAtt = "update "+clsnameweekly+",(select roll_no,((sum("+subarr.get(0)+")+sum("+subarr.get(1)+")+sum("+subarr.get(2)+")+sum("+subarr.get(3)+")+sum("+subarr.get(4)+")+sum("+subarr.get(5)+")+sum("+subarr.get(6)+")+sum("+subarr.get(7)+")+sum("+subarr.get(8)+"))/"+totalLecture+" *100) as trial from "+semchange+"."+clsname+"_attendance group by roll_no) as trials set wk"+week+" = trials.trial where "+clsnameweekly+".roll_no = trials.roll_no ;"; 
            }
            }
            else 
            {
               if(totalcol==1)
                studentAtt = "insert into "+clsnameweekly+" select roll_no, "
                    + "(sum("+subarr.get(0)+")+sum("+subarr.get(1)+")+sum("+subarr.get(2)+")+sum("+subarr.get(3)+")+sum("+subarr.get(4)+")+sum("+subarr.get(5)+")+sum("+subarr.get(6)+")+sum("+subarr.get(7)+"))/"+totalLecture+" *100 from "+semchange+"."+clsname+"_attendance group by roll_no;";

            else
            {
               studentAtt = "update "+clsnameweekly+",(select roll_no,((sum("+subarr.get(0)+")+sum("+subarr.get(1)+")+sum("+subarr.get(2)+")+sum("+subarr.get(3)+")+sum("+subarr.get(4)+")+sum("+subarr.get(5)+")+sum("+subarr.get(6)+")+sum("+subarr.get(7)+"))/"+totalLecture+" *100) as trial from "+semchange+"."+clsname+"_attendance group by roll_no) as trials set wk"+week+" = trials.trial where "+clsnameweekly+".roll_no = trials.roll_no ;"; 
            } 
            }
            
            Statement stmt1 = con.createStatement();
            System.out.println(studentAtt);
            stmt1.executeUpdate(studentAtt);
            stmt1.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Report Generated");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
          try
        {
            /*for(int k=1;k<totalcol-1;k++)
            {
            JRDesignField field = new JRDesignField();
            field.setName("week_"+k);
            field.setValueClass(java.lang.String.class);
            JasperDesign.addField(field);
            }*/
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/report","root","mash");
            JasperDesign jd = JRXmlLoader.load("C:/Users/Sahil Chanchad/Desktop/Attendence/src/report format/"+clsnameweekly+".jrxml");
            String sql = "Select * from "+clsnameweekly+"";
            JRDesignQuery newq = new JRDesignQuery();
            newq.setText(sql);
            jd.setQuery(newq);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
            JasperViewer.viewReport(jp);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } 
    }
    
    public void altercolumn()
    {
        String clsname = cmbSclass1.getSelectedItem().toString();
        int totalLecture=0,totalcol=0;
        String getColumncount = "select count(Column_name) from information_schema.columns where table_schema='report' and table_name='"+clsname+"_weeklyreport';";
        String dropColumn=""; 
        try
        {
            Class.forName("java.sql.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/report","root","mash");
            Statement stmt2 = con.createStatement();
            ResultSet rs1 = stmt2.executeQuery(getColumncount);
            while(rs1.next())
            {
                totalcol=rs1.getInt(1)-1;
            }
            stmt2.close();
            rs1.close();
            dropColumn="alter table "+clsname+"_weeklyreport drop column week_"+totalcol+";";
            Statement stmt3=con.createStatement();
            stmt3.executeUpdate(dropColumn);
            stmt3.close();
            con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public void retrivesdetails()
    { DefaultTableModel model =(DefaultTableModel)Stutable.getModel();
         try
        {            
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
            Statement stmt = con.createStatement();
            String retrieve = "select * from students;";
            ResultSet rs = stmt.executeQuery(retrieve);
            while(rs.next())
            {
            
            model.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6)} );
            }
           
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Cannot Retrieve!");
        }
    }
    public void retrivetdetails()
    {
         DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
         try
         {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
            Statement stmt = con.createStatement();
            String retrieve = "select * from teacher_details;";
            ResultSet rs = stmt.executeQuery(retrieve);
            while(rs.next())
            {
                model.addRow(new Object[] {rs.getString(1),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)});
            }
           
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        attendence = new javax.swing.JFrame();
        f2subject = new javax.swing.JLabel();
        f2date = new javax.swing.JLabel();
        f2Class = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        presenties = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        absenties = new javax.swing.JList();
        btnadd = new javax.swing.JButton();
        btnremove = new javax.swing.JButton();
        f2time = new javax.swing.JLabel();
        submitbtn = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listNamePresent = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        listNameAbsent = new javax.swing.JList();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        update_strength = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        etstrength = new javax.swing.JTextField();
        eeroll = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        esroll = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbclass2 = new javax.swing.JComboBox();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        add_students = new javax.swing.JFrame();
        lblclass = new javax.swing.JLabel();
        cmbclass = new javax.swing.JComboBox();
        lblname = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        lblroll = new javax.swing.JLabel();
        txtroll = new javax.swing.JTextField();
        lbladdress = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtnumber = new javax.swing.JTextField();
        btnsubmit = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        lblblood = new javax.swing.JLabel();
        txtblood = new javax.swing.JTextField();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        update_Student_details = new javax.swing.JFrame();
        jScrollPane6 = new javax.swing.JScrollPane();
        utxtaddress1 = new javax.swing.JTextArea();
        lblname1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        utxtnumber1 = new javax.swing.JTextField();
        utxtname1 = new javax.swing.JTextField();
        lblroll1 = new javax.swing.JLabel();
        lblclass1 = new javax.swing.JLabel();
        utxtroll1 = new javax.swing.JTextField();
        lbladdress1 = new javax.swing.JLabel();
        ucmbclass1 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        ubtnstudupdate = new javax.swing.JButton();
        lblstudblood = new javax.swing.JLabel();
        utxtblood = new javax.swing.JTextField();
        add_teacher = new javax.swing.JFrame();
        lbltname = new javax.swing.JLabel();
        txttname = new javax.swing.JTextField();
        lbltemail = new javax.swing.JLabel();
        txttemail = new javax.swing.JTextField();
        lbltaddress = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txttaddress = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txttphone = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txttblood = new javax.swing.JTextField();
        btntsubmit = new javax.swing.JButton();
        btntreset = new javax.swing.JButton();
        update_teacher = new javax.swing.JFrame();
        ulbltname = new javax.swing.JLabel();
        utxttname = new javax.swing.JTextField();
        utxttemail = new javax.swing.JTextField();
        ulbltemail = new javax.swing.JLabel();
        ulbltaddress = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        utxttaddress = new javax.swing.JTextArea();
        utxttnumber = new javax.swing.JTextField();
        ulbltphone = new javax.swing.JLabel();
        ulbltblood = new javax.swing.JLabel();
        utxttblood = new javax.swing.JTextField();
        ubtntedit = new javax.swing.JButton();
        ubtntupdate = new javax.swing.JButton();
        Subjectwise = new javax.swing.JFrame();
        cmbSclass = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Reportwise = new javax.swing.JFrame();
        generatereport = new javax.swing.JButton();
        cmbSclass1 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblTodate = new javax.swing.JLabel();
        fromDateChooser = new org.jdesktop.swingx.JXDatePicker();
        toDateChooser = new org.jdesktop.swingx.JXDatePicker();
        deleteColumn = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        wkno = new javax.swing.JTextField();
        Teacher_details = new javax.swing.JFrame();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Student_details = new javax.swing.JFrame();
        jScrollPane10 = new javax.swing.JScrollPane();
        Stutable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbClass = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbSubject = new javax.swing.JComboBox();
        btnProceed = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        timee = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        mnuAdmin = new javax.swing.JMenuBar();
        mnuAdd = new javax.swing.JMenu();
        mnuStudent = new javax.swing.JMenuItem();
        mnuTeacher = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenu();
        mnuStudentDetailsUpdate = new javax.swing.JMenuItem();
        mnuTeacherDetailsUpdate = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        attendence.setTitle("Attendance");
        attendence.setExtendedState(JFrame.MAXIMIZED_BOTH);
        attendence.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                attendenceWindowActivated(evt);
            }
        });

        f2subject.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        f2subject.setText("Subject ");

        f2date.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N

        f2Class.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        f2Class.setText("Class ");

        presenties.setModel(new DefaultListModel());
        presenties.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                presentiesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(presenties);

        absenties.setModel(new DefaultListModel());
        absenties.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                absentiesValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(absenties);

        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnremove.setText("Remove");
        btnremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoveActionPerformed(evt);
            }
        });

        f2time.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N

        submitbtn.setText("Submit");
        submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbtnActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        listNamePresent.setModel(new DefaultListModel());
        listNamePresent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listNamePresentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listNamePresent);

        listNameAbsent.setModel(new DefaultListModel());
        listNameAbsent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listNameAbsentMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listNameAbsent);

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel10.setText("Present Student List ");

        jLabel11.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel11.setText("Absent Student List");

        javax.swing.GroupLayout attendenceLayout = new javax.swing.GroupLayout(attendence.getContentPane());
        attendence.getContentPane().setLayout(attendenceLayout);
        attendenceLayout.setHorizontalGroup(
            attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attendenceLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(attendenceLayout.createSequentialGroup()
                        .addComponent(f2subject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(218, 218, 218))
                    .addGroup(attendenceLayout.createSequentialGroup()
                        .addComponent(f2Class, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(attendenceLayout.createSequentialGroup()
                        .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(attendenceLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                .addGap(33, 33, 33)
                                .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnremove, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10))
                        .addGap(37, 37, 37)
                        .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(attendenceLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(attendenceLayout.createSequentialGroup()
                        .addComponent(f2date, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(f2time, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        attendenceLayout.setVerticalGroup(
            attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, attendenceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(f2date, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f2time, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f2Class, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f2subject, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(12, 12, 12)
                .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(attendenceLayout.createSequentialGroup()
                        .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1))
                        .addGap(70, 70, 70))
                    .addGroup(attendenceLayout.createSequentialGroup()
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnremove, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );

        update_strength.setTitle("Update Strength");
        update_strength.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                update_strengthWindowActivated(evt);
            }
        });

        jLabel4.setText("Total_strength");

        jLabel6.setText("Ending roll_no");

        jLabel5.setText("Starting roll_no");

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Class");

        cmbclass2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FY_A", "FY_B", "SY_A", "SY_B", "TY_A", "TY_B" }));

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");

        jMenuItem3.setText("Add new student list");
        jMenu4.add(jMenuItem3);

        jMenuItem4.setText("Add total strength and roll_no ");
        jMenu4.add(jMenuItem4);

        jMenuItem9.setText("Update Strength");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar2.add(jMenu4);

        jMenu5.setText("GoTo");
        jMenuBar2.add(jMenu5);

        update_strength.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout update_strengthLayout = new javax.swing.GroupLayout(update_strength.getContentPane());
        update_strength.getContentPane().setLayout(update_strengthLayout);
        update_strengthLayout.setHorizontalGroup(
            update_strengthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(update_strengthLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(update_strengthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, update_strengthLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))
                    .addGroup(update_strengthLayout.createSequentialGroup()
                        .addGroup(update_strengthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(update_strengthLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(esroll, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(update_strengthLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbclass2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(update_strengthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(update_strengthLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(update_strengthLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(update_strengthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etstrength)
                            .addComponent(eeroll, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        update_strengthLayout.setVerticalGroup(
            update_strengthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, update_strengthLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(update_strengthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etstrength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbclass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(update_strengthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(esroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eeroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        add_students.setTitle("ADD Students");
        add_students.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                add_studentsWindowActivated(evt);
            }
        });

        lblclass.setText("Class :");

        cmbclass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FY_A", "FY_B", "SY_A", "SY_B", "TY_A", "TY_B" }));

        lblname.setText("Name :");

        lblroll.setText("Roll no :");

        lbladdress.setText("Address :");

        txtaddress.setColumns(20);
        txtaddress.setLineWrap(true);
        txtaddress.setRows(5);
        jScrollPane5.setViewportView(txtaddress);

        jLabel7.setText("Phone no :");

        btnsubmit.setText("Submit");
        btnsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubmitActionPerformed(evt);
            }
        });

        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        lblblood.setText("Blood group :");

        javax.swing.GroupLayout add_studentsLayout = new javax.swing.GroupLayout(add_students.getContentPane());
        add_students.getContentPane().setLayout(add_studentsLayout);
        add_studentsLayout.setHorizontalGroup(
            add_studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_studentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(add_studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(add_studentsLayout.createSequentialGroup()
                        .addGroup(add_studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(add_studentsLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(20, 20, 20)
                                .addComponent(txtnumber))
                            .addGroup(add_studentsLayout.createSequentialGroup()
                                .addGroup(add_studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblroll)
                                    .addComponent(lblname)
                                    .addComponent(lblclass, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbladdress))
                                .addGap(27, 27, 27)
                                .addGroup(add_studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtroll, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbclass, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                    .addComponent(txtname))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(add_studentsLayout.createSequentialGroup()
                        .addComponent(lblblood)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(add_studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(add_studentsLayout.createSequentialGroup()
                                .addComponent(txtblood, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 83, Short.MAX_VALUE))
                            .addGroup(add_studentsLayout.createSequentialGroup()
                                .addComponent(btnsubmit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(89, 89, 89))))
        );
        add_studentsLayout.setVerticalGroup(
            add_studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_studentsLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(add_studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblclass))
                .addGap(18, 18, 18)
                .addGroup(add_studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblroll))
                .addGap(18, 18, 18)
                .addGroup(add_studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblname)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(add_studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbladdress)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(add_studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(29, 29, 29)
                .addGroup(add_studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblblood)
                    .addComponent(txtblood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(add_studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem6.setText("jMenuItem6");

        update_Student_details.setTitle("Update Students details");
        update_Student_details.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                update_Student_detailsWindowActivated(evt);
            }
        });

        utxtaddress1.setEditable(false);
        utxtaddress1.setColumns(20);
        utxtaddress1.setLineWrap(true);
        utxtaddress1.setRows(5);
        jScrollPane6.setViewportView(utxtaddress1);

        lblname1.setText("Name :");

        jLabel8.setText("Phone no :");

        utxtnumber1.setEditable(false);

        utxtname1.setEditable(false);

        lblroll1.setText("Roll no :");

        lblclass1.setText("Class :");

        lbladdress1.setText("Address :");

        ucmbclass1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FY_A", "FY_B", "SY_A", "SY_B", "TY_A", "TY_B" }));

        jButton3.setText("Retrieve");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ubtnstudupdate.setText("Update");
        ubtnstudupdate.setEnabled(false);
        ubtnstudupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubtnstudupdateActionPerformed(evt);
            }
        });

        lblstudblood.setText("Blood group :");

        utxtblood.setEditable(false);

        javax.swing.GroupLayout update_Student_detailsLayout = new javax.swing.GroupLayout(update_Student_details.getContentPane());
        update_Student_details.getContentPane().setLayout(update_Student_detailsLayout);
        update_Student_detailsLayout.setHorizontalGroup(
            update_Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(update_Student_detailsLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(ubtnstudupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(update_Student_detailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(update_Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(update_Student_detailsLayout.createSequentialGroup()
                        .addComponent(lblstudblood)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(update_Student_detailsLayout.createSequentialGroup()
                        .addGroup(update_Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblroll1)
                            .addComponent(lblname1)
                            .addComponent(lblclass1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 38, Short.MAX_VALUE)
                        .addGroup(update_Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(utxtroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ucmbclass1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(utxtname1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(update_Student_detailsLayout.createSequentialGroup()
                        .addComponent(lbladdress1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(update_Student_detailsLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(utxtnumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, update_Student_detailsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(utxtblood, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        update_Student_detailsLayout.setVerticalGroup(
            update_Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(update_Student_detailsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(update_Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utxtroll1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblroll1))
                .addGap(18, 18, 18)
                .addGroup(update_Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ucmbclass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblclass1))
                .addGap(18, 18, 18)
                .addGroup(update_Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblname1)
                    .addComponent(utxtname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(update_Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbladdress1)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(update_Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(utxtnumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(update_Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblstudblood)
                    .addComponent(utxtblood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(update_Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(ubtnstudupdate))
                .addContainerGap())
        );

        add_teacher.setTitle("ADD teacher");
        add_teacher.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                add_teacherWindowActivated(evt);
            }
        });

        lbltname.setText("Name :");

        txttname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttnameActionPerformed(evt);
            }
        });

        lbltemail.setText("Email :");

        lbltaddress.setText("Address :");

        txttaddress.setColumns(20);
        txttaddress.setRows(5);
        jScrollPane7.setViewportView(txttaddress);

        jLabel9.setText("Phone no :");

        jLabel13.setText("Blood Group :");

        btntsubmit.setText("Submit");
        btntsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntsubmitActionPerformed(evt);
            }
        });

        btntreset.setText("Reset");
        btntreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntresetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout add_teacherLayout = new javax.swing.GroupLayout(add_teacher.getContentPane());
        add_teacher.getContentPane().setLayout(add_teacherLayout);
        add_teacherLayout.setHorizontalGroup(
            add_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_teacherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(add_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(add_teacherLayout.createSequentialGroup()
                        .addGroup(add_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltemail)
                            .addComponent(lbltname))
                        .addGap(41, 41, 41)
                        .addGroup(add_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttemail)
                            .addComponent(txttname)))
                    .addGroup(add_teacherLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txttphone))
                    .addGroup(add_teacherLayout.createSequentialGroup()
                        .addComponent(lbltaddress)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(add_teacherLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(add_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(add_teacherLayout.createSequentialGroup()
                                .addComponent(btntsubmit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btntreset)
                                .addGap(68, 68, 68))
                            .addComponent(txttblood, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        add_teacherLayout.setVerticalGroup(
            add_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_teacherLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(add_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltname)
                    .addComponent(txttname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(add_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltemail))
                .addGap(18, 18, 18)
                .addGroup(add_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltaddress)
                    .addGroup(add_teacherLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(add_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(18, 18, 18)
                .addGroup(add_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txttblood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(add_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntsubmit)
                    .addComponent(btntreset))
                .addContainerGap())
        );

        update_teacher.setTitle("update Teacher details");
        update_teacher.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                update_teacherWindowActivated(evt);
            }
        });

        ulbltname.setText("Name :");

        utxttemail.setEditable(false);

        ulbltemail.setText("Email :");

        ulbltaddress.setText("Address :");

        utxttaddress.setEditable(false);
        utxttaddress.setColumns(20);
        utxttaddress.setRows(5);
        jScrollPane8.setViewportView(utxttaddress);

        utxttnumber.setEditable(false);

        ulbltphone.setText("Phone no :");

        ulbltblood.setText("Blood Group :");

        utxttblood.setEditable(false);

        ubtntedit.setText("Retrieve");
        ubtntedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubtnteditActionPerformed(evt);
            }
        });

        ubtntupdate.setText("Update");
        ubtntupdate.setEnabled(false);
        ubtntupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubtntupdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout update_teacherLayout = new javax.swing.GroupLayout(update_teacher.getContentPane());
        update_teacher.getContentPane().setLayout(update_teacherLayout);
        update_teacherLayout.setHorizontalGroup(
            update_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(update_teacherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(update_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(update_teacherLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(ubtntedit)
                        .addGap(57, 57, 57)
                        .addComponent(ubtntupdate))
                    .addGroup(update_teacherLayout.createSequentialGroup()
                        .addComponent(ulbltblood)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(utxttblood, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(update_teacherLayout.createSequentialGroup()
                        .addGroup(update_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ulbltemail)
                            .addComponent(ulbltname)
                            .addComponent(ulbltaddress)
                            .addComponent(ulbltphone))
                        .addGap(21, 21, 21)
                        .addGroup(update_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(utxttnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(utxttname, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(utxttemail, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        update_teacherLayout.setVerticalGroup(
            update_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(update_teacherLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(update_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ulbltname)
                    .addComponent(utxttname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(update_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utxttemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ulbltemail))
                .addGap(18, 18, 18)
                .addGroup(update_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ulbltaddress)
                    .addGroup(update_teacherLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(update_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(utxttnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ulbltphone))))
                .addGap(18, 18, 18)
                .addGroup(update_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ulbltblood)
                    .addComponent(utxttblood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(update_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubtntedit)
                    .addComponent(ubtntupdate))
                .addContainerGap())
        );

        Subjectwise.setTitle("Subject wise Report");
        Subjectwise.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                SubjectwiseWindowActivated(evt);
            }
        });

        cmbSclass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "fy_a", "fy_b", "sy_a", "sy_b", "ty_a", "ty_b" }));

        jLabel14.setText("Class :");

        jButton1.setText("Generate report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SubjectwiseLayout = new javax.swing.GroupLayout(Subjectwise.getContentPane());
        Subjectwise.getContentPane().setLayout(SubjectwiseLayout);
        SubjectwiseLayout.setHorizontalGroup(
            SubjectwiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubjectwiseLayout.createSequentialGroup()
                .addGroup(SubjectwiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SubjectwiseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSclass, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SubjectwiseLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton1)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        SubjectwiseLayout.setVerticalGroup(
            SubjectwiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubjectwiseLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(SubjectwiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmbSclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        Reportwise.setTitle("Week wise Report");
        Reportwise.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                ReportwiseWindowActivated(evt);
            }
        });

        generatereport.setText("Generate report");
        generatereport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatereportActionPerformed(evt);
            }
        });

        cmbSclass1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "fy_a", "fy_b", "sy_a", "sy_b", "ty_a", "ty_b" }));
        cmbSclass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSclass1ActionPerformed(evt);
            }
        });

        jLabel15.setText("Class :");

        jLabel16.setText("From Date :");

        lblTodate.setText("To Date :");

        deleteColumn.setText("Edit date");
        deleteColumn.setEnabled(false);
        deleteColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteColumnActionPerformed(evt);
            }
        });

        jLabel17.setText("wEEK Num.");

        javax.swing.GroupLayout ReportwiseLayout = new javax.swing.GroupLayout(Reportwise.getContentPane());
        Reportwise.getContentPane().setLayout(ReportwiseLayout);
        ReportwiseLayout.setHorizontalGroup(
            ReportwiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportwiseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ReportwiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ReportwiseLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(wkno))
                    .addGroup(ReportwiseLayout.createSequentialGroup()
                        .addGroup(ReportwiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(lblTodate)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(ReportwiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbSclass1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fromDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(generatereport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        ReportwiseLayout.setVerticalGroup(
            ReportwiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportwiseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ReportwiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cmbSclass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ReportwiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ReportwiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTodate)
                    .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ReportwiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(wkno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(generatereport)
                .addGap(14, 14, 14)
                .addComponent(deleteColumn)
                .addGap(46, 46, 46))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email", "Address", "phone", "Blood_group"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(jTable1);

        javax.swing.GroupLayout Teacher_detailsLayout = new javax.swing.GroupLayout(Teacher_details.getContentPane());
        Teacher_details.getContentPane().setLayout(Teacher_detailsLayout);
        Teacher_detailsLayout.setHorizontalGroup(
            Teacher_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Teacher_detailsLayout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Teacher_detailsLayout.setVerticalGroup(
            Teacher_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Teacher_detailsLayout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Stutable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Roll_no", "Name", "Class", "Address", "Phone", "Blood_Group"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane10.setViewportView(Stutable);

        javax.swing.GroupLayout Student_detailsLayout = new javax.swing.GroupLayout(Student_details.getContentPane());
        Student_details.getContentPane().setLayout(Student_detailsLayout);
        Student_detailsLayout.setHorizontalGroup(
            Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Student_detailsLayout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Student_detailsLayout.setVerticalGroup(
            Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main");
        setMinimumSize(new java.awt.Dimension(299, 295));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Class");

        cmbClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "fy_a", "fy_b", "sy_a", "sy_b", "ty_a", "ty_b" }));
        cmbClass.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbClass.setNextFocusableComponent(cmbSubject);
        cmbClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClassActionPerformed(evt);
            }
        });

        jLabel2.setText("Subject");

        cmbSubject.setNextFocusableComponent(btnProceed);
        cmbSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSubjectActionPerformed(evt);
            }
        });

        btnProceed.setText("Proceed");
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });

        mnuAdd.setText("Add");

        mnuStudent.setText("Student Details");
        mnuStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuStudentActionPerformed(evt);
            }
        });
        mnuAdd.add(mnuStudent);

        mnuTeacher.setText("Teacher Details");
        mnuTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTeacherActionPerformed(evt);
            }
        });
        mnuAdd.add(mnuTeacher);

        mnuAdmin.add(mnuAdd);

        mnuEdit.setText("Edit");
        mnuEdit.setIconTextGap(15);

        mnuStudentDetailsUpdate.setText("Update Student Details");
        mnuStudentDetailsUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuStudentDetailsUpdateActionPerformed(evt);
            }
        });
        mnuEdit.add(mnuStudentDetailsUpdate);

        mnuTeacherDetailsUpdate.setText("Update Teacher Details");
        mnuTeacherDetailsUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTeacherDetailsUpdateActionPerformed(evt);
            }
        });
        mnuEdit.add(mnuTeacherDetailsUpdate);

        mnuAdmin.add(mnuEdit);

        jMenu2.setText("Report");
        jMenu2.setIconTextGap(10);

        jMenuItem7.setText("Subject wise");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Week wise ");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        mnuAdmin.add(jMenu2);

        jMenu6.setText("View ");

        jMenuItem10.setText("View Student details");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuItem11.setText("View Teacher details");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        mnuAdmin.add(jMenu6);

        setJMenuBar(mnuAdmin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbClass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel12))
                            .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timee, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(timee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addComponent(btnProceed)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClassActionPerformed
        getSubject(cmbClass.getSelectedIndex());
        cmbSubject.setModel(new DefaultComboBoxModel(subarr.toArray()));
    }//GEN-LAST:event_cmbClassActionPerformed

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
            if(cmbClass.getSelectedIndex()==-1 || cmbClass.getSelectedIndex()==0 )
            {
                JOptionPane.showMessageDialog(null,"SELECT CLASS");
            }
            else if(cmbClass.getSelectedIndex()>0  )
            {
                setdatatoanotherframe();
                attendence.setVisible(true);            
                get_rollno();
                insertAttendance();
                dispose();
             }
            else
             {
                JOptionPane.showMessageDialog(null,"SELECT CLASS & Subject");
             } 
    }//GEN-LAST:event_btnProceedActionPerformed

    private void cmbSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSubjectActionPerformed
        setdatatoanotherframe();
    }//GEN-LAST:event_cmbSubjectActionPerformed

    private void presentiesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_presentiesValueChanged
        listNamePresent.setSelectedIndices(presenties.getSelectedIndices());
    }//GEN-LAST:event_presentiesValueChanged

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        DefaultListModel lista= (DefaultListModel)absenties.getModel();
        DefaultListModel listp= (DefaultListModel)presenties.getModel();
        Object absentList[]=presenties.getSelectedValues();
        DefaultListModel listaname= (DefaultListModel)listNameAbsent.getModel();
        DefaultListModel listpname= (DefaultListModel)listNamePresent.getModel();
        Object absentListName[]=listNamePresent.getSelectedValues();
        int arrLength = absentList.length;
        for(int i=0;i<arrLength;i++)
        {
            lista.addElement(absentList[i]);
            listp.removeElement(absentList[i]);
            listaname.addElement(absentListName[i]);
            listpname.removeElement(absentListName[i]);
        }                
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoveActionPerformed
        DefaultListModel listp=(DefaultListModel)presenties.getModel();
        DefaultListModel lista=(DefaultListModel)absenties.getModel();
        Object presentList[]=absenties.getSelectedValues();
        DefaultListModel listaname= (DefaultListModel)listNameAbsent.getModel();
        DefaultListModel listpname= (DefaultListModel)listNamePresent.getModel();
        Object presentListName[]=listNameAbsent.getSelectedValues();
        int arrLength = presentList.length;
        for(int i=0;i<arrLength;i++)
        {
            lista.removeElement(presentList[i]);
            listp.addElement(presentList[i]);
            listaname.removeElement(presentListName[i]);
            listpname.addElement(presentListName[i]);
        }     
    }//GEN-LAST:event_btnremoveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int i=0;
        i = JOptionPane.showConfirmDialog(null,"Do you want to update the details");
        if(i==JOptionPane.YES_OPTION)
        {
            update_rollno_details();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void submitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbtnActionPerformed
        add_lecture();
        updateAttendance();
    }//GEN-LAST:event_submitbtnActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        CurrentDate();
    }//GEN-LAST:event_formWindowActivated

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        DefaultListModel lista= (DefaultListModel)absenties.getModel();
        DefaultListModel listp= (DefaultListModel)presenties.getModel();
        lista.removeAllElements();
        listp.removeAllElements();
        new main().setVisible(true);
        attendence.dispose();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void absentiesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_absentiesValueChanged
        listNameAbsent.setSelectedIndices(absenties.getSelectedIndices());
    }//GEN-LAST:event_absentiesValueChanged

    private void listNamePresentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listNamePresentMouseClicked
        presenties.setSelectedIndices(listNamePresent.getSelectedIndices());
    }//GEN-LAST:event_listNamePresentMouseClicked

    private void listNameAbsentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listNameAbsentMouseClicked
        absenties.setSelectedIndices(listNameAbsent.getSelectedIndices());
    }//GEN-LAST:event_listNameAbsentMouseClicked

    private void mnuStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuStudentActionPerformed
        add_students.setVisible(true);
    }//GEN-LAST:event_mnuStudentActionPerformed

    private void btnsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubmitActionPerformed
       add_student();
    }//GEN-LAST:event_btnsubmitActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
          reset_stud_details();
    }//GEN-LAST:event_btnresetActionPerformed

    private void mnuStudentDetailsUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuStudentDetailsUpdateActionPerformed
        update_Student_details.setVisible(true);
    }//GEN-LAST:event_mnuStudentDetailsUpdateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        retrieve_details();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ubtnstudupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubtnstudupdateActionPerformed
        update_student_details();
    }//GEN-LAST:event_ubtnstudupdateActionPerformed

    private void btntsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntsubmitActionPerformed
        add_teacher();
    }//GEN-LAST:event_btntsubmitActionPerformed

    private void mnuTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTeacherActionPerformed
        add_teacher.setVisible(true);
    }//GEN-LAST:event_mnuTeacherActionPerformed

    private void ubtnteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubtnteditActionPerformed
        if(utxttname.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter the name");
        }
        else
        {
            show_teacher_details();
        }
    }//GEN-LAST:event_ubtnteditActionPerformed

    private void mnuTeacherDetailsUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTeacherDetailsUpdateActionPerformed
        update_teacher.setVisible(true);
    }//GEN-LAST:event_mnuTeacherDetailsUpdateActionPerformed

    private void ubtntupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubtntupdateActionPerformed
            update_teacher_details();
    }//GEN-LAST:event_ubtntupdateActionPerformed

    private void update_strengthWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_update_strengthWindowActivated
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        update_strength.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }//GEN-LAST:event_update_strengthWindowActivated

    private void add_studentsWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_add_studentsWindowActivated
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        add_students.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }//GEN-LAST:event_add_studentsWindowActivated

    private void update_Student_detailsWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_update_Student_detailsWindowActivated
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        update_Student_details.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }//GEN-LAST:event_update_Student_detailsWindowActivated

    private void add_teacherWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_add_teacherWindowActivated
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        add_teacher.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }//GEN-LAST:event_add_teacherWindowActivated

    private void update_teacherWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_update_teacherWindowActivated
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        update_teacher.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }//GEN-LAST:event_update_teacherWindowActivated

    private void btntresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntresetActionPerformed
        txttname.setText("");
        txttaddress.setText("");
        txttemail.setText("");
        txttblood.setText("");
        txttphone.setText("");
    }//GEN-LAST:event_btntresetActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Subjectwise.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void attendenceWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_attendenceWindowActivated
        attendence.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }//GEN-LAST:event_attendenceWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        generatesubwisereport();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Reportwise.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void SubjectwiseWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_SubjectwiseWindowActivated
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Subjectwise.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }//GEN-LAST:event_SubjectwiseWindowActivated

    private void ReportwiseWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ReportwiseWindowActivated
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Reportwise.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }//GEN-LAST:event_ReportwiseWindowActivated

    private void generatereportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatereportActionPerformed
        getSubject(cmbSclass1.getSelectedIndex()+1);
        weeklyReport();
        generatereport.setEnabled(false);
        fromDateChooser.setEnabled(false);
        toDateChooser.setEnabled(false);
        deleteColumn.setEnabled(true);
    }//GEN-LAST:event_generatereportActionPerformed

    private void deleteColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteColumnActionPerformed
        altercolumn();
        fromDateChooser.setEnabled(true);
        toDateChooser.setEnabled(true);
        generatereport.setEnabled(true);
    }//GEN-LAST:event_deleteColumnActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        update_strength.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void cmbSclass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSclass1ActionPerformed
        // TODO add your handling code here:
         fromDateChooser.setEnabled(true);
        toDateChooser.setEnabled(true);
        generatereport.setEnabled(true);
    }//GEN-LAST:event_cmbSclass1ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
       retrivetdetails();
        Teacher_details.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
       retrivesdetails();
        Student_details.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void txttnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttnameActionPerformed

    public void add_teacher()
    {
        String name=(String)txttname.getText(),email=(String)txttemail.getText(),address=(String)txttaddress.getText(),blood=(String)txttblood.getText();
        try
        {
            int phone=Integer.parseInt(txttphone.getText());
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
            Statement stmt = con.createStatement();
            String insert="insert into teacher_details values('"+name+"',DEFAULT,'"+email+"','"+address+"','"+phone+"','"+blood+"');";
            int select = JOptionPane.showConfirmDialog(null, "Do you want to insert the details?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(select == 0)
            {
                stmt.executeUpdate(insert);
                JOptionPane.showMessageDialog(null,"Record inserted");
                reset_teacher_details();
            }
        }
        catch(NumberFormatException n)
        {
            JOptionPane.showMessageDialog(null, "Enter valid number");
            txttphone.requestFocus();
            txttphone.setText("");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
     }
    
    public void reset_teacher_details()
    {
        txttname.setText("");
        txttaddress.setText("");
        txttblood.setText("");
        txttemail.setText("");
        txttphone.setText("");
    }
    
    public void reset_stud_details()
    {
        txtaddress.setText("");
        txtname.setText("");
        txtroll.setText("");
        txtnumber.setText("");
        txtblood.setText("");
        cmbclass.setSelectedIndex(0);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame Reportwise;
    private javax.swing.JFrame Student_details;
    private javax.swing.JTable Stutable;
    private javax.swing.JFrame Subjectwise;
    private javax.swing.JFrame Teacher_details;
    private javax.swing.JList absenties;
    private javax.swing.JFrame add_students;
    private javax.swing.JFrame add_teacher;
    private javax.swing.JFrame attendence;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnProceed;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnremove;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsubmit;
    private javax.swing.JButton btntreset;
    private javax.swing.JButton btntsubmit;
    private javax.swing.JComboBox cmbClass;
    private javax.swing.JComboBox cmbSclass;
    private javax.swing.JComboBox cmbSclass1;
    private javax.swing.JComboBox cmbSubject;
    private javax.swing.JComboBox cmbclass;
    private javax.swing.JComboBox cmbclass2;
    private javax.swing.JLabel date;
    private javax.swing.JButton deleteColumn;
    private javax.swing.JTextField eeroll;
    private javax.swing.JTextField esroll;
    private javax.swing.JTextField etstrength;
    private javax.swing.JLabel f2Class;
    private javax.swing.JLabel f2date;
    private javax.swing.JLabel f2subject;
    private javax.swing.JLabel f2time;
    private org.jdesktop.swingx.JXDatePicker fromDateChooser;
    private javax.swing.JButton generatereport;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTodate;
    private javax.swing.JLabel lbladdress;
    private javax.swing.JLabel lbladdress1;
    private javax.swing.JLabel lblblood;
    private javax.swing.JLabel lblclass;
    private javax.swing.JLabel lblclass1;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblname1;
    private javax.swing.JLabel lblroll;
    private javax.swing.JLabel lblroll1;
    private javax.swing.JLabel lblstudblood;
    private javax.swing.JLabel lbltaddress;
    private javax.swing.JLabel lbltemail;
    private javax.swing.JLabel lbltname;
    private javax.swing.JList listNameAbsent;
    private javax.swing.JList listNamePresent;
    private javax.swing.JMenu mnuAdd;
    public javax.swing.JMenuBar mnuAdmin;
    private javax.swing.JMenu mnuEdit;
    private javax.swing.JMenuItem mnuStudent;
    private javax.swing.JMenuItem mnuStudentDetailsUpdate;
    private javax.swing.JMenuItem mnuTeacher;
    private javax.swing.JMenuItem mnuTeacherDetailsUpdate;
    private javax.swing.JList presenties;
    private javax.swing.JButton submitbtn;
    private javax.swing.JLabel timee;
    private org.jdesktop.swingx.JXDatePicker toDateChooser;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtblood;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnumber;
    private javax.swing.JTextField txtroll;
    private javax.swing.JTextArea txttaddress;
    private javax.swing.JTextField txttblood;
    private javax.swing.JTextField txttemail;
    private javax.swing.JTextField txttname;
    private javax.swing.JTextField txttphone;
    private javax.swing.JButton ubtnstudupdate;
    private javax.swing.JButton ubtntedit;
    private javax.swing.JButton ubtntupdate;
    private javax.swing.JComboBox ucmbclass1;
    private javax.swing.JLabel ulbltaddress;
    private javax.swing.JLabel ulbltblood;
    private javax.swing.JLabel ulbltemail;
    private javax.swing.JLabel ulbltname;
    private javax.swing.JLabel ulbltphone;
    private javax.swing.JFrame update_Student_details;
    private javax.swing.JFrame update_strength;
    private javax.swing.JFrame update_teacher;
    private javax.swing.JTextArea utxtaddress1;
    private javax.swing.JTextField utxtblood;
    private javax.swing.JTextField utxtname1;
    private javax.swing.JTextField utxtnumber1;
    private javax.swing.JTextField utxtroll1;
    private javax.swing.JTextArea utxttaddress;
    private javax.swing.JTextField utxttblood;
    private javax.swing.JTextField utxttemail;
    private javax.swing.JTextField utxttname;
    private javax.swing.JTextField utxttnumber;
    private javax.swing.JTextField wkno;
    // End of variables declaration//GEN-END:variables
}

