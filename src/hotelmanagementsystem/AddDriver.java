
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AddDriver implements ActionListener{
    JTextField tfname, tfcmodel,tfage,tfcompany,tflocation;
     JComboBox cb1,cb2;
     JButton submit,cancel;
     JFrame jframe=new JFrame(); 
    AddDriver()
    {
       // jframe.getContentPane().setBackground(Color.white);
        JLabel jlabel=new JLabel("Add Drivers");
        jlabel.setBounds(200,10,200,30);
        jlabel.setFont(new Font("serif",Font.BOLD,24));
        jframe.add(jlabel);
        
        JLabel name=new JLabel("Name:-");
        name.setFont(new Font("serif",Font.PLAIN,22));
        name.setBounds(50, 60,150, 30);
        jframe.add(name);
        
         tfname=new JTextField();
        tfname.setBounds(230, 60, 200, 30);
        jframe.add(tfname);
        
        
        JLabel age=new JLabel("Age:-");
        age.setFont(new Font("serif",Font.PLAIN,22));
        age.setBounds(50, 110,150, 30);
        jframe.add(age);
        
         tfage=new JTextField();
        tfage.setBounds(230, 110, 200, 30);
        jframe.add(tfage);
        
         JLabel gender=new JLabel("Gender:-");
       gender.setFont(new Font("serif",Font.PLAIN,22));
        gender.setBounds(50, 165,150, 30);
        jframe.add(gender);
        
        String rs[]={"Male","Female"};
        cb1=new JComboBox(rs);
        cb1.setBackground(Color.white);
        cb1.setBounds(230, 165, 200, 30);
        jframe.add(cb1);
        
         JLabel availiable=new JLabel("Availibility:-");
        availiable.setFont(new Font("serif",Font.PLAIN,22));
         availiable.setBounds(50, 230,170, 30);
        jframe.add(availiable);
        
        String cs[]={"Available","Unavailable"};
         cb2=new JComboBox(cs);
        cb2.setBackground(Color.white);
        cb2.setBounds(230, 230, 200, 30);
        jframe.add(cb2);

        
         JLabel cmodel=new JLabel("Car Model:-");
        cmodel.setFont(new Font("serif",Font.PLAIN,22));
        cmodel.setBounds(50, 290,150, 30);
        jframe.add(cmodel);
        
         tfcmodel=new JTextField();
        tfcmodel.setBounds(230, 290, 200, 30);
        jframe.add(tfcmodel);
        
         JLabel company=new JLabel("Car Company:-");
         company.setFont(new Font("serif",Font.PLAIN,22));
        company.setBounds(50, 345,150, 30);
        jframe.add(company);
        
        tfcompany=new JTextField();
        tfcompany.setBounds(230,345, 200, 30);
        jframe.add(tfcompany);

        
          JLabel location=new JLabel("Location:-");
         location.setFont(new Font("serif",Font.PLAIN,22));
          location.setBounds(50, 395,150, 30);
        jframe.add(location);
        
        tflocation=new JTextField();
        tflocation.setBounds(230,395, 200, 30);
        jframe.add(tflocation);
        
        submit=new JButton("Add Driver");
        submit.setBounds(50, 460, 150, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        jframe.add(submit);
        submit.addActionListener(this);
        
       cancel=new JButton("Cancel");
        cancel.setBounds(240, 460, 150, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        jframe.add(cancel);
        cancel.addActionListener(this);

        
         ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("icons/driver.jpg"));
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
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=cb1.getSelectedItem().toString();
            String avl=cb2.getSelectedItem().toString();
            String cmodel=tfcmodel.getText();
            String company=tfcompany.getText();
            String location=tflocation.getText();
            
            try{
                String query="insert into driver values('"+name+"','"+age+"','"+gender+"','"+avl+"','"+cmodel+"','"+company+"','"+location+"')";
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Driver Added Successfully");
                jframe.setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
            
        }else if(ae.getSource()==cancel)
        {
            jframe.setVisible(false);
        }
    }
    public static void main(String args[]){
        new AddDriver();
    }
}
