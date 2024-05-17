import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Main {


    public static void main(String[] args) {


        JFrame frame = new JFrame("Programmer Tycoon");
        frame.setSize(750, 750);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new MyPanel());


        frame.setVisible(true);


        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    MyPanel.cheatCode += "s";
                } else if (e.getKeyCode() == KeyEvent.VK_E) {
                    MyPanel.cheatCode += "e";
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    MyPanel.cheatCode += "a";
                } else if (e.getKeyCode() == KeyEvent.VK_V) {
                    MyPanel.cheatCode += "v";
                } else if (e.getKeyCode() == KeyEvent.VK_R) {
                    MyPanel.cheatCode += "r";
                }
            }
        });


    }
}

