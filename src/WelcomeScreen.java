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
    public void draw3(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.ITALIC,20));
        String begWords = "We received a new shipment of ducks.";
        String begWords2 ="Your job is to move them into this box.";
        String begWords3 ="Press the space bar to add a duck to your box";
        String begWords4 ="then use your < LEFT and RIGHT > arrow keys ";
        String begWords5 ="to move the paddle to keep the ducks in your box.";
        String begWords6 = "You get a point for each duck in your box";
        String begWords7 ="at the end of the round.";
        String begWords8 ="Press ENTER to begin.";
        g.drawString(begWords, 100, 100);
        g.drawString(begWords2, 100, 150);
        g.drawString(begWords3, 100, 200);
        g.drawString(begWords4, 100, 250);
        g.drawString(begWords5, 100, 300);
        g.drawString(begWords6, 100, 350);
        g.drawString(begWords7, 100, 400);
        g.setFont(new Font("Consolas", Font.BOLD,40));
        g.drawString(begWords8, 270, 450);
        try {
            pic2 = ImageIO.read(new File("./data/duck1.png"));
        } catch (IOException e) {
        }
        for (int h = 600 ; h < 900 ; h+=35) {
            g.drawImage(pic2, h, 30, null);
        }
        for (int j = 65 ; j < 300 ; j+=35) {
            g.drawImage(pic2, 900, j, null);
        }
    }
    public void draw4(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}