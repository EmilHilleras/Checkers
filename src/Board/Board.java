package Board;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import Move.CanMove;
import Move.PieceMove;
import Piece.Piece;
import java.awt.Color;
import Piece.PieceType;
import Piece.RegularPiece;
import Piece.KingPiece;
import Piece.PieceColor;



public class Board extends JFrame {

    //Instansvariabler
    Square[][] board = new Square[8][8];


    //Konstruktor
    public Board() {
        //Titeln på spelet
        this.setTitle("Checkers");
        //Stänger applikationen när programmet stängs av
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //brädstorlek
        int boardSize = 600;
        //Storlek på fönster
        this.setPreferredSize(new Dimension(boardSize, boardSize));
        //Skapar en JPanel som har rutnätet
        JPanel boardPanel = new JPanel(new GridLayout(8, 8));

        //Loop som skapar rutor
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                //Skapar ny square för varje angiven board där rad och kolumn anges
                board[row][col] = new Square(row,col);

                //Om summan av raden och kolumnen är jämn blir rutans färg c1(beige)
                if ((row + col) % 2 == 0) {
                    //c1 blir lika med beige färg
                    Color c1 = new Color(245, 245, 220);
                    //Sätter färgen för rutan
                    board[row][col].setBackground(c1);
                } else {
                    //Annars blir rutans färg c2(grön)
                    Color c2 = new Color(0, 100, 0);
                    //Sätter färgen för rutan
                    board[row][col].setBackground(c2);
                }
                //Lägger till rutan i JPanel, vilket gör rutan synlig
                boardPanel.add(getSquare(row, col));
                //Lägger till en mouseListner för att hålla koll på klickar i detta fall
                board[row][col].addMouseListener(new PieceMove(this));

                //If satser som placerar pjäser på spelplanen och uppfyller de krav som ställs utifrån färg
                if ((row + col) % 2 != 0 && row < 3) {
                    //Skapar en vanlig svart pjäs
                    board[row][col].setPiece(createPiece(PieceType.REGULAR, PieceColor.BLACK));
                    //Skriver ut att pjäsen har skapats
                    System.out.println("Added black piece at row " + row + ", column " + col);
                }
                if ((row + col) % 2 != 0 && row > 4) {
                    //Skapar vanlig röd pjäs
                    board[row][col].setPiece(createPiece (PieceType.REGULAR, PieceColor.RED));
                    //Skriver ut att pjäsen har skapats
                    System.out.println("Added red piece at row " + row + ", column " + col);

                }

            }
        }

        //Lägger till JPanel i fönstret
        this.add(boardPanel);
        //Justerar storlek på fönstret
        this.pack();
        //Sätter fönstret som synligt
        this.setVisible(true);

    }

    //Metod


    //Metod som skapar en pjäs efter given pjäs och färg
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

    //Avmarkerar rutor på brädet
    public void clearHighlights(){
        for (Square[] row : board) {
            for(Square square : row) {
                square.notHighlighted();
            }
        }
    }


    //Metod som returnerar en lista med alla giltiga drag som kan göras för given pjäs
    public List<Square> getValidMoves(Square square) {
        List<Square> validMoves = new ArrayList<>();

        Piece piece = square.getPiece();
        if (piece != null) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    Square destinationSquare = getSquare(row, col);
                    CanMove canMove = new CanMove(this, square, destinationSquare);
                    if (canMove.isValid() || canMove.hasPieceToJumpOver(row, col)) {
                        validMoves.add(destinationSquare);
                    }
                }
            }
        }

        return validMoves;
    }




    //GetSet

    //Getter som returnerar ett enskilt square objekt med rad och kolumn
    public Square getSquare(int row, int col) {
        return board[row][col];
    }
}
