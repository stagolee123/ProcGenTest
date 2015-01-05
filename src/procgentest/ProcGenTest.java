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
    
    int mapWIDTH = 250;
    int mapHEIGHT = 250;
    int tileSize = 10;
    String name = "Map1";
    tile[][] newTileArray = new tile[mapWIDTH][mapHEIGHT];
            for (int w = 0; w < mapWIDTH; w++) {
            for (int h = 0; h < mapHEIGHT; h++) {
                tile newTile = new tile(rndGn(9),rndGn(9),w,h,tileSize);
                newTileArray[w][h]=newTile;
                }
            }
    map newMap = new map(mapWIDTH,mapHEIGHT,newTileArray,name);

    for (int i = 1; i < 5000; i++) 
    {
//        mapSmoothing(newMap);
        int rndW = rndGn(248);
 //       System.out.println("rndX: "+rndW);
        int rndH = rndGn(248);
 //       System.out.println("rndH: "+rndH);
        int TileMiddleElev = (newMap.mapArray[rndW][rndH].getTileElevation());
        int TileBelowElev = (newMap.mapArray[rndW][rndH+1].getTileElevation());
        int TileBelowLeftElev = (newMap.mapArray[rndW-1][rndH+1].getTileElevation());
        int TileBelowRightElev = (newMap.mapArray[rndW+1][rndH+1].getTileElevation());
        int TileRightElev = (newMap.mapArray[rndW+1][rndH].getTileElevation()); 
        int TileAboveElev = (newMap.mapArray[rndW][rndH-1].getTileElevation());
        int TileAboveLeftElev = (newMap.mapArray[rndW-1][rndH-1].getTileElevation());
        int TileAboveRightElev = (newMap.mapArray[rndW+1][rndH-1].getTileElevation());
        int TileLeftElev = (newMap.mapArray[rndW-1][rndH].getTileElevation()); 
        
//        if (TileMiddleElev+1<TileRightElev)
//        {
//            newMap.mapArray[rndW+1][rndH].setTileElevation(TileRightElev-1);
//        }
//        if (TileMiddleElev-1>TileRightElev)
//        {
//            newMap.mapArray[rndW+1][rndH].setTileElevation(TileRightElev+1);
//        }
//        if (TileMiddleElev+1<TileLeftElev)
//        {
//            newMap.mapArray[rndW-1][rndH].setTileElevation(TileLeftElev-1);
//        }
//        if (TileMiddleElev-1>TileLeftElev)
//        {
//            newMap.mapArray[rndW-1][rndH].setTileElevation(TileLeftElev+1);
//        }
//        if (TileMiddleElev+1<TileBelowElev)
//        {
//            newMap.mapArray[rndW][rndH+1].setTileElevation(TileBelowElev-1);
//        }
//        if (TileMiddleElev-1>TileBelowElev)
//        {
//            newMap.mapArray[rndW][rndH+1].setTileElevation(TileBelowElev+1);
//        }
//        if (TileMiddleElev+1<TileAboveElev)
//        {
//            newMap.mapArray[rndW][rndH-1].setTileElevation(TileAboveElev-1);
//        }
//        if (TileMiddleElev-1>TileAboveElev)
//        {
//            newMap.mapArray[rndW][rndH-1].setTileElevation(TileAboveElev+1);
//        }
//        if (TileMiddleElev<4&&TileRightElev>3&&TileLeftElev>3&TileAboveElev>3&&TileBelowElev>3)
//        {
//            newMap.mapArray[rndW][rndH].setTileElevation(4);
//            System.out.println("normalized tile: "+ rndW+","+rndH);
//        }
//        if (TileMiddleElev>3&&TileRightElev<4&&TileLeftElev<4&TileAboveElev<4&&TileBelowElev<4)
//        {
//            newMap.mapArray[rndW][rndH].setTileElevation(3);
//            System.out.println("normalized tile: "+ rndW+","+rndH);
//        }
           
        newMap.mapArray[rndW][rndH].setTileElevation((TileMiddleElev+TileBelowElev+TileBelowLeftElev+TileBelowRightElev+TileRightElev+TileAboveElev+TileAboveLeftElev+TileAboveRightElev+TileLeftElev)/9);
        
        
        }
    
    
    
    ProcGenTestGUI newProcGenTestGUI = new ProcGenTestGUI(newMap);
    newProcGenTestGUI.createAndShowGUI(newMap);
    }  
        public static int rndGn(int range) {
        Random rndGn = new Random();
        int randomInt = (1 + (rndGn.nextInt(range)));
        return randomInt;
    }
    
//        public static void mapSmoothing(map newMap)
//        {

}

    
