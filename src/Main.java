import javax.swing.*;
import Board.Board;

public class Main {
    public static void main(String[] args) {

        //Creating new window
        SwingUtilities.invokeLater(Board::new);

    }
}