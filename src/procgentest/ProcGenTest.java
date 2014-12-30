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
import java.util.Random;

public class ProcGenTest {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args) {
    
    int mapHEIGHT = 250;
    int mapWIDTH = 250;
    int tileSize = 10;
    String name = "Map1";
    tile[][] newTileArray = new tile[mapHEIGHT][mapWIDTH];
            for (int x = 0; x < mapHEIGHT; x++) {
            for (int y = 0; y < mapWIDTH; y++) {
                tile newTile = new tile(rndGn(),rndGn(),x,y,tileSize);
                newTileArray[x][y]=newTile;
                }
            }
    map newMap = new map(mapHEIGHT,mapWIDTH,newTileArray,name);    
    ProcGenTestGUI newProcGenTestGUI = new ProcGenTestGUI(newMap);
    newProcGenTestGUI.createAndShowGUI(newMap);
    }  
        public static int rndGn() {
        Random rndGn = new Random();
        int randomInt = (1 + (rndGn.nextInt(9)));
        return randomInt;
    }
    
}

    