package controller;

import model.bo.SongBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SongServlet", value = "/SongServlet")
public class SongServlet extends HttpServlet {
    private SongBO songBO = new SongBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createSongForm(request, response);
                    break;
                case "update":

                    break;
                case "delete":

                    break;
                case "search":

                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":

                break;
            case "update":

                break;
            case "delete":

                break;
            case "search":

                break;
            default:
                break;
        }
    }

    private void createSongForm(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-form.jsp");
        dispatcher.forward(request, response);
    }

    private void createSong(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, SQLException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("add-form.jsp");
        dispatcher.forward(request, response);
    }



}
