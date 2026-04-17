package banksystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{

    JButton deposit, withdraw, fastcash, ministatement, pinchange, balance, exit;
    String pin;
    
    FastCash(String pin) {
       this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);


        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(170,215,500,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
 
        deposit = new JButton("Rs 100");
        deposit.setBounds(140,300,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Rs 500");
        withdraw.setBounds(300,300,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(300,335,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);


        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(300,370,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(140,335,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        
        balance = new JButton("Rs 10000");
        balance.setBounds(140,370,150,30);
        balance.addActionListener(this);
        image.add(balance);
      
        exit = new JButton("BACK");
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
            setVisible(false);
            new Transaction(pin).setVisible(true);
         }else {
           String amount = ((JButton)ae.getSource()).getText().substring(3);
           Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("Select * from bank where pin ='"+pin+"'");
                 int balance = 0;
                 while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                 } 

                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pin+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
             
                setVisible(false);
                new Transaction(pin).setVisible(true);
            
            } catch (Exception e) {
             System.out.println(e);    
            }
         }
    }


public static void main(String[] args) {
    new FastCash("");
}    
}
