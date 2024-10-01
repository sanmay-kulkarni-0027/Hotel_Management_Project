
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CheckOut implements ActionListener {
    
    JFrame jframe=new JFrame();
    JTextField tfid,tftime;
    Choice roomnum;
    JButton cancel,search,cout;
    CheckOut(){
        
        JLabel jlabel=new JLabel("CheckOut");
        jlabel.setFont(new Font("Raleway",Font.BOLD,26));
        jlabel.setForeground(Color.red);
        jlabel.setBounds(180,40,300,30);
        jframe.add(jlabel);
        
        
        JLabel roomno=new JLabel("Room number");
        roomno.setFont(new Font("Raleway",Font.PLAIN,20));
        roomno.setBounds(50, 100, 200, 30);
        jframe.add(roomno);
        
        roomnum=new Choice();
        roomnum.setBounds(280,105,200,30);
        jframe.add(roomnum);
        
        try{
            String q="select * from customer_info";
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery(q);
            while(rs.next()){
                roomnum.add(rs.getString("alloroom"));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JLabel cid=new JLabel("Customer Name");
        cid.setFont(new Font("Raleway",Font.PLAIN,20));
        cid.setBounds(50, 165, 200, 30);
        jframe.add(cid);
        
        tfid=new JTextField();
        tfid.setBounds(280, 165, 200, 30);
        jframe.add(tfid);
        
        JLabel time=new JLabel("Checkin Time");
        time.setFont(new Font("Raleway",Font.PLAIN,20));
        time.setBounds(50, 230, 200, 30);
        jframe.add(time);
        
        tftime=new JTextField();
        tftime.setBounds(280, 230, 200, 30);
        jframe.add(tftime);
        
        
        JLabel tout=new JLabel("Checkout Time");
        tout.setFont(new Font("Raleway",Font.PLAIN,20));
        tout.setBounds(50, 295, 150, 30);
        jframe.add(tout);
        
        
        Date d=new Date();
        JLabel tdate=new JLabel(""+d);
        tdate.setBounds(280, 300, 160, 30);
      
        jframe.add(tdate);
        
        search=new JButton("Get Info");
        search.setBounds(80, 380, 130, 30);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        jframe.add(search);
        search.addActionListener((ActionListener) this);
        
        cancel=new JButton("CheckOut");
        cancel.setBounds(280, 380, 130, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        jframe.add(cancel);
        cancel.addActionListener((ActionListener) this);
        
       
        cout=new JButton("Cancel");
        cout.setBounds(180, 440, 130, 30);
        cout.setBackground(Color.black);
        cout.setForeground(Color.white);
        jframe.add(cout);
        cout.addActionListener((ActionListener) this);

        
        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("icons/checkout.jpg"));
        Image i1=image.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i1);
        JLabel i2=new JLabel(i3);
        i2.setBounds(520,30,400,400);
        jframe.add(i2);
        
        jframe.setBounds(200,100,1000,600);
        jframe.setLayout(null);
        jframe.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String rno=roomnum.getSelectedItem();
           String q1="delete form customer_info where alloroom='"+rno+"'";
            

        String q="select * from customer_info where alloroom='"+rno+"'";
        Conn c=new Conn();
         try{
                
            ResultSet rs=c.s.executeQuery(q);
            while(rs.next()){
                tfid.setText(rs.getString("cname"));
                tftime.setText(rs.getString("checkintime"));
                
                
            }
            
             
            
                
            }catch(Exception e){
                e.printStackTrace();
            }
           
            
            
            
            
        }else if(ae.getSource()==cout){
            jframe.setVisible(false);
            new Reception();
        }
        else if(ae.getSource()==cancel){
            String rno=roomnum.getSelectedItem();
           String q1="delete from customer_info where alloroom='"+rno+"'";
           String q2="update addroom set roomavg='Available' where roomno='"+rno+"'";
           try{
               Conn c=new Conn();
               c.s.executeUpdate(q1);
               c.s.executeUpdate(q2);
               JOptionPane.showMessageDialog(null,"CheckOut Done>>!");
               jframe.setVisible(false);
               new Reception();
           }catch(Exception e){
               e.printStackTrace();
           }
            
        }
        
    }
    
    
    
    
    public static void main(String args[]){
        new CheckOut();
    }
    
    
}
