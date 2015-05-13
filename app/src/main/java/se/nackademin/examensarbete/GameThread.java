package se.nackademin.examensarbete;

import de.greenrobot.event.EventBus;
import se.nackademin.examensarbete.eventbus.CatClickEvent;
import se.nackademin.examensarbete.eventbus.UpdateUIEvent;
import se.nackademin.examensarbete.handlers.ResourceHandler;

/**
 * Created by Jonkan on 2015-04-29.
 */
public class GameThread implements Runnable {
    private EventBus bus = EventBus.getDefault();
    private boolean running = true;

    public void stopThread() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                UpdateUIEvent timerEvent = new UpdateUIEvent();
                bus.post(timerEvent);
                Thread.sleep(1000);
                ResourceHandler.getInstance().updateResourcesPerSecond();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
