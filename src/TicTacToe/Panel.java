package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Panel extends JPanel {

    public static List<ImageIcon> TicTacIcons = new ArrayList<>();
    public static List<Point> cordinates = new ArrayList<>();
    public static boolean is_choosen, is_win, win_X, O_TURN = false;
    public static boolean IS_DOUBLE, IS_PLAYING = false;
    public static List<Point> win_cordinates = new ArrayList<>();
    public static List<ImageIcon> win_icons = new ArrayList<>();
    public static int WIN_UP_X,WIN_UP_Y, WIN_DOWN_X, WIN_DOWN_Y = 0;

    public static int UP_X, UP_Y = 0;

    public static int FISRT_X, FISRT_Y, FIRST_INDEX = 0;

    public static char[][] board = new char[9][9];
    public static boolean[] board_win = {true,true,true,true,true,true,true,true,true};
    public static char[] board_win_chars = {'1','2','3','4','5','6','7','8','9'};


    public Panel() {
        setPreferredSize(new Dimension(Plansza.WINDOW_X, Plansza.WINDOW_Y));
//        x = new X();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Plansza.Paint(g);
        if (is_choosen){
            //            pionowe
            g.setColor(Color.GREEN);
            g.fillRect(UP_X,UP_Y,Plansza.THIN, 3*Plansza.BORDER);
            g.fillRect(3*Plansza.BORDER + UP_X,UP_Y,Plansza.THIN, 3*Plansza.BORDER);

//            poziome
            g.fillRect(UP_X,UP_Y,3*Plansza.BORDER, Plansza.THIN);
            g.fillRect(UP_X,3*Plansza.BORDER + UP_Y,3*Plansza.BORDER, Plansza.THIN);
        }

        int n = 0;
        for (ImageIcon i : TicTacIcons){
            Point c = cordinates.get(n++);
            i.paintIcon(this,g,c.x,c.y);
        }
        n=0;
        for (ImageIcon i : win_icons){
            Point c = win_cordinates.get(n++);
            i.paintIcon(this, g, c.x, c.y);
        }

        if (is_win){
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(win_X ? new Color(34, 255, 0) : new Color(176, 43, 0));
            g2.setStroke(new BasicStroke(20));
            g2.draw(new Line2D.Float(WIN_UP_X,WIN_UP_Y, WIN_DOWN_X,WIN_DOWN_Y));

            Font fontTitle = new Font("Arial", Font.PLAIN, 60);
            g.setFont(fontTitle);
            if (win_X) {
                g.setColor(new Color(0, 68, 13));
                g.drawString("YOU WIN!", 200, 300);
                g.drawString("Press ESC to play again", 50, 350);
                g.setColor(Color.WHITE);
                g.drawString("YOU WIN!", 204, 304);
            } else {
                g.setColor(new Color(255, 20, 20));
                g.drawString("YOU LOSE!", 200, 300);
                g.drawString("Press ESC to play again", 50, 350);
                g.setColor(Color.WHITE);
                g.drawString("YOU LOSE!", 204, 304);
            }
            g.drawString("Press ESC to play again", 54, 354);
        }
    }

    public void rep(){
        repaint();
    }

    public void main_win(){
//        pion
        if (board_win_chars[6]==board_win_chars[7] && board_win_chars[7]==board_win_chars[8]){
            WIN_UP_X = 0;
            WIN_UP_Y = 3*Plansza.BORDER - (Plansza.BORDER*3 /2);
            WIN_DOWN_X = Plansza.BORDER * 9;
            WIN_DOWN_Y = 3*Plansza.BORDER - (Plansza.BORDER*3 /2);
            is_win = true;
            win_X = board_win_chars[7] != (O_TURN ? 'X' :'O');
        }
        if (board_win_chars[3]==board_win_chars[4] && board_win_chars[4]==board_win_chars[5]){
            WIN_UP_X = 0;
            WIN_UP_Y = 6*Plansza.BORDER - (Plansza.BORDER*3 /2);
            WIN_DOWN_X = Plansza.BORDER * 9;
            WIN_DOWN_Y = 6*Plansza.BORDER - (Plansza.BORDER*3 /2);
            win_X = board_win_chars[4] != (O_TURN ? 'X' :'O');
            is_win = true;
        }
        if (board_win_chars[0]==board_win_chars[1] && board_win_chars[1]==board_win_chars[2]) {
            WIN_UP_X = 0;
            WIN_UP_Y = 9 * Plansza.BORDER -(Plansza.BORDER * 3 / 2);
            WIN_DOWN_X = Plansza.BORDER * 9;
            WIN_DOWN_Y = 9*Plansza.BORDER - (Plansza.BORDER*3 /2);
            win_X = board_win_chars[1] != (O_TURN ? 'X' :'O');
            is_win = true;
        }
//        poziom
        if (board_win_chars[6]==board_win_chars[3] && board_win_chars[3]==board_win_chars[0]){
            WIN_UP_X = 3*Plansza.BORDER - (Plansza.BORDER*3 /2);
            WIN_UP_Y = 0;
            WIN_DOWN_X = 3*Plansza.BORDER - (Plansza.BORDER*3 /2);
            WIN_DOWN_Y = Plansza.BORDER * 9;
            win_X = board_win_chars[3] != (O_TURN ? 'X' :'O');
            is_win = true;
        }
        if (board_win_chars[7]==board_win_chars[4] && board_win_chars[4]==board_win_chars[1]){
            WIN_UP_X = 6*Plansza.BORDER - (Plansza.BORDER*3 /2);
            WIN_UP_Y = 0;
            WIN_DOWN_X = 6*Plansza.BORDER - (Plansza.BORDER*3 /2);
            WIN_DOWN_Y = Plansza.BORDER * 9;
            win_X = board_win_chars[4] != (O_TURN ? 'X' :'O');
            is_win = true;
        }
        if (board_win_chars[8]==board_win_chars[5] && board_win_chars[5]==board_win_chars[2]){
            WIN_UP_X = 9*Plansza.BORDER - (Plansza.BORDER*3 /2);
            WIN_UP_Y = 0;
            WIN_DOWN_X = 9*Plansza.BORDER - (Plansza.BORDER*3 /2);
            WIN_DOWN_Y = Plansza.BORDER * 9;
            win_X = board_win_chars[5] != (O_TURN ? 'X' :'O');
            is_win = true;
        }
//        przekatne
        if (board_win_chars[6]==board_win_chars[4] && board_win_chars[4]==board_win_chars[2]){
            WIN_UP_X = 0;
            WIN_UP_Y = 0;
            WIN_DOWN_X = Plansza.BORDER * 9;
            WIN_DOWN_Y = Plansza.BORDER * 9;
            win_X = board_win_chars[4] != (O_TURN ? 'X' :'O');
            is_win = true;
        }
        if (board_win_chars[8]==board_win_chars[4] && board_win_chars[4]==board_win_chars[0]){
            WIN_UP_X = Plansza.BORDER * 9;
            WIN_UP_Y = 0;
            WIN_DOWN_X = 0;
            WIN_DOWN_Y = Plansza.BORDER * 9;
            win_X = board_win_chars[4] != (O_TURN ? 'X' :'O');
            is_win = true;
        }
    }

    public boolean is_coordinate_free(int x, int y){
        for (Point p : cordinates){
            if (p.x==x && p.y==y)
                return false;
        }
        return true;
    }
    public void check_win(char n){
        String path = "src/TicTacToe/static/"+ n +".png";
        if (board_win[FIRST_INDEX-1]) {
            for (int i = 0; i < 9; i += 3) {
                if (board[FIRST_INDEX - 1][i] == board[FIRST_INDEX - 1][i + 1] && board[FIRST_INDEX - 1][i + 1] == board[FIRST_INDEX - 1][i + 2] && (board[FIRST_INDEX - 1][i + 1] == 'x' || board[FIRST_INDEX - 1][i + 1] == 'o')) {
                    win_cordinates.add(new Point(FISRT_X, FISRT_Y));
                    win_icons.add(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(Plansza.BORDER * 3, Plansza.BORDER * 3, Image.SCALE_SMOOTH)));
                    board_win[FIRST_INDEX-1] = false;
                    board_win_chars[FIRST_INDEX-1] = n;
                    repaint();
                    break;
                }
            }
            for (int i = 0; i < 3; i++) {
                if (board[FIRST_INDEX - 1][i] == board[FIRST_INDEX - 1][i + 3] && board[FIRST_INDEX - 1][i + 3] == board[FIRST_INDEX - 1][i + 6] && (board[FIRST_INDEX - 1][i + 3] == 'x' || board[FIRST_INDEX - 1][i + 3] == 'o')){
                    win_cordinates.add(new Point(FISRT_X, FISRT_Y));
                    win_icons.add(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(Plansza.BORDER * 3, Plansza.BORDER * 3, Image.SCALE_SMOOTH)));
                    board_win[FIRST_INDEX-1] = false;
                    board_win_chars[FIRST_INDEX-1] = n;
                    repaint();
                    break;
                }
            }
            if (board[FIRST_INDEX - 1][0] == board[FIRST_INDEX - 1][4] && board[FIRST_INDEX - 1][4] == board[FIRST_INDEX - 1][8] && (board[FIRST_INDEX - 1][4] == 'x' || board[FIRST_INDEX - 1][4] == 'o')){
                win_cordinates.add(new Point(FISRT_X, FISRT_Y));
                win_icons.add(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(Plansza.BORDER * 3, Plansza.BORDER * 3, Image.SCALE_SMOOTH)));
                board_win[FIRST_INDEX-1] = false;
                board_win_chars[FIRST_INDEX-1] = n;
                repaint();
            }
            if (board[FIRST_INDEX - 1][2] == board[FIRST_INDEX - 1][4] && board[FIRST_INDEX - 1][4] == board[FIRST_INDEX - 1][6] && (board[FIRST_INDEX - 1][4] == 'x' || board[FIRST_INDEX - 1][4] == 'o')){
                win_cordinates.add(new Point(FISRT_X, FISRT_Y));
                win_icons.add(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(Plansza.BORDER * 3, Plansza.BORDER * 3, Image.SCALE_SMOOTH)));
                board_win[FIRST_INDEX-1] = false;
                board_win_chars[FIRST_INDEX-1] = n;
                repaint();
            }
        }
        main_win();
    }

    public void generate_circle(){
        Random rand = new Random();
        while (true){
            int r = rand.nextInt(9);
            if (!(board[FIRST_INDEX-1][r] == 'x' || board[FIRST_INDEX-1][r] == 'o')) {
                switch (r) {
                    case 0 -> {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/O.png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(FISRT_X, FISRT_Y + 2 * Plansza.BORDER));
                        board[FIRST_INDEX - 1][0] = 'o';
                        repaint();
                    }
                    case 1 -> {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/O.png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(FISRT_X + Plansza.BORDER, FISRT_Y + 2 * Plansza.BORDER));
                        board[FIRST_INDEX - 1][1] = 'o';
                        repaint();
                    }
                    case 2 -> {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/O.png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(FISRT_X + 2 * Plansza.BORDER, FISRT_Y + 2 * Plansza.BORDER));
                        board[FIRST_INDEX - 1][2] = 'o';
                        repaint();
                    }
                    case 3 -> {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/O.png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(FISRT_X, FISRT_Y + Plansza.BORDER));
                        board[FIRST_INDEX - 1][3] = 'o';
                        repaint();
                    }
                    case 4 -> {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/O.png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(FISRT_X + Plansza.BORDER, FISRT_Y + Plansza.BORDER));
                        board[FIRST_INDEX - 1][4] = 'o';
                        repaint();
                    }
                    case 5 -> {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/O.png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(FISRT_X + 2 * Plansza.BORDER, FISRT_Y + Plansza.BORDER));
                        board[FIRST_INDEX - 1][5] = 'o';
                        repaint();
                    }
                    case 6 -> {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/O.png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(FISRT_X, FISRT_Y));
                        board[FIRST_INDEX - 1][6] = 'o';
                        repaint();
                    }
                    case 7 -> {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/O.png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(FISRT_X + Plansza.BORDER, FISRT_Y));
                        board[FIRST_INDEX - 1][7] = 'o';
                        repaint();
                    }
                    case 8 -> {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/O.png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(FISRT_X + 2 * Plansza.BORDER, FISRT_Y));
                        board[FIRST_INDEX - 1][8] = 'o';
                        repaint();
                    }
                }
                check_win('O');
                break;
            }
        }
    }
