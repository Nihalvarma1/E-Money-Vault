package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener
{
    JComboBox religion, category, income, education, occupation;
    JTextField pan, aadhar;
    JDateChooser date;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    String formno;
    SignupTwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("New Account Application Form - Page 2");
        
        JLabel formnum = new JLabel("APPLICATION FORM NO. "+ formno);
        formnum.setFont(new Font("Raleway",Font.BOLD,38));
        formnum.setBounds(140,20,600,40);
        add(formnum);
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,300,30);
        add(additionalDetails);
        
        JLabel religionLabel = new JLabel("Religion:");
        religionLabel.setFont(new Font("Raleway",Font.BOLD,20));
        religionLabel.setBounds(100,140,100,30);
        add(religionLabel);
        
        String[] valReligion = {"Hindu","Muslim","Christian","Sikh","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(new Font("Raleway",Font.BOLD,20));
        categoryLabel.setBounds(100,190,200,30);
        add(categoryLabel);
        
        String[] valCategory = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);        
        
        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway",Font.BOLD,20));
        incomeLabel.setBounds(100,240,200,30);
        add(incomeLabel);
        
        String[] incomeCategory = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
                
        JLabel eduLabel = new JLabel("Educational");
        eduLabel.setFont(new Font("Raleway",Font.BOLD,20));
        eduLabel.setBounds(100,290,200,30);
        add(eduLabel);
        
        JLabel QLabel = new JLabel("Qualification:");
        QLabel.setFont(new Font("Raleway",Font.BOLD,20));
        QLabel.setBounds(100,315,200,30);
        add(QLabel);
        
        String[] educationValues = {"Non-Graduate","Graduate","Post-Graduate","Doctarate","Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel occLabel = new JLabel("Occupation:");
        occLabel.setFont(new Font("Raleway",Font.BOLD,20));
        occLabel.setBounds(100,390,200,30);
        add(occLabel);
        
        String[] occupationValues = {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,395,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel panLabel = new JLabel("PAN Number:");
        panLabel.setFont(new Font("Raleway",Font.BOLD,20));
        panLabel.setBounds(100,440,200,30);
        add(panLabel);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel aadharLabel = new JLabel("Aadhar Number:");
        aadharLabel.setFont(new Font("Raleway",Font.BOLD,20));
        aadharLabel.setBounds(100,490,200,30);
        add(aadharLabel);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel citizenLabel = new JLabel("Senior Citizen:");
        citizenLabel.setFont(new Font("Raleway",Font.BOLD,20));
        citizenLabel.setBounds(100,540,200,30);
        add(citizenLabel);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,80,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,90,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        //making all radio buttons together so that only one selected
        ButtonGroup citizengroup = new ButtonGroup();
        citizengroup.add(syes);
        citizengroup.add(sno);
        
        JLabel accLabel = new JLabel("Existing Account:");
        accLabel.setFont(new Font("Raleway",Font.BOLD,20));
        accLabel.setBounds(100,590,200,30);
        add(accLabel);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,80,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,90,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        //making all radio buttons together so that only one selected
        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(eyes);
        accountgroup.add(eno);
        
        
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
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String span = pan.getText();
        String saadhar = aadhar.getText();
        String seniorcitizen = null;
        if(syes.isSelected())
            seniorcitizen="Yes";
        else if(sno.isSelected())
            seniorcitizen="No";
        String existingaccount = null;
        if(eyes.isSelected())
            existingaccount = "Yes";
        else if(eno.isSelected())
            existingaccount = "No";
        try
        {
            if(span.equals(""))
                JOptionPane.showMessageDialog(null, "PAN Number is Required");
            else if(saadhar.equals(""))
                JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
            else if(seniorcitizen==null)
                JOptionPane.showMessageDialog(null, "Senior Citizen Field is Required");
            else if(existingaccount==null)
                JOptionPane.showMessageDialog(null, "Existing Account Information is Required");
            else
            {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    public static void main(String args[]) 
    {
        new SignupTwo("---");
    }
}
