package com.samjang.app.dao.info;

import com.samjang.app.builder.PlanetQueryBuilder;
import com.samjang.app.command.Command;
import com.samjang.app.db.DBManager;
import com.samjang.app.model.Planet;
import com.samjang.app.model.Satellite;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Query3 implements Command {

    private final String GET_MANY_SATELLITES = "SELECT id, planet_name, radius, mean_temperature, atmosphere, life, galaxy_name, satellites_number FROM " +
            "(SELECT planets.id as id, planets.name AS planet_name, planets.radius AS radius, mean_temperature, atmosphere, life, galaxies.name AS galaxy_name, " +
            "COUNT(satellites.id) AS satellites_number FROM planets, satellites, galaxies WHERE planets.galaxy_id = galaxies.id " +
            "AND satellites.planet_id = planets.id GROUP BY planet_name) inner_query WHERE satellites_number > 2 ORDER BY satellites_number DESC";

    private DBManager db = DBManager.getInstance();
    private PlanetQueryBuilder queryBuilder = new PlanetQueryBuilder();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<Planet, Integer> planetMap = queryBuilder.executeAndReturnMap(db, GET_MANY_SATELLITES);
        request.setAttribute("planetMap", planetMap);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/planet_list.jsp");
        dispatcher.forward(request, response);
    }
}
