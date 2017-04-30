package org.catan.components.areas;

import java.awt.Image;
import org.catan.ResourceLoader;

/**
 *
 * @author Artyukov
 */
public class DesertArea extends Area
{
    private final String tileName = "desert_area_cpy.png";
    private Image tile = null;
    
    public Image getTile()
    {
        if(tile == null)
        {
            tile = ResourceLoader.getTile(tileName);
        }
        return tile;
    }
}
