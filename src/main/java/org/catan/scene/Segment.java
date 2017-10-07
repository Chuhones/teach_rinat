package org.catan.scene;

import org.catan.components.areas.Area;
import org.catan.core.BaseComponent;
import org.catan.core.Component;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.util.Log;

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

    protected Component graphComponent = null; 

    public void initGraphics(GUIContext container, Component parentComponent) throws SlickException
    {
        if(parentComponent == null)
        {
            throw new SlickException("Cannot create crossline without parent");
        }
        graphComponent = new BaseComponent(container);
        graphComponent.setParent(parentComponent);
        graphComponent.setMesh(resolveShape());
        graphComponent.setImage(resolveImage());
        graphComponent.setLocation(parentComponent.getX()+xCoord, parentComponent.getY()+yCoord);
    }
    
    public void render(GUIContext guic, org.newdawn.slick.Graphics g)
            throws SlickException
    {
        graphComponent.render(guic, g);
    }
    
    protected Image resolveImage()
    {
        if(graphComponent == null || area == null)
        {
            return null;
        }

        return area.getTexture();
    }
    
    protected Shape resolveShape()
    {
        if(graphComponent == null || area == null)
        {
            return null;
        }

        return area.getMesh();
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
