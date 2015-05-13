package se.nackademin.examensarbete.statistics;

import se.nackademin.examensarbete.handlers.StatisticHandler;

/**
 * Created by olofberg on 15-05-13.
 */
public class CatClickStatistics implements Statistic {
    String StatisticsName = "Cat Click statistics";
    @Override
    public String getStatisticsName() {
        return StatisticsName;
    }

    @Override
    public String getStatisticsValue() {
        return String.valueOf(Math.round(StatisticHandler.getInstance().getTotalAmountOfClicks()));
    }
}
