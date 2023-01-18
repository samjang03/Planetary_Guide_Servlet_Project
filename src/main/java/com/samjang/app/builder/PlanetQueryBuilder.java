package com.samjang.app.builder;

import com.samjang.app.db.DBManager;
import com.samjang.app.model.Planet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanetQueryBuilder extends QueryBuilder<Planet> {
    @Override
    public List<Planet> getListOfResult(ResultSet rs) throws SQLException {
        List<Planet> planets = new ArrayList<>();
        while(rs.next()) {
            Planet planet = new Planet();
            planet.setId(rs.getInt("id"));
            planet.setName(rs.getString("planet_name"));
            planet.setRadius(rs.getFloat("radius"));
            planet.setMeanTemperature(rs.getFloat("mean_temperature"));
            planet.setAtmosphere(rs.getString("atmosphere"));
            planet.setLife(rs.getString("life"));
            planet.setGalaxy(rs.getString("galaxy_name"));
            planets.add(planet);
        }
        return planets;
    }

    @Override
    public Planet getResult(ResultSet rs) throws SQLException {
        Planet planet = new Planet();
        while(rs.next()) {
            planet.setId(rs.getInt("id"));
            planet.setName(rs.getString("name"));
            planet.setRadius(rs.getFloat("radius"));
            planet.setMeanTemperature(rs.getFloat("mean_temperature"));
            planet.setAtmosphere(rs.getString("atmosphere"));
            planet.setLife(rs.getString("life"));
            planet.setGalaxy(rs.getString("galaxy_id"));
        }
        return planet;
    }

    public Map<Planet, Integer> executeAndReturnMap(final DBManager instance, final String query) {
        Map<Planet, Integer> model = null;
        Connection conn = instance.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet rs = statement.executeQuery()) {
                model = getMapOfResults(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instance.closeConnection(conn);
        return model;
    }

    public Map<Planet, Integer> getMapOfResults(ResultSet rs) throws SQLException {
        Map<Planet, Integer> planetMap = new HashMap<>();
        while(rs.next()) {
            Planet planet = new Planet();
            planet.setId(rs.getInt("id"));
            planet.setName(rs.getString("planet_name"));
            planet.setRadius(rs.getFloat("radius"));
            planet.setMeanTemperature(rs.getFloat("mean_temperature"));
            planet.setAtmosphere(rs.getString("atmosphere"));
            planet.setLife(rs.getString("life"));
            planet.setGalaxy(rs.getString("galaxy_name"));
            int numberOfSatellites = rs.getInt("satellites_number");
            planetMap.put(planet, numberOfSatellites);
        }
        return planetMap;
    }
}
