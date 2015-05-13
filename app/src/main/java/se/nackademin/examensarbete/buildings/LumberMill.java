package se.nackademin.examensarbete.buildings;

import se.nackademin.examensarbete.handlers.AlgorithmHandler;
import se.nackademin.examensarbete.handlers.BuildingHandler;

/**
 * Created by olofberg on 15-04-29.
 */
public class LumberMill implements Building {
    private String name = "Lumber mill";
    private float lumberResourcePerSecond = 2f;
    private float stoneResourcePerSecond = 0f;
    private float catResourcePerSecond = 0f;
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
        return catResourcePerSecond;
    }

    @Override
    public float getLumberResourcePerSecond() {
        return lumberResourcePerSecond;
    }

    @Override
    public float getStoneResourcePerSecond() {
        return stoneResourcePerSecond;
    }

    @Override
    public int getNumberOfMe() {
        return BuildingHandler.getInstance().getNumberOfLumbermills();
    }
}
