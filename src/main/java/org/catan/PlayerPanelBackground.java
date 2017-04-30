package org.catan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Artyukov
 */
public final class PlayerPanelBackground extends JPanel
{
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
    
    private Image angleTileLeftDown = null;
    private Image angleTileRightDown = null;
    private Image angleTileLeftUp = null;
    private Image angleTileRightUp = null;
    private Image lineTileLeft = null;
    private Image lineTileRight = null;
    private Image lineTileUp = null;
    private Image lineTileDown = null;
    
    
    public PlayerPanelBackground()
    {
        angleTileLeftDown = ResourceLoader.getTile(angleTileLeftDownName);
        angleTileRightDown = ResourceLoader.getTile(angleTileRightDownName);
        angleTileLeftUp = ResourceLoader.getTile(angleTileLeftUpName);
        angleTileRightUp = ResourceLoader.getTile(angleTileRightUpName);
        lineTileLeft = ResourceLoader.getTile(lineTileLeftName);
        lineTileRight = ResourceLoader.getTile(lineTileRightName);
        lineTileUp = ResourceLoader.getTile(lineTileUpName);
        lineTileDown = ResourceLoader.getTile(lineTileDownName);
    }
    
    public void init(int xCoord, int yCoord, int width, int height)
    {
        setBackground(new Color(176, 120, 15));
        setBounds(xCoord, yCoord, width, height);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g); 
        paintOrnament(g);
    }
    
    public final void paintOrnament(Graphics graph)
    {
        Graphics2D graphics = (Graphics2D)graph;
        graphics.setPaintMode();
        
        graphics.drawImage(angleTileLeftUp, 0, 0, 30, 30, this);
        graphics.drawImage(angleTileRightUp, getWidth() - 30, 0, 30, 30, this);
        graphics.drawImage(angleTileRightDown, getWidth() - 30, getHeight() - 30, 30, 30, this);
        graphics.drawImage(angleTileLeftDown, 0, getHeight() - 30, 30, 30, this);
        
        graphics.drawImage(lineTileLeft,    0,                  30,                 30,                 getHeight() - 60, this);
        graphics.drawImage(lineTileRight,   getWidth() - 30,    30,                 30,                 getHeight() - 60, this);
        graphics.drawImage(lineTileUp,      30,                 0,                  getWidth() - 60,    30,               this);
        graphics.drawImage(lineTileDown,    30,                 getHeight() - 30,   getWidth() - 60,    30,               this);
        
        graphics.dispose();
    }

}
