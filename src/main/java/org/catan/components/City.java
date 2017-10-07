package org.catan.components;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Artyukov
 */
public class City extends Settlement
{
    private final String tileName = "building.png";
    
    @Override
    public Shape getMesh()
    {
        if(mesh == null)
        {
            mesh = new Rectangle(0, 0, 40, 40);
        }
        return mesh;
    }

    @Override
    public Image getTexture()
    {
        try
        {
            if(texture == null)
            {
                texture = new Image(tileName, false);
                return texture;
            }
        }
        catch(Exception ex)
        {
            Log.error(ex.getMessage(), ex);
            System.out.println("Errororororo");
            return null;
        }
        
        return texture;
    }
}
