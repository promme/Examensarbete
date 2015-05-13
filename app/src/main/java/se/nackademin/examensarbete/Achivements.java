package se.nackademin.examensarbete;

import de.greenrobot.event.EventBus;
import se.nackademin.examensarbete.eventbus.AchivementEvent;
import se.nackademin.examensarbete.handlers.StatisticHandler;

/**
 * Created by Jonkan on 2015-05-13.
 */
public class Achivements {
    private EventBus bus = EventBus.getDefault();
    private String totalAmountOfClicksID = "CgkItpSbptAKEAIQAQ";

    public void checkAchivements() {
        if (StatisticHandler.getInstance().getTotalAmountOfClicks() >= 100) {
            bus.post(new AchivementEvent(totalAmountOfClicksID));
        }

    }
}
