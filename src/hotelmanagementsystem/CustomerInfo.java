package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CustomerInfo implements ActionListener {
    JButton cancel;
    JFrame jframe=new JFrame();
    CustomerInfo(){
        
        
        JLabel jlabel=new JLabel("Customer Information");
        jlabel.setFont(new Font("Raleway",Font.BOLD,22));
        jlabel.setForeground(Color.red);
        jlabel.setBounds(380,5,300,30);
        jframe.add(jlabel);
        
        
       JLabel id=new JLabel("ID");
        id.setBounds(80,50, 80, 15);
        jframe.add(id);
        
        JLabel idno=new JLabel("ID Number");
        idno.setBounds(170, 50, 100, 15);
        jframe.add(idno);
        
        JLabel name=new JLabel("Name");
        name.setBounds(310, 50, 100, 15);
        jframe.add(name);
        
        JLabel gender=new JLabel("Gender");
        gender.setBounds(430, 50, 100, 15);
        jframe.add(gender);
        
        JLabel country=new JLabel("Country");
        country.setBounds(550, 50, 100, 15);
        jframe.add(country);
        
        JLabel allroom=new JLabel("Room Number");
        allroom.setBounds(670, 50, 100, 15);
        jframe.add(allroom);
      
        JLabel time=new JLabel("Chect-in Time");
        time.setBounds(800, 50, 100, 15);
        jframe.add(time);
        
        JLabel deposit=new JLabel("Deposit");
        deposit.setBounds(910, 50, 100, 15);
        jframe.add(deposit);
        
        JTable jtable=new JTable();
        jtable.setBounds(30, 70, 1000, 400);
        jframe.add(jtable);
        try {
            Conn c=new Conn();
            String query="select * from customer_info";
            ResultSet rs=c.s.executeQuery(query);
            jtable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
        
        cancel=new JButton("Back");
        cancel.setBounds(420, 490, 150, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        jframe.add(cancel);
        cancel.addActionListener((ActionListener) this);
        
        jframe.setBounds(300,100,1080, 590);
        jframe.setLayout(null);
        jframe.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        jframe.setVisible(false);
        new Reception();
    }
    public static void main(String args[]){
        new CustomerInfo();
    }
    
    
}
