package se.nackademin.examensarbete.handlers;

import com.google.gson.annotations.Expose;

import timber.log.Timber;

/**
 * Created by Jonkan on 2015-05-13.
 */
public class StatisticHandler {
    private static StatisticHandler instance;
    @Expose
    float totalAmountOfClicks = 0;


    protected StatisticHandler() {

    }

    public void addClick(){
        totalAmountOfClicks++;
    }

    public float getTotalAmountOfClicks() {
        return totalAmountOfClicks;
    }

    public void setTotalAmountOfClicks(float totalAmountOfClicks) {
        this.totalAmountOfClicks = totalAmountOfClicks;
    }

    public static StatisticHandler getInstance() {
        if (instance == null) {
            instance = new StatisticHandler();
        }
        return instance;
    }

    public static void setInstance(StatisticHandler instance) {
        StatisticHandler.instance = instance;
    }
}
