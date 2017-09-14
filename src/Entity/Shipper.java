package Entity;

import java.io.Serializable;

public class Shipper implements Serializable{
    private String name;

    public Shipper(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
