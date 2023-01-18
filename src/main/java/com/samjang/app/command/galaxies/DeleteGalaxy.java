package com.samjang.app.command.galaxies;

import com.samjang.app.command.Command;
import com.samjang.app.dao.BaseDAO;
import com.samjang.app.dao.GalaxyDAO;
import com.samjang.app.model.Galaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteGalaxy implements Command {

    private final BaseDAO<Galaxy, String> dao = new GalaxyDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        dao.delete(id);
        response.sendRedirect("list_galaxies");
    }
}
