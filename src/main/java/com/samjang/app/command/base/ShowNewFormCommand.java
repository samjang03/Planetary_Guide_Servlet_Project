package com.samjang.app.command.base;

import com.samjang.app.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowNewFormCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getParameter("action");
        String[] parts = path.split("_");
        switch(parts[1]) {
            case "galaxy"-> {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/galaxy_form.jsp");
                dispatcher.forward(request, response);
            }
            case "planet" -> {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/planet_form.jsp");
                dispatcher.forward(request, response);
            }
            case "satellite" -> {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/satellite_form.jsp");
                dispatcher.forward(request, response);
            }
            default -> throw new UnsupportedOperationException("Unexpected operation: " + path);
        }
    }
}
