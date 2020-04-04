package lv.tsi.courses.battleship;

import lv.tsi.courses.battleship.model.CellState;
import lv.tsi.courses.battleship.model.Game;
import lv.tsi.courses.battleship.model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StartupServlet", urlPatterns = "/setup")
public class SetupServlet extends HttpServlet {
    private static final String SHIP_SETUP_PAGE = "/WEB-INF/setupShips.jsp";
    private static final String REGISTER_PAGE = "/WEB-INF/register.jsp";
    private static final String WAIT_OPPONENT_PAGE = "/WEB-INF/waitOpponentLogin.jsp";
    private static final String WAIT_SETUP_PAGE = "/WEB-INF/waitSetup.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var player = (Player) request.getSession().getAttribute("player");
        var game = (Game) request.getSession().getAttribute("game");

        if (player == null) {
            request.getRequestDispatcher(REGISTER_PAGE).forward(request, response);
            return;
        }

        if (game.setupIsReady()) {
            response.sendRedirect("/game");
        } else if (player.isReadyToPlay()) {
            request.getRequestDispatcher(WAIT_SETUP_PAGE).include(request, response);
        } else if (game.isReady()) {
            request.getRequestDispatcher(SHIP_SETUP_PAGE).include(request, response);
        } else {
            request.getRequestDispatcher(WAIT_OPPONENT_PAGE).include(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selected = request.getParameterValues("cells");
        var player = (Player) request.getSession().getAttribute("player");
        player.getAllyField().clear();

        if (selected != null) {
            for (String addr : selected) {
                player.getAllyField().setState(addr, CellState.SHIP);
            }
        }

        if (player.getAllyField().isValid()) {
            request.getRequestDispatcher(WAIT_SETUP_PAGE).include(request, response);
        } else {
            request.setAttribute("message", "Wrong placement!");
            request.getRequestDispatcher(SHIP_SETUP_PAGE).include(request, response);
        }
    }
}
