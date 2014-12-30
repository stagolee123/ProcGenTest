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
int HEIGHT;
int WIDTH;
tile mapArray[][];
String mapName;

public map(int h, int w, tile[][] mapArray, String mapName)
{
this.HEIGHT = h;
this.WIDTH = w;
this.mapArray = mapArray;
this.mapName = mapName;
}

public tile getTileAt(int x, int y)
{
    return mapArray[x][y];
}
}
