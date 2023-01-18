package com.samjang.app.command.planets;

import com.samjang.app.command.Command;
import com.samjang.app.dao.BaseDAO;
import com.samjang.app.dao.PlanetDAO;
import com.samjang.app.model.Planet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllPlanets implements Command {

    private final BaseDAO<Planet, Integer> dao = new PlanetDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Planet> planetList = dao.getAll();
        request.setAttribute("planetList", planetList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/planet_list.jsp");
        dispatcher.forward(request, response);
    }
}
