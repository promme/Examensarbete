package se.nackademin.examensarbete.handlers;

import java.io.Serializable;

/**
 * Created by olofberg on 15-04-29.
 */
public class ResourceHandler implements Serializable {
    private static ResourceHandler instance;
    private int numberOfTrees = 0;
    private int numberOfStones = 0;
    private int numberOfCats = 0;

    protected ResourceHandler() {

    }

    public static void setResourceHandler(ResourceHandler instance) {
        ResourceHandler.instance = instance;
    }

    public void setNumberOfCats(int numberOfCats) {
        this.numberOfCats = numberOfCats;
    }

    public void setNumberOfTrees(int numberOfTrees) {
        this.numberOfTrees = numberOfTrees;
    }

    public void setNumberOfStones(int numberOfStones) {
        this.numberOfStones = numberOfStones;
    }

    public static ResourceHandler getInstance() {
        if (instance == null) {
            instance = new ResourceHandler();
        }
        return instance;
    }

    public void addTrees(int addedTrees) {
        numberOfTrees = numberOfTrees + addedTrees;
    }

    public void addCats(int addedCats) {
        numberOfCats = numberOfCats + addedCats;
    }

    public void addStones(int addedStones) {
        numberOfStones = numberOfStones + addedStones;
    }

    public void subtractCats(int removedCats) {
        numberOfCats = numberOfCats - removedCats;
    }

    public void subtractTrees(int removedTrees) {
        numberOfTrees = numberOfCats - removedTrees;

    }

    public void subtractStones(int removedStones) {
        numberOfStones = numberOfCats - removedStones;

    }

    public int getNumberOfTrees() {
        return numberOfTrees;
    }

    public int getNumberOfStones() {
        return numberOfStones;
    }

    public int getNumberOfCats() {
        return numberOfCats;
    }
}
