package se.nackademin.examensarbete.statistics;

/**
 * Created by Jonkan on 2015-05-11.
 */
public class Statistic {
    private String name;
    private String value;

    public Statistic(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
