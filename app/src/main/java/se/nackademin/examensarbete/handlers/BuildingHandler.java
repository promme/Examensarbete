package se.nackademin.examensarbete.handlers;

import se.nackademin.examensarbete.buildings.Building;

public class BuildingHandler {
    private static BuildingHandler instance;
    private int numberOfCatbreeders = 0;
    private int numberOfGoldMines = 0;
    private int numberOfLumbermills = 0;
    protected BuildingHandler() {

    }

    public static BuildingHandler getInstance() {
        if (instance == null) {
            instance = new BuildingHandler();
        }
        return instance;
    }

    public static void setInstance(BuildingHandler instance) {
        BuildingHandler.instance = instance;
    }

    public int getNumberOfCatbreeders() {
        return numberOfCatbreeders;
    }

    public void setNumberOfCatbreeders(int numberOfCatbreeders) {
        this.numberOfCatbreeders = numberOfCatbreeders;
    }

    public int getNumberOfGoldMines() {
        return numberOfGoldMines;
    }

    public void setNumberOfGoldMines(int numberOfGoldMines) {
        this.numberOfGoldMines = numberOfGoldMines;
    }

    public int getNumberOfLumbermills() {
        return numberOfLumbermills;
    }

    public void setNumberOfLumbermills(int numberOfLumbermills) {
        this.numberOfLumbermills = numberOfLumbermills;
    }

    public void addBuilding(Building b) {
        switch (b.getName()) {
            case ("Cat breeder"):
                numberOfCatbreeders = numberOfCatbreeders + 1;
                break;

            case ("Cat-Gold mine"):
                numberOfGoldMines = numberOfGoldMines + 1;
                break;

            case ("Lumber mill"):
                numberOfLumbermills = numberOfLumbermills + 1;
                break;

        }
    }
}
