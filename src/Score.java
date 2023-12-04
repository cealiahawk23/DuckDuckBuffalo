import java.awt.*;

public class Score extends Rectangle {
    static int GAME_WIDTH;
    static int GAME_HEIGHT;

    Score(int GAME_WIDTH, int GAME_HEIGHT) {
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }
    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Consolas", Font.PLAIN,60));
        g.drawLine(60, GAME_HEIGHT-500, GAME_WIDTH-160, GAME_HEIGHT-500);
        g.drawLine(GAME_WIDTH-80, GAME_HEIGHT-500, GAME_WIDTH-60, GAME_HEIGHT-500);
        g.drawLine(60, GAME_HEIGHT-500, 60, GAME_HEIGHT-80);
        g.drawLine(GAME_WIDTH-60, GAME_HEIGHT-500, GAME_WIDTH-60, GAME_HEIGHT-80);
    }
}