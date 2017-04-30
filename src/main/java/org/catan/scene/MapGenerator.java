package org.catan.scene;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import org.catan.components.areas.Area;
import org.catan.components.areas.DesertArea;
import org.catan.components.areas.FieldArea;
import org.catan.components.areas.ForestArea;
import org.catan.components.areas.HillArea;
import org.catan.components.areas.MountainArea;
import org.catan.components.areas.PastureArea;

/**
 *
 * @author Artyukov
 */
public class MapGenerator 
{
    private int currentElement = -1;
    private final List<Area> areas;
    public MapGenerator()
    {
        areas = new ArrayList<>();
        
        areas.add(new DesertArea());
        areas.add(new FieldArea());
        areas.add(new FieldArea());
        areas.add(new FieldArea());
        areas.add(new FieldArea());
        areas.add(new ForestArea());
        areas.add(new ForestArea());
        areas.add(new ForestArea());
        areas.add(new ForestArea());
        areas.add(new PastureArea());
        areas.add(new PastureArea());
        areas.add(new PastureArea());
        areas.add(new PastureArea());
        areas.add(new HillArea());
        areas.add(new HillArea());
        areas.add(new HillArea());
        areas.add(new MountainArea());
        areas.add(new MountainArea());
        areas.add(new MountainArea());

        Random random = new Random((long)(Math.random()*330201));
        List<Integer> randomValue = new ArrayList<>();
        for(int i = 0; i<19; i++)
        {
            areas.get(i).setRandomValue(random.nextDouble());
        }
        
        areas.sort(new RandomComparator());
    }
    
    public Area getNextArea()
    {
        currentElement++;
        return areas.get(currentElement);
    }
    
    private class RandomComparator implements Comparator<Area>
    {
        @Override
        public int compare(Area o1, Area o2)
        {
            return Double.compare(o1.getRandomValue(), o2.getRandomValue());
        }
    }
}
