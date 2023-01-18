package com.samjang.app.controller;

import com.samjang.app.command.Command;
import com.samjang.app.command.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FrontController", value = "/")
public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        CommandFactory commandFactory = CommandFactory.commandFactory();
        Command command = commandFactory.getCommand(request);
        command.execute(request, response);
/*        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/galaxy_list.jsp");
        dispatcher.forward(request, response);*/
    }
}
