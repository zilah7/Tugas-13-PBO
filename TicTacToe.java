import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame {
    private JButton[] buttons;
    private boolean isXTurn;
    
    public TicTacToe() {
        // Inisialisasi komponen
        buttons = new JButton[9];
        isXTurn = true;
        
        // Layout
        JPanel panel = new JPanel(new GridLayout(3, 3));
        
        // Membuat 9 button dan menambahkan event listener
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.BOLD, 48));
            buttons[i].addActionListener(new ButtonClickListener());
            panel.add(buttons[i]);
        }
        
        // Frame setup
        this.add(panel);
        this.setTitle("Tic Tac Toe");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            
            // Jika button sudah ada isinya, tidak melakukan apa-apa
            if (!clickedButton.getText().equals("")) {
                return;
            }
            
            // Bergantian antara X dan O
            if (isXTurn) {
                clickedButton.setText("X");
            } else {
                clickedButton.setText("O");
            }
            
            // Ganti giliran
            isXTurn = !isXTurn;
        }
    }
    
    public static void main(String[] args) {
        new TicTacToe();
    }
}