import java.awt.event.ActionListener;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;

public class tictactoe extends JFrame implements ActionListener {

    boolean jeu = true;

    private JButton[][] buttons = new JButton[3][3];

    public tictactoe() {

        GridLayout gl = new GridLayout();
        this.setLayout(gl);
        gl.setColumns(3);
        gl.setRows(3);
        this.setSize(700, 700);
        Font font = new Font("Arial", 20, 100);
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                JButton button = new JButton("");
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
                buttons[row][col] = button;
                button.setFont(font);
                button.addActionListener(this);
                super.add(button);
            }
        }

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton cliquer = (JButton) e.getSource();
        makeMove(cliquer);
        vainqueur();

    }

    private void makeMove(JButton cliquer) {
        if (jeu == true) {
            cliquer.setText("X");
        } else {
            cliquer.setText("O");
        }
        jeu = !jeu;
    }

    private void vainqueur() {
        if (buttons[0][0].getText() == "X" && buttons[1][1].getText() == "X" && buttons[2][2].getText() == "X") {
            xWins();
        }
        if (buttons[0][0].getText() == "X" && buttons[0][1].getText() == "X" && buttons[0][2].getText() == "X") {
            xWins();
        }
        if (buttons[1][0].getText() == "X" && buttons[1][1].getText() == "X" && buttons[1][2].getText() == "X") {
            xWins();
        }
        if (buttons[2][0].getText() == "X" && buttons[2][1].getText() == "X" && buttons[2][2].getText() == "X") {
            xWins();
        }
        if (buttons[2][0].getText() == "X" && buttons[1][1].getText() == "X" && buttons[0][2].getText() == "X") {
            xWins();
        }
        if (buttons[0][0].getText() == "X" && buttons[1][0].getText() == "X" && buttons[2][0].getText() == "X") {
            xWins();
        }
        if (buttons[0][1].getText() == "X" && buttons[1][1].getText() == "X" && buttons[2][1].getText() == "X") {
            xWins();
        }
        if (buttons[0][2].getText() == "X" && buttons[1][2].getText() == "X" && buttons[2][2].getText() == "X") {
            xWins();
        }

        if (buttons[0][0].getText() == "O" && buttons[1][1].getText() == "O" && buttons[2][2].getText() == "O") {
            oWins();
        }
        if (buttons[0][0].getText() == "O" && buttons[0][1].getText() == "O" && buttons[0][2].getText() == "O") {
            oWins();
        }
        if (buttons[1][0].getText() == "O" && buttons[1][1].getText() == "O" && buttons[1][2].getText() == "O") {
            oWins();
        }
        if (buttons[2][0].getText() == "O" && buttons[2][1].getText() == "O" && buttons[2][2].getText() == "O") {
            oWins();
        }
        if (buttons[2][0].getText() == "O" && buttons[1][1].getText() == "O" && buttons[0][2].getText() == "O") {
            oWins();
        }
        if (buttons[0][0].getText() == "O" && buttons[1][0].getText() == "O" && buttons[2][0].getText() == "O") {
            oWins();
        }
        if (buttons[0][1].getText() == "O" && buttons[1][1].getText() == "O" && buttons[2][1].getText() == "O") {
            oWins();
        }
        if (buttons[0][2].getText() == "O" && buttons[1][2].getText() == "O" && buttons[2][2].getText() == "O") {
            oWins();
        }

        int nb_cases = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText() == "X" || buttons[i][j].getText() == "O") {
                    nb_cases++;
                }
            }
        }
        if (nb_cases == 9) {
            JOptionPane.showMessageDialog(this, "Égalité");
            int choice = JOptionPane.showConfirmDialog(this, "Veux-tu réessayer ? ");
            if (choice == JOptionPane.YES_OPTION) {
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        buttons[row][col].setText("");
                    }
                }
            } else {
                super.dispose();
            }
        }
    }

    private void xWins() {
        JOptionPane.showMessageDialog(this, "Les X a gagné");
        int choice = JOptionPane.showConfirmDialog(this, "Veux-tu réessayer ? ");
        if (choice == JOptionPane.YES_OPTION) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    buttons[row][col].setText("");
                }
            }
        } else {
            super.dispose();
        }
    }

    private void oWins() {
        JOptionPane.showMessageDialog(this, "Les O a gagné");
        int choice = JOptionPane.showConfirmDialog(this, "Veux-tu réessayer ? ");
        if (choice == JOptionPane.YES_OPTION) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    buttons[row][col].setText("");
                }
            }
        } else {
            super.dispose();
        }
    }
}