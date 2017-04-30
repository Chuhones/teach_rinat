package org.catan.components.areas;

import java.awt.Image;
import org.catan.ResourceLoader;
import org.catan.components.raws.Raw;
import org.catan.components.raws.WoodRaw;

/**
 *
 * @author Artyukov
 */
public class ForestArea extends Area
{
    private final String tileName = "forest_area_cpy.png";
    private Image tile = null;
    
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
        return new WoodRaw();
    }
}
