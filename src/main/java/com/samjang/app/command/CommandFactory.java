package com.samjang.app.command;

import com.samjang.app.command.base.*;
import com.samjang.app.command.galaxies.DeleteGalaxy;
import com.samjang.app.command.galaxies.GetAllGalaxies;
import com.samjang.app.command.galaxies.InsertGalaxy;
import com.samjang.app.command.galaxies.UpdateGalaxy;
import com.samjang.app.command.planets.DeletePlanet;
import com.samjang.app.command.planets.GetAllPlanets;
import com.samjang.app.command.planets.InsertPlanet;
import com.samjang.app.command.planets.UpdatePlanet;
import com.samjang.app.command.satellites.DeleteSatellite;
import com.samjang.app.command.satellites.GetAllSatellites;
import com.samjang.app.command.satellites.InsertSatellite;
import com.samjang.app.command.satellites.UpdateSatellite;
import com.samjang.app.dao.info.Query1;
import com.samjang.app.dao.info.Query2;
import com.samjang.app.dao.info.Query3;
import com.samjang.app.dao.info.Query4;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static CommandFactory factory = new CommandFactory();
    private static Map<String, Command> commands = new HashMap<>();

    /**
     * Singleton
     */
    private CommandFactory() {}

    public static CommandFactory commandFactory() {
        if (factory == null) {
            factory = new CommandFactory();
        }
        return factory;
    }

    static {
        //commands.put("galaxies", new GetAllGalaxies());
        commands.put("sign_in", new SignInCommand());
        commands.put("verifying", new VerifyAdminCommand());
        commands.put("admin_panel", new AdminPanelCommand());
        commands.put("error", new ErrorCommand());
        commands.put("show_edit_form", new ShowEditFormCommand());
        commands.put("update_galaxy", new UpdateGalaxy());
        commands.put("update_planet", new UpdatePlanet());
        commands.put("update_satellite", new UpdateSatellite());
        commands.put("show_new_form", new ShowNewFormCommand());
        commands.put("insert_galaxy", new InsertGalaxy());
        commands.put("insert_planet", new InsertPlanet());
        commands.put("insert_satellite", new InsertSatellite());

        commands.put("/first_query", new Query1());
        commands.put("/second_query", new Query2());
        commands.put("/third_query", new Query3());
        commands.put("/fourth_query", new Query4());

        commands.put("/list_galaxies", new GetAllGalaxies());
        commands.put("/list_planets", new GetAllPlanets());
        commands.put("/list_satellites", new GetAllSatellites());
        commands.put("/delete_galaxy", new DeleteGalaxy());
        commands.put("/delete_planet", new DeletePlanet());
        commands.put("/delete_satellite", new DeleteSatellite());
    }

    public Command getCommand(HttpServletRequest request) {
        String option = request.getServletPath();
        if (option.contains("edit"))
            return commands.get("show_edit_form");
        if (option.contains("add_new"))
            return commands.get("show_new_form");
        if (option.contains("list") || option.contains("delete") || option.contains("query"))
            return commands.get(option);
        String action = request.getParameter("action");
        return commands.get(action);
    }
}
