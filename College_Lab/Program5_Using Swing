//Write a Java Program to Create a Swing program for student Registration containing all the fields Name, Age , Contact,Father's Name , Annual Income and a submit button.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Student{
public static void main(String args[])
{
JFrame frame = new JFrame("Swing Example");
frame.setLayout(new FlowLayout());
frame.setLayout(new GridLayout(10,10,4,4));
JLabel label1 = new JLabel("Name");
JTextField nameField = new JTextField(10);
JLabel label2 = new JLabel("Age");
JTextField  ageField = new JTextField(10);
JLabel label3 = new JLabel("Contact");;
JTextField contactField = new JTextField(10);
JLabel label4 = new JLabel("Father'sName");
JTextField fatherNameField  = new JTextField(10);
JLabel label5 = new JLabel("Income");
JTextField incomeField = new JTextField(10);
JButton button = new JButton("Submit");
button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Submit");
            } 
        });

frame.add(label1);
frame.add(nameField);
frame.add(label2);;
frame.add( ageField);


frame.add(label3);
frame.add(contactField);
frame.add(label4);
frame.add(fatherNameField);
frame.add(label5);
frame.add( incomeField);
frame.setSize(600, 600);
frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }	
}

