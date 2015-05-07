package se.nackademin.examensarbete.buildings;

/**
 * Created by olofberg on 15-04-29.
 */
public class CatBreeder implements Building {
    private String name = "Cat breeder";
    private float woodResourcePerMinute = 0f;
    private float stoneResourcePerMinute = 0f;
    private float catResourcePerMinute = 2f;
    private int catCost = 0;
    private int stoneCost = 50;
    private int woodCost = 50;

    public CatBreeder() {
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
