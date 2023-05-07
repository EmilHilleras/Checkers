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


    //Attribute
    private boolean hasPiece = false;
    private final static int SIZE = 75;
    private Piece piece;
    private static BufferedImage blackPieceImage;
    private static BufferedImage redPieceImage;
    private static BufferedImage blackKingImage;
    private static BufferedImage redKingImage;
    private PieceType pieceType;
    private final static int x = 10;
    private final static int y = 10;

    private int row;
    private int col;


    //Constructor
    public Square(int row, int col) {

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
        this.row = row;
        this.col = col;

    }

    //Method


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


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

    private BufferedImage loadImage(String filename) throws IOException {
        return ImageIO.read(getClass().getResource("/images/" + filename));
    }

    public boolean contains(Point point) {
        return this.x == point.x && this.y == point.y;
    }

    public boolean hasPiece() {
        return hasPiece;
    }

    public void setPiece(Piece piece) {
        hasPiece = true;
        this.piece = piece;
        this.pieceType = piece.getType();
        repaint();

    }

    public void movePieceTo(Square newSquare) {

        newSquare.setPiece(this.piece);
        this.removePiece();

    }

    public void removePiece() {
        hasPiece = false;
        piece = null;
        repaint();
    }

    public Piece getPiece() {
        return piece;
    }

    public int getRow() {

        return row;

    }

    public int getCol() {

        return col;
    }


}
