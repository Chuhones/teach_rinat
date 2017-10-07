package org.catan.breakings;

import java.awt.Image;
import java.io.IOException;
import org.catan.core.ResourceLoaderCatan;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Artyukov
 */
public class Market extends Breaking
{
    private final String tileName = "market.png";
    @Override
    public Texture getTexture()
    {
        if(tile == null)
        {
            try
            {
                tile = InternalTextureLoader.get().getTexture(tileName, false, 0);
            }
            catch(IOException ioe)
            {
                System.out.println("Cannot resolve texture "+tileName);
            }
        }
        return tile;
    }
}
