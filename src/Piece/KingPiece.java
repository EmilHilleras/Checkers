package Piece;
import java.awt.*;


public class KingPiece extends Piece{

    public KingPiece(PieceColor color) {
        super(PieceType.KING, color);
        setKing();
    }

    @Override
    public boolean isValidMove(int dx, int dy) {
        if (Math.abs(dx) == 1 && Math.abs(dy) == 1) {
            return true;
        } else {
            return false;
        }
    }



}
