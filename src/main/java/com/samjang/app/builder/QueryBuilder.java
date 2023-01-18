package com.samjang.app.builder;

import com.samjang.app.db.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class QueryBuilder<T> {
    public final void execute(final DBManager instance, final String query) {
        executeQuery(instance, query, new Object[0]);
    }

    public final void execute(final DBManager instance, final String query, Object... args) {
        executeQuery(instance, query, args);
    }

    private void executeQuery(final DBManager instance, String query, Object... args) {
        Connection conn = instance.getConnection();
        try (PreparedStatement st = conn.prepareStatement(query)) {
            setArgsOfPreparedStatement(st, args);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instance.closeConnection(conn);
    }

    public List<T> executeAndReturnList(final DBManager instance, final String query,
                                           Object... args) {
        List<T> models = null;
        Connection conn = instance.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            setArgsOfPreparedStatement(statement, args);
            try (ResultSet rs = statement.executeQuery()) {
                models = getListOfResult(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instance.closeConnection(conn);
        return models;
    }

    public T executeAndReturnValue(final DBManager instance, final String query, Object... args) {
        T model = null;
        Connection conn = instance.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            setArgsOfPreparedStatement(statement, args);
            try (ResultSet rs = statement.executeQuery()) {
                model = getResult(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instance.closeConnection(conn);
        return model;
    }

    public final int getNextAutoIncrement(final DBManager instance, final String query) {
        int nextId = 0;
        Connection conn = instance.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    nextId = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instance.closeConnection(conn);
        return nextId;
    }
    private void setArgsOfPreparedStatement(PreparedStatement statement, Object... args)
            throws SQLException {
        for (int i = 0; i < args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }
    }

    public abstract List<T> getListOfResult(ResultSet rs) throws SQLException;

    public abstract T getResult(ResultSet rs) throws SQLException;

    //public abstract void create();

    //public abstract void update();
}
