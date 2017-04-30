package org.catan.components.areas;

import java.awt.Image;
import org.catan.ResourceLoader;

/**
 *
 * @author Artyukov
 */
public class WaterArea extends Area
{
    private final String tileName = "water_area_cpy.png";
    
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
}
