package banksystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton back;
    String pinnumber;
    BalanceEnquiry (String pinnumber) {
    this.pinnumber = pinnumber;
    setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT); 
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);   
    image.setBounds(0,0,750,750);
    add(image); 

     back = new JButton("Back");
     back.setBounds(300,420,130,30);
     back.addActionListener(this);
     image.add(back);


      Conn c = new Conn();
      int balance = 0;
            try {
                ResultSet rs = c.s.executeQuery("Select * from bank where pin ='"+pinnumber+"'");
                 while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                 }
            }catch(Exception e) {
                System.out.println(e);
            } 

         JLabel text = new JLabel("Your Current Account balance is Rs " + balance);
         text.setForeground(Color.WHITE);
         text.setBounds(150,250,350,25);
         image.add(text);   

        setSize(750,750);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
