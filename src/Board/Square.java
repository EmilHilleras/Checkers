package Board;
import Piece.Piece;
import Piece.PieceImageType;
import Piece.PieceType;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Square extends JPanel {


    //Instansvariabler
    private boolean hasPiece = false; // Attribut som används för att indikera om en ruta innehåller en pjäs
    private final static int SIZE = 75; //Storlek på en enskild ruta
    private Piece piece; //Pjäsen som en ruta kan innehålla
    private static BufferedImage blackPieceImage; //Bilden för en svart pjäs
    private static BufferedImage redPieceImage; //Bilden för en röd pjäs
    private static BufferedImage blackKingImage; // Bilden för en svart kung
    private static BufferedImage redKingImage; //Bilden för en röd kung
    private PieceType pieceType; //Typen av pjäs rutan innehåller
    private final static int x = 10; //X-Koordinat för rutans vänstra hörn
    private final static int y = 10; //Y-Koordinat för rutans vänstra hörn
    private boolean highlighted; //Indikerar om rutan är markerad

    private int row; //Rad rutan tillhör
    private int col; //Kolumn rutan tillhör


    //Konstruktor
    public Square(int row, int col) {

        //Laddar bilderna för pjäser
        try {
            blackPieceImage = loadImage("black_piece.png");
            redPieceImage = loadImage("red_piece.png");
            blackKingImage = loadImage("black_king.png");
            redKingImage = loadImage("red_king.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Rutans storlek och border
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setSize(new Dimension(SIZE, SIZE));

        //Sätter tillhörande rad och kolumn för rutan
        this.row = row;
        this.col = col;

    }

    //Metod


    //Ritar rutans innehåll
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        //Ritar ut bilden för pjäsen om det finns någon
        if (piece != null) {
            PieceImageType imageType = piece.getImageType();
            if (imageType == PieceImageType.RED_PIECE) {
                g.drawImage(redPieceImage, x, y, SIZE - 20, SIZE - 20, null);
            } else if (imageType == PieceImageType.BLACK_PIECE) {
                g.drawImage(blackPieceImage, x, y, SIZE - 20, SIZE - 20, null);
            } else if (imageType == PieceImageType.RED_KING) {
                g.drawImage(redKingImage, x, y, SIZE - 20, SIZE - 20, null);
            } else if (imageType == PieceImageType.BLACK_KING) {
                g.drawImage(blackKingImage, x, y, SIZE - 20, SIZE - 20, null);
            }
        }

    }


    //LoadImage används för att hantera mappstrukturen separat och endast behöva ange den en gång
    private BufferedImage loadImage(String filename) throws IOException {
        return ImageIO.read(getClass().getResource("/images/" + filename));
    }



    //Returnerar om rutan har en pjäs

    public boolean hasPiece() {
        return hasPiece;
    }

    //Sätter en pjäs på en ruta
    public void setPiece(Piece piece) {
        hasPiece = true;
        this.piece = piece;
        repaint();
    }

    //Tar bort en pjäs från en ruta

    public void removePiece() {
        hasPiece = false;
        piece = null;
        repaint();
    }

    //returnerar vilken pjäs som finns på rutan
    public Piece getPiece() {
        return piece;
    }

    //returnerar vilken rad rutan ligger på
    public int getRow() {

        return row;

    }

    //returnerar vilken column rutan ligger på
    public int getCol() {

        return col;
    }

    //returnerar värdet av attributet highlighted
    public static boolean isHighlighted(boolean highlighted) {

        return highlighted;
    }

    //Sätter highlighted till true
    public void highlight() {

        highlighted = true;
        this.setBorder(BorderFactory.createLineBorder(Color.yellow));
        repaint();
    }

    //Sätter highlighted till false
    public void notHighlighted() {

        highlighted = false;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        repaint();
    }

}
