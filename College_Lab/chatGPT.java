import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DummyLoginRegister {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage());
    }
}

class LoginPage extends JFrame {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginBtn, registerBtn;

    LoginPage() {
        setTitle("Dummy Student Login");
        setSize(300, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginBtn = new JButton("Login");
        registerBtn = new JButton("Register");

        panel.add(loginBtn);
        panel.add(registerBtn);

        add(panel);
        setVisible(true);

        loginBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Welcome, " + usernameField.getText() + "!");
        });

        registerBtn.addActionListener(e -> {
            dispose();
            new RegisterPage();
        });
    }
}

class RegisterPage extends JFrame {
    JTextField nameField, rollnoField, emailField, phoneField;
    JButton registerBtn, backBtn;

    RegisterPage() {
        setTitle("Dummy Student Registration");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Roll No:"));
        rollnoField = new JTextField();
        panel.add(rollnoField);

        panel.add(new JLabel("Email ID:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        panel.add(phoneField);

        registerBtn = new JButton("Register");
        backBtn = new JButton("Back to Login");

        panel.add(registerBtn);
        panel.add(backBtn);

        add(panel);
        setVisible(true);

        registerBtn.addActionListener(e -> {
            // Show entered data in a dialog as confirmation
            String info = String.format(
                "Name: %s\nRoll No: %s\nEmail: %s\nPhone: %s\n\n(Registration not really saved!)",
                nameField.getText(),
                rollnoField.getText(),
                emailField.getText(),
                phoneField.getText()
            );
            JOptionPane.showMessageDialog(this, info, "Registration Info", JOptionPane.INFORMATION_MESSAGE);
        });

        backBtn.addActionListener(e -> {
            dispose();
            new LoginPage();
        });
    }
}
