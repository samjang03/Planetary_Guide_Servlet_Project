package com.samjang.app.command.base;

import com.samjang.app.command.Command;
import com.samjang.app.dao.BaseDAO;
import com.samjang.app.dao.GalaxyDAO;
import com.samjang.app.dao.PlanetDAO;
import com.samjang.app.dao.SatelliteDAO;
import com.samjang.app.model.Galaxy;
import com.samjang.app.model.Planet;
import com.samjang.app.model.Satellite;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowEditFormCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        String[] parts = path.split("_", 2);
        switch(parts[1]) {
            case "galaxy"-> {
                String id = request.getParameter("id");
                BaseDAO<Galaxy, String> dao = new GalaxyDAO();
                Galaxy existingGalaxy = dao.getById(id);
                request.setAttribute("galaxy", existingGalaxy);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/galaxy_form.jsp");
                dispatcher.forward(request, response);
            }
            case "planet" -> {
                Integer id = Integer.parseInt(request.getParameter("id"));
                BaseDAO<Planet, Integer> dao = new PlanetDAO();
                Planet existingPlanet = dao.getById(id);
                request.setAttribute("planet", existingPlanet);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/planet_form.jsp");
                dispatcher.forward(request, response);
            }
            case "satellite" -> {
                Integer id = Integer.parseInt(request.getParameter("id"));
                BaseDAO<Satellite, Integer> dao = new SatelliteDAO();
                Satellite existingSatellite = dao.getById(id);
                request.setAttribute("satellite", existingSatellite);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/satellite_form.jsp");
                dispatcher.forward(request, response);
            }
            default -> throw new UnsupportedOperationException("Unexpected operation: " + path);
        }
    }
}
