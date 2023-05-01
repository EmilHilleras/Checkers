package myPackage;
import java.awt.*;
import myPackage.Piece;


public class King extends Piece{


    public King(Color color) {
        super(PieceType.KING, color);
        setKing();
    }

}
