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
    private static final String FINISH_PAGE = "/WEB-INF/finish.jsp";
    private static final String REGISTER_PAGE = "/WEB-INF/register.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var player = (Player) request.getSession().getAttribute("player");
        var game = (Game) request.getSession().getAttribute("game");
        var message = game.getWinner() == player ? "You Won!" : "You Lost";

        if (game.isFinished()) {
            player.getAllyField().clear();
            request.setAttribute("message", message);
            request.getRequestDispatcher(FINISH_PAGE).include(request, response);
        } else {
            request.getRequestDispatcher(REGISTER_PAGE).forward(request, response);
        }
    }
}
