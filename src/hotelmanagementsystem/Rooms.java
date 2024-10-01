package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Rooms implements ActionListener {
    JButton cancel;
    JFrame jframe=new JFrame();
    Rooms(){
        
        
        JLabel jlabel=new JLabel("Room  Information");
        jlabel.setFont(new Font("Raleway",Font.BOLD,24));
        jlabel.setForeground(Color.red);
        jlabel.setBounds(250,10,300,30);
        jframe.add(jlabel);
        
        JLabel roomno=new JLabel("Room Number");
        roomno.setBounds(105, 60, 100, 15);
        jframe.add(roomno);
        
        JLabel roomavg=new JLabel("Availability");
        roomavg.setBounds(230,60, 100, 15);
        jframe.add(roomavg);
        
        JLabel status=new JLabel("Room Condition");
        status.setBounds(345, 60, 100, 15);
        jframe.add(status);
        
        JLabel price=new JLabel("Price");
        price.setBounds(475, 60, 100, 15);
        jframe.add(price);
        
        JLabel bed=new JLabel("Bed Type");
        bed.setBounds(590, 60, 100, 15);
        jframe.add(bed);
        
        JTable jtable=new JTable();
        jtable.setBounds(90, 80, 600, 490);
        jframe.add(jtable);
        try {
            Conn c=new Conn();
            String query="select * from addroom";
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
        cancel.setBounds(280, 580, 150, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        jframe.add(cancel);
        cancel.addActionListener((ActionListener) this);
        
        jframe.setBounds(300,100,800, 670);
        jframe.setLayout(null);
        jframe.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        jframe.setVisible(false);
        new Reception();
    }
    public static void main(String args[]){
        new Rooms();
    }
    
    
}
