package com.samjang.app.dao;

import com.samjang.app.builder.PlanetQueryBuilder;
import com.samjang.app.builder.QueryBuilder;
import com.samjang.app.db.DBManager;
import com.samjang.app.model.Planet;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlanetDAO implements BaseDAO<Planet, Integer> {

    /*private static final String GET_ALL = "SELECT id, planets.name as planet_name, radius, mean_temperature, atmosphere, " +
            "life, galaxies.name as galaxy_name FROM planets INNER JOIN galaxies ON planets.galaxy_id = galaxies.id";*/

    private static final String GET_ALL = "SELECT planets.id as id, planets.name as planet_name, radius, mean_temperature, atmosphere, " +
            "life, galaxies.name as galaxy_name FROM planets INNER JOIN galaxies ON planets.galaxy_id = galaxies.id";
    private static final String GET_BY_ID = "SELECT id, name, radius, mean_temperature, atmosphere, " +
            "life, galaxy_id FROM planets WHERE id = ?";
    private static final String GET_NEXT_AUTO_INCREMENT = "SELECT MAX(id)+1 FROM planets";
    private static final String INSERT = "INSERT INTO planets (id, name, radius, mean_temperature, atmosphere, life, " +
            "galaxy_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE planets SET name = ?, radius = ?, mean_temperature = ?, " +
            "atmosphere = ?, life = ?, galaxy_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM planets where id = ?";

    private DBManager db = DBManager.getInstance();
    private QueryBuilder<Planet> queryBuilder = new PlanetQueryBuilder();
    @Override
    public List<Planet> getAll() {
        return queryBuilder.executeAndReturnList(db, GET_ALL);
    }

    @Override
    public Planet getById(Integer id) {
        return queryBuilder.executeAndReturnValue(db, GET_BY_ID, id);
    }

    @Override
    public void add(@NotNull Planet planet) {
        int id = queryBuilder.getNextAutoIncrement(db, GET_NEXT_AUTO_INCREMENT);
        queryBuilder.execute(db, INSERT, id, planet.getName(), planet.getRadius(), planet.getMeanTemperature(),
                planet.getAtmosphere(), planet.getLife(), planet.getGalaxy());
    }

    @Override
    public void update(@NotNull Planet planet) {
        queryBuilder.execute(db, UPDATE, planet.getName(), planet.getRadius(), planet.getMeanTemperature(),
                planet.getAtmosphere(), planet.getLife(), planet.getGalaxy(), planet.getId());
    }

    @Override
    public void delete(@NotNull Integer id) {
        queryBuilder.execute(db, DELETE, id);
    }
}
