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
        this.setTitle("Checkers"); //Titeln på spelet
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Stänger applikationen när programmet stängs av
        int boardSize = 600; //brädstorlek
        this.setPreferredSize(new Dimension(boardSize, boardSize));//Storlek på fönster
        JPanel boardPanel = new JPanel(new GridLayout(8, 8)); //Skapar en JPanel som har rutnätet

        //Loop som skapar rutor
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                board[row][col] = new Square(row,col); //Skapar rutan

                //Om summan av raden och kolumnen är jämn blir rutans färg c1(beige)
                if ((row + col) % 2 == 0) {
                    Color c1 = new Color(245, 245, 220);//c1 blir lika med beige färg
                    board[row][col].setBackground(c1);//Bestämmer rutans färg
                } else { //Annars blir rutans färg c2(grön)
                    Color c2 = new Color(0, 100, 0);//c2 blir lika med grön färg
                    board[row][col].setBackground(c2);//Bestämmer rutans färg
                }
                boardPanel.add(getSquare(row, col));//Lägger till rutan i JPanel, vilket gör rutan synlig
                board[row][col].addMouseListener(new PieceMove(this));//Lägger till en mouseListner för att hålla koll på klickar i detta fall

                //If satser som placerar pjäser på spelplanen
                if ((row + col) % 2 != 0 && row < 3) {
                    board[row][col].setPiece(createPiece(PieceType.REGULAR, PieceColor.BLACK)); //Skapar en vanlig svart pjäs
                    System.out.println("Added black piece at row " + row + ", column " + col); //Skriver ut att pjäsen har skapats
                }
                if ((row + col) % 2 != 0 && row > 4) {
                    board[row][col].setPiece(createPiece (PieceType.REGULAR, PieceColor.RED)); //Skapar vanlig röd pjäs
                    System.out.println("Added red piece at row " + row + ", column " + col); //Skriver ut att pjäsen har skapats

                }

            }
        }

        this.add(boardPanel); //Lägger till JPanel i fönstret
        this.pack(); //Justerar storlek på fönstret
        this.setVisible(true); //Sätter fönstret som synligt

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
                    if (CanMove.isValid(this, square, destinationSquare)) {
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
