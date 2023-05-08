package Piece;


//Subklass till Piece
public class KingPiece extends Piece{


    //Instansvariabler

    //Konstruktor
    public KingPiece(PieceColor color) {
        super(PieceType.KING, color);
        setKing();
    }

    //Metod
    //Ger giltiga drag för KingPiece
    @Override
    public boolean isValidMove(int dx, int dy) {
        //Rörelse diagonalt i alla riktningar
        if (Math.abs(dx) == 1 && Math.abs(dy) == 1) {
            return true;
        } else {
            return false;
        }
    }

    //GetSet



}
