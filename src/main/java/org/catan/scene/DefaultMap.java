package org.catan.scene;

import java.awt.Color;
import java.util.ArrayList;
import org.catan.components.City;
import org.catan.components.Player;
import org.catan.components.Village;
import org.catan.components.areas.WaterArea;

/**
 *
 * @author Artyukov
 */
public class DefaultMap extends AbstractMap
{
    public DefaultMap()
    {
        crosslines = new CrossLine[11][6];
        segments = new Segment[7][7];
        lines = new ArrayList<>();
        initBaseMap();
    }
    
    private void initBaseMap()
    {
        Player player1 = new Player("FirstPlayer", Color.red);
        
        for(int x=0; x < crosslines.length; x++)
        {
            for(int y=0; y < crosslines[x].length; y++)
            {
                crosslines[x][y] = new CrossLine();
            }
        }
        
        MapGenerator generator = new MapGenerator();
                
        Segment newSegment = new Segment("1", new WaterArea());     //1
        getSegments()[1][0] = newSegment;
        crosslines[2][0].addSegment(newSegment);
        crosslines[3][0].addSegment(newSegment);
        
        newSegment = new Segment("2", new WaterArea());             //2
        getSegments()[2][0] = newSegment;
        crosslines[3][0].addSegment(newSegment);
        crosslines[4][0].addSegment(newSegment);
        crosslines[5][0].addSegment(newSegment);
        
        newSegment = new Segment("3", new WaterArea());             //3
        getSegments()[3][0] = newSegment;
        crosslines[5][0].addSegment(newSegment);
        crosslines[6][0].addSegment(newSegment);
        crosslines[7][0].addSegment(newSegment);
        
        newSegment = new Segment("4", new WaterArea());             //4
        getSegments()[4][0] = newSegment;
        crosslines[7][0].addSegment(newSegment);
        crosslines[8][0].addSegment(newSegment);
        
        newSegment = new Segment("5", new WaterArea());             //5
        getSegments()[1][1] = newSegment;
        crosslines[2][0].addSegment(newSegment);
        crosslines[2][1].addSegment(newSegment);
        crosslines[1][1].addSegment(newSegment);
        
        newSegment = new Segment("6", generator.getNextArea());             //6
        getSegments()[2][1] = newSegment;
        crosslines[2][0].addSegment(newSegment);
        crosslines[3][0].addSegment(newSegment);
        crosslines[4][0].addSegment(newSegment);
        crosslines[2][1].addSegment(newSegment);
        crosslines[3][1].addSegment(newSegment);
        crosslines[4][1].addSegment(newSegment);
        
        newSegment = new Segment("7", generator.getNextArea());             //7
        getSegments()[3][1] = newSegment;
        crosslines[4][0].addSegment(newSegment);
        crosslines[5][0].addSegment(newSegment);
        crosslines[6][0].addSegment(newSegment);
        crosslines[4][1].addSegment(newSegment);
        crosslines[5][1].addSegment(newSegment);
        crosslines[6][1].addSegment(newSegment);
        
        newSegment = new Segment("8", generator.getNextArea());             //8
        getSegments()[4][1] = newSegment;
        crosslines[6][0].addSegment(newSegment);
        crosslines[7][0].addSegment(newSegment);
        crosslines[8][0].addSegment(newSegment);
        crosslines[6][1].addSegment(newSegment);
        crosslines[7][1].addSegment(newSegment);
        crosslines[8][1].addSegment(newSegment);
        
        newSegment = new Segment("9", new WaterArea());             //9
        getSegments()[5][1] = newSegment;
        crosslines[8][0].addSegment(newSegment);
        crosslines[8][1].addSegment(newSegment);
        crosslines[9][1].addSegment(newSegment);
        
        newSegment = new Segment("10", new WaterArea());             //10
        getSegments()[0][2] = newSegment;
        crosslines[1][1].addSegment(newSegment);
        crosslines[0][2].addSegment(newSegment);
        crosslines[1][2].addSegment(newSegment);
        
        newSegment = new Segment("11", generator.getNextArea());             //11
        getSegments()[1][2] = newSegment;
        crosslines[1][1].addSegment(newSegment);
        crosslines[2][1].addSegment(newSegment);
        crosslines[3][1].addSegment(newSegment);
        crosslines[1][2].addSegment(newSegment);
        crosslines[2][2].addSegment(newSegment);
        crosslines[3][2].addSegment(newSegment);
        
        newSegment = new Segment("12", generator.getNextArea());             //12
        getSegments()[2][2] = newSegment;
        crosslines[3][1].addSegment(newSegment);
        crosslines[4][1].addSegment(newSegment);
        crosslines[5][1].addSegment(newSegment);
        crosslines[3][2].addSegment(newSegment);
        crosslines[4][2].addSegment(newSegment);
        crosslines[5][2].addSegment(newSegment);
        
        newSegment = new Segment("13", generator.getNextArea());             //13
        getSegments()[3][2] = newSegment;
        crosslines[5][1].addSegment(newSegment);
        crosslines[6][1].addSegment(newSegment);
        crosslines[7][1].addSegment(newSegment);
        crosslines[5][2].addSegment(newSegment);
        crosslines[6][2].addSegment(newSegment);
        crosslines[7][2].addSegment(newSegment);
        
        newSegment = new Segment("14", generator.getNextArea());             //14
        getSegments()[4][2] = newSegment;
        crosslines[7][1].addSegment(newSegment);
        crosslines[8][1].addSegment(newSegment);
        crosslines[9][1].addSegment(newSegment);
        crosslines[7][2].addSegment(newSegment);
        crosslines[8][2].addSegment(newSegment);
        crosslines[9][2].addSegment(newSegment);
        
        newSegment = new Segment("15", new WaterArea());             //15
        getSegments()[5][2] = newSegment;
        crosslines[9][1].addSegment(newSegment);
        crosslines[9][2].addSegment(newSegment);
        crosslines[10][2].addSegment(newSegment);
        
        newSegment = new Segment("16", new WaterArea());             //16
        getSegments()[0][3] = newSegment;
        crosslines[0][2].addSegment(newSegment);
        crosslines[0][3].addSegment(newSegment);

        newSegment = new Segment("17", generator.getNextArea());             //17
        getSegments()[1][3] = newSegment;
        crosslines[0][2].addSegment(newSegment);
        crosslines[1][2].addSegment(newSegment);
        crosslines[2][2].addSegment(newSegment);
        crosslines[0][3].addSegment(newSegment);
        crosslines[1][3].addSegment(newSegment);
        crosslines[2][3].addSegment(newSegment);
        
        newSegment = new Segment("18", generator.getNextArea());             //18
        getSegments()[2][3] = newSegment;
        crosslines[2][2].addSegment(newSegment);
        crosslines[3][2].addSegment(newSegment);
        crosslines[4][2].addSegment(newSegment);
        crosslines[2][3].addSegment(newSegment);
        crosslines[3][3].addSegment(newSegment);
        crosslines[4][3].addSegment(newSegment);
        
        newSegment = new Segment("19", generator.getNextArea());             //19
        getSegments()[3][3] = newSegment;
        crosslines[4][2].addSegment(newSegment);
        crosslines[5][2].addSegment(newSegment);
        crosslines[6][2].addSegment(newSegment);
        crosslines[4][3].addSegment(newSegment);
        crosslines[5][3].addSegment(newSegment);
        crosslines[6][3].addSegment(newSegment);
        
        newSegment = new Segment("20", generator.getNextArea());             //20
        getSegments()[4][3] = newSegment;
        crosslines[6][2].addSegment(newSegment);
        crosslines[7][2].addSegment(newSegment);
        crosslines[8][2].addSegment(newSegment);
        crosslines[6][3].addSegment(newSegment);
        crosslines[7][3].addSegment(newSegment);
        crosslines[8][3].addSegment(newSegment);
        
        newSegment = new Segment("21", generator.getNextArea());             //21
        getSegments()[5][3] = newSegment;
        crosslines[8][2].addSegment(newSegment);
        crosslines[9][2].addSegment(newSegment);
        crosslines[10][2].addSegment(newSegment);
        crosslines[8][3].addSegment(newSegment);
        crosslines[9][3].addSegment(newSegment);
        crosslines[10][3].addSegment(newSegment);
        
        newSegment = new Segment("22", new WaterArea());             //22
        getSegments()[6][3] = newSegment;
        crosslines[10][2].addSegment(newSegment);
        crosslines[10][3].addSegment(newSegment);
        
        newSegment = new Segment("23", new WaterArea());             //23
        getSegments()[0][4] = newSegment;
        crosslines[0][3].addSegment(newSegment);
        crosslines[1][3].addSegment(newSegment);
        crosslines[1][4].addSegment(newSegment);
        
        newSegment = new Segment("24", generator.getNextArea());             //24
        getSegments()[1][4] = newSegment;
        crosslines[1][3].addSegment(newSegment);
        crosslines[2][3].addSegment(newSegment);
        crosslines[3][3].addSegment(newSegment);
        crosslines[1][4].addSegment(newSegment);
        crosslines[2][4].addSegment(newSegment);
        crosslines[3][4].addSegment(newSegment);
        
        newSegment = new Segment("25", generator.getNextArea());             //25
        getSegments()[2][4] = newSegment;
        crosslines[3][3].addSegment(newSegment);
        crosslines[4][3].addSegment(newSegment);
        crosslines[5][3].addSegment(newSegment);
        crosslines[3][4].addSegment(newSegment);
        crosslines[4][4].addSegment(newSegment);
        crosslines[5][4].addSegment(newSegment);
        
        newSegment = new Segment("26", generator.getNextArea());             //26
        getSegments()[3][4] = newSegment;
        crosslines[5][3].addSegment(newSegment);
        crosslines[6][3].addSegment(newSegment);
        crosslines[7][3].addSegment(newSegment);
        crosslines[5][4].addSegment(newSegment);
        crosslines[6][4].addSegment(newSegment);
        crosslines[7][4].addSegment(newSegment);
        
        newSegment = new Segment("27", generator.getNextArea());             //27
        getSegments()[4][4] = newSegment;
        crosslines[7][3].addSegment(newSegment);
        crosslines[8][3].addSegment(newSegment);
        crosslines[9][3].addSegment(newSegment);
        crosslines[7][4].addSegment(newSegment);
        crosslines[8][4].addSegment(newSegment);
        crosslines[9][4].addSegment(newSegment);
        
        newSegment = new Segment("28", new WaterArea());             //28
        getSegments()[5][4] = newSegment;
        crosslines[9][3].addSegment(newSegment);
        crosslines[10][3].addSegment(newSegment);
        crosslines[9][4].addSegment(newSegment);
        
        newSegment = new Segment("29", new WaterArea());             //29
        getSegments()[1][5] = newSegment;
        crosslines[1][4].addSegment(newSegment);
        crosslines[2][4].addSegment(newSegment);
        crosslines[2][5].addSegment(newSegment);
        
        newSegment = new Segment("30", generator.getNextArea());             //30
        getSegments()[2][5] = newSegment;
        crosslines[2][4].addSegment(newSegment);
        crosslines[3][4].addSegment(newSegment);
        crosslines[4][4].addSegment(newSegment);
        crosslines[2][5].addSegment(newSegment);
        crosslines[3][5].addSegment(newSegment);
        crosslines[4][5].addSegment(newSegment);
        
        newSegment = new Segment("31", generator.getNextArea());             //31
        getSegments()[3][5] = newSegment;
        crosslines[4][4].addSegment(newSegment); crosslines[4][4].setSettlement(new City());
        crosslines[5][4].addSegment(newSegment); crosslines[5][4].setSettlement(new Village());
        crosslines[6][4].addSegment(newSegment);
        crosslines[4][5].addSegment(newSegment);
        crosslines[5][5].addSegment(newSegment);
        crosslines[6][5].addSegment(newSegment);
        
        newSegment = new Segment("32", generator.getNextArea());             //32
        getSegments()[4][5] = newSegment;
        crosslines[6][4].addSegment(newSegment);
        crosslines[7][4].addSegment(newSegment);
        crosslines[8][4].addSegment(newSegment);
        crosslines[6][5].addSegment(newSegment);
        crosslines[7][5].addSegment(newSegment);
        crosslines[8][5].addSegment(newSegment);
        
        newSegment = new Segment("33", new WaterArea());             //33
        getSegments()[5][5] = newSegment;
        crosslines[8][4].addSegment(newSegment);
        crosslines[9][4].addSegment(newSegment);
        crosslines[8][5].addSegment(newSegment);
        
        newSegment = new Segment("34", new WaterArea());             //34
        getSegments()[1][6] = newSegment;
        crosslines[2][5].addSegment(newSegment);
        crosslines[3][5].addSegment(newSegment);
        
        newSegment = new Segment("35", new WaterArea());             //35
        getSegments()[2][6] = newSegment;
        crosslines[3][5].addSegment(newSegment);
        crosslines[4][5].addSegment(newSegment);
        crosslines[5][5].addSegment(newSegment);
        
        newSegment = new Segment("36", new WaterArea());             //36
        getSegments()[3][6] = newSegment;
        crosslines[5][5].addSegment(newSegment);
        crosslines[6][5].addSegment(newSegment);
        crosslines[7][5].addSegment(newSegment);
        
        newSegment = new Segment("37", new WaterArea());             //37
        getSegments()[4][6] = newSegment;
        crosslines[7][5].addSegment(newSegment);
        crosslines[8][5].addSegment(newSegment);
        
        Line newLine;
        for(int x=0; x<crosslines.length; x++)
        {
            for(int y=0; y<crosslines[x].length; y++)
            {
                if(crosslines[x][y].getSegments().isEmpty())
                {
                    crosslines[x][y] = null;
                    continue;
                }
                
                if(crosslines[x][y] == null)
                {
                    continue;
                }
                
                if(x!=0 && crosslines[x-1][y] != null)
                {
                    newLine = new Line(crosslines[x][y], crosslines[x-1][y]);
                    if(x==5 && y==4)
                    {
                        newLine.occupy(player1);
                    }
                    lines.add(newLine);
                    crosslines[x][y].addLine(newLine);
                    crosslines[x-1][y].addLine(newLine);
                }
//                
//                if(x+1 < crosslines.length && crosslines[x+1][y] != null)
//                {
//                    crosslines[x][y].addLine(new Line(crosslines[x][y], crosslines[x+1][y]));
//                }
                
                if( ((x%2 == 0 && y%2 == 0)|| (x%2 != 0 && y%2 != 0)) && y+1 < crosslines[x].length && crosslines[x][y+1] != null)
                {
                    newLine = new Line(crosslines[x][y], crosslines[x][y+1]);
                    lines.add(newLine);
                    crosslines[x][y].addLine(newLine);
                    continue;
                }
            }
        }
        
        
    }
}
