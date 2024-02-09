import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 650;// 50 px pour le Panel 

    //Creation de la fenetre 
    JFrame frame = new JFrame();

    //Creation de l'etiquette 
    JLabel textLabel = new JLabel();
    //Creation du panneau
    JPanel textPanel = new JPanel();


    TicTacToe(){
        //Propriétés de la fenetre
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

                //Propriétés de l'etiquette

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

    }
}
