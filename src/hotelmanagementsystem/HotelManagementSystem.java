package hotelmanagementsystem;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
public class HotelManagementSystem implements ActionListener {

    JFrame jframe=new JFrame();
    HotelManagementSystem()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icon1.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0, 0, 1169, 532);
        jframe.add(image);
      
         JButton b1=new JButton("Next>>");
         b1.setBounds(1000, 450, 90,30);
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         image.add(b1);
         b1.addActionListener(this);
         
         
         JLabel j1=new JLabel("#HOTEL SHREE WELCOMES YOU#");
         j1.setBounds(280, 80, 650, 80);
          j1.setForeground(Color.WHITE);
          j1.setFont(new Font("serif",Font.BOLD,34));
          image.add(j1);
          
          
          jframe.setSize(1169,532);
        jframe.setLayout(null);
        jframe.setVisible(true);
        jframe.setLocation(100, 100);
         jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true)
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
        
        
    }
    public void actionPerformed(ActionEvent ae){
        new Login();
        jframe.dispose();
    }
    
    
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
