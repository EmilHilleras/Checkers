package Move;
import Board.Board;
import GameRules.PlayerTurn;
import Piece.Piece;
import Board.Square;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PieceMove extends MouseAdapter {


    //Instansvariabler

    //Variabel för brädet
    private Board board;

    //Variabel för vald pjäs
    private Piece selectedPiece;

    //Variabel för vald ruta
    private Square selectedSquare;

    //Variabel för andra vald ruta
    private Square selectedSquare2;



    //Skapar en ny runda genom hänvisning till PlayerTurn klassen
    PlayerTurn playerTurn = new PlayerTurn(true);

    //Konstruktor
    public PieceMove(Board board) {
        this.board = board;
        this.board.addMouseListener(this);
    }

    //Metod

    //Metoden registrerar när någon clickar och använder det för att flytta pjäser
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click Button " + e.getButton());
        System.out.println("Player turn: " + PlayerTurn.getPlayerTurn());


        if (e.getButton() == MouseEvent.BUTTON1) {
            Square clickedSquare = (Square) e.getSource();
            //Om inget klick har registrerats
            if (selectedSquare == null) {

                //Om en pjäs tillhörande den nuvarande spelaren klickas på
                if (clickedSquare.hasPiece() && clickedSquare.getPiece().isRed() == PlayerTurn.getPlayerTurn()) {

                    //Vald pjäs hämtas
                    selectedPiece = clickedSquare.getPiece();
                    selectedSquare = clickedSquare;

                    System.out.println("Selected piece: " + selectedPiece);
                    System.out.println("Selected Square: " + selectedSquare);

                    //Gör drag för pjäs
                    makeValidMove(selectedSquare);

                }
            } else {

                //Om pjäsen som tryckts på klickas försvinner markeringen
                if (selectedSquare == clickedSquare){

                    selectedPiece = null;
                    selectedSquare = null;
                    selectedSquare2 = null;
                    board.clearHighlights();

                }
            }
        }
    }


    //Metod som highlightar möjliga drag och utför det

    private void makeValidMove(Square square) {
        board.getValidMoves(square).forEach(validSquare -> {
            validSquare.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    if (e.getButton() == MouseEvent.BUTTON1) {
                        //Väljer clicked square som selected square 2
                        Square clickedSquare = (Square) e.getSource();
                        selectedSquare2 = clickedSquare;
                        System.out.println("Selected square 2: " + selectedSquare2);
                        //skapar ett objekt move som förlitar sig på CanMove
                        CanMove move = new CanMove(board, selectedSquare, selectedSquare2);
                        if (move.isValid() || move.hasPieceToJumpOver(selectedSquare2.getRow(), selectedSquare2.getCol())) {
                            //Utfärdar drag om
                            move.execute();
                            System.out.println("Move executed: " + selectedSquare + " -> " + selectedSquare2);

                            // Tar bort vald pjäs och ruta efter lyckat drag
                            selectedPiece = null;
                            selectedSquare = null;
                            selectedSquare2 = null;

                            // Tar bort highlighting från alla rutor
                            board.clearHighlights();
                            // Byter runda
                            PlayerTurn.switchTurn();

                        } else  if (!move.isValid() && !move.hasPieceToJumpOver(selectedSquare2.getRow(), selectedSquare2.getCol())){
                            System.out.println("Invalid move");
                            board.clearHighlights();
                        }


                    }
                }
            });
            validSquare.highlight();
        });
    }
}

