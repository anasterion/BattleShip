package lv.tsi.courses.battleship;

import lv.tsi.courses.battleship.model.GameManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class StartAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        var gameManager = new GameManager();
        contextEvent.getServletContext().setAttribute("gameManager", gameManager);
        System.out.println("GAME MANAGER INITIALIZED");
    }
}
