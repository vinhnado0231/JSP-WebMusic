package controller;

import model.bo.AccountBO;
import model.bo.SongBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SongServlet", value = "/SongServlet")
public class SongServlet extends HttpServlet {
    private SongBO songBO = new SongBO();
    private AccountBO accountBO = new AccountBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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


}
