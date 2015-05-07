package se.nackademin.examensarbete.buildings;

/**
 * Created by olofberg on 15-04-29.
 */
public interface Building {
    String getName();

    float getCatCost();

    float getWoodCost();

    float getStoneCost();

    float getCatResourcePerSecond();

    float getWoodResourcePerSecond();

    float getStoneResourcePerSecond();

}
