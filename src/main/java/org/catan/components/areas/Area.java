package org.catan.components.areas;

import org.catan.components.raws.Raw;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author Artyukov
 */
public abstract class Area 
{
    protected Image texture = null;
    protected Shape mesh = null;
    
    double randomValue = 0.0;
    
    public void setRandomValue(double value)
    {
        randomValue = value;
    }
    
    public double getRandomValue()
    {
        return randomValue;
    }
    
    public Shape getMesh()
    {
        if(mesh == null)
        {
            mesh = new Rectangle(0, 0, 100, 115);
        }
        return mesh;
    }
  
    public Image getTexture()
    {
        return null;
    }
    
    public Raw receiveRaw()
    {
        return null;
    }
}
