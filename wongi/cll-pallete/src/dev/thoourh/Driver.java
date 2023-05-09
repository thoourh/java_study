package dev.thoourh;

public class Driver {
    private String name;
    private int licence;

    public Driver() {
    }

    public Driver(String name, int licence) {
        this.name = name;
        this.licence = licence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLicence() {
        return licence;
    }

    public void setLicence(int licence) {
        this.licence = licence;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", licence=" + licence +
                '}';
    }
}
