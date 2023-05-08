package Piece;
import java.awt.*;

public abstract class Piece{

    //Instansvariabler
    private final PieceType type; //Pjäs typ som en pjäs kan ha
    private final PieceColor color; //Pjäsens färger som den kan ha
    private boolean isKing; //Avgör om pjäsen är kung
    private boolean isRed; //Avgör mo pjäsen är röd
    private boolean isRegular; //Avgör om pjäsen är vanlig
    private PieceImageType imageType; //Typ av pjäs bild



    //Konstruktor
    public Piece(PieceType type, PieceColor color) {

        //Pjäsens värden
        this.type = type;
        this.color = color;

        //If satser som används för att avgöra vad för grafisk representation av pjäsen som ska ske efter typ och färg
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

    //Metoder

    //En abstract metod som ärvs och bestäms i under klasserna KingPiece och RegularPiece
    public abstract boolean isValidMove(int dx, int dy);

    //returnerar kung
    public boolean isKing() {

        return isKing;
    }

    //returnerar vanlig pjäs
    public boolean isRegular() {
        return isRegular;}

    //Returnerar röd färg
    public boolean isRed() {

        return isRed;
    }

    //returnerar svart färg
    public boolean isBlack() {

        return !isRed;
    }


    //GetSet

    //Returnerar typ av pjäs
    public PieceType getType() {

        return type;
    }

    //Returnerar färg
    public PieceColor getColor() {

        return color;
    }

    //Returnerar bild typ
    public PieceImageType getImageType() {

        return imageType;
    }

    //Setter en kung
    public void setKing() {

        isKing = true;
    }

    //Setter en vanlig pjäs
    public void setRegular(){
        isRegular = true;
    }

}
