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
    int mapWIDTH = ProcGenTest.mapWIDTH;
    int mapHEIGHT = ProcGenTest.mapHEIGHT;
    
    public ProcGenTestGUI(map newMap)
    {
        this.newMap = newMap;
        canvas = new BufferedImage(mapWIDTH, mapHEIGHT, BufferedImage.TYPE_INT_ARGB);
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
                            canvas.setRGB(a,b,getColour((newMap.getTileAt(x, y)).getTileElevation(),(newMap.getTileAt(x, y)).getTileType()));
                        }
                    }
                }    
            repaint();
        }
    }
    
    public int getColour(int elevation, int type){
        int output;
              switch (elevation){
                   case 1: 
                       Color col1 = new Color(31, 133, 235);
                       output = col1.getRGB();
                       break;
                   case 2: 
                       Color col2 = new Color(41, 143, 245);
                       output = col2.getRGB();
                       break; 
                   case 3: 
                       Color col3 = new Color(51, 153, 255);
                       output = col3.getRGB();
                       break;   
                   case 4:                        
                       Color col4 = new Color(140, 170, 65);
                       output = col4.getRGB();
                       break;   
                   case 5:                        
                       Color col5 = new Color(150, 180, 75);
                       output = col5.getRGB();
                       break;
                   case 6:                        
                       Color col6 = new Color(160, 190, 85);
                       output = col6.getRGB();
                       break;
                   case 7:                        
                       Color col7 = new Color(170, 200, 95);
                       output = col7.getRGB();
                       break;
                   case 8:                        
                       Color col8 = new Color(180, 210, 105);
                       output = col8.getRGB();
                       break;
                       
                  default: 
                       Color col9 = new Color(190, 220, 115);
                       output = col9.getRGB();
                       break;                   
        }
        return output;      
    }

    public void createAndShowGUI(map newMap) {
        setBorder(BorderFactory.createLineBorder(Color.black));        
        JFrame f = new JFrame("test");
        ProcGenTestGUI p = new ProcGenTestGUI(newMap);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(mapWIDTH, mapHEIGHT);
        f.setPreferredSize(new Dimension(mapWIDTH+15, mapHEIGHT+20));
        f.add(p);
        p.setSize(mapWIDTH, mapHEIGHT);
        f.pack();
        f.setVisible(true);
        p.setVisible(true);
    }

}

