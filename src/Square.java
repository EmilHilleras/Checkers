import myPackage.Piece;
import myPackage.PieceImageType;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Square extends JPanel {


    //Attribute
    private boolean hasPiece = false;
    private final int SIZE = 75;
    private Piece piece;
    private BufferedImage blackPieceImage;
    private BufferedImage redPieceImage;
    private BufferedImage blackKingImage;
    private BufferedImage redKingImage;


    //Constructor
    public Square() {

        try {
            blackPieceImage = loadImage("black_piece.png");
            redPieceImage = loadImage("red_piece.png");
            blackKingImage = loadImage("black_king.png");
            redKingImage = loadImage("red_king.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setSize(new Dimension(SIZE, SIZE));

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        if (piece !=null) {
            PieceImageType imageType = piece.getImageType();
            if (imageType == PieceImageType.RED_PIECE) {
                g.drawImage(redPieceImage, 10, 10, SIZE - 20, SIZE - 20, null);
            } else if (imageType == PieceImageType.BLACK_PIECE) {
                g.drawImage(blackPieceImage, 10, 10, SIZE - 20, SIZE - 20, null);
            } else if (imageType == PieceImageType.RED_KING) {
                g.drawImage(redKingImage, 10, 10, SIZE - 20, SIZE - 20, null);
            } else if (imageType == PieceImageType.BLACK_KING) {
                g.drawImage(blackKingImage, 10, 10, SIZE - 20, SIZE - 20, null);
            }
        }

    }
    private BufferedImage loadImage(String filename) throws IOException {
        return ImageIO.read(getClass().getResource("/images/" + filename));
    }

    public boolean hasPiece(Piece piece) {
        return this.piece == piece;
    }

    public void setPiece(boolean hasPiece, Piece piece) {
        this.hasPiece = hasPiece;
        this.piece = piece;
        repaint();

    }

    public void removePiece(){
        hasPiece = false;
        piece = null;
        repaint();
    }

}
