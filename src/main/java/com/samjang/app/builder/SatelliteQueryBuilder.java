package com.samjang.app.builder;

import com.samjang.app.model.Satellite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SatelliteQueryBuilder extends QueryBuilder<Satellite> {
    @Override
    public List<Satellite> getListOfResult(ResultSet rs) throws SQLException {
        List<Satellite> satellites = new ArrayList<>();
        while(rs.next()) {
            Satellite satellite = new Satellite();
            satellite.setId(rs.getInt("id"));
            satellite.setName(rs.getString("name"));
            satellite.setRadius(rs.getFloat("radius"));
            satellite.setDistanceToThePlanet(rs.getInt("dist_to_the_planet"));
            satellite.setPlanet(rs.getString("planet_name"));
            satellites.add(satellite);
        }
        return satellites;
    }

    @Override
    public Satellite getResult(ResultSet rs) throws SQLException {
        Satellite satellite = new Satellite();
        while(rs.next()) {
            satellite.setId(rs.getInt("id"));
            satellite.setName(rs.getString("name"));
            satellite.setRadius(rs.getFloat("radius"));
            satellite.setDistanceToThePlanet(rs.getInt("dist_to_the_planet"));
            satellite.setPlanet(rs.getString("planet_name"));
        }
        return satellite;
    }
}
