package TicTacToe;

import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class TicTacToeMain {
    public static void main(String[] args) {
        Icon.addIcons();
        Window window = new Window();
        showMessageDialog(null, "Witaj w Tic Tac Toe!\nAby zagrać w trybie multi naciśnij 'D'");
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_D) {
                    Panel.IS_DOUBLE = !Panel.IS_DOUBLE;
                    if (Panel.IS_PLAYING)
                        showMessageDialog(null, "Nie mozesz zmienic trybu gry w c");
                    if (!Panel.IS_DOUBLE)
                        Panel.O_TURN = false;
                    showMessageDialog(null, "Tryb multi "+ (Panel.IS_DOUBLE ? "został włączony" :"został wyłączony"));
                }
                if (!Panel.is_win) {
                    if (keyCode == KeyEvent.VK_1) {
                        window.panel.checkPosition(1);
//                    System.out.println("1");
                    } else if (keyCode == KeyEvent.VK_2) {
                        window.panel.checkPosition(2);
//                    System.out.println("2");
                    } else if (keyCode == KeyEvent.VK_3) {
                        window.panel.checkPosition(3);
//                    System.out.println("3");
                    } else if (keyCode == KeyEvent.VK_4) {
                        window.panel.checkPosition(4);
//                    System.out.println("4");
                    } else if (keyCode == KeyEvent.VK_5) {
                        window.panel.checkPosition(5);
//                    System.out.println("5");
                    } else if (keyCode == KeyEvent.VK_6) {
                        window.panel.checkPosition(6);
//                    System.out.println("6");
                    } else if (keyCode == KeyEvent.VK_7) {
                        window.panel.checkPosition(7);
//                    System.out.println("7");
                    } else if (keyCode == KeyEvent.VK_8) {
                        window.panel.checkPosition(8);
//                    System.out.println("8");
                    } else if (keyCode == KeyEvent.VK_9) {
                        window.panel.checkPosition(9);
//                    System.out.println("9");
                    }
                }
                if (keyCode == KeyEvent.VK_ESCAPE){
                    Panel.is_choosen = false;
                    Panel.is_win = false;
                    Panel.TicTacIcons.clear();
                    Panel.win_icons.clear();
                    Panel.win_cordinates.clear();
                    Panel.cordinates.clear();
                    Panel.board = new char[9][9];
                    Arrays.fill(Panel.board_win, false);
                    for (int i=0; i < Panel.board_win_chars.length; i++)
                        Panel.board_win_chars[i] = (char)i;
                    window.panel.rep();
                }
            }
        });
    }
}
