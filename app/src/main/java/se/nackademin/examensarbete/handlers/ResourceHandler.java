package se.nackademin.examensarbete.handlers;

import org.json.JSONObject;

import java.io.Serializable;

import timber.log.Timber;


public class ResourceHandler implements Serializable {
    private static ResourceHandler instance;
    private float numberOfLumber = 0;
    private float numberOfStones = 0;
    private float numberOfCats = 0;

    protected ResourceHandler() {

    }

    public void updateResourceHandlerFromJson(JSONObject jsonObject){
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
        numberOfLumber = numberOfCats - removedLumber;

    }

    public void subtractStones(float removedStones) {
        numberOfStones = numberOfCats - removedStones;

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
}
