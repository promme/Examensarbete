package se.nackademin.examensarbete.eventbus;

import se.nackademin.examensarbete.handlers.StatisticHandler;

/**
 * Created by Jonkan on 2015-04-28.
 */
public class CatClickEvent {
    public CatClickEvent() {
        StatisticHandler.getInstance().addClick();
    }
}
