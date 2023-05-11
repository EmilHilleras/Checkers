import javax.swing.*;
import Board.Board;

public class Main {
    public static void main(String[] args) {

        //Skapa nytt bräde
        SwingUtilities.invokeLater(Board::new);

    }
}