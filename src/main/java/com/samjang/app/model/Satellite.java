package com.samjang.app.model;

public class Satellite extends Entity {

    private int id;
    private String name;
    private float radius;
    private int distanceToThePlanet;
    private String planet;
    private int planetID;

    public Satellite() {    }

    public Satellite(int id, String name, float radius, int distanceToThePlanet, String planet) {
        this.id = id;
        this.name = name;
        this.radius = radius;
        this.distanceToThePlanet = distanceToThePlanet;
        this.planet = planet;
    }

    public Satellite(int id, String name, float radius, int distanceToThePlanet, int planetID) {
        this.id = id;
        this.name = name;
        this.radius = radius;
        this.distanceToThePlanet = distanceToThePlanet;
        this.planetID = planetID;
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

    public int getDistanceToThePlanet() {
        return distanceToThePlanet;
    }

    public void setDistanceToThePlanet(int distanceToThePlanet) {
        this.distanceToThePlanet = distanceToThePlanet;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public int getPlanetID() {
        return planetID;
    }

    public void setPlanetID(int planetID) {
        this.planetID = planetID;
    }
}
