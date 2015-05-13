package se.nackademin.examensarbete;

import com.google.gson.annotations.Expose;

import se.nackademin.examensarbete.handlers.BuildingHandler;
import se.nackademin.examensarbete.handlers.ResourceHandler;
import se.nackademin.examensarbete.handlers.StatisticHandler;


public class SaveFile {
    @Expose
    ResourceHandler resourceHandler;
    @Expose
    BuildingHandler buildingHandler;
    @Expose
    StatisticHandler statisticHandler;

    public SaveFile() {
        buildingHandler = BuildingHandler.getInstance();
        resourceHandler = ResourceHandler.getInstance();
        statisticHandler = StatisticHandler.getInstance();
    }

    public ResourceHandler getResourceHandler() {
        return resourceHandler;
    }

    public BuildingHandler getBuildingHandler() {
        return buildingHandler;
    }

    public StatisticHandler getStatisticHandler() {
        return statisticHandler;
    }
}
