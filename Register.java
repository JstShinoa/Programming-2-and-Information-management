import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    private JTextField textField1;
    private JButton registerStudentButton;
    private JButton backToMainMenuButton;
    private JPanel main;
    private JPasswordField passwordField1;
    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "password123";

    public Register() {
        setContentPane(main);
        setTitle("Login Form");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        registerStudentButton.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        String username = textField1.getText();
                                                        String password = new String(passwordField1.getPassword());
                                                        if (username.isEmpty() || password.isEmpty()) {
                                                            JOptionPane.showMessageDialog(Register.this,
                                                                    "Username and password cannot be empty",
                                                                    "Error",
                                                                    JOptionPane.ERROR_MESSAGE);
                                                        } else if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
                                                            JOptionPane.showMessageDialog(Register.this,
                                                                    "Login successful!",
                                                                    "Success",
                                                                    JOptionPane.INFORMATION_MESSAGE);
                                                            new PaymentSystemSwing().setVisible(true);
                                                        } else {
                                                            JOptionPane.showMessageDialog(Register.this,
                                                                    "Invalid username or password",
                                                                    "Error",
                                                                    JOptionPane.ERROR_MESSAGE);
                                                            passwordField1.setText("");
                                                        }


                                                    }
                                                });

        backToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (backToMainMenuButton.isSelected()){
                    dispose();
                }
                else {

                    JOptionPane.showMessageDialog(Register.this,
                            "Returning to main menu...",
                            "Info", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Register().setVisible(true);
            }
        });
        }}


