package org.catan;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author Artyukov
 */
public class ResourceLoader
{
    public static Map<String, Image> tiles = new HashMap<>();

    public static void reloadTextures()
    {
        //File directory = new File("src\\main\\resources\\pics");
        File directory = new File("src/main/resources/pics");
        if(directory.isDirectory())
        {
            File[] files = directory.listFiles();

            for(File imageFile : files)
            {
                if(imageFile.isDirectory())
                {
                    continue;
                }

                if(imageFile.getName().endsWith(".png"))
                {
                    addTile(imageFile);
                }
            }
        }
    }

    public static Image getTile(String tileName)
    {
        return tiles.get(tileName);
    }

    private static void addTile(File imageFile)
    {
        String key = imageFile.getName();
        try
        {
            BufferedImage image = ImageIO.read(imageFile);
            tiles.put(key, image);
            System.out.println("Loaded image '"+key+"'");
        }
        catch(IOException ioe)
        {
            System.out.println("Error on load image "+key+"   "+imageFile.getPath()+": \n"
                    +ioe.getLocalizedMessage());
        }
    }
}
