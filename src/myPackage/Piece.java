package myPackage;
import java.awt.*;

public class Piece extends Point{

    private final PieceType type;
    private boolean isKing;

    private PieceImageType imageType;

    public static final Color BLACK = Color.BLACK;

    public static final Color RED = Color.RED;
    private static Color color;

    public Piece(PieceType type, Color color) {
        this.type = type;
        this.color = color;

        if (color == Piece.RED) {
            if (type == PieceType.REGULAR) {
                this.imageType = PieceImageType.RED_PIECE;
            } else {
                this.imageType = PieceImageType.RED_KING;
            }
        } else {
            if (type == PieceType.REGULAR) {
                this.imageType = PieceImageType.BLACK_PIECE;
            } else {
                this.imageType = PieceImageType.BLACK_KING;
            }
        }

    }



    public PieceType getType() {
        return type;
    }

    public PieceImageType getImageType() {
        return imageType;
    }

    public void setKing() {
        isKing = true;
    }

    public void setRegular(){
        boolean isRegular = true;
    }

    public boolean isKing() {
        return isKing;
    }

    public boolean isRegular() {return isRegular();}

    public static Color getColor() {
        return color;
    }




}
