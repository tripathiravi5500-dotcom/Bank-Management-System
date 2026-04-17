package banksystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class Transaction extends JFrame implements ActionListener{

    JButton deposit, withdraw, fastcash, ministatement, pinchange, balance, exit;
    String pinnumber;
    Transaction(String pinnumber) {
       this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);


        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(170,215,500,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
 
     deposit = new JButton("Deposit");
        deposit.setBounds(140,300,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(300,300,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

     fastcash = new JButton("Fast Cash");
        fastcash.setBounds(300,335,150,30);
       fastcash.addActionListener(this);
        image.add(fastcash);


     ministatement = new JButton("Mini Statement");
        ministatement.setBounds(300,370,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

     pinchange = new JButton("Pin Change");
        pinchange.setBounds(140,335,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        
        balance = new JButton("Balance Enquiry");
        balance.setBounds(140,370,150,30);
        balance.addActionListener(this);
        image.add(balance);
      
     exit = new JButton("Exit");
        exit.setBounds(340,405,100,20);
        exit.addActionListener(this);
        image.add(exit);

        setSize(800,730);
        setLocation(300,0);
        // setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
         if (ae.getSource() == exit) {
            System.exit(0);
         }else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);

         }else if (ae.getSource() == withdraw) {
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
         }else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
         }else if (ae.getSource() == pinchange){
          setVisible(false);
          new PinChange(pinnumber).setVisible(true);
         }else if (ae.getSource() == balance) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
         }else if (ae.getSource() == ministatement) {
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
         }
    }


public static void main(String[] args) {
    new Transaction("");
}    
}
