import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle{
    int id;
    int xVelocity;
    int speed = 10;
    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT){
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            setXDirection(-speed);
            move();
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            setXDirection(speed);
            move();
        }
    }
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            setXDirection(0);
            move();
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            setXDirection(0);
            move();
        }
    }
    public void setXDirection(int xDirection) {
        xVelocity = xDirection;
    }
    public void move() {
        x = x + xVelocity;

    }
    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);

    }
}

















