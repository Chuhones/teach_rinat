/*
 * Copyright 2015 by Solvo, LTD
 *
 * This program is commercial software.
 * Any unauthorized use is prohibited.
 *
 * Created Jun 19, 2017
 */

package org.catan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JPanel;
import org.catan.components.Player;
import org.catan.components.raws.Raw;

/**
 *
 * @author artyukov
 */
public class PlayerPanelRaws extends JPanel
{
    final PlayerPanel mainPanel;

    public static float RATIO = 1.5f;

    public PlayerPanelRaws(PlayerPanel mainPanel)
    {
        this.mainPanel = mainPanel;
    }

    public void init(int xCoord, int yCoord, int width, int height)
    {
        setBackground(new Color(176, 120, 15));
        setBounds(xCoord, yCoord, width, height);

        System.out.println("Player RAW bounds: "+xCoord+"   "+yCoord+"   "+width+"   "+height);
    }


    @Override
    public void paint(Graphics g)
    {
    }

    public void manPaint(Graphics g)
    {
        super.paint(g);
        paintRaws((Graphics2D)g);

        g.dispose();
    }

    private void paintRaws(Graphics2D graph)
    {
        graph.setPaintMode();
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
        for(Raw raw : raws)
        {
            graph.drawImage(raw.getTile(), left + num * oneCardWidth, up, cardWidth, height, this);
            num++;
        }

    }
}
