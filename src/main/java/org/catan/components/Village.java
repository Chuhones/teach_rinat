package org.catan.components;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Artyukov
 */
public class Village extends Settlement
{
    private final String tileName = "house.png";

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
            texture = new Image(tileName, false);
            texture.setFilter(Image.FILTER_NEAREST);
            return texture;
        }
        catch(SlickException ex)
        {
            Log.error(ex.getMessage(), ex);
            System.out.println("Errororororo");
            return null;
        }
    }
    
}
