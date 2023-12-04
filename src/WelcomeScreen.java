import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class WelcomeScreen extends Rectangle{
    Image image;
    Graphics graphics;
    static int SCREEN_WIDTH;
    static int SCREEN_HEIGHT;
    BufferedImage pic2;
    BufferedImage pic3;
    WelcomeScreen(int SCREEN_WIDTH, int SCREEN_HEIGHT) {
        WelcomeScreen.SCREEN_WIDTH = SCREEN_WIDTH;
        WelcomeScreen.SCREEN_HEIGHT = SCREEN_HEIGHT;
    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.PLAIN,40));
        String begWords = "Welcome to";
        String begWords2 = "Duck Duck Buffalo";
        String begWords3 = "Press ENTER";
        g.drawString(begWords, 410, 230);
        g.setFont(new Font("Consolas", Font.PLAIN,60));
        g.drawString(begWords2, 233, 300);
        g.setFont(new Font("Consolas", Font.PLAIN,40));
        g.drawString(begWords3, 400, 400);
        try {
            pic2 = ImageIO.read(new File("./data/duck1.png"));
        } catch (IOException e) {
        }
        for (int h = 200 ; h < 800 ; h+=35) {
            g.drawImage(pic2, h, 330, null);
        }
        try {
            pic3 = ImageIO.read(new File("./data/buffalo.png"));
        } catch (IOException e) {
        }
        g.drawImage(pic3, 835, 305, null);
    }
    public void draw2(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}