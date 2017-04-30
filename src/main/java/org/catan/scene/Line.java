package org.catan.scene;

import java.util.ArrayList;
import java.util.List;
import org.catan.components.Player;

/**
 *
 * @author Artyukov
 */
public class Line 
{
    List<CrossLine> crossLines;
    Player player = null;

    public Line(CrossLine cross1, CrossLine cross2)
    {
        crossLines = new ArrayList<>();
        crossLines.add(cross1);
        crossLines.add(cross2);
    }
    
    public List<CrossLine> getCrossLines()
    {
        return crossLines;
    }
    
    public void occupy(Player player)
    {
        this.player = player;
    }
    
    public Player getPlayer()
    {
        return this.player;
    }
}
