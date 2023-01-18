package com.samjang.app.dao.info;

import com.samjang.app.builder.PlanetQueryBuilder;
import com.samjang.app.builder.QueryBuilder;
import com.samjang.app.command.Command;
import com.samjang.app.db.DBManager;
import com.samjang.app.model.Planet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Query4 implements Command {

    private final String GET_PLUS_TEMPERATURE = "SELECT planets.id as id, planets.name as planet_name, radius, mean_temperature, " +
            "atmosphere, life, galaxies.name as galaxy_name FROM planets INNER JOIN galaxies ON planets.galaxy_id = galaxies.id " +
            "WHERE mean_temperature > 0 ORDER BY mean_temperature";

    private DBManager db = DBManager.getInstance();
    private QueryBuilder<Planet> queryBuilder = new PlanetQueryBuilder();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Planet> planetList =  queryBuilder.executeAndReturnList(db, GET_PLUS_TEMPERATURE);
        request.setAttribute("planetList", planetList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/planet_list.jsp");
        dispatcher.forward(request, response);
    }
}
