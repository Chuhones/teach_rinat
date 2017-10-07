package org.catan.components;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author Artyukov
 */
public abstract class Settlement 
{
    protected Image texture;
    protected Shape mesh;
            
    /**
     * @return the texture
     */
    public Image getTexture()
    {
        return texture;
    }

    /**
     * @return the mesh
     */
    public Shape getMesh()
    {
        return mesh;
    }
}
