
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Reception implements ActionListener{
    JButton rooms,logout,customerform,department,allemp,customerinfo,managerinfo,roomsearch,updatestatus,pickservice,checkout;
    JFrame jframe=new JFrame();
    
    Reception()
    {
     
     jframe.getContentPane().setBackground(Color.lightGray);
     
     
     customerform=new JButton("New Customer Form");
     customerform.setBackground(Color.black);
     customerform.setForeground(Color.white);
     customerform.setBounds(50, 40,220, 30);
     jframe.add(customerform);
     customerform.addActionListener(this);
     
     
     
      rooms=new JButton("Room Information");
     rooms.setBackground(Color.black);
     rooms.setForeground(Color.white);
     rooms.setBounds(50, 85,220, 30);
     jframe.add(rooms);
     rooms.addActionListener(this);
     
      department=new JButton("Department Information");
     department.setBackground(Color.black);
     department.setForeground(Color.white);
     department.setBounds(50, 130,220, 30);
     jframe.add(department);
     department.addActionListener(this);
     
     allemp=new JButton("Employee Information");
     allemp.setBackground(Color.black);
     allemp.setForeground(Color.white);
      allemp.setBounds(50, 175,220, 30);
     jframe.add(allemp);
      allemp.addActionListener(this);
     
      customerinfo=new JButton("Customer Information");
     customerinfo.setBackground(Color.black);
     customerinfo.setForeground(Color.white);
     customerinfo.setBounds(50, 220,220, 30);
     jframe.add(customerinfo);
     customerinfo.addActionListener(this);
     
     managerinfo=new JButton("Manager Information");
     managerinfo.setBackground(Color.black);
     managerinfo.setForeground(Color.white);
     managerinfo.setBounds(50, 265,220, 30);
     jframe.add(managerinfo);
     managerinfo.addActionListener(this);
     
      checkout=new JButton("Checkout");
     checkout.setBackground(Color.black);
     checkout.setForeground(Color.white);
     checkout.setBounds(50, 310,220, 30);
     jframe.add(checkout);
     checkout.addActionListener(this);
     
     updatestatus=new JButton("Update Status");
     updatestatus.setBackground(Color.black);
     updatestatus.setForeground(Color.white);
     updatestatus.setBounds(50, 355,220, 30);
     jframe.add(updatestatus);
     updatestatus.addActionListener(this);
     
     JButton roomstatus=new JButton(" ");
     roomstatus.setBackground(Color.black);
     roomstatus.setForeground(Color.white);
     roomstatus.setBounds(50, 400,220, 30);
     jframe.add(roomstatus);
     
     pickservice=new JButton("Pickup Serice");
     pickservice.setBackground(Color.black);
     pickservice.setForeground(Color.white);
     pickservice.setBounds(50, 445,220, 30);
     jframe.add(pickservice);
     pickservice.addActionListener(this);
     
      roomsearch=new JButton("Search Room");
     roomsearch.setBackground(Color.black);
     roomsearch.setForeground(Color.white);
     roomsearch.setBounds(50, 490,220, 30);
     jframe.add(roomsearch);
     roomsearch.addActionListener(this);
     
     logout=new JButton("Logout");
     logout.setBackground(Color.black);
    logout.setForeground(Color.white);
     logout.setBounds(50, 535,220, 30);
     jframe.add(logout);
     logout.addActionListener(this);
     
     ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("icons/reception.jpg"));
     Image i2=image1.getImage().getScaledInstance(550, 530,Image.SCALE_DEFAULT);
     ImageIcon image2=new ImageIcon(i2);
     JLabel i1=new JLabel(image2);
     i1.setBounds(320,40,550,530);
     jframe.add(i1);
     
     jframe.setSize(950,650);
     jframe.setLayout(null);
     jframe.setVisible(true);
     jframe.setLocation(200, 100);
     
     
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==customerform){
            jframe.setVisible(false);
            new AddNewCustomer();
        }else if(ae.getSource()==rooms){
            jframe.setVisible(false);
            new Rooms();
        }else if(ae.getSource()==department){
            jframe.setVisible(false);
            new Department();
        }else if(ae.getSource()==allemp){
            jframe.setVisible(false);
            new Employeeinfo();
        }else if(ae.getSource()==customerinfo){
            jframe.setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource()==managerinfo){
            jframe.setVisible(false);
            new ManagerInfo();
        }else if(ae.getSource()==roomsearch)
        {
            jframe.setVisible(false);
            new SearchRoom();
        }else if(ae.getSource()==updatestatus){
            jframe.setVisible(false);
            new UpdateCheck();
        }else if(ae.getSource()==pickservice){
            jframe.setVisible(false);
            new PickService();
        }else if(ae.getSource()==checkout){
            jframe.setVisible(false);
            new CheckOut();
        }else if(ae.getSource()==logout){
            jframe.setVisible(false);
            new DashBoard();
        }
    }
    public static void main(String args[]){
        new Reception();
    }
    
    
}
