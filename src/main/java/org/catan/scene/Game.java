package org.catan.scene;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.catan.components.Player;

/**
 *
 * @author Artyukov
 */
public class Game
{
    private static Game instance = null;
    String gameName;
    AbstractMap map;
    List<Player> players = new ArrayList<>();

    private Game()
    {
        gameName = "New Game "+ (new SimpleDateFormat("HH:mm:ss yyyy MMMM dd").format(new Date()));
    }

    public static Game getGame()
    {
        if(instance == null)
        {
            instance = new Game();
            instance.setMap(new DefaultMap());
        }
        return instance;
    }

    public void setMap(AbstractMap map)
    {
        this.map = map;
    }

    public String getGameName()
    {
        return gameName;
    }

    public AbstractMap getMap()
    {
        return map;
    }

    public List<Player> getPlayers()
    {
        return players;
    }

    public void addPlayer(Player player)
    {
        players.add(player);
    }

}
