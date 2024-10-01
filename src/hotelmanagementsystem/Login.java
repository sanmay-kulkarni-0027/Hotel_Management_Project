package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Login implements ActionListener {
    JTextField tf;
    JPasswordField pf;
    JFrame jframe=new JFrame();
    JButton jbutton1,jbutton;
    Login()
    {
        
        
        jframe.getContentPane().setBackground(Color.lightGray);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("icons/user.jpg"));
        Image image2=image1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);
        JLabel j3=new JLabel(image3);
        j3.setBounds(430,100,200,200);
        jframe.add(j3);
      //jframe.pack();
        
        JLabel j1=new JLabel("LOGIN");
        j1.setBounds(170, 50, 200, 40);
        j1.setFont(new Font("serif",Font.BOLD,32));
        jframe.add(j1);
      
        JLabel username=new JLabel("Username:-");
        username.setBounds(50, 130, 120, 30);
        username.setFont(new Font("serif",Font.PLAIN,22));
        jframe.add(username);
        
        JLabel password=new JLabel("Password:-");
        password.setBounds(50, 200, 120, 30);
        password.setFont(new Font("serif",Font.PLAIN,22));
        jframe.add(password);
        
        tf=new JTextField();
       tf.setBounds(190, 130, 180, 30);
        tf.setFont(new Font("serif",Font.PLAIN,22));
        jframe.add(tf);

        
        pf=new JPasswordField();
       pf.setBounds(190, 203, 180, 30);
        pf.setFont(new Font("serif",Font.PLAIN,22));
        jframe.add(pf);
        
         jbutton=new JButton("Login");
        jbutton.setBounds(110, 300, 100, 40);
        jbutton.setFont(new Font("serif",Font.PLAIN,18));
        jframe.add(jbutton);
        jbutton.addActionListener(this);
        
        jbutton1=new JButton("Back");
        jbutton1.setBounds(280, 300, 100, 40);
        jbutton1.setFont(new Font("serif",Font.PLAIN,18));
        jframe.add(jbutton1);
        jbutton1.addActionListener(this);
        
        jframe.setSize(700,500);
        jframe.setLayout(null);
        jframe.setVisible(true);
        jframe.setLocation(400,100);
    }
    /*public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==jbutton){
        try{
            String sql="select * from userframe where username=? and pass_word=?";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelManagementSystem", "root", "Sanmay@2002");
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,tf.getText());
            pstmt.setString(2,new String(pf.getPassword()));
            ResultSet rs=pstmt.executeQuery();
            if(rs.next())
            {
                new DashBoard();
                jframe.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Enter valid username/password");
            }
            tf.setText(" ");
            pf.setText(" ");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, ae);
        }
        }
        if(ae.getSource()==jbutton1)
       {
           jframe.setVisible(false);
        }
    }*/
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==jbutton)
        {
            String name=tf.getText();
            String pass=pf.getText();
            try{
                Conn c1=new Conn();
                String query="select * from userframe where username='"+name+"' and pass_word='"+pass+"'";
                ResultSet rs=c1.s.executeQuery(query);
                if(rs.next())
                {
                    new DashBoard();
                    jframe.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Enter valid username/password");
                }
            }catch(Exception a)
            {
                a.printStackTrace();
            }
            
            
        }else if(ae.getSource()==jbutton1)
        {
            jframe.setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new Login();                                                        
    }
}
