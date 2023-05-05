import javax.swing.*;
import java.awt.*;
import myPackage.Piece;
import java.awt.Color;
import java.util.ArrayList;
import myPackage.PieceType;


public class Window extends JFrame {

    //Attribute
    private final int boardSize = 600;
    private final Color c1 = new Color(245, 245, 220);
    private final Color c2 = new Color(0, 100, 0);
    private static Piece[][] pieces = new Piece[8][8];
    private static Square[][] squares = new Square[8][8];
    private static ArrayList<Point> piecePos;


    //Constructor
    public Window() {
        this.setTitle("Checkers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(boardSize, boardSize));
        JPanel boardPanel = new JPanel(new GridLayout(8, 8));
        piecePos = new ArrayList<>();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Square square = new Square();
                if ((row + col) % 2 == 0) {
                    square.setBackground(c1);
                } else {
                    square.setBackground(c2);
                }
                boardPanel.add(square);
                squares[row][col] = square;

                if ((row + col) % 2 != 0 && row < 3) {
                    Piece piece = new Piece(PieceType.REGULAR, Piece.BLACK);
                    squares[row][col].setPiece(true, piece);
                    piecePos.add(new Point(row, col));
                    System.out.println("Added black piece at row " + row + ", column " + col);
                }
                if ((row + col) % 2 != 0 && row > 4) {
                    Piece piece = new Piece(PieceType.REGULAR, Piece.RED);
                    squares[row][col].setPiece(true, piece);
                    piecePos.add(new Point(row, col));
                    System.out.println("Added red piece at row " + row + ", column " + col);
                }


            }
        }

        this.add(boardPanel);
        this.pack();
        this.setVisible(true);
    }

    //Method

    public static ArrayList<Point> getPieces() {
        return piecePos;
    }



    //GetSet


    public static Square[][] getSquares() {
        return squares;
    }

    public Point getPos(){

        return new Point(0, 0);
    }



}
