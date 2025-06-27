import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class KuisPenjumlahan extends JFrame {
    private JTextField num1Field, num2Field, answerField, resultField;
    private JButton checkButton;
    private int num1, num2;
    private Random random;

    public KuisPenjumlahan() {
        // Inisialisasi komponen
        random = new Random();
        num1Field = new JTextField(5);
        num2Field = new JTextField(5);
        answerField = new JTextField(5);
        resultField = new JTextField(20);
        checkButton = new JButton("Check");
        
        // Set field tidak bisa diubah
        num1Field.setEditable(false);
        num2Field.setEditable(false);
        resultField.setEditable(false);
        
        // Generate angka acak
        generateNumbers();
        
        // Layout
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Angka 1:"));
        panel.add(num1Field);
        panel.add(new JLabel("Angka 2:"));
        panel.add(num2Field);
        panel.add(new JLabel("Jawaban Anda:"));
        panel.add(answerField);
        panel.add(checkButton);
        panel.add(resultField);
        
        // Event handler untuk tombol check
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });
        
        // Frame setup
        this.add(panel);
        this.setTitle("Kuis Penjumlahan");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void generateNumbers() {
        num1 = random.nextInt(10) + 1; // Angka 1-10
        num2 = random.nextInt(10) + 1;
        num1Field.setText(Integer.toString(num1));
        num2Field.setText(Integer.toString(num2));
        answerField.setText("");
        resultField.setText("");
        getContentPane().setBackground(Color.WHITE);
    }
    
    private void checkAnswer() {
        try {
            int answer = Integer.parseInt(answerField.getText());
            if (answer == num1 + num2) {
                resultField.setText("Selamat, Jawaban Anda Benar!");
                getContentPane().setBackground(Color.GREEN);
                // Setelah 2 detik, generate soal baru
                Timer timer = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        generateNumbers();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            } else {
                resultField.setText("Maaf, Jawaban Anda Salah");
                getContentPane().setBackground(Color.RED);
            }
        } catch (NumberFormatException ex) {
            resultField.setText("Masukkan angka yang valid!");
            getContentPane().setBackground(Color.YELLOW);
        }
    }
    
    public static void main(String[] args) {
        new KuisPenjumlahan();
    }
}