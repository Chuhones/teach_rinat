package org.catan.breakings;

import java.awt.Image;
import org.catan.ResourceLoader;

/**
 *
 * @author Artyukov
 */
public class Townhall extends Breaking
{
    private final String tileName = "townhall.png";
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
