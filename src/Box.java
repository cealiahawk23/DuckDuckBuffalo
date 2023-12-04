import java.awt.*;

public class Box extends Rectangle {
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    Box(int GAME_WIDTH, int GAME_HEIGHT) {
        Box.GAME_WIDTH = GAME_WIDTH;
        Box.GAME_HEIGHT = GAME_HEIGHT;
    }
    public void draw(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect(62, GAME_HEIGHT-498, GAME_WIDTH-123, GAME_HEIGHT-140);
    }
}