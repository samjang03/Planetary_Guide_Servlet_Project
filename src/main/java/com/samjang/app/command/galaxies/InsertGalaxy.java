package com.samjang.app.command.galaxies;

import com.samjang.app.command.Command;
import com.samjang.app.dao.BaseDAO;
import com.samjang.app.dao.GalaxyDAO;
import com.samjang.app.model.Galaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertGalaxy implements Command {

    private final BaseDAO<Galaxy, String> dao = new GalaxyDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        int diameter = Integer.parseInt(request.getParameter("diameter"));
        int distance = Integer.parseInt(request.getParameter("dist_to_the_planet"));

        Galaxy galaxy = new Galaxy(id, name, type, diameter, distance);
        dao.add(galaxy);
        response.sendRedirect("list_galaxies");
    }
}
