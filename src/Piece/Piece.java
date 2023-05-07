package Piece;
import java.awt.*;

public abstract class Piece{

    private final PieceType type;
    private final PieceColor color;
    private boolean isKing;
    private boolean isRed;
    private boolean isRegular;
    private PieceImageType imageType;



    public Piece(PieceType type, PieceColor color) {
        this.type = type;
        this.color = color;

        if (color == PieceColor.RED) {
            if (type == PieceType.REGULAR) {
                this.imageType = PieceImageType.RED_PIECE;
            } else {
                this.imageType = PieceImageType.RED_KING;
            }
            this.isRed = true;
        } else if (color == PieceColor.BLACK){
            if (type == PieceType.REGULAR) {
                this.imageType = PieceImageType.BLACK_PIECE;
            } else {
                this.imageType = PieceImageType.BLACK_KING;
            }
        }

    }

    public abstract boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol);

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

    public PieceColor getColor() {

        return color;
    }

}
