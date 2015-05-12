package se.nackademin.examensarbete.handlers;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.HashMap;

import se.nackademin.examensarbete.buildings.Building;
import se.nackademin.examensarbete.buildings.CatBreeder;
import se.nackademin.examensarbete.buildings.GoldMine;
import se.nackademin.examensarbete.buildings.LumberMill;
import timber.log.Timber;

public class BuildingHandler {
    private static BuildingHandler instance;
    @Expose
    private int numberOfCatbreeders = 0;
    @Expose
    private int numberOfGoldMines = 0;
    @Expose
    private int numberOfLumbermills = 0;

    private ArrayList<Building> buildings = new ArrayList<>();

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
        updateBuildingHandler();
    }

    public void updateBuildingHandler() {
        buildings.clear();
        for (int i = 0; i < numberOfCatbreeders; i++) {
            buildings.add(new CatBreeder());
        }
        for (int i = 0; i < numberOfGoldMines; i++) {
            buildings.add(new GoldMine());

        }
        for (int i = 0; i < numberOfLumbermills; i++) {
            buildings.add(new LumberMill());

        }
    }

    public HashMap<String, Integer> getResourcesPerSecond() {
        int totalCatResourcePerSecond = 0;
        int totalLumberResourcePerSecond = 0;
        int totalStoneResourcePerSecond = 0;
        HashMap<String, Integer> allResourcesPerMinHashmap = new HashMap<>();
        for (int i = 0; i < buildings.size(); i++) {
            totalCatResourcePerSecond += buildings.get(i).getCatResourcePerSecond();
            totalLumberResourcePerSecond += buildings.get(i).getLumberResourcePerSecond();
            totalStoneResourcePerSecond += buildings.get(i).getStoneResourcePerSecond();
        }
        Timber.d("Buildings size =" + buildings.size() + " Cats " + totalCatResourcePerSecond + " lumber " + totalLumberResourcePerSecond + " stone " + totalStoneResourcePerSecond);
        allResourcesPerMinHashmap.put("totalCatResourcePerSecond", totalCatResourcePerSecond);
        allResourcesPerMinHashmap.put("totalLumberResourcePerSecond", totalLumberResourcePerSecond);
        allResourcesPerMinHashmap.put("totalStoneResourcePerSecond", totalStoneResourcePerSecond);


        return allResourcesPerMinHashmap;
    }
}
