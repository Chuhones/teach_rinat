package org.catan.breakings;

import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Artyukov
 */
public abstract class Breaking 
{
    protected Texture tile = null;
    
    public abstract Texture getTexture();
}
