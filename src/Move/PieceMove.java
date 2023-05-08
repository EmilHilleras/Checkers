package Move;

import Board.Board;
import GameRules.PlayerTurn;
import Piece.Piece;
import Board.Square;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PieceMove extends MouseAdapter {


    //Instansvariabler
    private Board board; //Variabel för brädet
    private Piece selectedPiece; //Variabel för vald pjäs
    private Square selectedSquare; //Variabel för vald ruta
    private Square selectedSquare2; //Variabel för andra vald ruta

    PlayerTurn playerTurn = new PlayerTurn(true); //Skapar en ny runda genom hänvisning till PlayerTurn klassen

    //Konstruktor
    public PieceMove(Board board) {
        this.board = board;

    }

    //Metod


    //Metoden registrerar när någon clickar och använder det för att flytta pjäser
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click");
        System.out.println(e.getButton());
        if (e.getButton() == MouseEvent.BUTTON1) {
            Square clickedSquare = (Square) e.getSource();

            //Om inget klick har registrerats
            if (selectedPiece == null) {

                //Om en pjäs tillhörande den nuvarande spelaren klickas på
                if (clickedSquare.hasPiece() && clickedSquare.getPiece().isRed() == PlayerTurn.getPlayerTurn()) {

                    //Vald pjäs hämtas
                    selectedPiece = clickedSquare.getPiece();
                    selectedSquare = clickedSquare;

                    // Highlightar drag som kan göras för pjäserna
                    highlightValidMoves(selectedSquare);


                    //Upprepar samma funktion för andra spelaren
                } else if (clickedSquare.hasPiece() && clickedSquare.getPiece().isBlack() == PlayerTurn.getPlayerTurn()) {

                    selectedPiece = clickedSquare.getPiece();
                    selectedSquare = clickedSquare;

                    highlightValidMoves(selectedSquare);
                }
            } else if (selectedPiece != null){
                // Vid detta skede är en pjäs vald

                if (e.getButton() == MouseEvent.BUTTON2) {

                    Square clickedSquare2 = (Square) e.getSource();
                    selectedSquare2 = clickedSquare2;

                    CanMove move = new CanMove(board, selectedSquare, selectedSquare2);//skapar ett objekt move som förlitar sig på CanMove
                    if (move.isValid()) {
                        move.execute(); //Utfärdar drag om möjligt


                        // Tar bort vald pjäs och ruta efter lyckat drag
                        selectedPiece = null;
                        selectedSquare = null;

                        // Tar bort highlighting från alla rutor
                        board.clearHighlights();

                        // Byter runda
                        PlayerTurn.switchTurn();
                    }
                }
            }
        }
    }


    //Highlightar möjliga drag
    private void highlightValidMoves(Square square) {
        for (Square validSquare : board.getValidMoves(square)) {
            validSquare.highlight();
        }
    }


}

