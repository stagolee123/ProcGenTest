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
public class tile {
int Type;
int Elevation;
int x;
int y;
int size;

public tile(int initType, int initElevation, int initX , int initY, int size)
{
    this.Type = initType;
    this.Elevation = initElevation;
    this.x = initX;
    this.y = initY;
    this.size = size;
}

public void setTileType(int newType)
{
    this.Type = newType;
}

public void setTileX(int newX)
{
    this.x = newX;
}

public void setTileY(int newY)
{
    this.y = newY;
}

public void setTileElevation(int newElevation)
{
    this.Elevation = newElevation;
}

public void setTileSize(int newSize)
{
    this.size = newSize;
}

public int getTileSize()
{
    return this.size;
}

public int getTileType()
{
    return this.Type;
}

public int getTileElevation()
{
    return this.Elevation;
}

public int getTileX()
{
    return this.x;
}

public int getTileY()
{
    return this.y;
}

}