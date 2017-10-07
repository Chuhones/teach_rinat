package org.catan;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import org.catan.components.Player;

/**
 *
 * @author Artyukov
 */
public class PlayerNamePanel extends JPanel
{
    private Player player = null;
    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public Player getPlayer()
    {
        return player;
    }
    
    public void init(int xCoord, int yCoord, int width, int height, Player player)
    {
        setPlayer(player);
        setBounds(xCoord, yCoord, width, height);
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g); 
        Graphics2D graph = (Graphics2D)g;
        
        graph.setPaintMode();
        graph.setFont(Font.getFont(Font.SANS_SERIF));
        
        String playerName = (player == null)? "N/A":player.getName();
        graph.drawString(playerName, getX(), getY());
    }
}
