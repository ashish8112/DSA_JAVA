package DSA.College_Lab;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Login{
public static void main(String [] args )
{
JFrame frame = new JFrame("Login Page ");
frame.setLayout(new GridLayout(3,2,5,5));
JLabel label1= new JLabel("Username");
JTextField username = new JTextField(10);
JLabel label2 = new JLabel("Password");
JTextField password = new JTextField(10);
JButton button1 = new JButton("Login");
button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Welcome");
            } 
        });
JButton button2= new JButton("Register");
    button2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(() -> {
                new StudentRegistration().setVisible(true);
            });
            frame.dispose(); // close login window (optional)
        }
    });


frame.add(label1);
frame.add(username);
frame.add(label2);
frame.add(password);
frame.setSize(600,200);
frame.add(button1);
frame.add(button2);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
}
}
