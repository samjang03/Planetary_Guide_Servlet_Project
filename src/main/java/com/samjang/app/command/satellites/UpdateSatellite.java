package com.samjang.app.command.satellites;

import com.samjang.app.command.Command;
import com.samjang.app.dao.BaseDAO;
import com.samjang.app.dao.PlanetDAO;
import com.samjang.app.dao.SatelliteDAO;
import com.samjang.app.model.Planet;
import com.samjang.app.model.Satellite;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateSatellite implements Command {

    private final BaseDAO<Satellite, Integer> dao = new SatelliteDAO();
    private final BaseDAO<Planet, Integer> planetDAO = new PlanetDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float radius = Float.parseFloat(request.getParameter("radius"));
        int distanceToThePlanet = Integer.parseInt(request.getParameter("dist_to_the_planet"));
        int planetID = Integer.parseInt(request.getParameter("planetID"));

        String planet = planetDAO.getById(planetID).getName();

        Satellite satellite = new Satellite(id, name, radius, distanceToThePlanet, planetID);
        dao.update(satellite);
        response.sendRedirect("list_satellites");
    }
}
