package se.nackademin.examensarbete.buildings;

/**
 * Created by olofberg on 15-04-29.
 */
public interface Building {
    String getName();

    int getCatCost();

    int getWoodCost();

    int getStoneCost();

    float getCatResourcePerSecond();

    float getWoodResourcePerSecond();

    float getStoneResourcePerSecond();

}
