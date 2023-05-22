package Move;
import Board.Board;
import Board.Square;
import Piece.Piece;

import java.awt.*;

public class CanMove {

    //Instansvariabel

    // variabel för brädet
    private Board board;
    //Källruta
    private Square sourceSquare;
    //Målruta
    private Square targetSquare;
    //variabel för pjäsen
    private Piece piece;

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
        if (piece == null && !sourceSquare.hasPiece()) {
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

        int dx = targetSquare.getCol() - sourceSquare.getCol();
        int dy = targetSquare.getRow() - sourceSquare.getRow();
        // Kollar om draget är diagonalt
        if (Math.abs(dx) != Math.abs(dy)) {

            return false;
        }

        // Kollar om draget är i korrekt riktning
        if ((piece.isRed() && piece.isRegular() && dy > 0) || (piece.isBlack() && piece.isRegular() &&dy < 0)) {
            return false;
        }

        // Kollar om draget är giltigt för pjäsen
        if (!piece.isValidMove(dx, dy)) {
            return false;
        }

        return true; //Returnerar sant om inget krav bryts
    }

    // Metod som kollar om det finns en pjäs att hoppa över
    public boolean hasPieceToJumpOver(int dy, int dx) {
        int middleRow = (sourceSquare.getRow() + targetSquare.getRow()) / 2;
        int middleCol = (sourceSquare.getCol() + targetSquare.getCol()) / 2;
        Square middleSquare = board.getSquare(middleRow, middleCol);


        if (piece == null && !sourceSquare.hasPiece()) {
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

        // Kollar om det finns en pjäs i mellanrummet och om det är annan färg än den som ska flyttas
        return middleSquare.hasPiece() && middleSquare.getPiece().getColor() != piece.getColor() && !targetSquare.hasPiece();
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
            if (Math.abs(dx) == 2 && Math.abs(dy) == 2 && hasPieceToJumpOver(dx, dy)) {
                int middleRow = (sourceSquare.getRow() + targetSquare.getRow()) / 2;
                int middleCol = (sourceSquare.getCol() + targetSquare.getCol()) / 2;
                Square middleSquare = board.getSquare(middleRow, middleCol);
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





