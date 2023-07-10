package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener
{
    JRadioButton savingAcc,FDAcc,currAcc,RDAcc;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
    SignupThree(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        
        getContentPane().setBackground(Color.WHITE);
        
        setTitle("New Account Application Form - Page 3");
        
        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,25));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type :");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        savingAcc = new JRadioButton("Saving Account");
        savingAcc.setFont(new Font("Raleway",Font.BOLD,16));
        savingAcc.setBackground(Color.WHITE);
        savingAcc.setBounds(100,200,150,20);
        add(savingAcc);
        
        FDAcc = new JRadioButton("Fixed Deposit Account");
        FDAcc.setFont(new Font("Raleway",Font.BOLD,16));
        FDAcc.setBackground(Color.WHITE);
        FDAcc.setBounds(350,200,200,20);
        add(FDAcc);
        
        currAcc = new JRadioButton("Current Account");
        currAcc.setFont(new Font("Raleway",Font.BOLD,16));
        currAcc.setBackground(Color.WHITE);
        currAcc.setBounds(100,240,150,20);
        add(currAcc);
        
        RDAcc = new JRadioButton("Recurring Deposit Account");
        RDAcc.setFont(new Font("Raleway",Font.BOLD,16));
        RDAcc.setBackground(Color.WHITE);
        RDAcc.setBounds(350,240,250,20);
        add(RDAcc);
        
        ButtonGroup acc = new ButtonGroup();
        acc.add(savingAcc);
        acc.add(FDAcc);
        acc.add(currAcc);
        acc.add(RDAcc);
        
        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4148");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        
        JLabel carddetail = new JLabel("Your 16 Digits Card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,330,300,20);
        add(carddetail);
        
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);
        
        JLabel pindetail = new JLabel("Your 16 PIN Number");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,400,300,20);
        add(pindetail);
        
        JLabel services = new JLabel("Services Required :");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,250,30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBackground(Color.WHITE);
        c6.setBounds(350,600,200,30);
        add(c6);  
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,680,600,30);
        add(c7);
     
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accountType=null;
            if(savingAcc.isSelected())
                accountType="Saving Account";
            else if(currAcc.isSelected())
                accountType="Current Account";
            else if(FDAcc.isSelected())
                accountType="Fixed Deposit Account";
            else if(RDAcc.isSelected())
                accountType="Recurring Deposit Account";
            
            Random random = new Random();
            String cardNumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            String pinNumber = "" + Math.abs((random.nextLong()%9000L)+1000L);
            
            String facility = "";
            if(c1.isSelected())
                facility+=" ATM CARD";
            if(c2.isSelected())
                facility+=" Internet Banking";
            if(c3.isSelected())
                facility+=" Mobile Banking";
            if(c4.isSelected())
                facility+=" Email & SMS Alerts";
            if(c5.isSelected())
                facility+=" Cheque Book";
            if(c6.isSelected())
                facility+=" E-Statement";
            
            boolean declaration = false;
            if((c7.isSelected()))
                declaration = true;
            
            try
            {
                if(accountType==null)
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                else if(declaration==false)
                    JOptionPane.showMessageDialog(null,"Tick the Declaration");                    
                else
                {
                    Conn c = new Conn();
                    String query = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String query1 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardNumber+"\nPIN Number : "+pinNumber);                    
                    
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]) 
    {
        new SignupThree("");
    }
}
