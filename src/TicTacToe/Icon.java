package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Icon extends JPanel {
    public static List<ImageIcon> XIcons = new ArrayList<>();
    public static List<ImageIcon> OIcons = new ArrayList<>();

    ImageIcon X = new ImageIcon("src/TicTacToe/static/X.png");
    Image imageX = X.getImage(); //transformuje typ zmiennej zeby zmienic rozmiar
    Image ScaledX = imageX.getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH);
    ImageIcon iconX = new ImageIcon(ScaledX); //transormuje z powrotem na ikone zeby ja narysowac
//    ImageIcon X;
//    Image imageX;
//    Image ScaledX;
//    ImageIcon iconX;

    ImageIcon O = new ImageIcon("src/TicTacToe/static/O.png");
    Image imageO = O.getImage(); //transformuje typ zmiennej zeby zmienic rozmiar
    Image ScaledO = imageO.getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH);
    ImageIcon iconO = new ImageIcon(new ImageIcon("src/TicTacToe/static/X.png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)); //transormuje z powrotem na ikone zeby ja narysowac

    public static int POSITION_X;
    public static int POSITION_Y;

    public static void addIcons(){
//        for (int i=0; i<81; i++){
//            XIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/X.png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
//            OIcons.add(new ImageIcon(new ImageIcon("src/TicTacToe/static/O.png").getImage().getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH)));
//        }

    }

    @Override
    protected void paintComponent(Graphics g) {
//        g.drawImage(imageX, POSITION_X, POSITION_Y, this);
        iconX.paintIcon(this, g, POSITION_X, POSITION_Y);
        iconO.paintIcon(this, g, POSITION_X+80, POSITION_Y);
        int i=0;
        for (int y=0; y<490; y+=80){
            XIcons.get(i).paintIcon(this, g, 80, y);
        }
        System.out.println(XIcons.size());
    }

    public Icon changePosition(int x, int y) {
//        X = new ImageIcon("src/TicTacToe/static/X.png");
//        imageX = X.getImage(); //transformuje typ zmiennej zeby zmienic rozmiar
//        ScaledX = imageX.getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH);
//        iconX = new ImageIcon(ScaledX); //transormuje z powrotem na ikone zeby ja narysowac

        POSITION_X = x * Plansza.BORDER;
        POSITION_Y = y * Plansza.BORDER;
//        repaint();

        return new Icon();
    }
}
