package cz.cvut.junit.entity;

/**
 * Created by frox on 19.4.16.
 */
public enum CoolingType {
    FREEZING,COOLING;

    public static CoolingType fromString(String s) {
        if(FREEZING.name().equalsIgnoreCase(s)) {
            return FREEZING;
        }
        if(COOLING.name().equalsIgnoreCase(s)) {
            return COOLING;
        }

        return null;
    }
}
