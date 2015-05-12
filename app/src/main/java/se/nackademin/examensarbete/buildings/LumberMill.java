package se.nackademin.examensarbete.buildings;

import se.nackademin.examensarbete.handlers.AlgorithmHandler;
import se.nackademin.examensarbete.handlers.BuildingHandler;

/**
 * Created by olofberg on 15-04-29.
 */
public class LumberMill implements Building {
    private String name = "Lumber mill";
    private float lumberResourcePerMinute = 2f;
    private float stoneResourcePerMinute = 0f;
    private float catResourcePerMinute = 0f;
    private float catCost = 50;
    private float stoneCost = 0;
    private float lumberCost = 0;

    public LumberMill() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getCatCost() {
        return AlgorithmHandler.CalculatePrice(catCost, getNumberOfMe());
    }

    @Override
    public float getLumberCost() {
        return AlgorithmHandler.CalculatePrice(lumberCost, getNumberOfMe());
    }

    @Override
    public float getStoneCost() {
        return AlgorithmHandler.CalculatePrice(stoneCost, getNumberOfMe());
    }

    @Override
    public float getCatResourcePerSecond() {
        return catResourcePerMinute;
    }

    @Override
    public float getLumberResourcePerSecond() {
        return lumberResourcePerMinute;
    }

    @Override
    public float getStoneResourcePerSecond() {
        return stoneResourcePerMinute;
    }

    @Override
    public int getNumberOfMe() {
        return BuildingHandler.getInstance().getNumberOfLumbermills();
    }
}
