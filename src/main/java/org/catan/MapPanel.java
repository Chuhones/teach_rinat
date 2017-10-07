package org.catan;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import java.util.List;
import org.catan.core.Component;
import org.catan.scene.AbstractMap;
import org.catan.scene.CrossLine;
import org.catan.scene.Game;
import org.catan.scene.Line;
import org.catan.scene.Segment;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Artyukov
 */
public class MapPanel extends Component
{
    //Image testImg = new Image("house.png",false);
    public MapPanel(GUIContext container, int X, int Y, int width, int height)
    {
        this(container);
        setLocation(X, Y);
        this.width = width;
        this.height = height;
        init(container);
    }

    private MapPanel(GUIContext container)
    {
        super(container);
        background = Color.blue;
    }
    
    private void init(GUIContext container) 
    {
        Game game = Game.getGame();
        AbstractMap map = game.getMap();
        Segment[][] segments = map.getSegments();
        
        try
        {
            for(CrossLine[] crossVector : map.getCrosslines())
            {
                for(CrossLine cross : crossVector)
                {
                    if(cross != null)
                    {
                        cross.initGraphics(container, this);
                    }
                }
            }
            
            for (Segment[] segmentRow : segments)
            {
                for (Segment segment : segmentRow)
                {
                    if(segment != null && segment.getArea() != null)
                    {
                        segment.initGraphics(container, this);
                    }
                }
            }
        }
        catch(SlickException sle)
        {
            Log.debug(sle.getMessage());
        }
    }
    

    @Override
    public void render(GUIContext guic, Graphics g)
            throws SlickException
    {
        Rectangle oldClip = g.getClip();
        
        Color clr = g.getColor();
        
        g.setWorldClip(x,y,width, height);
        g.setBackground(getBackground());
        renderGame(guic, g);
        
        
        
        g.setColor(clr);
        g.clearWorldClip();
        g.setClip(oldClip);
    }
    
    public void renderGame(GUIContext guic, Graphics graph) throws SlickException
    {
        Game game = Game.getGame();
        AbstractMap map = game.getMap();

        CrossLine[][] crosslines = map.getCrosslines();
        Segment[][] segments = map.getSegments();
        List<Line> lines = map.getLines();
        
        for (Segment[] segmentRow : segments)
        {
            for (Segment segment : segmentRow)
            {
                if(segment == null || segment.getArea() == null)
                {
                    continue;
                }
                
                segment.render(guic, graph);
            }
        }
        
        for (Line line : lines)
        {
            drawRoad(graph, line);
        }
        
        for (CrossLine[] crossline : crosslines)
        {
            for (CrossLine cross : crossline)
            {
                if(cross == null)
                {
                    continue;
                }
                cross.render(guic, graph);
            }
        }
        
        graph.flush();
    }
    
    private void drawRoad(Graphics graphics, Line line)
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

        graphics.setLineWidth(6);
        graphics.drawLine(from.getXCoord()+getX(), from.getYCoord()+getY(), 
                           to.getXCoord()+getX(),   to.getYCoord()+getY());
    }
    

}
