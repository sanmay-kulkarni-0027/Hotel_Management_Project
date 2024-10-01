
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.Choice;
import java.sql.*;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddNewCustomer implements ActionListener{
    
    
      JTextField tfnum,tfname,tfcountry,tfdeposit;
      JButton submit,cancel;
      JRadioButton rb1,rb2;
      JComboBox cbid;
      Choice croomno;
      JLabel jtime;
      JFrame jframe=new JFrame();    
      AddNewCustomer()
      {
          
          JLabel jlabel=new JLabel("NEW  CUSTOMER  FORM");
          jlabel.setFont(new Font("Raleway",Font.BOLD,20));
          jlabel.setBounds(100,30,250,30);
          jframe.add(jlabel);
          
          JLabel id=new JLabel("ID");
          id.setFont(new Font("Raleway",Font.PLAIN,20));
          id.setBounds(50,90,200,30);
          jframe.add(id);
          
          String cid[]={"Aadhar Card","Passport","Driving","Voter-id","Ration Card"};
         
           cbid=new JComboBox(cid);
          cbid.setBounds(270,90,200,30);
          cbid.setBackground(Color.white);
          jframe.add(cbid);
          
          JLabel num=new JLabel("Number");
          num.setFont(new Font("Raleway",Font.PLAIN,20));
          num.setBounds(50,140,200,30);
          jframe.add(num);
          
         tfnum=new JTextField();
        tfnum.setBounds(270, 140, 200, 30);
        jframe.add(tfnum);
          
          JLabel name=new JLabel("Name");
          name.setFont(new Font("Raleway",Font.PLAIN,20));
          name.setBounds(50,190,200,30);
          jframe.add(name);
          
              
         tfname=new JTextField();
        tfname.setBounds(270, 190, 200, 30);
        jframe.add(tfname);
          
          
            JLabel gender=new JLabel("Gender:-");
       gender.setFont(new Font("Raleway",Font.PLAIN,20));
        gender.setBounds(50, 240,150, 30);
        jframe.add(gender);

        
        rb1=new JRadioButton("Male");
     rb1.setBounds(270, 240, 70, 30);
    rb1.setFont(new Font("Raleway",Font.BOLD,16));
     jframe.add(rb1);
     
     rb2=new JRadioButton("Female");
     rb2.setBounds(360, 240, 80, 30);
     rb2.setFont(new Font("Raleway",Font.BOLD,16));
     jframe.add(rb2);
     ButtonGroup bg=new ButtonGroup();
     bg.add(rb1);
     bg.add(rb2);
          
          JLabel country=new JLabel("Country");
          country.setFont(new Font("Raleway",Font.PLAIN,20));
          country.setBounds(50,290,200,30);
          jframe.add(country);
          
            tfcountry=new JTextField();
        tfcountry.setBounds(270, 290, 200, 30);
        jframe.add(tfcountry);
          
          JLabel roomno=new JLabel("Allocated Room Number");
          roomno.setFont(new Font("Raleway",Font.PLAIN,20));
          roomno.setBounds(50,340,230,30);
          jframe.add(roomno);
          
          croomno=new Choice();
         try{
             String query="select * from addroom where roomavg='Available'";
             Conn c=new Conn();
             ResultSet rs=c.s.executeQuery(query);
             while(rs.next())
             {
                 croomno.add(rs.getString("roomno"));
             }
         }catch(Exception e)
         {
             e.printStackTrace();
         }
         croomno.setBounds(300, 340, 170, 40);
         jframe.add(croomno);
          
         
        
          JLabel time=new JLabel("Chect-in Time");
          time.setFont(new Font("Raleway",Font.PLAIN,20));
          time.setBounds(50,390,230,30);
          jframe.add(time);
          
          Date date=new Date();
           jtime=new JLabel(""+date);
        //  jtime.setFont(new Font("Raleway",Font.PLAIN,20));
          jtime.setBounds(270,390,230,30);
          jframe.add(jtime);
          
          JLabel deposit=new JLabel("Deposit");
          deposit.setFont(new Font("Raleway",Font.PLAIN,20));
          deposit.setBounds(50,440,230,30);
          jframe.add(deposit);
          
             tfdeposit=new JTextField();
        tfdeposit.setBounds(270, 440, 200, 30);
        jframe.add(tfdeposit);
          
          submit=new JButton("Add Customer");
        submit.setBounds(50, 510, 150, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        jframe.add(submit);
        submit.addActionListener(this);
        
       cancel=new JButton("Cancel");
        cancel.setBounds(240, 510, 150, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        jframe.add(cancel);
        cancel.addActionListener(this);

        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/checkin.jpg"));
        Image i2=i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(520,50,400,500);
        jframe.add(image);
        
          
          jframe.setSize(1000,640);
          jframe.setLayout(null);
          jframe.setVisible(true);
          jframe.setLocation(300,80);
          
          
      }
      
      public void actionPerformed(ActionEvent ae){
          if(ae.getSource()==submit){
             String id=cbid.getSelectedItem().toString();
             String num=tfnum.getText();
             String name=tfname.getText();
             String gender=null;
             if(rb1.isSelected())
             {
                 gender=rb1.getText();
             }else if(rb2.isSelected())
             {
                 gender=rb2.getText();
             }
              String country=tfcountry.getText();
              String roomno=croomno.getSelectedItem();
              String time=jtime.getText();
              String deposit=tfdeposit.getText();
              try{
                 Conn c=new Conn();
                 String query="insert into customer_info values('"+id+"','"+num+"','"+name+"','"+gender+"','"+country+"','"+roomno+"','"+time+"','"+deposit+"')";
                 c.s.executeUpdate(query);
                 String query1="update addroom set roomavg='Occupied' where roomno='"+roomno+"'";
                 c.s.executeUpdate(query1);
                 JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
                //jframe.setVisible(false);
                  
              }catch(Exception e){
                        // e.printStackTrace();
                        JOptionPane.showMessageDialog(null,e);
                         } 
              
          }else if(ae.getSource()==cancel)
          {
              jframe.setVisible(false);
              new Reception();
          }
      }
      public static void main(String args[])
      {
          new AddNewCustomer();
      }
     
}
