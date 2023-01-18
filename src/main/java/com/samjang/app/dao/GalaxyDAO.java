package com.samjang.app.dao;

import com.samjang.app.builder.GalaxyQueryBuilder;
import com.samjang.app.builder.QueryBuilder;
import com.samjang.app.db.DBManager;
import com.samjang.app.model.Galaxy;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GalaxyDAO implements BaseDAO<Galaxy, String> {

    private static final String GET_ALL = "SELECT * FROM galaxies";
    private static final String GET_BY_ID = "SELECT id, name, type, diameter, dist_to_the_galaxy FROM galaxies " +
            "WHERE id = ?";
    private static final String INSERT = "INSERT INTO galaxies (id, name, type, diameter, dist_to_the_galaxy) " +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE galaxies SET name = ?, type = ?, diameter = ?, " +
            "dist_to_the_galaxy = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM galaxies where id = ?";

    private DBManager db = DBManager.getInstance();
    private QueryBuilder<Galaxy> queryBuilder = new GalaxyQueryBuilder();

    public List<Galaxy> getAll() {
        return queryBuilder.executeAndReturnList(db, GET_ALL);
    }

    public Galaxy getById(@NotNull String id) {
        return queryBuilder.executeAndReturnValue(db, GET_BY_ID, id);
    }

    public void add(@NotNull Galaxy galaxy) {
        //Galaxy galaxy = (Galaxy) entity;
        queryBuilder.execute(db, INSERT, galaxy.getId(), galaxy.getName(), galaxy.getType(),
                galaxy.getDiameter(), galaxy.getDistanceToTheGalaxy());
    }

    public void update(@NotNull Galaxy galaxy) {
        queryBuilder.execute(db, UPDATE, galaxy.getName(), galaxy.getType(), galaxy.getDiameter(),
                galaxy.getDistanceToTheGalaxy(), galaxy.getId());
    }

    public void delete(@NotNull String id) {
        queryBuilder.execute(db, DELETE, id);
    }
}
