package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SearchRoom implements ActionListener {
    JButton cancel,search;
    JCheckBox checkbox;
    JComboBox cb;
    JTable jtable;
    JFrame jframe=new JFrame();
    SearchRoom(){
        
        
        JLabel jlabel=new JLabel("Search For Rooms");
        jlabel.setFont(new Font("Raleway",Font.BOLD,24));
        jlabel.setForeground(Color.red);
        jlabel.setBounds(250,10,300,30);
        jframe.add(jlabel);
        
        
        JLabel bedtype=new JLabel("Bed Room Type");
        bedtype.setFont(new Font("Raleway",Font.PLAIN,18));
        bedtype.setBounds(40, 90, 150, 30);
        jframe.add(bedtype);
        
        String str[]={"Single Bed","Double Bed"};
        cb=new JComboBox(str);
        cb.setBackground(Color.white);
        cb.setBounds(200, 90, 150, 30);
        jframe.add(cb);
        
         checkbox=new JCheckBox(" Only Display Available Rooms");
        checkbox.setBounds(440, 90, 300, 30);
        checkbox.setFont(new Font("Raleway",Font.PLAIN,18));
        jframe.add(checkbox);
        
        JLabel roomno=new JLabel("Room Number");
        roomno.setBounds(105, 160, 100, 15);
        jframe.add(roomno);
        
        JLabel roomavg=new JLabel("Availability");
        roomavg.setBounds(230,160, 100, 15);
        jframe.add(roomavg);
        
        JLabel status=new JLabel("Room Condition");
        status.setBounds(345, 160, 100, 15);
        jframe.add(status);
        
        JLabel price=new JLabel("Price");
        price.setBounds(475, 160, 100, 15);
        jframe.add(price);
        
        JLabel bed=new JLabel("Bed Type");
        bed.setBounds(590, 160, 100, 15);
        jframe.add(bed);
        
        jtable=new JTable();
        jtable.setBounds(90, 180, 600, 380);
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
        
        jframe.setBounds(300,100,800, 670);
        jframe.setLayout(null);
        jframe.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String bed=cb.getSelectedItem().toString();
            ResultSet rs=null;
            Conn c=new Conn();
            
            if(checkbox.isSelected()){
                try{
                String query1="select * from addroom where bed='"+bed+"' and roomavg='Available'";
                rs=c.s.executeQuery(query1);             
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                try{
                String query2="select * from addroom where bed='"+bed+"'";
                rs=c.s.executeQuery(query2);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            
            jtable.setModel(DbUtils.resultSetToTableModel(rs));
            
        }else if(ae.getSource()==cancel){
        jframe.setVisible(false);
        new Reception();
        }
    }
    public static void main(String args[]){
        new SearchRoom();
    }
    
    
}
