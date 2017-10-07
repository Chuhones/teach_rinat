package org.catan.core;

import java.io.File;
import org.newdawn.slick.util.FileSystemLocation;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author Artyukov
 */
public class ResourceLoaderCatan extends ResourceLoader
{
    public static void reloadTexturesSlick()
    {
        File picsFileLoc = new File("src/main/resources/pics");
        File svgFileLoc = new File("src/main/resources/svg");

        FileSystemLocation picsLoc = new FileSystemLocation(picsFileLoc);
        FileSystemLocation svgLoc = new FileSystemLocation(svgFileLoc);
        
        ResourceLoaderCatan.addResourceLocation(picsLoc);
        ResourceLoaderCatan.addResourceLocation(svgLoc);
    }
    
    

//    public static void reloadTextures()
//    {
//        //File directory = new File("src\\main\\resources\\pics");
//        File directory = new File("src/main/resources/pics");
//        if(directory.isDirectory())
//        {
//            File[] files = directory.listFiles();
//
//            for(File imageFile : files)
//            {
//                if(imageFile.isDirectory())
//                {
//                    continue;
//                }
//
//                if(imageFile.getName().endsWith(".png"))
//                {
//                    addTile(imageFile);
//                }
//            }
//        }
//    }

//    public static Image getTile(String tileName)
//    {
//        return tiles.get(tileName);
//    }

//    private static void addTile(File imageFile)
//    {
//        String key = imageFile.getName();
////        try
////        {
//            ImageIcon icon = new ImageIcon(imageFile.getPath());
//            //BufferedImage image = ImageIO.read(imageFile);
//
//            Image image = icon.getImage();
//            tiles.put(key, image);
//            System.out.println("Loaded image '"+key+"'");
////        }
////        catch(IOException ioe)
////        {
////            System.out.println("Error on load image "+key+"   "+imageFile.getPath()+": \n"
////                    +ioe.getLocalizedMessage());
////        }
//    }
}
