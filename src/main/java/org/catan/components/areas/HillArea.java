package org.catan.components.areas;

import java.awt.Image;
import org.catan.ResourceLoader;
import org.catan.components.raws.ClayRaw;
import org.catan.components.raws.Raw;

/**
 *
 * @author Artyukov
 */
public class HillArea extends Area
{
    private final String tileName = "hill_area_cpy.png";
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
        return new ClayRaw();
    }

}
