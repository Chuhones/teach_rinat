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
    PlayerPanelRaws raws;
    private Player player = null;

    public PlayerPanel()
    {
        //background = new PlayerPanelBackground();
        raws = new PlayerPanelRaws(this);
    }

    @Override
    public void setVisible(boolean aFlag)
    {
        System.out.println("Player Panel bounds: "+getX()+"   "+getY()+"   "+getWidth()+"   "+getHeight());
        //add(background,0);
        add(raws,0);

        super.setVisible(aFlag);

        //background.setVisible(true);
        raws.setVisible(true);


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
//        background.init((int)bound.getMinX(),
//                        (int)bound.getMinY(),
//                        (int)bound.getWidth(),
//                        (int)bound.getHeight());

        raws.init((int)bound.getMinX()+30,
                  (int)(bound.getMinY() + bound.getHeight()/2 - 60),
                  (int)bound.getWidth()-60,
                  (int)bound.getHeight()/2);

    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        paintPlayerPanel(g);

        g.dispose();
    }

    public void paintPlayerPanel(Graphics g)
    {
        Graphics2D graphics = (Graphics2D)g;
        graphics.setPaintMode();

        //background.manPaint(graphics);
        raws.manPaint(graphics);
    }


}
