package org.catan.components.areas;

import java.io.IOException;
import org.catan.components.raws.Raw;
import org.catan.components.raws.WoodRaw;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Artyukov
 */
public class ForestArea extends Area
{
    private final String textureName = "forest_area_cpy.png";
    
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
        return new WoodRaw();
    }
}
