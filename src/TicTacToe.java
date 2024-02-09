import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 650;// 50 px pour le Panel 

    //Creation de la fenetre 
    JFrame frame = new JFrame("Tic-Tac-Toe");

    //Creation de l'etiquette 
    JLabel textLabel = new JLabel();
    //Creation du panneau
    JPanel textPanel = new JPanel();

    //Creation des bords
    JPanel boardPanel = new JPanel();

    //Creation des boutons

    JButton[][] board = new JButton[3][3];
    String playerX = "X";
    String playerO  = "O";
    String currentplayer = playerX;  

    boolean gameOver = false;
    int turns = 0;


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


        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        for (int r = 0; r < 3; r++) {
            for(int c = 0; c<3; c++){
                JButton tile = new JButton();
                board[r][c] =tile;
                boardPanel.add(tile);

                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);
                // tile.setText(currentplayer);

                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        if (gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        if (tile.getText() == "") {
                            tile.setText(currentplayer);
                            turns++; 
                            checkWinner();
                            if(!gameOver){
                                 // alterner les joueurs 
                            currentplayer = currentplayer == playerX ? playerO : playerX;
                            textLabel.setText("Tour de "+currentplayer); 
                            }
                           
                        }
                        
                    }
                });
            }
        }
    }

    void checkWinner(){
        //Horizontale
        for (int r = 0; r < 3; r++) {
            if(board[r][0].getText() == "") continue;

            if(board[r][0].getText() == board[r][1].getText()&&
            board[r][1].getText() == board[r][2].getText()){

                for (int i = 0; i < 3; i++) {
                    setWinner(board[r][i]);
                }
                gameOver =true;
                return;
            }
        }

        //vertical

        for (int c = 0; c < 3; c++) {
            if(board[0][c].getText() == "") continue;

            if(board[0][c].getText() == board[1][c].getText()&&
            board[1][c].getText() == board[2][c].getText()){

                for (int i = 0; i < 3; i++) {
                    setWinner(board[i][c]);
                }
                gameOver =true;
                return;
            }
        }
        // Diagonale
       if(board[0][0].getText() == board[1][1].getText() &&
       board[1][1].getText() == board[2][2].getText() &&
       board[0][0].getText()!=""){

        for (int i = 0; i < board.length; i++) {
            setWinner(board[i][i]);
        }
        gameOver=true;
        return;
       }

       //anti-Diagonale
       if(board[0][2].getText() == board[1][1].getText() &&
       board[1][1].getText() == board[2][0].getText() &&
       board[0][2].getText()!=""){

        setWinner(board[0][2]);
        setWinner(board[1][1]);

        setWinner(board[2][0]);


        gameOver=true;
        return;
       }
       if (turns == 9) {
            for (int r = 0; r < board.length; r++) {
              for (int c = 0; c < 3; c++) {
                setTie(board[r][c]);
              }  
            }

       }

    }
    void setWinner(JButton tile){
        tile.setForeground(Color.green);
        tile.setBackground(Color.gray);
        textLabel.setText(currentplayer+ " à gagné!");
    }

    void setTie(JButton tile){
        tile.setForeground(Color.orange);
        tile.setBackground(Color.gray);
        textLabel.setText("Match nul !");

    }
}
