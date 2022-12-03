package controller;

import model.bo.AccountBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "AccountServlet", value = "/AccountServlet")
public class AccountServlet extends HttpServlet {
    private AccountBO accountBO = new AccountBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("login") != null) {

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/View/header.jsp");
            rd.forward(request, response);

//            if (accountBO.checkLogin(request.getParameter("username"), request.getParameter("password"))) {
//                request.setAttribute("checkLogin" , true);
//
//            }
//            else {
//                request.setAttribute("checkLogin" , false);
//
//            }
        }
        else if (request.getParameter("generalPlaylist") != null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/View/general-playlist.jsp");
            rd.forward(request, response);
        }
    }
}
