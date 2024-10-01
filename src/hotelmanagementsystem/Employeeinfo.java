package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Employeeinfo implements ActionListener {
    JButton cancel;
    JFrame jframe=new JFrame();
    Employeeinfo(){
        
        
        JLabel jlabel=new JLabel("Employee Information");
        jlabel.setFont(new Font("Raleway",Font.BOLD,22));
        jlabel.setForeground(Color.red);
        jlabel.setBounds(380,5,300,30);
        jframe.add(jlabel);
        
        
       JLabel name=new JLabel("Name");
        name.setBounds(80,50, 100, 15);
        jframe.add(name);
        
        JLabel age=new JLabel("Age");
        age.setBounds(200, 50, 100, 15);
        jframe.add(age);
        
        JLabel gender=new JLabel("Gender");
        gender.setBounds(310, 50, 100, 15);
        jframe.add(gender);
        
        JLabel job=new JLabel("Job");
        job.setBounds(430, 50, 100, 15);
        jframe.add(job);
        
        JLabel salary=new JLabel("Salary");
        salary.setBounds(550, 50, 100, 15);
        jframe.add(salary);
        
        JLabel contact=new JLabel("Contact");
        contact.setBounds(670, 50, 100, 15);
        jframe.add(contact);
      
        JLabel email=new JLabel("E-Mail");
        email.setBounds(800, 50, 100, 15);
        jframe.add(email);
        
        JLabel adhar=new JLabel("Adhar Number");
        adhar.setBounds(910, 50, 100, 15);
        jframe.add(adhar);
        
        JTable jtable=new JTable();
        jtable.setBounds(30, 70, 1000, 400);
        jframe.add(jtable);
        try {
            Conn c=new Conn();
            String query="select * from employee_info";
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
        new Employeeinfo();
    }
    
    
}
