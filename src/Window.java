import javax.swing.*;
import java.awt.*;
import myPackage.Piece;
import java.awt.Color;
import myPackage.PieceType;


public class Window extends JFrame {

    //Attribute
    private final int boardSize = 600;
    private final Color c1 = new Color(245, 245, 220);
    private final Color c2 = new Color(0, 100, 0);

    //Constructor
    public Window() {
        this.setTitle("Checkers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(boardSize, boardSize));
        JPanel boardPanel = new JPanel(new GridLayout(8, 8));
        Square[][] squares = new Square[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = new Square();
                if ((i + j) % 2 == 0) {
                    square.setBackground(c1);
                } else {
                    square.setBackground(c2);
                }
                boardPanel.add(square);
                squares[i][j] = square;

                if ((i + j) % 2 != 0 && i < 3) {
                    Piece piece = new Piece(PieceType.REGULAR, Piece.BLACK);
                    squares[i][j].setPiece(true, piece);
                    System.out.println("Added black piece at row " + i + ", column " + j);
                }
                if ((i + j) % 2 != 0 && i > 4) {
                    Piece piece = new Piece(PieceType.REGULAR, Piece.RED);
                    squares[i][j].setPiece(true, piece);
                    System.out.println("Added red piece at row " + i + ", column " + j);
                }


            }
        }

        this.add(boardPanel);
        this.pack();
        this.setVisible(true);
    }

    //Method

    //GetSet

}
