package org.catan;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;
import org.catan.components.Player;

/**
 *
 * @author Artyukov
 */
public class PlayerPanel extends JPanel
{
    PlayerPanelBackground background;
    private Player player = null;

    public PlayerPanel()
    {
        background = new PlayerPanelBackground();
        add(background);
        background.setVisible(true);
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
        Rectangle bound = getBounds();
        background.init((int)bound.getMinX()+20, 
                        (int)bound.getMinY()+20, 
                        (int)bound.getWidth()-40, 
                        (int)bound.getHeight()-40);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g); 
        paintPlayerPanel(g);
    }
    
    public void paintPlayerPanel(Graphics g)
    {
        Graphics2D graphics = (Graphics2D)g;
        background.paint(g);               
        
        graphics.dispose();
    }
    
    
}
