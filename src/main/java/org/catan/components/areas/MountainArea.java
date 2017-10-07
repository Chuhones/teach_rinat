package org.catan.components.areas;

import java.io.IOException;
import org.catan.components.raws.OreRaw;
import org.catan.components.raws.Raw;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Artyukov
 */
public class MountainArea extends Area
{
    private final String textureName = "mountain_area_cpy.png";
    
    @Override
    public Image getTexture()
    {
        try
        {
            texture = new Image(textureName, false);
            texture.setFilter(Image.FILTER_NEAREST);
            return texture;
        }
        catch(SlickException ex)
        {
            Log.error(ex.getMessage(), ex);
            return null;
        }
    }
    
    @Override
    public Raw receiveRaw()
    {
        return new OreRaw();
    }

}
