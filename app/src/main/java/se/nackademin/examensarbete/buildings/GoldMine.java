package se.nackademin.examensarbete.buildings;

/**
 * Created by olofberg on 15-04-29.
 */
public class GoldMine implements Building {
    private String name = "Cat-Gold mine";
    private float woodResourcePerMinute = 0f;
    private float stoneResourcePerMinute = 2f;
    private float catResourcePerMinute = 0f;
    private float catCost = 50;
    private float stoneCost = 0;
    private float woodCost = 0;

    public GoldMine() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getCatCost() {
        return catCost;
    }

    @Override
    public float getWoodCost() {
        return woodCost;
    }

    @Override
    public float getStoneCost() {
        return stoneCost;
    }

    @Override
    public float getCatResourcePerSecond() {
        return catResourcePerMinute;
    }

    @Override
    public float getWoodResourcePerSecond() {
        return woodResourcePerMinute;
    }

    @Override
    public float getStoneResourcePerSecond() {
        return stoneResourcePerMinute;
    }
}
