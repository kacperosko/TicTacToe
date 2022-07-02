package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class IconX{
    ImageIcon iconX;
    public IconX(){
        ImageIcon X = new ImageIcon("src/TicTacToe/static/X.png");
        Image imageX = X.getImage(); //transformuje typ zmiennej zeby zmienic rozmiar
        Image ScaledX = imageX.getScaledInstance(Plansza.BORDER, Plansza.BORDER, Image.SCALE_SMOOTH);
        ImageIcon iconX = new ImageIcon(ScaledX); //transormuje z powrotem na ikone zeby ja narysowac
    }

    public ImageIcon getX(){
        return iconX;
    }
}
