/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procgentest;

/**
 *
 * @author rooneys
 */

import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

public class ProcGenTestGUI extends JPanel {

    int H = 250;
    int W = 250;
    int[][] testArray = new int[H][W];
    
    private BufferedImage canvas;

    public ProcGenTestGUI()
    {
        canvas = new BufferedImage(250, 250, BufferedImage.TYPE_INT_ARGB);
        fillCanvas();
        pass3();
        pass2();
        pass4();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }
    
    public void fillCanvas() {
        int seed = 2632;
            for (int x = 0; x < H; x++) {
            for (int y = 0; y < W; y++) {
                if (x > 5 && y > 5 && (testArray[x - 1][y - 1] == testArray[x - 1][y] || testArray[x - 1][y - 1] == testArray[x][y - 1]) && (testArray[x][y] != testArray[x-5][y-5])) {
                    if ((this.rndGn()) % seed > 1) {
                        testArray[x][y] = testArray[x - 1][y - 1];
                        canvas.setRGB(x,y, -((testArray[x][y])*1000000));   
                    }

                } else {
                    testArray[x][y] = ((this.rndGn())%seed);
                    canvas.setRGB(x,y, -(((this.rndGn())%seed)*1000000));
                }
            }
            repaint();
        }
    }
    
    public void pass2() {
        int seed = 632;
            for (int x = 248; x > 0; x--) {
            for (int y = 248; y > 0; y--) {
                if (x > 6 && y > 6 && (testArray[x + 1][y + 1] == testArray[x + 1][y] || testArray[x + 1][y + 1] == testArray[x][y + 1]) && (testArray[x][y] != testArray[x-2][y-2])) {
                    if ((this.rndGn()) % seed > 1) {
                        testArray[x][y] = testArray[x + 1][y + 1];
                        canvas.setRGB(x,y, -((testArray[x][y])*1000000));   
                    }

                } else {

                }
            }
            repaint();
        }
    }
    
        public void pass3() {
        int seed = 1632;
            for (int x = 240; x > 0; x--) {
            for (int y = 0; y < W; y++) {
                if (x > 6 && y > 6 && (testArray[x + 1][y - 1] == testArray[x + 1][y] || testArray[x + 1][y - 1] == testArray[x][y - 1]) && (testArray[x][y] != testArray[x-5][y-5])) {
                    if ((this.rndGn()) % seed > 1) {
                        testArray[x][y] = testArray[x + 1][y - 1];
                        canvas.setRGB(x,y, -((testArray[x][y])*1000000));   
                    }

                } else {

                }
            }
            repaint();
        }
    }
        public void pass4() {
        int seed = 3632;
            for (int x = 0; x < H; x++) {
            for (int y = 247; y > 0; y--) {
                if (x > 6 && y > 6 && (testArray[x - 1][y + 1] == testArray[x - 1][y] || testArray[x - 1][y + 1] == testArray[x][y + 1]) && (testArray[x][y] != testArray[x-5][y-5])) {
                    if ((this.rndGn()) % seed > 1) {
                        testArray[x][y] = testArray[x - 1][y + 1];
                        canvas.setRGB(x,y, -((testArray[x][y])*100000));   
                    }

                } else {

                }
            }
            repaint();
        }
    }
    public void createAndShowGUI() {
        setBorder(BorderFactory.createLineBorder(Color.black));        
        JFrame f = new JFrame("test");
        ProcGenTestGUI p = new ProcGenTestGUI();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250, 250);
        f.setPreferredSize(new Dimension(250,250));
        f.add(p);
        p.setSize(250, 250);
        f.pack();
        f.setVisible(true);
        p.setVisible(true);
    }

    public int rndGn() {
        Random rndGn = new Random();
        int randomInt = (1 + (rndGn.nextInt(9)));
        return randomInt;

    }
}
