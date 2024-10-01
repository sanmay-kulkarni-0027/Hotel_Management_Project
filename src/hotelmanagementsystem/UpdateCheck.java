package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static java.lang.Integer.parseInt;
import java.util.*;
public class UpdateCheck implements ActionListener{
    JFrame jframe=new JFrame();
    Choice croomno;
    JTextField tfname,tfid,tfnum,tftime,tfdeposit,tframount;
    JButton check,update,cancel;
    UpdateCheck()
    {
        
        JLabel jlabel=new JLabel("Check Status");
        jlabel.setFont(new Font("Raleway",Font.BOLD,24));
        jlabel.setForeground(Color.red);
        jlabel.setBounds(150, 30,200, 30);
        jframe.add(jlabel);
        
        JLabel roomno=new JLabel("Room Number");
        roomno.setBounds(50,90, 150, 30);
        roomno.setFont(new Font("Raleway",Font.PLAIN,20));
        jframe.add(roomno);
        
        croomno=new Choice();
        croomno.setBounds(300,95,200,30);
        jframe.add(croomno);
        
        try{
            Conn c=new Conn();
            String query="select * from addroom where roomavg='Occupied'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                croomno.add(rs.getString("roomno"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel name=new JLabel("Name");
        name.setBounds(50,145,150, 30);
        name.setFont(new Font("Raleway",Font.PLAIN,20));
        jframe.add(name);
        
        tfname=new JTextField();
        tfname.setBounds(300,145,200,30);
        jframe.add(tfname);
        
        JLabel id=new JLabel("ID");
        id.setBounds(50,200, 150, 30);
        id.setFont(new Font("Raleway",Font.PLAIN,20));
        jframe.add(id);
        
        tfid=new JTextField();
        tfid.setBounds(300,200,200,30);
        jframe.add(tfid);
        
        JLabel idnum=new JLabel("ID Number");
        idnum.setBounds(50,255, 150, 30);
        idnum.setFont(new Font("Raleway",Font.PLAIN,20));
        jframe.add(idnum);
        
        tfnum=new JTextField();
        tfnum.setBounds(300,255,200,30);
        jframe.add(tfnum);
        
        JLabel time=new JLabel("Check-in Time");
        time.setBounds(50,315, 150, 30);
        time.setFont(new Font("Raleway",Font.PLAIN,20));
        jframe.add(time);
        
        tftime=new JTextField();
        tftime.setBounds(300,315,200,30);
        jframe.add(tftime);
        
        JLabel deposit=new JLabel("Deposit");
        deposit.setBounds(50,370, 150, 30);
        deposit.setFont(new Font("Raleway",Font.PLAIN,20));
        jframe.add(deposit);
        
        tfdeposit=new JTextField();
        tfdeposit.setBounds(300,375,200,30);
        jframe.add(tfdeposit);
        
        JLabel ramount=new JLabel("Remaining Amount");
        ramount.setBounds(50,435, 200, 30);
        ramount.setFont(new Font("Raleway",Font.PLAIN,20));
        jframe.add(ramount);
        
        tframount=new JTextField();
        tframount.setBounds(300,435,200,30);
        jframe.add(tframount);
        
         
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.jpg"));
        Image i2=i1.getImage().getScaledInstance(350, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,110,350,400);
        jframe.add(image);
        
        
        
        check=new JButton("Check");
        check.setBounds(110, 500, 150, 30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        jframe.add(check);
      check.addActionListener((ActionListener) this);
        
        update=new JButton("Update");
        update.setBounds(320, 500, 150, 30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        jframe.add(update);
        update.addActionListener((ActionListener) this);
        
        cancel=new JButton("Back");
        cancel.setBounds(210, 560, 150, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        jframe.add(cancel);
        cancel.addActionListener((ActionListener) this);
        
        jframe.setBounds(250,100,1000,700);
        jframe.setLayout(null);
        jframe.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String rno=croomno.getSelectedItem();
        
        if(ae.getSource()==check)
        {
            int i=0,j=0,sub=0;
            try{
                Conn c=new Conn();
                String q="select * from customer_info where alloroom='"+rno+"'";
                ResultSet rs=c.s.executeQuery(q);
                while(rs.next()){
                    tfname.setText(rs.getString("cname"));
                    tfid.setText(rs.getString("id"));
                    tfnum.setText(rs.getString("idnum"));
                    tftime.setText(rs.getString("checkintime"));
                    tfdeposit.setText(rs.getString("deposit"));
                    i=Integer.parseInt(rs.getString("deposit"));
                }
                String h="select roomprice from addroom where roomno='"+rno+"'";
                ResultSet r=c.s.executeQuery(h);
                while(r.next()){
                   j=Integer.parseInt(r.getString("roomprice"));
                }
                sub=j-i;
              tframount.setText(""+sub);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
                                
            
            
        }else if(ae.getSource()==update){
           String rno1=croomno.getSelectedItem();
           String name=tfname.getText();
           String id=tfid.getText();
           String idnum=tfnum.getText();
           String time=tftime.getText();
           String deposit=tfdeposit.getText();
           String ramount=tframount.getText();
           try{
               String q="update customer_info set id='"+id+"',idnum='"+idnum+"',cname='"+name+"',checkintime='"+time+"',deposit='"+deposit+"' where alloroom='"+rno1+"'";
               Conn c=new Conn();
               c.s.executeUpdate(q);
               JOptionPane.showMessageDialog(null,"Data updated successfully");
           }catch(Exception e){
               e.printStackTrace();
           }
            
            
            
            
        }else if(ae.getSource()==cancel){
           jframe.setVisible(false);
           new Reception();
        }
    }
    
    
    
    
    public static void main(String args[]){
        new UpdateCheck();
    }

    private int Integer(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
