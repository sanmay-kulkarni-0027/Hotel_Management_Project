package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PickService implements ActionListener {
    JButton cancel,search;
    JCheckBox checkbox;
    Choice cartype;
    JTable jtable;
    JFrame jframe=new JFrame();
    PickService(){
        
        
        JLabel jlabel=new JLabel("Search For Cars");
        jlabel.setFont(new Font("Raleway",Font.BOLD,24));
        jlabel.setForeground(Color.red);
        jlabel.setBounds(260,30,300,30);
        jframe.add(jlabel);
        
        
        JLabel bedtype=new JLabel("Car Type");
        bedtype.setFont(new Font("Raleway",Font.PLAIN,18));
        bedtype.setBounds(80, 90, 100, 30);
        jframe.add(bedtype);
        
       cartype=new Choice();
        cartype.setBackground(Color.white);
        cartype.setBounds(210, 100, 150, 30);
        jframe.add(cartype);
        try{
            Conn c=new Conn();
            String q="select * from driver";
            ResultSet rs=c.s.executeQuery(q);
            while(rs.next()){
                cartype.add(rs.getString("carmodel"));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
       
        
        JLabel roomno=new JLabel("Name");
        roomno.setBounds(50, 160, 100, 15);
        jframe.add(roomno);
        
        JLabel roomavg=new JLabel("Age");
        roomavg.setBounds(170,160, 100, 15);
        jframe.add(roomavg);
        
        JLabel status=new JLabel("Gender");
        status.setBounds(270, 160, 80, 15);
        jframe.add(status);
        
        JLabel price=new JLabel("Availibility");
        price.setBounds(360, 160, 100, 15);
        jframe.add(price);
        
        JLabel bed=new JLabel("Model");
        bed.setBounds(470, 160, 70, 15);
        jframe.add(bed);
        
        
        JLabel bed1=new JLabel("Company");
        bed1.setBounds(560, 160, 100, 15);
        jframe.add(bed1);
        
        JLabel bed2=new JLabel("Model");
        bed2.setBounds(670, 160, 100, 15);
        jframe.add(bed2);
        
        jtable=new JTable();
        jtable.setBounds(40, 180, 700, 380);
        jframe.add(jtable);
        try {
            Conn c=new Conn();
            String query="select * from driver";
            ResultSet rs=c.s.executeQuery(query);
            jtable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
        
        search=new JButton("Search");
        search.setBounds(210, 580, 150, 30);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        jframe.add(search);
        search.addActionListener((ActionListener) this);
        
        cancel=new JButton("Back");
        cancel.setBounds(420, 580, 150, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        jframe.add(cancel);
        cancel.addActionListener((ActionListener) this);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/car.jpg"));
        Image i2=i1.getImage().getScaledInstance(180, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,30,180,100);
        jframe.add(image);
        
        jframe.setBounds(300,100,800, 670);
        jframe.setLayout(null);
        jframe.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String bed=cartype.getSelectedItem();
            ResultSet rs=null;
            Conn c=new Conn();
            try{
                String query1="select * from driver where carmodel='"+bed+"'";
                rs=c.s.executeQuery(query1); 
                jtable.setModel(DbUtils.resultSetToTableModel(rs));
                }catch(Exception e){
                    e.printStackTrace();
                }
           
            
            
            
        }else if(ae.getSource()==cancel){
        jframe.setVisible(false);
        new Reception();
        }
    }
    public static void main(String args[]){
        new PickService();
    }
    
    
}
