package lv.tsi.courses.battleship;

import lv.tsi.courses.battleship.model.Game;
import lv.tsi.courses.battleship.model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FinishServlet", urlPatterns = "/finish")
public class FinishServlet extends HttpServlet {
    private static final String WON_GAME_PAGE = "/WEB-INF/wonGame.jsp";
    private static final String LOST_GAME_PAGE = "/WEB-INF/lostGame.jsp";
    private static final String REGISTER_PAGE = "/WEB-INF/register.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var player = (Player) request.getSession().getAttribute("player");
        var game = (Game) request.getSession().getAttribute("game");
        var resultPage = game.getWinner() == player ? WON_GAME_PAGE : LOST_GAME_PAGE;

        if (game.isFinished()) {
            request.getRequestDispatcher(resultPage).include(request, response);
        } else {
            request.getRequestDispatcher(REGISTER_PAGE).forward(request, response);
        }
    }
}
