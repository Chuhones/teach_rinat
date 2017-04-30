package org.catan.components.raws;

import java.awt.Image;
import org.catan.ResourceLoader;

/**
 *
 * @author Artyukov
 */
public class ClayRaw extends Raw
{
    private final String tileName = "clay_raw.png";
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
