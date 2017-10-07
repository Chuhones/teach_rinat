package org.catan;

import java.awt.Font;
import org.catan.components.Player;
import org.catan.core.Component;
import org.catan.core.TextInRectangleRenderer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.svg.Diagram;
import org.newdawn.slick.svg.Figure;
import org.newdawn.slick.svg.InkscapeLoader;
import org.newdawn.slick.svg.SimpleDiagramRenderer;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Artyukov
 */
public class PlayerPanel extends Component
{
    public static final String playerPanelSvgName = "player_panel.svg";
    protected Diagram playerShape;
    
    Shape playerBackground = null;
    Shape playerName = null;
    Shape playerPhoto = null;
    Shape playerRaws = null;
    Shape playerScore = null;
    
    protected SimpleDiagramRenderer svgRender = null;
    protected TextInRectangleRenderer textRenderer = null;
    
    private Player player = null;

    
    public PlayerPanel(GUIContext container)
    {
        super(container);
        init(container);
    }
    
    public void init(GUIContext container)
    {
        try
        {
            playerShape = InkscapeLoader.load(playerPanelSvgName);
            textRenderer = new TextInRectangleRenderer("Times New Roman", Font.BOLD, 10);
            
            Figure tempFigure = playerShape.getFigureByID("player_name");
            playerName = tempFigure.getShape();
            
            tempFigure = playerShape.getFigureByID("player_background");
            tempFigure.getData().addAttribute("fill", "#ac780f");
            playerBackground = tempFigure.getShape();
            
            
        }
        catch(SlickException sle)
        {
            Log.debug("Errrrrrororororo SVG");
        }
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
        if(player != null)
        {
            fillPanels();
        }
    }

    protected void fillPanels()
    {
        
    }

    @Override
    public void render(GUIContext guic, Graphics grphcs) throws SlickException
    {
        if(player != null && playerShape != null)
        {
            grphcs.translate(x, y);
            grphcs.scale(2, 2);
            SimpleDiagramRenderer.render(grphcs,playerShape);
            textRenderer.render(guic, grphcs, player.getName(), playerName, player.getColor());
            grphcs.scale(1/2, 1/2);
        }
    }

}
