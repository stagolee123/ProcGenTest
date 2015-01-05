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
public class map{
int WIDTH;   
int HEIGHT;
tile mapArray[][];
String mapName;

public map(int w, int h, tile[][] mapArray, String mapName)
{
this.WIDTH = w;
this.HEIGHT = h;
this.mapArray = mapArray;
this.mapName = mapName;
}

public tile getTileAt(int x, int y)
{
    return mapArray[x][y];
}
}
