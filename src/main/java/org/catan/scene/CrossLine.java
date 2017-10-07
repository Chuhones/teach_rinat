package org.catan.scene;

import java.util.ArrayList;
import java.util.List;
import org.catan.components.Settlement;
import org.catan.core.BaseComponent;
import org.catan.core.Component;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.util.Log;

/**
 *
 * @author Artyukov
 */
public class CrossLine 
{
    private List<Segment> segments = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();
    private int xCoord = 0;
    private int yCoord = 0;
    
    protected Settlement settlement = null;

    private final String defaultTextureName = "crossline_cpy.png";
    protected Component graphComponent = null; 

    public void initGraphics(GUIContext container, Component parentComponent) throws SlickException
    {
        if(parentComponent == null)
        {
            throw new SlickException("Cannot create crossline without parent");
        }
        if(graphComponent == null)
        {
            graphComponent = new BaseComponent(container);
            graphComponent.setParent(parentComponent);
            graphComponent.setMesh(resolveShape());
            graphComponent.setImage(resolveImage());
        }
        
        graphComponent.setLocation(parentComponent.getX()+xCoord, parentComponent.getY()+yCoord);
    }
    
    public void render(GUIContext guic, org.newdawn.slick.Graphics g)
            throws SlickException
    {
        graphComponent.render(guic, g);
    }

    protected Image resolveImage()
    {
        if(graphComponent == null)
        {
            return null;
        }
        
        try
        {
            if(settlement == null)
            {
                return new Image(defaultTextureName, false);
            }
            else 
            {
                return settlement.getTexture();
            }
        }
        catch(SlickException ex)
        {
            Log.error(ex.getMessage(), ex);
            return null;
        }
    }
    
    protected Shape resolveShape()
    {
        if(graphComponent == null)
        {
            return null;
        }

        if(settlement == null)
        {
            return new Circle(0, 0, 4, 12);
        }
        else 
        {
            return settlement.getMesh();
        }

    }
    
    public void addSegment(Segment newSegment)
    {
        if(segments.size() >= 3)
        {
            throw new RuntimeException("Слишком много сегментов примыкают к перекрестку");
        }
        segments.add(newSegment);
    }
    
    public void addLine(Line line)
    {
        if(lines.size() >= 3)
        {
            throw new RuntimeException("Слишком много дорог примыкают к перекрестку");
        }
        lines.add(line);
    }
    
    /**
     * @return the segments
     */
    public List<Segment> getSegments()
    {
        return segments;
    }

    /**
     * @param segments the segments to set
     */
    public void setSegments(List<Segment> segments)
    {
        this.segments = segments;
    }

    /**
     * @return the lines
     */
    public List<Line> getLines()
    {
        return lines;
    }

    /**
     * @param lines the lines to set
     */
    public void setLines(List<Line> lines)
    {
        this.lines = lines;
    }

    /**
     * @return the xCoord
     */
    public int getXCoord()
    {
        return xCoord;
    }

    /**
     * @param xCoord the xCoord to set
     */
    public void setXCoord(int xCoord)
    {
        this.xCoord = xCoord;
    }

    /**
     * @return the yCoord
     */
    public int getYCoord()
    {
        return yCoord;
    }

    /**
     * @param yCoord the yCoord to set
     */
    public void setYCoord(int yCoord)
    {
        this.yCoord = yCoord;
    }

    /**
     * @return the settlement
     */
    public Settlement getSettlement()
    {
        return settlement;
    }

    /**
     * @param settlement the settlement to set
     */
    public void setSettlement(Settlement settlement)
    {
        this.settlement = settlement;
        if(graphComponent != null)
        {
            graphComponent.setImage(resolveImage());
            Shape tempMesh = resolveShape();
            tempMesh.setLocation(graphComponent.getX(), graphComponent.getY());
            graphComponent.setMesh(resolveShape());
        }
    }

    /**
     * @return the graphComponent
     */
    public Component getGraphComponent()
    {
        return graphComponent;
    }

    /**
     * @param graphComponent the graphComponent to set
     */
    public void setGraphComponent(Component graphComponent)
    {
        this.graphComponent = graphComponent;
    }
}
