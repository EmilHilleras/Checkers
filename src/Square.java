import javax.swing.*;
import java.awt.*;

public class Square extends JPanel {


    //Attribute
    private boolean hasPiece = false;
    private int size = 75;

    //Constructor
    public Square() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setSize(new Dimension(size, size));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (hasPiece) {
            g.setColor(Color.red);
            g.fillOval(10, 10, size - 20, size - 20);
        }
    }

    public boolean hasPiece() {
        return hasPiece;
    }

    public void setPiece(boolean hasPiece) {
        this.hasPiece = hasPiece;
    }


}
