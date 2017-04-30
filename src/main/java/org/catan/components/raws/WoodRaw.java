package org.catan.components.raws;

import java.awt.Image;
import org.catan.ResourceLoader;

/**
 *
 * @author Artyukov
 */
public class WoodRaw extends Raw
{
    private final String tileName = "wood_raw.png";
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
