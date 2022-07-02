package TicTacToe;

import java.awt.*;

public class Plansza {
    public static int PLANSZA_SIZE = 9;

    public static int BORDER = 80;
    public static int THIN = 5;


    public static int WINDOW_X = PLANSZA_SIZE * BORDER;
    public static int WINDOW_Y = PLANSZA_SIZE * BORDER;

    public static Color color = new Color(89, 0, 180);
    public static Color thin_color = new Color(0, 196, 177);

    public static void Paint(Graphics g){
        g.setColor(thin_color);
        int x = 0;
        int y = 0;
        for (int i = 1; i < 10; i++){
//            pionowe

            g.fillRect(BORDER + x,y,THIN, 3*BORDER);
            g.fillRect(2*BORDER + x,y,THIN, 3*BORDER);

//            poziome
            g.fillRect(x,BORDER + y,3*BORDER, THIN);
            g.fillRect(x,2*BORDER + y,3*BORDER, THIN);
            x += 3 * BORDER;
            if (i%3==0) {
                y += 3 * BORDER;
                x = 0;
            }
        }
        g.setColor(color);
//        pionowe
        g.fillRect(3*BORDER,0,THIN, 9*BORDER);
        g.fillRect(6*BORDER,0,THIN, 9*BORDER);

//        poziome
        g.fillRect(0,3*BORDER,9*BORDER, THIN);
        g.fillRect(0,6*BORDER,9*BORDER, THIN);
    }
}
