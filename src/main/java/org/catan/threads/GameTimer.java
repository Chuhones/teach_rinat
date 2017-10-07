/*
 * Copyright 2015 by Solvo, LTD
 *
 * This program is commercial software.
 * Any unauthorized use is prohibited.
 *
 * Created Jun 19, 2017
 */

package org.catan.threads;

import java.util.Timer;
import java.util.TimerTask;
import org.catan.core.GlobalVariables;

/**
 *
 * @author artyukov
 */
public class GameTimer extends Timer
{
    private final GameTimerTask timerTask;

    private GameTimer()
    {
        super(true);
        timerTask = new GameTimerTask();

    }

    public static void init()
    {
        GameTimer timer = new GameTimer();
        timer.schedule();
    }

    public void schedule()
    {
        schedule(timerTask, 0, 100);
    }

    private class GameTimerTask extends TimerTask
    {

        @Override
        public void run()
        {
            GlobalVariables.timerCount.incrementAndGet();
        }

    }
}
