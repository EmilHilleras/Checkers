package Piece;
import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PieceImage implements Icon {

    //Instansvariabler
    private static final int WIDTH = 75; //Bestämmer bredd
    private static final int HEIGHT = 75; //Bestämmer höjd
    private final PieceImageType type; //Typ av bild

    //Konstruktor


    // Använder PieceImage instans med given typ av pjäs
    public PieceImage(PieceImageType type) {

        this.type = type;
    }
    //Metod


    //Använder HashMap för att lagra bilder för olika pjäser
    private static final HashMap<PieceImageType, Image> pieceImages = new HashMap<>();

    //Laddar in bilderna i HashMappen
    static {
        pieceImages.put(PieceImageType.RED_PIECE, loadImage("red_piece.png"));
        pieceImages.put(PieceImageType.BLACK_PIECE, loadImage("black_piece.png"));
        pieceImages.put(PieceImageType.RED_KING, loadImage("red_king.png"));
        pieceImages.put(PieceImageType.BLACK_KING, loadImage("black_king.png"));
    }


    //Metod för att ladda in bild och ge den rätt skala
    private static Image loadImage(String filename) {
        try {


            //Används för att öppna en inmatningsström till bildfilen
            InputStream is = PieceImage.class.getResourceAsStream(filename);
            //Läser in bildinnehållet från den inmatningsström
            BufferedImage img = ImageIO.read(is);

            //Skalar om bilden
            Image scaledImg = img.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);

            return scaledImg;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



    //Metod som ritar ut ikon efter given position
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Image pieceImage = pieceImages.get(type);
        g.drawImage(pieceImage, x, y, WIDTH, HEIGHT, null);
    }


    //GetSet

    //Returnerar bredden
    @Override
    public int getIconWidth() {
        return WIDTH;
    }

    //Returnerar höjden
    @Override
    public int getIconHeight() {
        return HEIGHT;
    }


}
