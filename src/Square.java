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
    private final int x = 10;
    private final int y = 10;



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
    private BufferedImage loadImage(String filename) throws IOException {
        return ImageIO.read(getClass().getResource("/images/" + filename));
    }

    public boolean contains(Point point) {
        return this.x == point.x && this.y == point.y;
    }

    public Point getPos() {
        return new Point(x*SIZE, y*SIZE);
    }

    public boolean hasPiece(Boolean hasPiece) {
        return hasPiece;
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

    public Piece getPiece() {
        return piece;
    }

    public int getRow(){

        return y / SIZE;

    }

    public int getCol(){

        return x / SIZE;
    }


    public void setPiece(Point selectedPiece) {
    }


}
