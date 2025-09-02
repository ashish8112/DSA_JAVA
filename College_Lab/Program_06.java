package DSA.College_Lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StudentRegistration extends JFrame implements ActionListener {
    private JTextField nameField, ageField, contactField, fatherNameField, incomeField;	// Variables of TextField , Button and Creating Panel as well as giving size 
    private JButton submitButton;

    public StudentRegistration() {
        setTitle("Student Registration Form");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));				             //Giving size to panel or window of Student Registration

        add(new JLabel("Name :"));
        nameField = new JTextField(10);
        add(nameField);

        add(new JLabel("Age :"));
        ageField = new JTextField(10);
        add(ageField);

        add(new JLabel("Contact :"));
        contactField = new JTextField(10);
        add(contactField);

        add(new JLabel("Father's Name :"));
        fatherNameField = new JTextField(10);
        add(fatherNameField);

        add(new JLabel("Annual Income :"));
        incomeField = new JTextField(10);
        add(incomeField);

        add(new JLabel(""));  // Empty cell for spacing

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {		// Here we are  getting values.
        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();
        String contact = contactField.getText().trim();
        String fatherName = fatherNameField.getText().trim();
        String incomeText = incomeField.getText().trim();

        if (name.isEmpty() || fatherName.isEmpty() || ageText.isEmpty() || contact.isEmpty() || incomeText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
            if (age < 3 || age > 45) {
                JOptionPane.showMessageDialog(this, "Age must be between 3 and 45!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Age must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!contact.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Contact must be a 10-digit number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double income;
        try {
            income = Double.parseDouble(incomeText);
            if (income < 0) {
                JOptionPane.showMessageDialog(this, "Income cannot be less than 0!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Income must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Registration Successful!\n\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Contact: " + contact + "\n" +
                "Father's Name: " + fatherName + "\n" +
                "Annual Income: " + income,
                "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentRegistration().setVisible(true);
        });
    }
}
