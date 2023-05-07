package Piece;
import java.awt.*;

public class Piece{

    private final PieceType type;
    private boolean isKing;
    private boolean isRed;
    private boolean isRegular;
    private Color color;
    private PieceImageType imageType;

    public static final Color BLACK = Color.BLACK;
    public static final Color RED = Color.RED;


    public Piece(PieceType type, Color color) {
        this.type = type;
        this.color = color;

        if (color == Piece.RED) {
            if (type == PieceType.REGULAR) {
                this.imageType = PieceImageType.RED_PIECE;
            } else {
                this.imageType = PieceImageType.RED_KING;
            }
            this.isRed = true;
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
        isRegular = true;
    }

    public boolean isKing() {
        return isKing;
    }

    public boolean isRegular() {return isRegular;}

    public boolean isRed() {
        return isRed;
    }

    public boolean isBlack() {
        return !isRed;
    }

    public Color getColor() {
        return color;
    }

}
