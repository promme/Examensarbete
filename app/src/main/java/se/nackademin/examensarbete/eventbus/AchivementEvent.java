package se.nackademin.examensarbete.eventbus;

/**
 * Created by Jonkan on 2015-05-11.
 */
public class AchivementEvent {
    private String achivementID;

    public AchivementEvent(String achivementID) {
        this.achivementID = achivementID;
    }

    public String getAchivementID() {
        return achivementID;
    }

    public void setAchivementID(String achivementID) {
        this.achivementID = achivementID;
    }
}
