package com.samjang.app.dao;

import com.samjang.app.builder.QueryBuilder;
import com.samjang.app.builder.SatelliteQueryBuilder;
import com.samjang.app.db.DBManager;
import com.samjang.app.model.Satellite;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SatelliteDAO implements BaseDAO<Satellite, Integer> {

    private static final String GET_ALL = "SELECT satellites.id as id, satellites.name as name, satellites.radius as radius, " +
            "dist_to_the_planet, planets.name as planet_name FROM satellites INNER JOIN planets ON satellites.planet_id = planets.id";
    private static final String GET_BY_ID = "SELECT satellites.id as id, satellites.name as name, satellites.radius as radius, " +
            "dist_to_the_planet, planets.name as planet_name FROM satellites, planets WHERE satellites.planet_id = planets.id AND satellites.id = ?";
    private static final String GET_NEXT_AUTO_INCREMENT = "SELECT MAX(id)+1 FROM satellites";
    private static final String INSERT = "INSERT INTO satellites (id, name, radius, dist_to_the_planet, planet_id) " +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE satellites SET name = ?, radius = ?, dist_to_the_planet = ?, planet_id = ? " +
            "WHERE id = ?";
    private static final String DELETE = "DELETE FROM satellites where id = ?";

    private DBManager db = DBManager.getInstance();
    private QueryBuilder<Satellite> queryBuilder = new SatelliteQueryBuilder();

    @Override
    public List<Satellite> getAll() {
        return queryBuilder.executeAndReturnList(db, GET_ALL);
    }

    @Override
    public Satellite getById(@NotNull Integer id) {
        return queryBuilder.executeAndReturnValue(db, GET_BY_ID, id);
    }

    @Override
    public void add(@NotNull Satellite satellite) {
        int id = queryBuilder.getNextAutoIncrement(db, GET_NEXT_AUTO_INCREMENT);
        queryBuilder.execute(db, INSERT, id, satellite.getName(), satellite.getRadius(),
                satellite.getDistanceToThePlanet(), satellite.getPlanetID());
    }

    @Override
    public void update(@NotNull Satellite satellite) {
        queryBuilder.execute(db, UPDATE, satellite.getName(), satellite.getRadius(),
                satellite.getDistanceToThePlanet(), satellite.getPlanetID(), satellite.getId());
    }

    @Override
    public void delete(@NotNull Integer id) {
        queryBuilder.execute(db, DELETE, id);
    }
}
