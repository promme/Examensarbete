package se.nackademin.examensarbete;

import com.google.gson.annotations.Expose;

import se.nackademin.examensarbete.handlers.BuildingHandler;
import se.nackademin.examensarbete.handlers.ResourceHandler;


public class SaveFile {
    @Expose
    ResourceHandler resourceHandler;
    @Expose
    BuildingHandler buildingHandler;

    public SaveFile() {
        buildingHandler = BuildingHandler.getInstance();
        resourceHandler = ResourceHandler.getInstance();
    }

    public ResourceHandler getResourceHandler() {
        return resourceHandler;
    }

    public BuildingHandler getBuildingHandler() {
        return buildingHandler;
    }
}
