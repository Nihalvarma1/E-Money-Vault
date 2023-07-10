package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener
{
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JDateChooser date;
    JButton next;
    JRadioButton male, female, other, married, unmarried, other_status;
    SignupOne()
    {
        setLayout(null);
        setTitle("New Account Application Form - Page 1");
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel persondetails = new JLabel("Page 1: Personal Details");
        persondetails.setFont(new Font("Raleway",Font.BOLD,22));
        persondetails.setBounds(290,80,270,30);
        add(persondetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        date = new JDateChooser();
        date.setBounds(300,240,400,30);
        date.setForeground(new Color(105,105,105));
        add(date);
                
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,70,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        other = new JRadioButton("Other");
        other.setBounds(610,290,60,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        //making all radio buttons together so that only one selected
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        JLabel maritial = new JLabel("Maritial Status:");
        maritial.setFont(new Font("Raleway",Font.BOLD,20));
        maritial.setBounds(100,390,200,30);
        add(maritial);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,80,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,90,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other_status = new JRadioButton("Other");
        other_status.setBounds(610,390,60,30);
        other_status.setBackground(Color.WHITE);
        add(other_status);
        
        //making all radio buttons together so that only one selected
        ButtonGroup marriedgroup = new ButtonGroup();
        marriedgroup.add(married);
        marriedgroup.add(unmarried);
        marriedgroup.add(other_status);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)date.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected())
            gender="Male";
        else if(female.isSelected())
            gender="Female";
        else if(other.isSelected())
            gender="Other";
        String email = emailTextField.getText();
        String maritial = null;
        if(married.isSelected())
            maritial = "Married";
        else if(unmarried.isSelected())
            maritial = "Unmarried";
        else if(other_status.isSelected())
            maritial = "Other";
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try
        {
            if(name.equals(""))
                JOptionPane.showMessageDialog(null, "Name is Required");
            else if(fname.equals(""))
                JOptionPane.showMessageDialog(null, "Father's Name is Required");
            else if(dob.equals(""))
                JOptionPane.showMessageDialog(null, "Date of Birth is Required");
            else if(gender==null)
                JOptionPane.showMessageDialog(null, "Gender is Required");
            else if(email.equals(""))
                JOptionPane.showMessageDialog(null, "Email Address is Required");
            else if(maritial==null)
                JOptionPane.showMessageDialog(null, "Maritial Status is Required");
            else if(address.equals(""))
                JOptionPane.showMessageDialog(null, "Address is Required");
            else if(city.equals(""))
                JOptionPane.showMessageDialog(null, "City is Required");
            else if(state.equals(""))
                JOptionPane.showMessageDialog(null, "State is Required");
            else if(pin.equals(""))
                JOptionPane.showMessageDialog(null, "Pin Code is Required");
            else
            {
                Conn c = new Conn();
                String query = "insert into signupone values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritial+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    public static void main(String args[]) 
    {
        new SignupOne();
    }
}
