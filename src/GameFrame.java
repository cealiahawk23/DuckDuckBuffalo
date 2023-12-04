import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame {
    GamePanel panel;
    WelcomeScreen panel2;
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