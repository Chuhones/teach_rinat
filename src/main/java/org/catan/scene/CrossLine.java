package org.catan.scene;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import org.catan.ResourceLoader;
import org.catan.components.Settlement;

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

    private final String tileName = "crossline_cpy.png";
    private Image tile = null;
    
    public Image getTile()
    {
        if(tile == null)
        {
            tile = ResourceLoader.getTile(tileName);
        }
        return tile;
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
        if(settlement != null)
        {
            this.tile = settlement.getTile();
        }
    }
}
