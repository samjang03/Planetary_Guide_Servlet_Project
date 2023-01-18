package com.samjang.app.model;

public class Galaxy extends Entity {
    private String id;
    private String name;
    private String type;
    private int diameter;
    private int distanceToTheGalaxy;

    public Galaxy() {    }

    public Galaxy(String id, String name, String type, int diameter, int distanceToTheGalaxy) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.diameter = diameter;
        this.distanceToTheGalaxy = distanceToTheGalaxy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getDistanceToTheGalaxy() {
        return distanceToTheGalaxy;
    }

    public void setDistanceToTheGalaxy(int distanceToTheGalaxy) {
        this.distanceToTheGalaxy = distanceToTheGalaxy;
    }
}
