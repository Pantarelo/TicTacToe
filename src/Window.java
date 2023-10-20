import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Window implements ActionListener {

    public JFrame frame;
    public JLabel textField, textPlayer1, textPlayer2, textTie;
    public Panel panelText, panelButtons, panelScore, panelCenter, panelLeft;
    public JButton[] buttons;
    public JButton restartButton, newGameButton;
    public boolean player1Change;
    public Random random;
    public int matchPoint, xWins, oWins, tWins;

    public Window() {

        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(600, 728);

        panelButtons = new Panel();
        panelButtons.setBounds(0, 100, 600, 600);
        panelButtons.setLayout(new GridLayout(3, 3));

        buttons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            panelButtons.add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        panelText = new Panel(new BorderLayout());
        panelText.setBounds(0, 0, 600, 100);

        panelScore = new Panel();
        panelScore.setLayout(new BorderLayout(3, 1));

        panelLeft = new Panel();
        panelLeft.setLayout(new BorderLayout(2,1));

        panelCenter = new Panel(new BorderLayout());

        textField = new JLabel("Tic Tac Toe");
        textField.setFont(new Font( "Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setVerticalAlignment(JLabel.CENTER);
        panelCenter.add(textField);

        textPlayer1 = new JLabel("Player1 X: " + xWins);
        panelScore.add(textPlayer1, BorderLayout.NORTH);

        textPlayer2 = new JLabel("Player2 O: " + oWins);
        panelScore.add(textPlayer2, BorderLayout.SOUTH);

        textTie = new JLabel("Tie: " + tWins);
        panelScore.add(textTie, BorderLayout.CENTER);

        restartButton = new JButton("Restart");
        panelLeft.add(restartButton, BorderLayout.NORTH);
        restartButton.addActionListener(this);

        newGameButton = new JButton("New Game");
        panelLeft.add(newGameButton, BorderLayout.SOUTH);
        newGameButton.addActionListener(this);

        panelText.add(panelLeft, BorderLayout.WEST);
        panelText.add(panelCenter, BorderLayout.CENTER);
        panelText.add(panelScore, BorderLayout.EAST);

        frame.add(panelText);
        frame.add(panelButtons);

        matchPoint = 0;
        xWins = 0;
        oWins = 0;
        tWins = 0;

        frame.setVisible(true);

        startGame();
    }

    public void startGame() {
        random = new Random();
        int begin = random.nextInt(100);

        if (begin < 50) {
            player1Change = true;
            textField.setText("X turn");
        }
        else {
            player1Change = false;
            textField.setText("O turn");
        }

        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
    }

    public void gameOver() {
        matchPoint = 0;

        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setBackground(Color.RED);
            buttons[i].setEnabled(true);
        }

        matchPoint = 0;
    }

    public void restartGame() {
        xWins = 0;
        oWins = 0;
        tWins = 0;
        matchPoint = 0;

        textPlayer1.setText("Player1 X: " + xWins);
        textPlayer2.setText("Player2 O: " + oWins);
        textTie.setText("Tie: " + tWins);

        startGame();
    }

    public void matchCheck() {

        if (matchPoint == 9) {
            tWins();
        }

        if (buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) {
            xWins(0, 1, 2);
        }
        else
            if (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")) {
                xWins(3, 4, 5);
            }
        else
            if (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")) {
                xWins(6, 7, 8);
            }
        else
            if (buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")) {
            xWins(0, 3, 6);
            }
        else
            if (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) {
                xWins(1, 4, 7);
            }
        else
            if (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) {
                xWins(2, 5, 8);
            }
        else
            if (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) {
                xWins(0, 4, 8);
            }
        else
            if (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")) {
                xWins(2, 4, 6);
            }
        else
            if (buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) {
                oWins(0, 1, 2);
            }
        else
            if (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")) {
                oWins(3, 4, 5);
            }
        else
            if (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")) {
                oWins(6, 7, 8);
            }
        else
            if (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")) {
                oWins(0, 3, 6);
            }
        else
            if (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) {
                oWins(1, 4, 7);
            }
        else
            if (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")) {
                oWins(2, 5, 8);
            }
        else
            if (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) {
                oWins(0, 4, 8);
            }
        else
            if (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")) {
                oWins(2, 4, 6);
            }
    }

    public void xWins(int x1, int x2, int x3) {
        textField.setText("X wins");
        xWins++;
        System.out.println(xWins);
        textPlayer1.setText("Player1 X: " + xWins);

        for (int i = 0; i < 9; i++)
            buttons[i].setEnabled(false);
    }

    public void oWins(int o1, int o2, int o3) {
        textField.setText("O wins");
        oWins++;
        System.out.println(oWins);
        textPlayer2.setText("Player2 O: " + oWins);

        for (int i = 0; i < 9; i++)
            buttons[i].setEnabled(false);
    }

    public void tWins() {
        textField.setText("Tie");
        tWins++;
        System.out.println(tWins);
        textTie.setText("Tie: " + tWins);

        for (int i = 0; i < 9; i++)
            buttons[i].setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == restartButton)
            restartGame();

        if(e.getSource() == newGameButton) {
            gameOver();
            startGame();
        }
        
        for (int i = 0; i < 9; i++)
            if (e.getSource() == buttons[i]) {
                if (buttons[i].getText().isEmpty()) {
                    if (player1Change) {
                        buttons[i].setText("X");
                        buttons[i].setFont(new Font("Arial", Font.PLAIN, 45));
                        player1Change = false;
                        textField.setText("O turn");
                    }
                    else {
                        buttons[i].setText("O");
                        buttons[i].setFont(new Font("Arial", Font.PLAIN, 45));
                        player1Change = true;
                        textField.setText("X turn");
                    }
                    matchPoint++;
                    matchCheck();
                }
            }
    }

}
