package org.catan.components.areas;

import java.awt.Image;
import org.catan.components.raws.Raw;

/**
 *
 * @author Artyukov
 */
public abstract class Area 
{
    double randomValue = 0.0;
    
    public void setRandomValue(double value)
    {
        randomValue = value;
    }
    
    public double getRandomValue()
    {
        return randomValue;
    }
    
    public Image getTile()
    {
        return null;
    }
    
    public Raw receiveRaw()
    {
        return null;
    }
}
