package Piece;


//Subklass till Piece
public class RegularPiece extends Piece{

    //Instansvariabler

    //Konstruktor

    public RegularPiece(PieceColor color) {

            super(PieceType.REGULAR, color);
            setRegular();
    }

    //Metoder

    @Override
    public boolean isValidMove(int dx, int dy) {
        //direction sätts till -1 för röda pjäser och 1 för svarta
        int direction = (isRed()) ? -1 : 1;

        //Koden returnerar true om dx är lika med 1 eller -1 för att kunna röra sig diagonalt, annars false
        if (dx == 1 && dy == direction) {
            return true;
        } else if (dx == -1 && dy == direction) {
            return true;
        } else {
            return false;
        }
    }

    //GetSet


}
