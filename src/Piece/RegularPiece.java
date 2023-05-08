package Piece;

import java.awt.*;

public class RegularPiece extends Piece{

    public RegularPiece(PieceColor color) {

            super(PieceType.REGULAR, color);
            setRegular();
    }

    @Override
    public boolean isValidMove(int dx, int dy) {
        int direction = (isRed()) ? -1 : 1;
        if (dx == 1 && dy == direction) {
            return true;
        } else if (dx == -1 && dy == direction) {
            return true;
        } else {
            return false;
        }
    }


}
