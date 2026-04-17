package banksystem;

import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{
   JTextField amount;
    JButton deposit, back;
    String pinnumber;

    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
     setLayout(null);

      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(0,0,750,750);
      add(image);

      JLabel text = new JLabel("Enter the amount you want to deposit");
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System",Font.BOLD,16));
         text.setBounds(130,250,300,15);
         image.add(text);

         amount = new JTextField();
         amount.setFont(new Font("Raleway",Font.BOLD,16));
         amount.setBounds(130,275,300,20);
         image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(290,380,140,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        back = new JButton("Exit");
        back.setBounds(290,420,140,20);
        back.addActionListener(this);
        image.add(back);


        setSize(750,750);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"','Deposit' , '"+number+"')";
                    conn.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null, "Rs" + number+"Deposited Successfully");
                   setVisible(false);
                   new Transaction(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource() == back){
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
