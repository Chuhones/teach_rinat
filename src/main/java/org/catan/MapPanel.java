package org.catan;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.util.List;
import javax.swing.JPanel;
import org.catan.components.areas.Area;
import org.catan.scene.AbstractMap;
import org.catan.scene.CrossLine;
import org.catan.scene.Game;
import org.catan.scene.Line;
import org.catan.scene.Segment;

/**
 *
 * @author Artyukov
 */
public class MapPanel extends JPanel
{
    @Override
    public void paint(Graphics g)
    {
        super.paint(g); 
        addGameToFrame(g);
    }
        
    public void addGameToFrame(Graphics graph)
    {
        Game game = Game.getGame();
        AbstractMap map = game.getMap();
        Graphics2D graphics = (Graphics2D)graph;
        graphics.setPaintMode();

        CrossLine[][] crosslines = map.getCrosslines();
        Segment[][] segments = map.getSegments();
        List<Line> lines = map.getLines();
        
        Image tileCrossline;
        Area area;
        Image tileArea;
        
        for (Segment[] segmentRow : segments)
        {
            for (Segment segment : segmentRow)
            {
                if(segment == null || segment.getArea() == null)
                {
                    continue;
                }
                area = segment.getArea();
                
                tileArea = area.getTile();
                drawImage(graphics, tileArea, segment.getXCoord(), segment.getYCoord(), 100, 115);
            }
        }
        
        for (Line line : lines)
        {
            drawRoad(graphics, line);
        }
        
        int xyDiff = 4;
        for (CrossLine[] crossline : crosslines)
        {
            for (CrossLine cross : crossline)
            {
                if(cross == null)
                {
                    continue;
                }
                
                tileCrossline = cross.getTile();
                
                if(cross.getSettlement() == null)
                {
                    xyDiff = 8;
                }
                else
                {
                    xyDiff = 30;
                }
                drawImage(graphics, tileCrossline, 
                        cross.getXCoord()-(xyDiff/2), cross.getYCoord()-(xyDiff/2), 
                        xyDiff, xyDiff);
            }
        }
        
        graphics.dispose();
    }
    
    private void drawRoad(Graphics2D graphics, Line line)
    {
        Color defaultColor = new Color(250, 220, 128);
        
        if(line.getCrossLines() == null || line.getCrossLines().size() != 2)
        {
            return;
        }

        if(line.getPlayer() != null)
        {
            graphics.setColor(line.getPlayer().getColor());
        }
        else
        {
            graphics.setColor(defaultColor);
        }

        CrossLine from = line.getCrossLines().get(0);
        CrossLine to = line.getCrossLines().get(1);

        graphics.setStroke(new BasicStroke(6));
        graphics.drawLine(from.getXCoord(), from.getYCoord(), 
                           to.getXCoord(),   to.getYCoord());
    }
    
    private void drawImage(
            Graphics2D graph, Image image, int x, int y, Integer width, Integer height)
    {
        if(image == null)
        {
            
            graph.drawString("N/A", x, y);
        }
        else
        {
            if(width == null || height == null)
            {
                width = image.getWidth(this);
                height = image.getHeight(this);
            }
            
            graph.drawImage(image, x, y, width, height, this);
        }
    }
    
    private void drawImage(Graphics2D graph, Image image, int x, int y)
    {
        drawImage(graph, image, x, y, null, null);
    }
}
