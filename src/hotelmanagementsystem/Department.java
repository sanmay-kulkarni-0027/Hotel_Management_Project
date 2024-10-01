package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Department implements ActionListener {
    JButton cancel;
    JFrame jframe=new JFrame();
    Department(){
        
        JLabel jlabel=new JLabel("  Department's  Information");
        jlabel.setFont(new Font("Raleway",Font.BOLD,22));
        jlabel.setForeground(Color.red);
        jlabel.setBounds(230,5,300,30);
        jframe.add(jlabel);
        
        
        JLabel roomno=new JLabel("Department");
        roomno.setBounds(180, 50, 100, 15);
        jframe.add(roomno);
        
        JLabel roomavg=new JLabel("Budget");
        roomavg.setBounds(480, 50, 100, 15);
        jframe.add(roomavg);
        
                
        JTable jtable=new JTable();
        jtable.setBounds(100, 70, 600, 450);
        jframe.add(jtable);
        try {
            Conn c=new Conn();
            String query="select * from department limit 5";
            ResultSet rs=c.s.executeQuery(query);
            jtable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        /*ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("icons/Room1.png"));
        Image i1=image.getImage().getScaledInstance(430, 500,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel image1=new JLabel(i2);
        image1.setBounds(610,30, 400, 500);
        jframe.add(image1);*/
        
        cancel=new JButton("Back");
        cancel.setBounds(280, 540, 150, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        jframe.add(cancel);
        cancel.addActionListener((ActionListener) this);
        
        jframe.setBounds(300,100,800, 630);
        jframe.setLayout(null);
        jframe.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        jframe.setVisible(false);
        new Reception();
    }
    public static void main(String args[]){
        new Department();
    }
    
    
}

