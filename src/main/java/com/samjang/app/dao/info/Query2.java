package com.samjang.app.dao.info;

import com.samjang.app.builder.QueryBuilder;
import com.samjang.app.builder.SatelliteQueryBuilder;
import com.samjang.app.command.Command;
import com.samjang.app.db.DBManager;
import com.samjang.app.model.Satellite;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Query2 implements Command {

    private final String GET_SMALL_RADIUS = "SELECT satellites.id as id, satellites.name as name, satellites.radius as radius," +
            "dist_to_the_planet, planets.name as planet_name FROM satellites INNER JOIN planets ON satellites.planet_id = planets.id " +
            "WHERE satellites.radius < (SELECT AVG(radius) FROM satellites) ORDER BY radius";

    private DBManager db = DBManager.getInstance();
    private QueryBuilder<Satellite> queryBuilder = new SatelliteQueryBuilder();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Satellite> satelliteList = queryBuilder.executeAndReturnList(db, GET_SMALL_RADIUS);
        request.setAttribute("satelliteList", satelliteList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/satellite_list.jsp");
        dispatcher.forward(request, response);
    }
}
