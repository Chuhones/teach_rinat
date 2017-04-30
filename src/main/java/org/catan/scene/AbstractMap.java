package org.catan.scene;

import java.util.List;

/**
 *
 * @author Artyukov
 */
public class AbstractMap 
{
    protected CrossLine[][] crosslines;
    protected Segment[][] segments;
    protected List<Line> lines;

    /**
     * @return the crosslines
     */
    public CrossLine[][] getCrosslines()
    {
        return crosslines;
    }

    /**
     * @param crosslines the crosslines to set
     */
    public void setCrosslines(CrossLine[][] crosslines)
    {
        this.crosslines = crosslines;
    }

    /**
     * @return the segments
     */
    public Segment[][] getSegments()
    {
        return segments;
    }

    /**
     * @param segments the segments to set
     */
    public void setSegments(Segment[][] segments)
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
}
