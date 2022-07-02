package TicTacToe;

import javax.swing.*;

public class Window extends JFrame {
    Panel panel = new Panel();

    public Window(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        add(panel);

        pack();
        setLocationRelativeTo(null); //Wysrodkowuje okno na ekranie uzytkownika
        setVisible(true);
        setResizable(false); //Uniemozliwia uzytkownikowi zmiane rozmiaru okna
    }
}
