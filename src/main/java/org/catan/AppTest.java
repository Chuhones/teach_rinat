package org.catan;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import org.catan.scene.AbstractMap;
import org.catan.scene.CrossLine;
import org.catan.scene.Game;
import org.catan.scene.Segment;

/**
 *
 * @author Artyukov
 */
public class AppTest extends JFrame implements Runnable
{
    Game game = null;
    MapPanel mapPane = null;
    boolean running = true;
    
    public AppTest() throws HeadlessException
    {
        super();
    }

    public static void main(String[] args)
    {
        ResourceLoader.reloadTextures();
        
        Game game = Game.getGame();
        fillCoordinates(game.getMap());
        
        AppTest gameFrame = new AppTest();
        gameFrame.setLayout(null);
        gameFrame.setUndecorated(true);
        gameFrame.setBackground(new Color(87, 104, 207, 254));
        
        gameFrame.game = game;
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        gameFrame.setPreferredSize(size);
        gameFrame.setResizable(false);
        
        MapPanel mapPanel = new MapPanel();
        ExitButton exitButton = new ExitButton();
        PlayerPanelBackground bg1 = new PlayerPanelBackground();
                
        gameFrame.add(mapPanel);
        gameFrame.add(exitButton);
        gameFrame.add(bg1);

        gameFrame.setTitle(game.getGameName());
        gameFrame.pack();
        
        gameFrame.initMapPanel(mapPanel);
        gameFrame.initExitButton(exitButton);
        
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //gameFrame.setLocationRelativeTo(null);
        
        gameFrame.setVisible(true);
        
        mapPanel.setVisible(true);
        exitButton.setVisible(true);
        bg1.setVisible(true);

        //gameFrame.run();
    }
    
    Timer fps = new Timer();
    public int frameCounter = 0;
    
    @Override
    public void run()
    {
        
        fps.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                System.out.println("FPS="+frameCounter);
                frameCounter = 0;
            }
        }, 1L, 1000L);
        
        while (running)
        {
            frameCounter++;
            update();
            repaint();
        }
    }
    
    private void initMapPanel(MapPanel mapPanel)
    {
        int xCenter = this.getWidth() / 2;
        
        mapPanel.setBackground(new Color(87, 104, 207, 254));
        mapPanel.setBounds(xCenter-350, 30, 700, 630);
    }
    
    public void initExitButton(ExitButton exitButton)
    {
        exitButton.setBounds((this.getWidth() / 2) - 45, 0, 90, 20);
    }
   
    public static void fillCoordinates(AbstractMap map)
    {
        CrossLine[][] crosslines = map.getCrosslines();
        
        int currentX = 100;
        int currentY = 100;
        int yDelta = 15;
        for(int x=0; x<crosslines.length; x++)
        {
            for(int y=0; y<crosslines[x].length; y++)
            {
                if(crosslines[x][y] != null)
                {
                    crosslines[x][y].setXCoord(currentX);
                    crosslines[x][y].setYCoord(
                        currentY+(yDelta * (int)Math.pow(-1, x) * (int)Math.pow(-1, y)));
                }
                
                currentY+=85;
            }
            currentY =100;
            currentX+=50;
        }
        
        Segment[][] segments = map.getSegments();
        int xDelta;
        currentY = 0;
        currentX = 0;
        for(int x=0; x<segments.length; x++)
        {
            for(int y=0; y<segments[x].length; y++)
            {
                if(y%2 == 0)
                {
                    xDelta = 50;
                }
                else
                {
                    xDelta = 0;
                }
                if(segments[x][y] != null)
                {
                    segments[x][y].setXCoord(currentX+xDelta);
                    segments[x][y].setYCoord(currentY+1);
                }
                
                currentY+=85;
            }
            currentY = 0;
            currentX+=100;
        }
    }
    
    public void update()
    {
    }
}
