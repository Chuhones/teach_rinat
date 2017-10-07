package org.catan.components;

import org.newdawn.slick.Color;
import java.util.ArrayList;
import java.util.List;
import org.catan.components.raws.Raw;

/**
 *
 * @author Artyukov
 */
public class Player 
{
    protected String name;
    protected Color color;
    
    protected int freeVillageCount = 5;
    protected int freeCityCount = 4;
    protected int freeRoads = 15;
    
    protected List<Raw> raws = new ArrayList<>();

    public Player(String name, Color color)
    {
        this.name = name;
        this.color = color;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the color
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color)
    {
        this.color = color;
    }

    /**
     * @return the freeVillageCount
     */
    public int getFreeVillageCount()
    {
        return freeVillageCount;
    }

    /**
     * @param freeVillageCount the freeVillageCount to set
     */
    public void setFreeVillageCount(int freeVillageCount)
    {
        this.freeVillageCount = freeVillageCount;
    }

    /**
     * @return the freeCityCount
     */
    public int getFreeCityCount()
    {
        return freeCityCount;
    }

    /**
     * @param freeCityCount the freeCityCount to set
     */
    public void setFreeCityCount(int freeCityCount)
    {
        this.freeCityCount = freeCityCount;
    }

    /**
     * @return the freeRoads
     */
    public int getFreeRoads()
    {
        return freeRoads;
    }

    /**
     * @param freeRoads the freeRoads to set
     */
    public void setFreeRoads(int freeRoads)
    {
        this.freeRoads = freeRoads;
    }
    
    public List<Raw> getRaws()
    {
        return raws;
    }
    
}
