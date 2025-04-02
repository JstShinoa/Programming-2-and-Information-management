import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchoolfeeSystem extends JFrame{
    private JButton login;
    private JButton exitButton;
    private JPanel mainer;

    public SchoolfeeSystem() {
        setTitle("School Fee System");
        setContentPane(mainer);
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(login.isSelected()){

                }
                else {
                    new Register().setVisible(true);
                }

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        SchoolfeeSystem.this,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    dispose();
                }

                if(exitButton.isSelected()) {
                }
                else {
                    JOptionPane.showMessageDialog(SchoolfeeSystem.this, "Thank you for visiting");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new SchoolfeeSystem().setVisible(true);
            }
        });
    }

}


