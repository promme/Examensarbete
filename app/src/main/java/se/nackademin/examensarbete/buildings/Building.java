package se.nackademin.examensarbete.buildings;

/**
 * Created by olofberg on 15-04-29.
 */
public interface Building {
    String getName();

    float getCatCost();

    float getLumberCost();

    float getStoneCost();

    float getCatResourcePerSecond();

    float getLumberResourcePerSecond();

    float getStoneResourcePerSecond();

    int getNumberOfMe();

}
