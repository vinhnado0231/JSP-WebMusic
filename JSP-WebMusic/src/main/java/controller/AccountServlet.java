package controller;

import model.bo.AccountBO;
import model.bo.UserBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccountServlet", value = "/AccountServlet")
public class AccountServlet extends HttpServlet {
    private AccountBO accountBO = new AccountBO();
    private UserBO userBO = new UserBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("checkLogin", true);

        if (request.getParameter("action").equals("loginForm")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login-form.jsp");
            rd.forward(request, response);
        } else if (request.getParameter("action").equals("login")) {

            if (accountBO.checkLogin(request.getParameter("username"), request.getParameter("password"))) {
                session.setAttribute("checkLogin", true);

                response.sendRedirect("/");
            } else {
                session.setAttribute("checkLogin", false);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/login-form.jsp");
                rd.forward(request, response);
            }
        } else if (request.getParameter("action").equals("logout")) {
            session.setAttribute("checkLogin", false);

            response.sendRedirect("/");

        }
    }
}

