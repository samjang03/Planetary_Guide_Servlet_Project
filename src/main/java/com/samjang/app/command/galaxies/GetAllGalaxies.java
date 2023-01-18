package com.samjang.app.command.galaxies;

import com.samjang.app.command.Command;
import com.samjang.app.dao.BaseDAO;
import com.samjang.app.dao.GalaxyDAO;
import com.samjang.app.model.Galaxy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllGalaxies implements Command {

    private final BaseDAO<Galaxy, String> dao = new GalaxyDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Galaxy> galaxyList = dao.getAll();
        request.setAttribute("galaxyList", galaxyList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/galaxy_list.jsp");
        dispatcher.forward(request, response);
    }
}
