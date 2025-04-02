import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.List;

public class PaymentSystemSwing extends JFrame{
    private static List<Payment> payments = new ArrayList<>();
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox1;
    private JButton showAllRecordButton;
    private JButton recordPaymentButton;
    private JPanel main2;
    private JScrollBar scrollBar1;
    private JTextArea textArea1;
    private JButton generateReceiptButton;
    private JTextField textField5;
    private JComboBox comboBox2;



    public PaymentSystemSwing(){
        setContentPane(main2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Record Payment");
        setLocationRelativeTo(null);
        setSize(700,400);


        recordPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String studentname = textField1.getText();
                    String studentId = textField2.getText();
                    double amount = Double.parseDouble(textField3.getText());
                    String course = textField5.getText();
                    String Semester = (String) comboBox2.getSelectedItem();
                    String date = textField4.getText();
                    String method = (String) comboBox1.getSelectedItem();

                    Payment payment = new Payment(studentname, studentId, amount,course,Semester,date, method);
                    payments.add(payment);
                    textArea1.append("Payment recorded: " + payment + "\n");
                     clearForm(textField1, textField2, textField3, textField4);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PaymentSystemSwing.this, "Please enter a valid amount!", "Error", JOptionPane.ERROR_MESSAGE);
    }}});

        showAllRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                if (payments.isEmpty()) {
                    textArea1.append("No payments recorded yet.\n");
                } else {
                    textArea1.append("╔══════════════════════════════╗\n");
                    textArea1.append("║      UNIVERSITY RECEIPT      ║\n");
                    textArea1.append("╠══════════════════════════════╣\n");

                    textArea1.append("╠══════════════════════════════╣\n");
                    textArea1.append("║         FEE DETAILS         ║\n");
                    textArea1.append("╠══════════════════════════════╣\n");
                    for (Payment p : payments) {
                        textArea1.append(p + "\n");
                        textArea1.append("\n");
                        textArea1.append("╠══════════════════════════════╣\n");
                        textArea1.append("║  This is computer generated  ║\n");
                        textArea1.append("║    receipt. No signature     ║\n");
                        textArea1.append("║         required.           ║\n");
                        textArea1.append("╚══════════════════════════════╝\n");
                    }
                }
            }
        });
        scrollBar1.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if(scrollBar1.getValueIsAdjusting()){
                    showAllRecordButton.setVisible(true);
                }
            }
        });}

    private static void clearForm(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }
}
class Payment {

    private String studname;
    private String studid;
    private double am;
    private String co;
    private String sem;
    private String date;
    private String Method;

    public Payment(String studentname, String studentId, double amount,String co,String sem, String paymentDate, String paymentMethod) {
        this.studname = studentname;
        this.studid = studentId;
        this.am = amount;
        this.co = co;
        this.sem = sem;
        this.date = paymentDate;
        this.Method = paymentMethod;
    }

    @Override
    public String toString() {
        return String.format("\n Student Name: %s\n"+" Student ID: %s\n"+" Amount: P%.2f\n"+"Course: %s\n"+"Semester: %s\nDate: %s\n"+" Method: %s",
                studname, studid, am,co,sem, date, Method);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaymentSystemSwing().setVisible(true);

            }
        });
    }
}