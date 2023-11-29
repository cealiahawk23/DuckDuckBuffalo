import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{
    static final int SCREEN_WIDTH = 1500;
    static final int GAME_WIDTH = 1000;
    static final int SCREEN_HEIGHT = (int)(SCREEN_WIDTH * (0.5555));
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension GAME_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final Dimension SCREEN_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    //static final Dimension BOX_LOCATION = new Dimension(BOX_SIDE_L, BOX_TOP);
    static final int DUCK_DIAMETER = 20;
    static final int PADDLE_WIDTH = 80;
    static final int PADDLE_HEIGHT = 20;
    static final int BOX_TOP = (GAME_HEIGHT-500);
    static final int BOX_BOTTOM = (GAME_HEIGHT - 70);
    static final int BOX_SIDE_R = (GAME_WIDTH-100);
    static final int BOX_SIDE_L = 60;
    static final int BOX_SIDE_LP = 60;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Box box;
    Paddle paddle;
    Duck duck;
    Duck[] Ducks = new Duck[10];
    ArrayList<Duck> Ducks2 = new ArrayList<Duck>();
    Score score;


    GamePanel() {
        newPaddle();
        makeDucks();
        addDucksToArray();

        box = new Box(GAME_WIDTH, GAME_HEIGHT);
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(GAME_SIZE);
        gameThread = new Thread(this);
        gameThread.start();

    }
    public void newPaddle() {
        paddle = new Paddle((GAME_WIDTH/2)-(PADDLE_WIDTH/2), (GAME_HEIGHT-PADDLE_HEIGHT-BOX_SIDE_LP), PADDLE_WIDTH, PADDLE_HEIGHT);
    }
    public void makeDucks() {
        random = new Random();
        for(int i = 0; i < 10; i++){
            duck = new Duck((BOX_SIDE_R-DUCK_DIAMETER + random.nextInt()), (BOX_TOP + random.nextInt()), DUCK_DIAMETER, DUCK_DIAMETER);
            this.Ducks[i] = duck;
        }
    }
    public void addDucksToArray() {
        random = new Random();
        duck = new Duck((BOX_SIDE_R-DUCK_DIAMETER + random.nextInt(2)), (BOX_TOP + random.nextInt(2)), DUCK_DIAMETER, DUCK_DIAMETER);
        Ducks2.add(duck);

    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);

    }
    public void draw(Graphics g) {
        box.draw(g);
        score.draw(g);
        paddle.draw(g);
        duck.draw(g);
        for (Duck d: this.Ducks)
        {
            d.draw(g);
        }
        for (Duck d: this.Ducks2)
        {
            d.draw(g);
        }
    }
    public void move() {
        paddle.move();
        duck.move();
        for (Duck d: this.Ducks)
        {
            d.move();
        }
        for (Duck d: this.Ducks2)
        {
            d.move();
        }
    }
    public void checkCollision(Duck duck) {
        //stops duck from leaving top of screen
        if (duck.y <= 40) {
            duck.setYDirection(-duck.yVelocity);
        }
        //stops duck from leaving sides of screen
        if (duck.x <= 60) {
            duck.setXDirection(-duck.xVelocity);
        }
        if (duck.x >= (GAME_WIDTH - 60) - DUCK_DIAMETER) {
            duck.setXDirection(-duck.xVelocity);
        }
        //bounces duck off paddle
        if (duck.intersects(paddle)) {
            duck.yVelocity = Math.abs(duck.yVelocity);
            duck.yVelocity--; //makes duck bounce off paddle
              if(duck.xVelocity>0) {
                //  duck.xVelocity++;//makes duck faster bouncing off paddle
              }
              else {
                  duck.xVelocity--;
              }
            duck.setXDirection(duck.xVelocity);
            duck.setYDirection(duck.yVelocity);
        }
        //stops paddle from leaving screen
        if (paddle.x <= 60) {
            paddle.x = 60;
        }
        if (paddle.x >= ((GAME_WIDTH - 60) - PADDLE_WIDTH)) {
            paddle.x = (GAME_WIDTH - 60) - PADDLE_WIDTH;
        }
    }
    public void run() {
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.00;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if(delta >= 1) {
                move();
                for (Duck duck: this.Ducks)
                {
                    checkCollision(duck);
                }
                for (Duck duck: this.Ducks2)
                {
                    checkCollision(duck);
                }
                repaint();
                delta--;
            }
        }

    }
    public class AL extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            paddle.keyPressed(e);
            keyTyped(e);
        }
        @Override
        public void keyReleased(KeyEvent e) { paddle.keyReleased(e); }
  //      public void keyTyped(KeyEvent e) {
  //          duck.keyTyped(e); }
        public void keyTyped(KeyEvent e) {
            boolean shouldRelease = false;
            if ((e.getKeyCode() == KeyEvent.VK_SPACE)) {
                 shouldRelease = true;
                 addDucksToArray();
                 System.out.println("Duck released " + shouldRelease);
          }
      }
    }


}




















