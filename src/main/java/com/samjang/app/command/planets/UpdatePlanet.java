package com.samjang.app.command.planets;

import com.samjang.app.command.Command;
import com.samjang.app.dao.BaseDAO;
import com.samjang.app.dao.PlanetDAO;
import com.samjang.app.model.Planet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdatePlanet implements Command {

    private final BaseDAO<Planet, Integer> dao = new PlanetDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float radius = Float.parseFloat(request.getParameter("radius"));
        float meanTemperature = Float.parseFloat(request.getParameter("mean_temperature"));
        String atmosphere = request.getParameter("atmosphere");
        String life = request.getParameter("life");
        String galaxy = request.getParameter("galaxy");

        Planet planet = new Planet(id, name, radius, meanTemperature, atmosphere, life, galaxy);
        dao.update(planet);
        response.sendRedirect("list_planets");
    }
}
