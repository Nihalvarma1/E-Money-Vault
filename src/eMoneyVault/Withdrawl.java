package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener
{
    JButton withdraw, back;
    JTextField amount;
    String pinnumber;
    
    Withdrawl(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter The Amount You Want To Withdrawl");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
      
    }
    
//    public void actionPerformed(ActionEvent ae)
//    {
//        if(ae.getSource() == withdraw)
//        {
//            String number = amount.getText();
//            Date date = new Date();
//            if(number.equals(""))
//                JOptionPane.showMessageDialog(null, "Enter a Valid Amount");
//            else
//            {
//                try
//                {
//                    Conn c = new Conn();
//                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
//                    c.s.executeUpdate(query);
//                    JOptionPane.showMessageDialog(null, "Rs. "+number+" Withdrawed Successfully."); 
//                    setVisible(false);
//                    new Transactions(pinnumber).setVisible(true);
//                }
//                catch(Exception e)
//                {
//                    System.out.println(e);
//                }
//            }
//        }
//        else if(ae.getSource() == back)
//        {
//            setVisible(false);
//            new Transactions(pinnumber).setVisible(true);
//        }
//    }
    
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource() == withdraw)
         {
            String number = amount.getText();
            try
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                        balance += Integer.parseInt(rs.getString("amount")); 
                    else
                        balance -= Integer.parseInt(rs.getString("amount")); 
                }
                if(ae.getSource()!= back && balance < Integer.parseInt(number))
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl','"+number+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+number+" Withdrawed Successfully.");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
         }
         else if(ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main(String args[]) 
    {
        new Withdrawl("");
    }
}
