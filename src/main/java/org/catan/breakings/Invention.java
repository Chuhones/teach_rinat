package org.catan.breakings;

import java.io.IOException;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Artyukov
 */
public class Invention extends Breaking
{
    private final String tileName = "invention.png";
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
