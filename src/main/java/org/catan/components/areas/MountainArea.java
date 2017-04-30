package org.catan.components.areas;

import java.awt.Image;
import org.catan.ResourceLoader;
import org.catan.components.raws.OreRaw;
import org.catan.components.raws.Raw;

/**
 *
 * @author Artyukov
 */
public class MountainArea extends Area
{
    private final String tileName = "mountain_area_cpy.png";
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
        return new OreRaw();
    }

}
