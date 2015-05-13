package se.nackademin.examensarbete.buildings;

import se.nackademin.examensarbete.handlers.AlgorithmHandler;
import se.nackademin.examensarbete.handlers.BuildingHandler;

/**
 * Created by olofberg on 15-04-29.
 */
public class GoldMine implements Building {
    private String name = "Cat-Gold mine";
    private float lumberResourcePerSecond = 0f;
    private float stoneResourcePerSecond = 2f;
    private float catResourcePerSecond = 0f;
    private float catCost = 50;
    private float stoneCost = 0;
    private float lumberCost = 0;

    public GoldMine() {

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
        return BuildingHandler.getInstance().getNumberOfGoldMines();
    }
}
