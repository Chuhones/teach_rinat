package org.catan.scene;

import org.catan.components.areas.Area;

/**
 *
 * @author Artyukov
 */
public class Segment 
{
    protected Area area = null;
    String number = "N/A";
    
    private int xCoord = 0;
    private int yCoord = 0;

    public Segment(String number)
    {
        this.number = number;
    }
    
    public Segment(String number, Area area)
    {
        this(number);
        this.area = area;
    }

    public String getNumber()
    {
        return number;
    }

    /**
     * @return the xCoord
     */
    public int getXCoord()
    {
        return xCoord;
    }

    /**
     * @param xCoord the xCoord to set
     */
    public void setXCoord(int xCoord)
    {
        this.xCoord = xCoord;
    }

    /**
     * @return the yCoord
     */
    public int getYCoord()
    {
        return yCoord;
    }

    /**
     * @param yCoord the yCoord to set
     */
    public void setYCoord(int yCoord)
    {
        this.yCoord = yCoord;
    }

    /**
     * @return the area
     */
    public Area getArea()
    {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Area area)
    {
        this.area = area;
    }
}
