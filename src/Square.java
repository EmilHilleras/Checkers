import myPackage.Piece;

import javax.swing.*;
import java.awt.*;

public class Square extends JPanel {


    //Attribute
    private boolean hasPiece = false;
    private final int SIZE = 75;

    //Constructor
    public Square() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setSize(new Dimension(SIZE, SIZE));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (hasPiece) {
                g.setColor(Color.black);
                g.fillOval(10, 10, SIZE - 20, SIZE - 20);
        }
    }

    public boolean hasPiece(Piece piece) {
        return hasPiece;
    }

    public void setPiece(boolean hasPiece, Piece piece) {
        this.hasPiece = hasPiece;
    }

    public void removePiece(){
        hasPiece = false;
    }

}
