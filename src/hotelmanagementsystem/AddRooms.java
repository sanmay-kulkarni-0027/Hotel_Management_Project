package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRooms implements ActionListener {
 
     JTextField tfroomno, tfprice;
     JComboBox cb1,cb2,cb3;
     JButton submit,cancel;
     JFrame jframe=new JFrame(); 
    AddRooms()
    {
        
        
        
        
       // jframe.getContentPane().setBackground(Color.white);
        JLabel jlabel=new JLabel("Add Rooms");
        jlabel.setBounds(200,30,200,30);
        jlabel.setFont(new Font("serif",Font.BOLD,24));
        jframe.add(jlabel);
        
        JLabel roomno=new JLabel("Room Number:-");
        roomno.setFont(new Font("serif",Font.PLAIN,22));
        roomno.setBounds(50, 100,150, 30);
        jframe.add(roomno);
        
         tfroomno=new JTextField();
        tfroomno.setBounds(230, 100, 200, 30);
        jframe.add(tfroomno);
        
         JLabel roomstate=new JLabel("Availablity:-");
        roomstate.setFont(new Font("serif",Font.PLAIN,22));
        roomstate.setBounds(50, 165,150, 30);
        jframe.add(roomstate);
        
        String rs[]={"Available","Occupied"};
        cb1=new JComboBox(rs);
        cb1.setBackground(Color.white);
        cb1.setBounds(230, 165, 200, 30);
        jframe.add(cb1);
        
         JLabel cleanstatus=new JLabel("Cleaning Status:-");
        cleanstatus.setFont(new Font("serif",Font.PLAIN,22));
        cleanstatus.setBounds(50, 230,170, 30);
        jframe.add(cleanstatus);
        
        String cs[]={"Cleaned","Dirty"};
         cb2=new JComboBox(cs);
        cb2.setBackground(Color.white);
        cb2.setBounds(230, 230, 200, 30);
        jframe.add(cb2);

        
         JLabel price=new JLabel("Price:-");
        price.setFont(new Font("serif",Font.PLAIN,22));
        price.setBounds(50, 295,150, 30);
        jframe.add(price);
        
         tfprice=new JTextField();
        tfprice.setBounds(230, 295, 200, 30);
        jframe.add(tfprice);
        
         JLabel bed=new JLabel("Bed Type:-");
       bed.setFont(new Font("serif",Font.PLAIN,22));
        bed.setBounds(50, 365,150, 30);
        jframe.add(bed);
        
        String bt[]={"Single Bed","Double Bed"};
        cb3=new JComboBox(bt);
        cb3.setBackground(Color.white);
        cb3.setBounds(230, 365, 200, 30);
        jframe.add(cb3);

        submit=new JButton("Add Room");
        submit.setBounds(50, 450, 150, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        jframe.add(submit);
        submit.addActionListener(this);
        
       cancel=new JButton("Cancel");
        cancel.setBounds(240, 450, 150, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        jframe.add(cancel);
        cancel.addActionListener(this);

        
         ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
         Image i1=image.getImage().getScaledInstance(600, 350, Image.SCALE_DEFAULT);
         ImageIcon i2=new ImageIcon(i1);
         JLabel jimage=new JLabel(i2);
         jimage.setBounds(480, 80, 600, 350);
         jframe.add(jimage);
         
           jframe.setSize(1150,600);
        jframe.setLayout(null);
        jframe.setVisible(true);
        jframe.setLocation(200,200);
        
         JLabel j1=new JLabel("#HOTEL SHREE#");
         j1.setBounds(600, 430, 300, 100);
          j1.setForeground(Color.blue);
          j1.setFont(new Font("serif",Font.BOLD,36));
          jframe.add(j1);
          
        
          
      /*     while(true)
        {
            j1.setVisible(false);
            try{
                Thread.sleep(750);
            }catch(Exception e)
            {
                e.printStackTrace();;
            }
            j1.setVisible(true);
            try{
                Thread.sleep(750);
            }catch(Exception e)
            {
                e.printStackTrace();;
            }

        }
          */       
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String roomno=tfroomno.getText();
            String available=cb1.getSelectedItem().toString();
            String cleanstatus=cb2.getSelectedItem().toString();
            String price=tfprice.getText();
            String bed=cb3.getSelectedItem().toString();
            try{
               Conn c=new Conn();
               String query="insert into addroom values('"+roomno+"','"+available+"','"+cleanstatus+"','"+price+"','"+bed+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Room Added Successfully");
               jframe.setVisible(false);
                
            }catch(Exception e)
            {
                e.printStackTrace();;
            }
            
            
            
            
            
        }else if(ae.getSource()==cancel)
        {
            jframe.setVisible(false);
            new DashBoard();
        }
        
    }
    public static void main(String args[])
    {
        new AddRooms();
    }
}
