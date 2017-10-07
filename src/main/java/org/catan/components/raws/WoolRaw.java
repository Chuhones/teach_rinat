package org.catan.components.raws;

import java.io.IOException;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Artyukov
 */
public class WoolRaw extends Raw
{
    private final String tileName = "wool_raw.png";
    private Texture tile = null;
    
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
