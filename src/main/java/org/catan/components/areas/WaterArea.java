package org.catan.components.areas;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Artyukov
 */
public class WaterArea extends Area
{
    private final String textureName = "water_area_cpy.png";
    
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
}
