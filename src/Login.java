/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.mail.*;
import java.util.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.WindowConstants;
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newpassFrame = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        txtnewPass = new javax.swing.JPasswordField();
        txtconfirmpass = new javax.swing.JPasswordField();
        passOKbtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        mailPassword = new javax.swing.JFrame();
        lblUser = new javax.swing.JLabel();
        txtUserforgot = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        newpassFrame.setTitle("Change password");
        newpassFrame.setResizable(false);
        newpassFrame.setSize(new java.awt.Dimension(335, 285));
        newpassFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                newpassFrameWindowActivated(evt);
            }
        });

        jLabel3.setText("Username :");

        jLabel4.setText("New Password :");

        jLabel5.setText("Confirm Password :");

        txtusername.setEditable(false);
        txtusername.setText("hash");

        passOKbtn.setText("OK");
        passOKbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passOKbtnActionPerformed(evt);
            }
        });

        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newpassFrameLayout = new javax.swing.GroupLayout(newpassFrame.getContentPane());
        newpassFrame.getContentPane().setLayout(newpassFrameLayout);
        newpassFrameLayout.setHorizontalGroup(
            newpassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newpassFrameLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(newpassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passOKbtn)
                    .addGroup(newpassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGroup(newpassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newpassFrameLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(newpassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtusername, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(txtnewPass)
                            .addComponent(txtconfirmpass)))
                    .addGroup(newpassFrameLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton3)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        newpassFrameLayout.setVerticalGroup(
            newpassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newpassFrameLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(newpassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newpassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newpassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtconfirmpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(newpassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passOKbtn)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        mailPassword.setResizable(false);
        mailPassword.setSize(new java.awt.Dimension(400, 300));
        mailPassword.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                mailPasswordWindowActivated(evt);
            }
        });

        lblUser.setText("Username");

        lblEmail.setText("Email address");

        txtEmail.setEnabled(false);

        btnSend.setText("Send Mail");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mailPasswordLayout = new javax.swing.GroupLayout(mailPassword.getContentPane());
        mailPassword.getContentPane().setLayout(mailPasswordLayout);
        mailPasswordLayout.setHorizontalGroup(
            mailPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mailPasswordLayout.createSequentialGroup()
                .addGroup(mailPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mailPasswordLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(mailPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail))
                        .addGap(44, 44, 44)
                        .addGroup(mailPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserforgot)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
                    .addGroup(mailPasswordLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        mailPasswordLayout.setVerticalGroup(
            mailPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mailPasswordLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(mailPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserforgot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser))
                .addGap(30, 30, 30)
                .addGroup(mailPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(btnSend)
                .addGap(36, 36, 36))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setMinimumSize(new java.awt.Dimension(304, 241));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Username :");

        jLabel2.setText("Password :");

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Forgot Password");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtuser, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .addComponent(txtpass))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void login()
    {
        String getpass="",passquery,user=txtuser.getText(), getuser=""; 
        String pass=new String(txtpass.getPassword());
        try
        {
            
           Class.forName("java.sql.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
           Statement stmt1=con.createStatement();
           passquery="select username,password from teacher_details where username='"+user+"';";
           ResultSet rs=stmt1.executeQuery(passquery);
           while(rs.next())
           { 
               getuser=rs.getString(1);
               getpass=rs.getString(2);
           }
           rs.close();
           stmt1.close();
           con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        if(getuser.equals("") || getpass.equals(""))
        {
           JOptionPane.showMessageDialog(null, "Enter User and password!");
        }
        else  if(!(getuser.equals(user)))
        {
            JOptionPane.showMessageDialog(null, "User does not exist");
            txtuser.setText("");
            txtpass.setText("");
        }
        else
        {
            if(getpass.equals("1234") && pass.equals("1234") )
            {
                    dispose();
                    newpassFrame.setVisible(true);
            }                
            else
            {
                if(pass.equals(getpass) && user.equals(getuser))
                   { 
                    //new main(txtuser.getText()).setVisible(true);
                    main mainObj = new main();
                    if(!user.equalsIgnoreCase("Bharat"))
                        mainObj.mnuAdmin.setVisible(false);
                    mainObj.setVisible(true);
                    dispose();
                   }            
                else
                {
                    JOptionPane.showMessageDialog(null,"Enter correct password and username");
                    txtpass.setText("");
                    txtuser.setText("");            
                }
            }  
        }
    }
    
    public void passwordchange()
    {
        String username=txtusername.getText(), newpass=new String(txtnewPass.getPassword()), confirmpass=new String(txtconfirmpass.getPassword());
        String setPasswordQuery="" ;
        if(newpass.equals(confirmpass))
        {
            try
            {
                Class.forName("java.sql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
                Statement stmt1=con.createStatement();                
                setPasswordQuery="update teacher_details set password ='"+newpass+"' where username='"+username+"';";
                stmt1.executeUpdate(setPasswordQuery);
                JOptionPane.showMessageDialog(null, "Password changed");
                stmt1.close();
                con.close();
                newpassFrame.dispose();
                new Login().setVisible(true);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Password can not be changed");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Passwords do not match");
        }
    }
    
    public void forgotpass()
    {
         if (txtuser.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Please enter username");
        else
        {
            String getemail="",emailquery,user=txtuser.getText();
            try
            {
                Class.forName("java.sql.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
                Statement stmt1=con.createStatement();
                emailquery="select email from teacher_details where username='"+user+"';";
                ResultSet rs=stmt1.executeQuery(emailquery);
                while(rs.next())
                {    
                    getemail=rs.getString(1);
                }
                txtUserforgot.setText(txtuser.getText());
                txtEmail.setText(getemail);
                rs.close();
                stmt1.close();
                con.close();
                if(getemail.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter a valid username");
                    txtuser.setText("");
                }
                else
                    mailPassword.setVisible(true);
            }   
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error in Connection");
            }
        }
    }
    
    public void sendemail()
    {
        String getpass="",emailquery,user=txtuser.getText();
            JOptionPane.showMessageDialog(null,"Please wait it may take some time!");
            try
            {
                Class.forName("java.sql.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","mash");
                Statement stmt1=con.createStatement();
                emailquery="select password from teacher_details where username='"+user+"';";
                ResultSet rs=stmt1.executeQuery(emailquery);
                while(rs.next())
                {    
                    getpass=rs.getString(1);
                }
            }   
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error in Connection");
            }
            Properties props = new Properties();
            props.put("mail.smtp.host","smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port","465");
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.port","465");
            Session s = Session.getDefaultInstance(props,
		new javax.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
                            return new PasswordAuthentication("mash62774@gmail.com","mash42774");
			} 
		}
            );
            String mailcontent="Hi "+txtUserforgot.getText()+",\n\nYour password is: "+getpass+".\n\nThank you.";
            try 
            {
                Message msg = new MimeMessage(s);
        	msg.setFrom(new InternetAddress("mash62774@gmail.com"));
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(txtEmail.getText()));
                msg.setSubject("Password Request");
        	msg.setText(mailcontent);
        	Transport.send(msg);
                JOptionPane.showMessageDialog(null,"Mail sent");
                mailPassword.dispose();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void passOKbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passOKbtnActionPerformed
            passwordchange();
    }//GEN-LAST:event_passOKbtnActionPerformed

    private void newpassFrameWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_newpassFrameWindowActivated
          Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
          newpassFrame.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
          txtusername.setText(txtuser.getText());
    }//GEN-LAST:event_newpassFrameWindowActivated

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtnewPass.setText("");
        txtconfirmpass.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        newpassFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }//GEN-LAST:event_formWindowActivated

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        forgotpass();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        sendemail();
    }//GEN-LAST:event_btnSendActionPerformed

    private void mailPasswordWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_mailPasswordWindowActivated
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mailPassword.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }//GEN-LAST:event_mailPasswordWindowActivated

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblUser;
    private javax.swing.JFrame mailPassword;
    private javax.swing.JFrame newpassFrame;
    private javax.swing.JButton passOKbtn;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtUserforgot;
    private javax.swing.JPasswordField txtconfirmpass;
    private javax.swing.JPasswordField txtnewPass;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
