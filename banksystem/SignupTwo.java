package banksystem;
import com.toedter.calendar.*;

import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
  
 
  JTextField pantext ,aadhar;
  JButton next;
  JRadioButton syes, no, eyes, eno;
  
  
  JComboBox religionCBox,category,income,education,occupation;
  String formno;
  SignupTwo(String formno) {
     this.formno = formno;
     setLayout(null);
     
      setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

     
     JLabel additionalDetails = new JLabel("Page 2: Additional Details");
     additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
     additionalDetails.setBounds(290,80,400,30);
     add(additionalDetails); 


     
     JLabel religion = new JLabel("Religion: ");
     religion.setFont(new Font("Raleway",Font.BOLD,20));
     religion.setBounds(100,140,100,30);
     add(religion); 
     
     String [] valReligion = {"Hindu","Muslim","Sikh","Christian","Other"};
      religionCBox = new JComboBox<>(valReligion);
      religionCBox .setBounds(300,140,400,30);
      religionCBox.setBackground(Color.WHITE);
      add(religionCBox);
      
    
      
     JLabel fname = new JLabel("Category: ");
     fname.setFont(new Font("Raleway",Font.BOLD,20));
     fname.setBounds(100,190,200,30);
     add(fname); 

     String valCategory[] = {"General","OBC","SC","ST","Other"};
     category = new JComboBox<>(valCategory);
     category.setBounds(300,190,400,30);
     category.setBackground(Color.WHITE);
     add(category);

     
     JLabel dob = new JLabel("Income: ");
     dob.setFont(new Font("Raleway",Font.BOLD,20));
     dob.setBounds(100,240,200,30);
     add(dob); 

      String incomeCategory[] = {"Null","< 1,50,000","< 2,50,00","< 5,00,000","Upto 10,00,000"};
     income = new JComboBox<>(incomeCategory);
     income.setBounds(300,240,400,30);
     income.setBackground(Color.WHITE);
     add(income);

    

     JLabel gender = new JLabel("Educational: ");
     gender.setFont(new Font("Raleway",Font.BOLD,20));
     gender.setBounds(100,290,200,30);
     add(gender); 

 

     JLabel email = new JLabel("Qualification: ");
     email.setFont(new Font("Raleway",Font.BOLD,20));
     email.setBounds(100,315,200,30);
     add(email); 

     String educationValues[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
     education = new JComboBox<>(educationValues);
     education.setBounds(300,315,400,30);
     education.setBackground(Color.WHITE);
     add(education);
   
     
     JLabel maritalStatus = new JLabel("Occupation: ");
     maritalStatus.setFont(new Font("Raleway",Font.BOLD,20));
     maritalStatus.setBounds(100,390,200,30);
     add(maritalStatus); 

     
     String occupationValues[] = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
      occupation = new JComboBox<>(occupationValues);
     occupation.setBounds(300,390,400,30);
     occupation.setBackground(Color.WHITE);
     add(occupation);
     
     

    
     JLabel pan = new JLabel("PAN Number: ");
     pan.setFont(new Font("Raleway",Font.BOLD,20));
     pan.setBounds(100,440,200,30);
     add(pan); 

     pantext = new JTextField();  
     pantext.setFont(new Font("Raleway", Font.BOLD,14));
     pantext.setBounds(300,440,400,30);
     add(pantext);
    

     JLabel city = new JLabel("Aadhar No: ");
     city.setFont(new Font("Raleway",Font.BOLD,20));
     city.setBounds(100,490,200,30);
     add(city); 


     aadhar = new JTextField();  
     aadhar.setFont(new Font("Raleway", Font.BOLD,14));
     aadhar.setBounds(300,490,400,30);
     add(aadhar);
    
     
     JLabel state = new JLabel("Senior Citizen: ");
     state.setFont(new Font("Raleway",Font.BOLD,20));
     state.setBounds(100,540,200,30);
     add(state); 

     syes = new JRadioButton("Yes");
     syes.setBounds(300,540,100,30);
     syes.setBackground(Color.WHITE);
     add(syes);


      no = new JRadioButton("No");
      no.setBounds(450,540,100,30);
      no.setBackground(Color.WHITE);
      add(no);
     
      
      ButtonGroup mgGroup = new ButtonGroup();
      mgGroup.add(syes);
      mgGroup.add(no);

     JLabel pincode = new JLabel("Existing Account: ");
     pincode.setFont(new Font("Raleway",Font.BOLD,20));
     pincode.setBounds(100,590,200,30);
     add(pincode); 

     eyes = new JRadioButton("Yes");
     eyes.setBounds(300,590,100,30);
     eyes.setBackground(Color.WHITE);
     add(eyes);


      eno = new JRadioButton("No");
      eno.setBounds(450,590,100,30);
      eno.setBackground(Color.WHITE);
      add(eno);
     
      
      ButtonGroup group = new ButtonGroup();
      group.add(syes);
      group.add(eno);
  


     next = new JButton("Next");
     next.setBackground(Color.BLACK);
     next.setForeground(Color.WHITE);
     next.setFont(new Font("Raleway", Font.BOLD,14));
     next.setBounds(620,660,80,30);
     next.addActionListener(this);
     add(next);


     getContentPane().setBackground(Color.WHITE);
     
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
     
    }


    public void actionPerformed(ActionEvent ae){
       String religion  = (String) religionCBox.getSelectedItem();
       String scategory = (String) category.getSelectedItem();
       String sincome =   (String) income.getSelectedItem();;
       String seducation = (String) education.getSelectedItem();
       String soccupation = (String) occupation.getSelectedItem();
      
       String seniorCitizen = null;
      
       if (syes.isSelected()) {
           seniorCitizen = "Yes";
       }else if (no.isSelected()) {
         seniorCitizen = "No";
       }

       String exisitingaccount = null;

       if (eyes.isSelected()) {
         exisitingaccount = "Yes"; 
       }else if (eno.isSelected()) {
        exisitingaccount = "No";
      }

      String span = pantext.getText();
      String saadhar = aadhar.getText();
     

      try {
        Conn c = new Conn();
        String query = "insert into signuptwo values('"+formno+"', '"+religion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorCitizen+"', '"+exisitingaccount+"')";
        c.s.executeUpdate(query);
        
        //SignupThree object
        setVisible(false);
        new SignupThree(formno).setVisible(true);;
      }catch(Exception e) {
         System.out.println(e);
   } 
   }

    public static void main(String[] args) {
      new SignupTwo("");   
    }
}