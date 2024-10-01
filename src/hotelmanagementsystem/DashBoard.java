package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class DashBoard implements ActionListener {
    JFrame jframe=new JFrame();
    JMenuItem emp,driver,rooms;
    DashBoard()
    {
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.jpg"));
        Image image2=image1.getImage().getScaledInstance(1281, 800,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);
        JLabel j1=new JLabel(image3);
        j1.setBounds(0, 0,1281, 800);
        jframe.add(j1); 
        
        JMenuBar jmenubar=new JMenuBar();
        jmenubar.setBounds(0, 0, 1281, 30);
        j1.add(jmenubar);
        
        JMenu hotel=new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.red);
        jmenubar.add(hotel);
        
        JMenuItem reception=new JMenuItem("RECEPTION");
        hotel.add(reception);
        reception.addActionListener(this);
        
        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.blue);
        jmenubar.add(admin);
       
        
         emp=new JMenuItem("ADD EMPLOYEE");
        admin.add(emp);
        emp.addActionListener(this);
        
        driver=new JMenuItem("ADD DRIVER");
        admin.add(driver);
        driver.addActionListener(this);
        
         rooms=new JMenuItem("ADD ROOMS");
        admin.add(rooms);
        rooms.addActionListener(this);
        
         jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jframe.setSize(1281,800);
       jframe.setLayout(null);
       jframe.setVisible(true);
       jframe.setLocation(100, 10);
    }
    
   public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOMS"))
        {
            new AddRooms();
        }
        else if(ae.getActionCommand().equals("ADD DRIVER"))
        {
            new AddDriver();
        }
        else if(ae.getActionCommand().equals("RECEPTION"))
        {
            new Reception();
        }
    }
    
    public static void main(String args[])
    {
        new DashBoard();
    }
}
