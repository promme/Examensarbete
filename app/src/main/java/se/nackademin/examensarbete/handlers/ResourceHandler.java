package se.nackademin.examensarbete.handlers;

import java.io.Serializable;


public class ResourceHandler implements Serializable {
    private static ResourceHandler instance;
    private float numberOfTrees = 0;
    private float numberOfStones = 0;
    private float numberOfCats = 0;

    protected ResourceHandler() {

    }

    public static void setResourceHandler(ResourceHandler instance) {
        //TODO should be able to create resourcehanlders from jsonObjects
        ResourceHandler.instance = instance;
    }

    public void setNumberOfCats(float numberOfCats) {
        this.numberOfCats = numberOfCats;
    }

    public void setNumberOfTrees(float numberOfTrees) {
        this.numberOfTrees = numberOfTrees;
    }

    public void setNumberOfStones(float numberOfStones) {
        this.numberOfStones = numberOfStones;
    }

    public static ResourceHandler getInstance() {
        if (instance == null) {
            instance = new ResourceHandler();
        }
        return instance;
    }

    public void addTrees(float addedTrees) {
        numberOfTrees = numberOfTrees + addedTrees;
    }

    public void addCats(float addedCats) {
        numberOfCats = numberOfCats + addedCats;
    }

    public void addStones(float addedStones) {
        numberOfStones = numberOfStones + addedStones;
    }

    public void subtractCats(float removedCats) {
        numberOfCats = numberOfCats - removedCats;
    }

    public void subtractTrees(float removedTrees) {
        numberOfTrees = numberOfCats - removedTrees;

    }

    public void subtractStones(float removedStones) {
        numberOfStones = numberOfCats - removedStones;

    }

    public float getNumberOfTrees() {
        return numberOfTrees;
    }

    public float getNumberOfStones() {
        return numberOfStones;
    }

    public float getNumberOfCats() {
        return numberOfCats;
    }
}
