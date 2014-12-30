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
    private BufferedImage canvas;
    map newMap;

    public ProcGenTestGUI(map newMap)
    {
        this.newMap = newMap;
        canvas = new BufferedImage(250, 250, BufferedImage.TYPE_INT_ARGB);
        fillCanvas();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }
    
    public void fillCanvas() {
            int mapHeight = newMap.HEIGHT;
                System.out.println("MapHeight: "+ mapHeight);
            int mapWidth = newMap.WIDTH;
                System.out.println("MapWidth: "+ mapWidth);
            int tileSize = newMap.getTileAt(1, 1).getTileSize();
                System.out.println("TileSize: "+ tileSize);
            int numberOfHorizontalTiles = (mapHeight/tileSize);
                System.out.println("numberOfHorizontalTiles: "+ numberOfHorizontalTiles);
            int numberOfVerticalTiles = (mapWidth/tileSize);
                System.out.println("numberOfVerticalTiles" + numberOfVerticalTiles);
            for (int x = 0; x < numberOfHorizontalTiles ; x++)
            {
                for (int y = 0; y < numberOfVerticalTiles ; y++)
                {
                    for (int a = x*tileSize; a < (x*tileSize)+tileSize; a++) 
                    {
                        for (int b = y*tileSize; b < (y*tileSize)+tileSize; b++) 
                        {
                            canvas.setRGB(a,b,-getColour((newMap.getTileAt(x, y)).getTileElevation(),(newMap.getTileAt(x, y)).getTileType()));
                        }
                    }
                }    
            repaint();
        }
    }
    
    public int getColour(int elevation, int type){
        int output;
        if (type < 5)
        {
            output = 5055755;
            return output;
        }else
                   switch (elevation){
                   case 1: output = 101010;
                       break;
                   case 2: output = 202020;
                       break; 
                   case 3: output = 303030;
                       break;   
                   case 4: output = 404040;
                       break;   
                   case 5: output = 505050;
                       break;   
                   default: output = 606060;
                       break;                   
        }
        return output;      
    }

    public void createAndShowGUI(map newMap) {
        setBorder(BorderFactory.createLineBorder(Color.black));        
        JFrame f = new JFrame("test");
        ProcGenTestGUI p = new ProcGenTestGUI(newMap);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250, 250);
        f.setPreferredSize(new Dimension(250,250));
        f.add(p);
        p.setSize(250, 250);
        f.pack();
        f.setVisible(true);
        p.setVisible(true);
    }

}
