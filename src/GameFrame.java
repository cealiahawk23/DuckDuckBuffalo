import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    GamePanel panel;


    GameFrame() {

        panel = new GamePanel();

        this.add(panel);
        this.setTitle("Duck Duck Buffalo");
        this.setResizable(false);
        this.setBackground(Color.lightGray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
















