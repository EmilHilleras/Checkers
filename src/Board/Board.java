package Board;
import javax.swing.*;
import java.awt.*;
import Piece.Piece;
import java.awt.Color;
import Piece.PieceType;
import Piece.RegularPiece;
import Piece.KingPiece;
import Piece.PieceColor;


public class Board extends JFrame {

    //Attribute
    private final int boardSize = 600;
    private final Color c1 = new Color(245, 245, 220);
    private final Color c2 = new Color(0, 100, 0);

    Square[][] board = new Square[8][8];


    //Constructor
    public Board() {
        this.setTitle("Checkers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(boardSize, boardSize));
        JPanel boardPanel = new JPanel(new GridLayout(8, 8));

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                board[row][col] = new Square(row,col);
                if ((row + col) % 2 == 0) {
                    board[row][col].setBackground(c1);
                } else {
                    board[row][col].setBackground(c2);
                }

                if ((row + col) % 2 != 0 && row < 3) {
                    board[row][col].setPiece(createPiece(PieceType.REGULAR, PieceColor.BLACK));
                    System.out.println("Added black piece at row " + row + ", column " + col);
                }
                if ((row + col) % 2 != 0 && row > 4) {
                    board[row][col].setPiece(createPiece(PieceType.REGULAR, PieceColor.RED));
                    System.out.println("Added red piece at row " + row + ", column " + col);
                }

            }
        }

        this.add(boardPanel);
        this.pack();
        this.setVisible(true);
    }

    //Method

    public static Piece createPiece(PieceType type, PieceColor color) {
        if (color == PieceColor.RED) {
            if (type == PieceType.REGULAR) {
                return new RegularPiece(PieceColor.RED);
            } else if (type == PieceType.KING) {
                return new KingPiece(PieceColor.RED);
            }
        } else if (color == PieceColor.BLACK) {
            if (type == PieceType.REGULAR) {
                return new RegularPiece(PieceColor.BLACK);
            } else if (type == PieceType.KING) {
                return new KingPiece(PieceColor.BLACK);
            }
        }
        return null;
    }



    //GetSet

    public Square getSquare(int row, int col) {
        return board[row][col];
    }
}
