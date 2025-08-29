package DSA.College_Lab;

import javax.swing.*;
import java.awt.event.*;
class Demo{
public static void main(String args[])
{
JFrame frame= new JFrame("Swing Example");
JButton button = new JButton("Click Me");

button.addActionListener(new ActionListener(){
public void actionPerformed (ActionEvent e){
JOptionPane.showMessageDialog(frame,"Button Clicked!");
}
});
frame.add(button);
frame.setSize(300,200);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}
}
