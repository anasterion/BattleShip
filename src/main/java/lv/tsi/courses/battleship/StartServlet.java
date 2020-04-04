package lv.tsi.courses.battleship;

import lv.tsi.courses.battleship.model.Game;
import lv.tsi.courses.battleship.model.GameManager;
import lv.tsi.courses.battleship.model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/battleship")
public class StartServlet extends HttpServlet {
    private static final String WAIT_OPPONENT_PAGE = "/WEB-INF/waitOpponentLogin.jsp";
    private static final String REGISTER_PAGE = "/WEB-INF/register.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var gameManager = (GameManager) getServletContext().getAttribute("gameManager");
        var name = request.getParameter("name");
        var player = new Player();
        player.setName(name);

        var game = gameManager.getIncompleteGameAndJoin(player);
        request.getSession().setAttribute("player", player);
        request.getSession().setAttribute("game", game);
        request.getRequestDispatcher(WAIT_OPPONENT_PAGE).include(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var player = (Player) request.getSession().getAttribute("player");
        var game = (Game) request.getSession().getAttribute("game");

        if (player == null) {
            request.getRequestDispatcher(REGISTER_PAGE).forward(request, response);
            return;
        }

        if (game.isReady()) {
            response.sendRedirect("/setup");
        } else {
            request.getRequestDispatcher(WAIT_OPPONENT_PAGE).include(request, response);
        }
    }
}
