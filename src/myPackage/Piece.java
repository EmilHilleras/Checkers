package myPackage;

import java.awt.*;
public class Piece {

    private final PieceType type;
    private boolean isKing;

    public static final Color BLACK = Color.BLACK;

    public static final Color WHITE= Color.WHITE;
    private static Color color;

    public Piece(PieceType type, Color color) {
        this.type = type;
        this.color = color;
    }

    public PieceType getType() {
        return type;
    }


    public enum PieceType{
        REGULAR,
        KING

    }

    public void setKing() {
        isKing = true;
    }

    public boolean isKing() {
        return isKing;
    }

    public static Color getColor() {
        return color;
    }


}
