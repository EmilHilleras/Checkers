import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        //Window design and function
        this.setTitle("Checkers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Window content
        this.add(new Board());

        //window visible
        this.pack();
        this.setVisible(true);

    }

}
