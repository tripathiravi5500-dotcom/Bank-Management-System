
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

public class Withdraw extends JFrame implements ActionListener{
   JTextField amount;
    JButton withdraw, back;
    String pinnumber;

    Withdraw(String pinnumber){
        this.pinnumber = pinnumber;
     setLayout(null);

      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(0,0,750,750);
      add(image);

      JLabel text = new JLabel("Enter the amount you want to Withdraw");
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System",Font.BOLD,16));
         text.setBounds(130,250,300,15);
         image.add(text);

         amount = new JTextField();
         amount.setFont(new Font("Raleway",Font.BOLD,16));
         amount.setBounds(130,275,300,20);
         image.add(amount);

         withdraw = new JButton("WithDraw");
         withdraw.setBounds(290,380,140,20);
         withdraw.addActionListener(this);
         image.add(withdraw);
        
        
        back = new JButton("Exit");
        back.setBounds(290,420,140,20);
        back.addActionListener(this);
        image.add(back);


        setSize(750,750);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            }else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"','Withdraw' , '"+number+"')";
                    conn.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null, "Rs" + number+"Withdraw Successfully");
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
        new Withdraw("");
    }
}
