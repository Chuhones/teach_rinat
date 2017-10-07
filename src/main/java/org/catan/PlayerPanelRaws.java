/*
 * Copyright 2015 by Solvo, LTD
 *
 * This program is commercial software.
 * Any unauthorized use is prohibited.
 *
 * Created Jun 19, 2017
 */

package org.catan;

import java.util.List;
import org.catan.components.Player;
import org.catan.components.raws.Raw;
import org.catan.core.Component;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;

/**
 *
 * @author artyukov
 */
public class PlayerPanelRaws extends Component
{
    final PlayerPanel mainPanel;

    public static float RATIO = 1.5f;

    public PlayerPanelRaws(PlayerPanel mainPanel, GUIContext container)
    {
        super(container);
        this.mainPanel = mainPanel;
    }
    
    public void init(int xCoord, int yCoord, int width, int height)
    {
//        setBackground(new Color(176, 120, 15));
//        setBounds(xCoord, yCoord, width, height);
//
//        System.out.println("Player RAW bounds: "+xCoord+"   "+yCoord+"   "+width+"   "+height);
    }

    private void render(Graphics graph)
    {
        if(mainPanel.getPlayer() == null)
        {
            return;
        }

        Player pl = mainPanel.getPlayer();
        List<Raw> raws = pl.getRaws();
        if(raws == null || raws.isEmpty())
        {
            return;
        }

        int height = getHeight();
        int up = getY();
        int width = getWidth();
        int left = getX();

        int cardWidth = (int)Math.floor(height/RATIO);
        int oneCardWidth = Math.floorDiv(width-cardWidth, raws.size()-1);
        if(oneCardWidth > cardWidth + 5)
        {
            oneCardWidth = cardWidth + 5;
        }

        int num = 0;

        //Rectangle bds = getBounds();
        //System.out.println("Player RAW bounds2: "+bds.x+"   "+bds.y+"   "+bds.width+"   "+bds.height);
        for(Raw raw : raws)
        {
            graph.drawImage(new Image(raw.getTexture()), left + num * oneCardWidth, up);//, cardWidth, height, this);
            num++;
        }

    }
}
