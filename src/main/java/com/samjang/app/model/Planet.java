package com.samjang.app.model;

public class Planet extends Entity {
    private int id;
    private String name;
    private float radius;
    private float meanTemperature;
    private String atmosphere;
    private String life;
    private String galaxy;

    public Planet() {    }

    public Planet(int id, String name, float radius, float meanTemperature, String atmosphere, String life, String galaxy) {
        this.id = id;
        this.name = name;
        this.radius = radius;
        this.meanTemperature = meanTemperature;
        this.atmosphere = atmosphere;
        this.life = life;
        this.galaxy = galaxy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getMeanTemperature() {
        return meanTemperature;
    }

    public void setMeanTemperature(float meanTemperature) {
        this.meanTemperature = meanTemperature;
    }

    public String getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(String atmosphere) {
        this.atmosphere = atmosphere;
    }

    public String getLife() {
        return life;
    }

    public void setLife(String life) {
        this.life = life;
    }

    public String getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(String galaxy) {
        this.galaxy = galaxy;
    }
}
