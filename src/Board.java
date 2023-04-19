import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private int[][] board = new int[8][8];

    int SIZE = 600;


    public Board() {

        this.setPreferredSize(new Dimension(SIZE, SIZE));

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //sets color of grid lines
        g.setColor(Color.BLACK);

        //draws gridlines
        for(int i = 0; i < 9; i++) {

            g.drawLine(SIZE * i / 8, 0, SIZE * i / 8, SIZE);
            g.drawLine(0, SIZE * i / 8, SIZE, SIZE * i / 8);
        }


    }









}
