package Piece;
import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PieceImage implements Icon {
    private static final int WIDTH = 75;
    private static final int HEIGHT = 75;

    private static final HashMap<PieceImageType, Image> pieceImages = new HashMap<>();
    static {
        pieceImages.put(PieceImageType.RED_PIECE, loadImage("red_piece.png"));
        pieceImages.put(PieceImageType.BLACK_PIECE, loadImage("black_piece.png"));
        pieceImages.put(PieceImageType.RED_KING, loadImage("red_king.png"));
        pieceImages.put(PieceImageType.BLACK_KING, loadImage("black_king.png"));
    }


    private static Image loadImage(String filename) {
        try {

            InputStream is = PieceImage.class.getResourceAsStream(filename);
            BufferedImage img = ImageIO.read(is);


            Image scaledImg = img.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);

            return scaledImg;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private final PieceImageType type;

    public PieceImage(PieceImageType type) {

        this.type = type;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Image pieceImage = pieceImages.get(type);
        g.drawImage(pieceImage, x, y, WIDTH, HEIGHT, null);
    }

    @Override
    public int getIconWidth() {
        return WIDTH;
    }

    @Override
    public int getIconHeight() {
        return HEIGHT;
    }


}
