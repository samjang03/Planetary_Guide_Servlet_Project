package com.samjang.app.command.planets;

import com.samjang.app.command.Command;
import com.samjang.app.dao.BaseDAO;
import com.samjang.app.dao.GalaxyDAO;
import com.samjang.app.dao.PlanetDAO;
import com.samjang.app.model.Galaxy;
import com.samjang.app.model.Planet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletePlanet implements Command {

    private final BaseDAO<Planet, Integer> dao = new PlanetDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.delete(id);
        response.sendRedirect("list_planets");
    }
}
