package Piece;
import java.awt.*;


public class KingPiece extends Piece{

    public KingPiece(PieceColor color) {
        super(PieceType.KING, color);
        setKing();
    }

    public boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol) {

    }


}
