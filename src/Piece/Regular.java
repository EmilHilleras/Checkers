package Piece;

import java.awt.*;

public class Regular extends Piece{

    public Regular(Color color) {
        super(PieceType.REGULAR, color);
        setRegular();
    }
}
