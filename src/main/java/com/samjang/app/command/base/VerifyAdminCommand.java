package com.samjang.app.command.base;

import com.samjang.app.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class VerifyAdminCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("username").equals("little_prince") &&
                request.getParameter("password").equals("fox")) {
            HttpSession session = request.getSession();
            session.setAttribute("role", "admin");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin_panel.jsp");

            dispatcher.forward(request, response);
        }

        else
            throw new IllegalAccessError();
    }
}
