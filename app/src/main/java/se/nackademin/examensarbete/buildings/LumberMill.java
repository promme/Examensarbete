package se.nackademin.examensarbete.buildings;

/**
 * Created by olofberg on 15-04-29.
 */
public class LumberMill implements Building {
    private String name = "Cat-Gold mine";
    private float woodResourcePerMinute = 2f;
    private float stoneResourcePerMinute = 0f;
    private float catResourcePerMinute = 0f;
    private int catCost = 50;
    private int stoneCost = 0;
    private int woodCost = 0;

    public LumberMill() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCatCost() {
        return catCost;
    }

    @Override
    public int getWoodCost() {
        return woodCost;
    }

    @Override
    public int getStoneCost() {
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
