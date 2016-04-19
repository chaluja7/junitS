package cz.cvut.junit.pojo;

import java.nio.charset.Charset;

/**
 * Created by sange on 19/04/16.
 */
public class ReportItem {

    public static final String COMMA = ",";
    private String type;
    private int count;
    private boolean isFrozen;
    private int expiresInDays;

    public ReportItem() {
    }

    public ReportItem(String type, int count, boolean isFrozen, int expiresInDays) {
        this.type = type;
        this.count = count;
        this.isFrozen = isFrozen;
        this.expiresInDays = expiresInDays;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type.toUpperCase();
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    public int getExpiresInDays() {
        return expiresInDays;
    }

    public void setExpiresInDays(int expiresInDays) {
        this.expiresInDays = expiresInDays;
    }

    @Override
    public String toString() {
        return  getType() + COMMA + count + COMMA + expiresInDays + COMMA +  isFrozen;
    }
}
