
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class AddEmployee implements ActionListener {
    
    JTextField tfname,tfage,tfsalary,tfemail,tfadhar,tfphone;
    JRadioButton rb1,rb2;
    JComboBox cbjobs;
     JFrame jframe=new JFrame();
    AddEmployee()
    {
    
     
     JLabel name=new JLabel("Name:-");
     name.setBounds(50, 30,100 , 30);
     name.setFont(new Font("serif",Font.BOLD,22));
     jframe.add(name);
     
      tfname=new JTextField();
     tfname.setBounds(170, 30, 200, 30);
     jframe.add(tfname);
     
     JLabel age=new JLabel("Age:-");
     age.setBounds(50, 85,100 , 30);
     age.setFont(new Font("serif",Font.BOLD,22));
     jframe.add(age);
     
      tfage=new JTextField();
     tfage.setBounds(170, 85, 200, 30);
     jframe.add(tfage);
     
     JLabel gender=new JLabel("Gender:-");
     gender.setBounds(50, 140,100 , 30);
     gender.setFont(new Font("serif",Font.BOLD,22));
     jframe.add(gender);
     
     rb1=new JRadioButton("Male");
     rb1.setBounds(170, 140, 70, 30);
    rb1.setFont(new Font("serif",Font.BOLD,16));
     jframe.add(rb1);
     
     rb2=new JRadioButton("Female");
     rb2.setBounds(265, 140, 80, 30);
     rb2.setFont(new Font("serif",Font.BOLD,16));
     jframe.add(rb2);
     ButtonGroup bg=new ButtonGroup();
     bg.add(rb1);
     bg.add(rb2);
     
     
     JLabel job=new JLabel("Job:-");
     job.setBounds(50, 195,100 , 30);
     job.setFont(new Font("serif",Font.BOLD,22));
     jframe.add(job);
     
     String jobs[]={"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waiteress","Manager","Accountant"};
     cbjobs=new JComboBox(jobs);
     cbjobs.setBounds(170,195,200,30);
     cbjobs.setBackground(Color.white);
     jframe.add(cbjobs);
     
     JLabel salary=new JLabel("Salary:-");
     salary.setBounds(50, 250,100 , 30);
     salary.setFont(new Font("serif",Font.BOLD,22));
     jframe.add(salary);
     
      tfsalary=new JTextField();
     tfsalary.setBounds(170, 250, 200, 30);
     jframe.add(tfsalary);
     
     JLabel phoneno=new JLabel("Phone:-");
     phoneno.setBounds(50, 305,100 , 30);
     phoneno.setFont(new Font("serif",Font.BOLD,22));
     jframe.add(phoneno);
     
      tfphone=new JTextField();
     tfphone.setBounds(170, 305, 200, 30);
     jframe.add(tfphone);
     
     JLabel email=new JLabel("E-Mail:-");
     email.setBounds(50, 365,100 , 30);
     email.setFont(new Font("serif",Font.BOLD,22));
     jframe.add(email);
     
       tfemail=new JTextField();
     tfemail.setBounds(170, 365, 200, 30);
     jframe.add(tfemail);
     
     JLabel adhar=new JLabel("Aadhar:-");
     adhar.setBounds(50, 425,100 , 30);
     adhar.setFont(new Font("serif",Font.BOLD,22));
     jframe.add(adhar);
     
       tfadhar=new JTextField();
     tfadhar.setBounds(170, 425, 200, 30);
     jframe.add(tfadhar);
     
     JButton submit=new JButton("Submit");
     submit.setBounds(170, 490, 200, 30);
     submit.setBackground(Color.black);
     submit.setForeground(Color.white);
     submit.setFont(new Font("serif",Font.BOLD,20));
     jframe.add(submit);
     submit.addActionListener(this);
     
     ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("icons/employee.jpg"));
     Image image2=image.getImage().getScaledInstance(350, 350,Image.SCALE_DEFAULT);
     ImageIcon image3=new ImageIcon(image2);
     JLabel image1=new JLabel(image3);
     image1.setBounds(450,60,350,350);
     jframe.add(image1);
     
    // jframe.getContentPane().setBackground(Color.WHITE);
     jframe.setLayout(null);
     jframe.setSize(900, 600);
     jframe.setVisible(true);
     jframe.setLocation(350,200);
     
     JLabel j1=new JLabel("#HOTEL SHREE#");
         j1.setBounds(480, 420, 300, 100);
          j1.setForeground(Color.blue);
          j1.setFont(new Font("serif",Font.BOLD,36));
          jframe.add(j1);
          
        
          
       /*    while(true)
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

        }*/
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        String name=tfname.getText();
        String age=tfage.getText();
        String salary=tfsalary.getText();
        String email=tfemail.getText();
        String adhar=tfadhar.getText();
        String phoneno=tfphone.getText();
        
        String gender=null;
        if(rb1.isSelected())
        {
            gender=rb1.getText();
        }
        else if (rb2.isSelected())
        {
            gender=rb2.getText();
        }
        String job=cbjobs.getSelectedItem().toString();
        
        try{
            String query="insert into employee_info values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phoneno+"','"+email+"','"+adhar+"')";
            Conn c=new Conn();
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee Data Added Successfully....");
           // jframe.setVisible(false);
           jframe.dispose();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String args[])
    {
        new AddEmployee();
    }
}
