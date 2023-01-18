package com.samjang.app.builder;

import com.samjang.app.model.Galaxy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GalaxyQueryBuilder extends QueryBuilder<Galaxy> {
    @Override
    public List<Galaxy> getListOfResult(ResultSet rs) throws SQLException {
        List<Galaxy> galaxies = new ArrayList<>();
        while(rs.next()) {
            Galaxy galaxy = new Galaxy();
            galaxy.setId(rs.getString("id"));
            galaxy.setName(rs.getString("name"));
            galaxy.setType(rs.getString("type"));
            galaxy.setDiameter(rs.getInt("diameter"));
            galaxy.setDistanceToTheGalaxy(rs.getInt("dist_to_the_galaxy"));
            galaxies.add(galaxy);
        }
        return galaxies;
    }

    @Override
    public Galaxy getResult(ResultSet rs) throws SQLException {
        Galaxy galaxy = new Galaxy();
        while(rs.next()) {
            galaxy.setId(rs.getString("id"));
            galaxy.setName(rs.getString("name"));
            galaxy.setType(rs.getString("type"));
            galaxy.setDiameter(rs.getInt("diameter"));
            galaxy.setDistanceToTheGalaxy(rs.getInt("dist_to_the_galaxy"));
        }
        return galaxy;
    }
}
