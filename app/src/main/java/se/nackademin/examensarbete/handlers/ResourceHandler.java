package se.nackademin.examensarbete.handlers;

import com.google.gson.annotations.Expose;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;

import timber.log.Timber;


public class ResourceHandler implements Serializable {
    private static ResourceHandler instance;
    @Expose
    private float numberOfLumber = 0;
    @Expose
    private float numberOfStones = 0;
    @Expose
    private float numberOfCats = 0;

    protected ResourceHandler() {

    }

    public void updateResourceHandlerFromJson(JSONObject jsonObject) {
        getInstance().setNumberOfCats(jsonObject.optInt("numberOfCats", 0));
        getInstance().setNumberOfLumber(jsonObject.optInt("numberOfStones", 0));
        getInstance().setNumberOfStones(jsonObject.optInt("numberOfLumber", 0));
        Timber.d("Loaded save file with" + numberOfCats + " cats, " + numberOfStones + " stones and " + numberOfLumber + " lumber.");
    }

    public void setNumberOfCats(float numberOfCats) {
        this.numberOfCats = numberOfCats;
    }

    public void setNumberOfLumber(float numberOfLumber) {
        this.numberOfLumber = numberOfLumber;
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

    public void addLumber(float addedLumber) {
        numberOfLumber = numberOfLumber + addedLumber;
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

    public void subtractLumber(float removedLumber) {
        numberOfLumber = numberOfLumber - removedLumber;

    }

    public void subtractStones(float removedStones) {
        numberOfStones = numberOfStones - removedStones;

    }

    public float getNumberOfLumber() {
        return numberOfLumber;
    }

    public float getNumberOfStones() {
        return numberOfStones;
    }

    public float getNumberOfCats() {
        return numberOfCats;
    }

    public void updateResourcesPerSecond() {
        HashMap<String, Integer> hashMap = BuildingHandler.getInstance().getResourcesPerSecond();
        addCats(hashMap.get("totalCatResourcePerSecond"));
        addLumber(hashMap.get("totalLumberResourcePerSecond"));
        addStones(hashMap.get("totalStoneResourcePerSecond"));
    }

    public static void setInstance(ResourceHandler instance) {
        ResourceHandler.instance = instance;
    }
}
