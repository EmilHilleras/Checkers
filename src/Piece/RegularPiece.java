package Piece;

import java.awt.*;

public class RegularPiece extends Piece{

    public RegularPiece(PieceColor color) {

            super(PieceType.REGULAR, color);
            setRegular();
    }

    public boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol) {

    }

}
