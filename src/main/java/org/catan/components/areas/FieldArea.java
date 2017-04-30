package org.catan.components.areas;

import java.awt.Image;
import org.catan.ResourceLoader;
import org.catan.components.raws.GrainRaw;
import org.catan.components.raws.Raw;

/**
 *
 * @author Artyukov
 */
public class FieldArea extends Area
{
    private final String tileName = "field_area_cpy.png";
    private Image tile = null;
    
    @Override
    public Image getTile()
    {
        if(tile == null)
        {
            tile = ResourceLoader.getTile(tileName);
        }
        return tile;
    }
    
    @Override
    public Raw receiveRaw()
    {
        return new GrainRaw();
    }
    
}
