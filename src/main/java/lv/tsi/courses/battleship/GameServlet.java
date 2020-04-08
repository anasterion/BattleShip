package lv.tsi.courses.battleship;

import lv.tsi.courses.battleship.model.Game;
import lv.tsi.courses.battleship.model.Player;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GameServlet", urlPatterns = "/game")
public class GameServlet extends HttpServlet {
    private static final String FIRE_PAGE = "/WEB-INF/fire.jsp";
    private static final String WAIT_FIRE_PAGE = "/WEB-INF/waitFire.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var player = (Player) request.getSession().getAttribute("player");
        var game = (Game) request.getSession().getAttribute("game");
        if (game.isFinished()) {
            response.sendRedirect("/finish");
        } else if (game.isMyTurn(player)) {
            request.getRequestDispatcher(FIRE_PAGE).include(request, response);
        } else {
            request.getRequestDispatcher(WAIT_FIRE_PAGE).include(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var addr = request.getParameter("cell");
        if (StringUtils.isEmpty(addr)) {
            request.setAttribute("message", "Please select a cell");
            request.getRequestDispatcher(FIRE_PAGE).include(request, response);
            return;
        }
        var player = (Player) request.getSession().getAttribute("player");
        var game = (Game) request.getSession().getAttribute("game");
        if (game.isMyTurn(player)) {
            game.fire(addr);
        }
        doGet(request, response);
    }
}
