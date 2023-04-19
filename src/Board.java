import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {


    private int[][] board = new int[8][8];

    //Square and board size are defined
    int boardSize = 600;
    int squareSize = 75;


    public Board() {

        //sets the dimensions of board
        this.setPreferredSize(new Dimension(boardSize, boardSize));

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //draws board and sets colors of each square
        g.setColor(new Color(245, 245, 220));
        g.fillRect(0, 0, boardSize, boardSize);

        g.setColor(new Color(0,100,0));
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    g.fillRect(col * squareSize, row * squareSize, squareSize, squareSize);
                }
            }
        }

    }




}
