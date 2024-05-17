import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MyPanel extends JPanel {


    public int count;
    private int multiplier;
    public static String cheatCode = "";
    private String status;
    private boolean shop;
    private int timer;
    public MyPanel(){


        count = 0;
        multiplier = 1;
        status = "Baby Programmer";
        shop = false;
        timer = 0;
        setBackground(Color.GRAY);


        addMouseListener(new MouseAdapter() {


            @Override
            public void mousePressed(MouseEvent e){


                super.mousePressed(e);


                if(!shop){
                    if(e.getX() >= 327 && e.getX() <= 577 && e.getY() >= 550 && e.getY() <= 650) {
                        shop = true;
                    } else {
                        count += multiplier;
                    }


                } else {
                    if(e.getY() >= 550 && e.getY() <= 650){
                        if(e.getX() >= 327 && e.getX() <= 577)
                            shop = false;


                    } else if(e.getY() >= 250 && e.getY() <= 350){
                        if(e.getX() >= 190 && e.getX() <= 560){
                            if(count >= 200){
                                multiplier = 2;
                                count -= 200;
                            }
                        }
                    } else if(e.getY() >= 400 && e.getY() <= 500){
                        if(e.getX() >= 190 && e.getX() <= 560){
                            if(count >= 1000){
                                multiplier = 5;
                                count -= 1000;
                            }
                        }
                    }
                }


            }


        });


    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        if(!shop){
            if(count >= 10000 || cheatCode.contains("seaver")){
                status = "Seaver (MAX LEVEL)";
            } else if(count >= 5000){
                status = "Prateek (GOAT LEVEL)";
            } else if(count >= 2500){
                status = "Jack (Amazing LEVEL)";
            } else if(count >= 1000){
                status = "Logan (Great LEVEL)";
            } else if(count >= 500){
                status = "Luke (Good LEVEL)";
            } else if(count >= 100){
                status = "Sean (Mid LEVEL)";
            } else if(count >= 50){
                status = "Ryan (Bad LEVEL)";
            }


            g.setColor(Color.PINK);
            g.setFont(new Font("SansSerif", Font.PLAIN, 75));
            int textWidth1 = g.getFontMetrics().stringWidth("Programmer Tycoon");
            g.drawString("Programmer Tycoon", 375 - (textWidth1 / 2), 125);

            if(status.contains("Ryan (Bad LEVEL)")){
                ImageIcon image = new ImageIcon("Images/ryan.png");
                g.drawImage(image.getImage(), 200, 200, 200, 400, null);
            }
            else if(status.contains("Sean (Mid LEVEL)")){
                ImageIcon image = new ImageIcon("Images/sean.png");
                g.drawImage(image.getImage(), 200, 200, 200, 400, null);
            }else if(status.contains("Luke (Good LEVEL)")){
                ImageIcon image = new ImageIcon("Images/luke.PNG");
                g.drawImage(image.getImage(), 200, 200, 200, 400, null);
            }else if(status.contains("Logan (Great LEVEL)")){
                ImageIcon image = new ImageIcon("Images/goog.png");
                g.drawImage(image.getImage(), 200, 200, 200, 400, null);
            }else if(status.contains("Jack (Amazing LEVEL)")){
                ImageIcon image = new ImageIcon("Images/jack.PNG");
                g.drawImage(image.getImage(), 200, 200, 200, 400, null);
            }

            g.setColor(Color.WHITE);
            g.setFont(new Font("SansSerif", Font.PLAIN, 50));
            int textWidth2 = g.getFontMetrics().stringWidth("Clicks: " + count);
            g.drawString("Clicks: " + count, 375 - (textWidth2 / 2), 225);




            g.setColor(Color.YELLOW);
            g.setFont(new Font("SansSerif", Font.PLAIN, 40));
            int textWidth3 = g.getFontMetrics().stringWidth("Status: " + status);
            g.drawString("Status: " + status, 375 - (textWidth3 / 2), 500);


            g.setColor(Color.PINK);
            g.fillRect(375 - (250/2), 550, 250, 100);
            g.setColor(Color.WHITE);
            int textWidth4 = g.getFontMetrics().stringWidth("Shop");
            g.drawString("Shop", 375 - (textWidth4 / 2), 620);


            if(status.contains("Seaver")){
                timer++;
            }


            if(timer >= 60){
                System.exit(0);
            } else if(timer > 0){
                g.setColor(Color.GREEN);
                g.setFont(new Font("SansSerif", Font.PLAIN, 100));
                g.drawString("YOU WIN!", 375 - (g.getFontMetrics().stringWidth("YOU WIN!") / 2), 360);
            }


        } else {
            g.setColor(Color.PINK);
            g.setFont(new Font("SansSerif", Font.PLAIN, 75));
            int textWidth5 = g.getFontMetrics().stringWidth("The Shop");
            g.drawString("The Shop", 375 - (textWidth5 / 2), 125);


            g.setFont(new Font("SansSerif", Font.PLAIN, 35));


            g.setColor(Color.WHITE);
            int textWidth6 = g.getFontMetrics().stringWidth("Clicks: " + count);
            g.drawString("Clicks: " + count,375 - (textWidth6 / 2), 200);


            g.setColor(Color.PINK);
            g.fillRect(375 - (370/2), 250, 370, 100);
            g.setColor(Color.WHITE);
            if(multiplier >= 2){
                int textWidth7 = g.getFontMetrics().stringWidth("Unavailable");
                g.drawString("Unavailable", 375 - (textWidth7 / 2), 320);
            } else {
                int textWidth7 = g.getFontMetrics().stringWidth("2x Mult (200 Clicks)");
                g.drawString("2x Mult (200 Clicks)", 375 - (textWidth7 / 2), 320);
            }


            g.setColor(Color.PINK);
            g.fillRect(375 - (370/2), 400, 370, 100);
            g.setColor(Color.WHITE);
            if(multiplier >= 5){
                int textWidth8 = g.getFontMetrics().stringWidth("Unavailable");
                g.drawString("Unavailable", 375 - (textWidth8 / 2), 470);
            } else {
                int textWidth8 = g.getFontMetrics().stringWidth("5x Mult (1000 Clicks)");
                g.drawString("5x Mult (1000 Clicks)", 375 - (textWidth8 / 2), 470);
            }


            g.setFont(new Font("SansSerif", Font.PLAIN, 45));
            g.setColor(Color.PINK);
            g.fillRect(375 - (250/2), 550, 250, 100);
            g.setColor(Color.WHITE);
            int textWidth4 = g.getFontMetrics().stringWidth("Back");
            g.drawString("Back", 375 - (textWidth4 / 2), 620);
        }


        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();


        JButton gambleButton = new JButton("Gamble");
        gambleButton.setBounds(300, 650, 150, 50);
        gambleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform the gambling action
                int outcome = (int) (Math.random() * 100);
                if (outcome < 50) {
                    // Reset clicks and status to original values
                    count = 0;
                    multiplier = 1;
                    status = "Baby Programmer";
                } else {
                    count *=2;


                }
            }
        });
        add(gambleButton); // Add the button to the panel
    }




}



