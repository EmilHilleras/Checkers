package Move;

import Board.Board;
import Board.Square;
import Piece.Piece;

public class CanMove {

    //Instansvariabel
    private Board board; // variabel för brädet
    private Square sourceSquare; //Källruta
    private Square targetSquare; //Målruta
    private Piece piece; //variabel för pjäsen

    //Konstruktor

    //Initierar variabler
    public CanMove(Board board, Square sourceSquare, Square targetSquare) {
        this.board = board;
        this.sourceSquare = sourceSquare;
        this.targetSquare = targetSquare;
        this.piece = sourceSquare.getPiece();
    }

    //Metod


    //Metod som ser om draget är giltigt
    public boolean isValid() {
        //Kollar om källrutan innehåller en pjäs
        if (piece == null) {
            return false;
        }

        //Kollar om målrutan är ogiltig eller om käll och målruta är densamma
        if (targetSquare == null || sourceSquare == targetSquare) {
            return false;
        }

        // Kollar om målrutan innehåller en pjäs
        if (targetSquare.hasPiece()) {
            return false;
        }

        // Kollar om draget är diagonalt
        int dx = targetSquare.getCol() - sourceSquare.getCol();
        int dy = targetSquare.getRow() - sourceSquare.getRow();
        if (Math.abs(dx) != Math.abs(dy)) {
            return false;
        }

        // Kollar om draget är i korrekt riktning
        if ((piece.isRed() && dy > 0) || (piece.isBlack() && dy < 0)) {
            return false;
        }

        // Kollar om draget är giltigt för pjäsen
        if (!piece.isValidMove(dx, dy)) {
            return false;
        }

        // Kollar om draget är ett hopp över en annan pjäs
        if (Math.abs(dx) == 2 && Math.abs(dy) == 2) {
            Square middleSquare = board.getSquare((sourceSquare.getRow() + targetSquare.getRow()) / 2, (sourceSquare.getCol() + targetSquare.getCol()) / 2);
            //Kollar om det finns en pjäs i mellanrummet och om det är annan färg än den som ska flyttas
            if (middleSquare.hasPiece() && middleSquare.getPiece().getColor() != piece.getColor()) {
                return true;
            } else {
                return false;
            }
        }

        return true; //Returnerar sant om inget krav bryts
    }

    //Metod som utför draget
    public void execute() {
        //Kollar om draget är giltigt
        if (isValid()) {

            targetSquare.setPiece(piece); //Sätter pjäs i målrutan
            sourceSquare.removePiece(); //Tar bort pjäs från källrutan

            // Kollar efter drag att hoppa över en annan pjäs och i så fall ta bort den
            int dx = targetSquare.getCol() - sourceSquare.getCol();
            int dy = targetSquare.getRow() - sourceSquare.getRow();
            if (Math.abs(dx) == 2 && Math.abs(dy) == 2) {
                Square middleSquare = board.getSquare((sourceSquare.getRow() + targetSquare.getRow()) / 2, (sourceSquare.getCol() + targetSquare.getCol()) / 2);
                middleSquare.removePiece();
            }
        }
    }

    //Returnerar källruta
    public Square getSourceSquare() {

        return sourceSquare;
    }

    //Returnerar målruta
    public Square getTargetSquare() {

        return targetSquare;
    }

    //Returnerar en pjäs
    public Piece getPiece() {

        return piece;
    }
}





