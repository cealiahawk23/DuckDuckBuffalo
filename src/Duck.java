import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics2D;

public class Duck extends Rectangle {
    Random random;
    BufferedImage pic1;
    double xVelocity;
    double yVelocity;
    double initialSpeed = 1.5;

    Duck(int x, int y, int width, int height){
        super(x, y, width, height);
        random = new Random();
        double randomXDirection = random.nextDouble(3);
        if(randomXDirection == 0) {
            randomXDirection++;
        }
        setXDirection(randomXDirection*initialSpeed);

        double randomYDirection = random.nextDouble(3);
        if(randomYDirection == 0) {
            randomYDirection++;
        }
        setYDirection(randomYDirection*initialSpeed);
    }
    public void setXDirection(double randomXDirection) { xVelocity = randomXDirection; }
    public void setYDirection(double randomYDirection) {
        yVelocity = randomYDirection;
    }
    public void move() {
        x += (xVelocity*initialSpeed);
        y += (yVelocity*initialSpeed);
    }
    public void draw(Graphics g) {
        try {
            pic1 = ImageIO.read(new File("./data/duck1.png"));
        } catch (IOException e) {
        }
        g.drawImage(pic1, x, y, null);
    }
}




















