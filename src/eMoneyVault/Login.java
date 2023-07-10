package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);//removing the border layout so that image/component is not centered.
        
        //Adding an image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//create an image
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);//altering the size of image
        ImageIcon i3 = new ImageIcon(i2);//changing modified image back to imageicon
        JLabel label = new JLabel(i3);//jlabel is needed for add component
        label.setBounds(70,10,100,100);//setting the location of label/image(boderlayout should be removed).
        add(label);//adding component/image
        
        //adding title
        JLabel text = new JLabel("Welcome To ATM");//add the title inside frame
        text.setFont(new Font("Osward",Font.BOLD,38));//setting the font of component/text
        text.setBounds(200,40,400,40);//setting the location of that title
        add(text);//adding component
        
        //adding cardno
        JLabel cardno = new JLabel("Card No:");//add the text inside frame
        cardno.setFont(new Font("Raleway",Font.BOLD,28));//setting the font of component/text
        cardno.setBounds(120,150,150,30);//setting the location of that text
        add(cardno);//adding component
        
        //adding textfield to cardno
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        //adding PIN
        JLabel pin = new JLabel("PIN:");//add the pin text inside frame
        pin.setFont(new Font("Raleway",Font.BOLD,28));//setting the font of component/text
        pin.setBounds(120,220,250,30);//setting the location of that text
        add(pin);//adding component
        
        //adding textfield to cardno
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        //for creating a signin button
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);//button color
        login.setForeground(Color.WHITE);//text color in button
        login.addActionListener(this);
        add(login);
        
        //for creating a clear button
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);//button color
        clear.setForeground(Color.WHITE);//text color in button
        clear.addActionListener(this);
        add(clear);
        
        //for creating a signup button
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);//button color
        signup.setForeground(Color.WHITE);//text color in button
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);//setting the background color
        
        setSize(800,480);//size of frame
        setVisible(true);//to show the frame to user(by default it is not visible)
        setLocation(350,200);//location of frame on the screen
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login)
        {
            Conn c = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardnumber+"' and pinNumber = '"+pinnumber+"'";
            try
            {
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String args[]) 
    {
        Login l = new Login();
    }
}
