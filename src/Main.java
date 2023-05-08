import javax.swing.*;
import Board.Board;

public class Main {
    public static void main(String[] args) {

        //Skapa nytt fönster
        SwingUtilities.invokeLater(Board::new);

    }
}