package org.catan.components.areas;

import java.awt.Image;
import org.catan.ResourceLoader;
import org.catan.components.raws.Raw;
import org.catan.components.raws.WoolRaw;

/**
 *
 * @author Artyukov
 */
public class PastureArea extends Area
{
    private final String tileName = "pasture_area_cpy.png";
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
        return new WoolRaw();
    }
    
}
