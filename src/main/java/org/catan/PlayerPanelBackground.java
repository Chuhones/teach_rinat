package org.catan;

import java.io.IOException;
import org.catan.components.Player;
import org.catan.core.Component;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Artyukov
 */
public final class PlayerPanelBackground extends Component
{
    protected Player player = null;
    public static final int DEFAULT_WIDTH = 450;
    public static final int DEFAULT_HEIGHT = 180;

    private final String angleTileLeftDownName = "player_panel_angle_ld.png";
    private final String angleTileRightDownName = "player_panel_angle_rd.png";
    private final String angleTileLeftUpName = "player_panel_angle_lu.png";
    private final String angleTileRightUpName = "player_panel_angle_ru.png";
    private final String lineTileLeftName = "player_panel_line_l.png";
    private final String lineTileRightName = "player_panel_line_r.png";
    private final String lineTileUpName = "player_panel_line_u.png";
    private final String lineTileDownName = "player_panel_line_d.png";

    private Texture angleTileLeftDown = null;
    private Texture angleTileRightDown = null;
    private Texture angleTileLeftUp = null;
    private Texture angleTileRightUp = null;
    private Texture lineTileLeft = null;
    private Texture lineTileRight = null;
    private Texture lineTileUp = null;
    private Texture lineTileDown = null;

    public PlayerPanelBackground(GUIContext container, int X, int Y, int width, int height)
    {
        this(container);
        setLocation(X, Y);
        this.width = width;
        this.height = height;
    }
    
    private PlayerPanelBackground(GUIContext container)
    {
        super(container);
        try
        {
            InternalTextureLoader textureLoader = InternalTextureLoader.get();
            angleTileLeftDown = textureLoader.getTexture(angleTileLeftDownName, false, 0);
            angleTileRightDown = textureLoader.getTexture(angleTileRightDownName, false, 0);
            angleTileLeftUp = textureLoader.getTexture(angleTileLeftUpName, false, 0);
            angleTileRightUp = textureLoader.getTexture(angleTileRightUpName, false, 0);
            lineTileLeft = textureLoader.getTexture(lineTileLeftName, false, 0);
            lineTileRight = textureLoader.getTexture(lineTileRightName, false, 0);
            lineTileUp = textureLoader.getTexture(lineTileUpName, false, 0);
            lineTileDown = textureLoader.getTexture(lineTileDownName, false, 0);
        }
        catch(IOException ioe)
        {
            System.out.println("Cannot resolve textures ");
        }
    }
    
    public void init(int xCoord, int yCoord, int width, int height, Player player)
    {
        setPlayer(player);
        //setBackground(new Color(176, 120, 15));
        //setBounds(xCoord, yCoord, width, height);
        //setVisible(true);
    }

    @Override
    public void render(GUIContext guic, Graphics grphcs) throws SlickException
    {
        super.render(guic, grphcs);
        paintOrnament(grphcs);
        grphcs.flush();
    }

    public final void paintOrnament(Graphics graph)
    {
        //graph.setPaintMode();

        graph.drawImage(new Image(angleTileLeftUp),    getX(),                      getY());//,                     30, 30, this);
        graph.drawImage(new Image(angleTileRightUp),   getX() + getWidth() - 30,    getY());//,                     30, 30, this);
        graph.drawImage(new Image(angleTileRightDown), getX() + getWidth() - 30,    getY());// + getHeight() - 30,  30, 30, this);
        graph.drawImage(new Image(angleTileLeftDown),  getX(),                      getY());// + getHeight() - 30,  30, 30, this);

        graph.drawImage(new Image(lineTileLeft),    getX(),                   getY() + 30);//,                  30,                 getHeight() - 60, this);
        graph.drawImage(new Image(lineTileRight),   getX() + getWidth() - 30, getY() + 30);//,                  30,                 getHeight() - 60, this);
        graph.drawImage(new Image(lineTileUp),      getX() + 30,              getY());//,                       getWidth() - 60,    30,               this);
        graph.drawImage(new Image(lineTileDown),    getX() + 30,              getY() + getHeight() - 30);//,    getWidth() - 60,    30,               this);
    }

    /**
     * @return the player
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player)
    {
        this.player = player;
    }

}