//  7 8 9
//  4 5 6
//  1 2 3
    public void checkPosition(int cell){
        if (is_choosen){
            int x,y;
            switch (cell) {
                case 1:
                    if (is_coordinate_free(x=FISRT_X,y=FISRT_Y + 2 * Plansza.BORDER)) {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/" + (O_TURN ? "O":"X")+".png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(x, y));
                        board[FIRST_INDEX - 1][0] = O_TURN ? 'o' : 'x';
                        repaint();

                        check_win(O_TURN ? 'O' : 'X');
                        if (board_win[FIRST_INDEX - 1] && !IS_DOUBLE)
                            generate_circle();
                        check_win(O_TURN ? 'X' : 'O');

                        if (IS_DOUBLE)
                            O_TURN = !O_TURN;
                    }
                    break;
                case 2:
                    if (is_coordinate_free(x=FISRT_X + Plansza.BORDER,y=FISRT_Y + 2 * Plansza.BORDER)) {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/" + (O_TURN ? "O":"X")+".png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(x, y));
                        board[FIRST_INDEX - 1][1] = O_TURN ? 'o' : 'x';
                        repaint();

                        check_win(O_TURN ? 'O' : 'X');
                        if (board_win[FIRST_INDEX - 1] && !IS_DOUBLE)
                            generate_circle();
                        check_win(O_TURN ? 'X' : 'O');

                        if (IS_DOUBLE)
                            O_TURN = !O_TURN;
                    }
                    break;
                case 3:
                    if (is_coordinate_free(x=FISRT_X + 2*Plansza.BORDER,y=FISRT_Y + 2 * Plansza.BORDER)) {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/" + (O_TURN ? "O":"X")+".png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(x, y));
                        board[FIRST_INDEX - 1][2] = O_TURN ? 'o' : 'x';
                        repaint();

                        check_win(O_TURN ? 'O' : 'X');
                        if (board_win[FIRST_INDEX - 1] && !IS_DOUBLE)
                            generate_circle();
                        check_win(O_TURN ? 'X' : 'O');

                        if (IS_DOUBLE)
                            O_TURN = !O_TURN;
                    }
                    break;
                case 4:
                    if (is_coordinate_free(x=FISRT_X,y=FISRT_Y + Plansza.BORDER)) {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/" + (O_TURN ? "O":"X")+".png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(x, y));
                        board[FIRST_INDEX - 1][3] = O_TURN ? 'o' : 'x';
                        repaint();

                        check_win(O_TURN ? 'O' : 'X');
                        if (board_win[FIRST_INDEX - 1] && !IS_DOUBLE)
                            generate_circle();
                        check_win(O_TURN ? 'X' : 'O');

                        if (IS_DOUBLE)
                            O_TURN = !O_TURN;
                    }
                    break;
                case 5:
                    if (is_coordinate_free(x=FISRT_X + Plansza.BORDER,y=FISRT_Y + Plansza.BORDER)) {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/" + (O_TURN ? "O":"X")+".png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(x, y));
                        board[FIRST_INDEX - 1][4] = O_TURN ? 'o' : 'x';
                        repaint();

                        check_win(O_TURN ? 'O' : 'X');
                        if (board_win[FIRST_INDEX - 1] && !IS_DOUBLE)
                            generate_circle();
                        check_win(O_TURN ? 'X' : 'O');

                        if (IS_DOUBLE)
                            O_TURN = !O_TURN;
                    }
                    break;
                case 6:
                    if (is_coordinate_free(x=FISRT_X + 2*Plansza.BORDER,y=FISRT_Y + Plansza.BORDER)) {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/" + (O_TURN ? "O":"X")+".png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(x, y));
                        board[FIRST_INDEX - 1][5] = O_TURN ? 'o' : 'x';
                        repaint();

                        check_win(O_TURN ? 'O' : 'X');
                        if (board_win[FIRST_INDEX - 1] && !IS_DOUBLE)
                            generate_circle();
                        check_win(O_TURN ? 'X' : 'O');

                        if (IS_DOUBLE)
                            O_TURN = !O_TURN;
                    }
                    break;
                case 7:
                    if (is_coordinate_free(x=FISRT_X,y=FISRT_Y)) {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/" + (O_TURN ? "O":"X")+".png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(x, y));
                        board[FIRST_INDEX - 1][6] = O_TURN ? 'o' : 'x';
                        repaint();

                        check_win(O_TURN ? 'O' : 'X');
                        if (board_win[FIRST_INDEX - 1] && !IS_DOUBLE)
                            generate_circle();
                        check_win(O_TURN ? 'X' : 'O');

                        if (IS_DOUBLE)
                            O_TURN = !O_TURN;
                    }
                    break;
                case 8:
                    if (is_coordinate_free(x=FISRT_X + Plansza.BORDER,y=FISRT_Y)) {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/" + (O_TURN ? "O":"X")+".png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(x, y));
                        board[FIRST_INDEX - 1][7] = O_TURN ? 'o' : 'x';
                        repaint();

                        check_win(O_TURN ? 'O' : 'X');
                        if (board_win[FIRST_INDEX - 1] && !IS_DOUBLE)
                            generate_circle();
                        check_win(O_TURN ? 'X' : 'O');

                        if (IS_DOUBLE)
                            O_TURN = !O_TURN;
                    }
                    break;
                case 9:
                    if (is_coordinate_free(x=FISRT_X + 2*Plansza.BORDER,y=FISRT_Y)) {
                        TicTacIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/" + (O_TURN ? "O":"X")+".png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
                        cordinates.add(new Point(x, y));
                        board[FIRST_INDEX - 1][8] = O_TURN ? 'o' : 'x';
                        repaint();

                        check_win(O_TURN ? 'O' : 'X');
                        if (board_win[FIRST_INDEX - 1] && !IS_DOUBLE)
                            generate_circle();
                        check_win(O_TURN ? 'X' : 'O');

                        if (IS_DOUBLE)
                            O_TURN = !O_TURN;
                    }
                    break;
            }
            IS_PLAYING = true;
            is_choosen = false;
        }else {
            switch (cell) {
                case 1 -> {
                    FIRST_INDEX = 1;
                    if (!board_win[FIRST_INDEX-1])
                        break;
                    is_choosen = true;
                    FISRT_X = 0;
                    FISRT_Y = 2 * (3 * Plansza.BORDER);
                    UP_X = 0;
                    UP_Y = 2 * (3 * Plansza.BORDER);
                    repaint();
                }
                case 2 -> {
                    FIRST_INDEX = 2;
                    if (!board_win[FIRST_INDEX-1])
                        break;
                    is_choosen = true;
                    FISRT_X = (3 * Plansza.BORDER);
                    FISRT_Y = 2 * (3 * Plansza.BORDER);
                    UP_X = (3 * Plansza.BORDER);
                    UP_Y = 2 * (3 * Plansza.BORDER);
                    repaint();
                }
                case 3 -> {
                    FIRST_INDEX = 3;
                    if (!board_win[FIRST_INDEX-1])
                        break;
                    is_choosen = true;
                    FISRT_X = 2 * (3 * Plansza.BORDER);
                    FISRT_Y = 2 * (3 * Plansza.BORDER);
                    UP_X = 2 * (3 * Plansza.BORDER);
                    UP_Y = 2 * (3 * Plansza.BORDER);
                    repaint();
                }
                case 4 -> {
                    FIRST_INDEX = 4;
                    if (!board_win[FIRST_INDEX-1])
                        break;
                    is_choosen = true;
                    FISRT_X = 0;
                    FISRT_Y = (3 * Plansza.BORDER);
                    UP_X = 0;
                    UP_Y = (3 * Plansza.BORDER);
                    repaint();
                }
                case 5 -> {
                    FIRST_INDEX = 5;
                    if (!board_win[FIRST_INDEX-1])
                        break;
                    is_choosen = true;
                    FISRT_X = (3 * Plansza.BORDER);
                    FISRT_Y = (3 * Plansza.BORDER);
                    UP_X = (3 * Plansza.BORDER);
                    UP_Y = (3 * Plansza.BORDER);
                    repaint();
                }
                case 6 -> {
                    FIRST_INDEX = 6;
                    if (!board_win[FIRST_INDEX-1])
                        break;
                    is_choosen = true;
                    FISRT_X = 2 * (3 * Plansza.BORDER);
                    FISRT_Y = (3 * Plansza.BORDER);
                    UP_X = 2 * (3 * Plansza.BORDER);
                    UP_Y = (3 * Plansza.BORDER);
                    repaint();
                }
                case 7 -> {
                    FIRST_INDEX = 7;
                    if (!board_win[FIRST_INDEX-1])
                        break;
                    is_choosen = true;
                    FISRT_X = 0;
                    FISRT_Y = 0;
                    UP_X = 0;
                    UP_Y = 0;
                    repaint();
                }
                case 8 -> {
                    FIRST_INDEX = 8;
                    if (!board_win[FIRST_INDEX-1])
                        break;
                    is_choosen = true;
                    FISRT_X = (3 * Plansza.BORDER);
                    FISRT_Y = 0;
                    UP_X = (3 * Plansza.BORDER);
                    UP_Y = 0;
                    repaint();
                }
                case 9 -> {
                    FIRST_INDEX = 9;
                    if (!board_win[FIRST_INDEX-1])
                        break;
                    is_choosen = true;
                    FISRT_X = 2 * (3 * Plansza.BORDER);
                    FISRT_Y = 0;
                    UP_X = 2 * (3 * Plansza.BORDER);
                    UP_Y = 0;
                    repaint();
                }
            }
        }
        repaint();
    }

}
