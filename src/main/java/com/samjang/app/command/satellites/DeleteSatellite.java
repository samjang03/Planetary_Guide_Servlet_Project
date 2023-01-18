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

public class DeleteSatellite implements Command {

    private final BaseDAO<Satellite, Integer> dao = new SatelliteDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.delete(id);
        response.sendRedirect("list_satellites");
    }
}
