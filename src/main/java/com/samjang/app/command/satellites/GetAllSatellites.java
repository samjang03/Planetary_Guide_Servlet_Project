package com.samjang.app.command.satellites;

import com.samjang.app.command.Command;
import com.samjang.app.dao.BaseDAO;
import com.samjang.app.dao.PlanetDAO;
import com.samjang.app.dao.SatelliteDAO;
import com.samjang.app.model.Planet;
import com.samjang.app.model.Satellite;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllSatellites implements Command {
    private final BaseDAO<Satellite, Integer> dao = new SatelliteDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Satellite> satelliteList = dao.getAll();
        request.setAttribute("satelliteList", satelliteList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/satellite_list.jsp");
        dispatcher.forward(request, response);
    }
}
