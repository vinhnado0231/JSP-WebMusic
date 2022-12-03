package controller;

import model.bean.User;
import model.bo.AccountBO;
import model.bo.UserBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AccountServlet", value = "/AccountServlet")
public class AccountServlet extends HttpServlet {
    private AccountBO accountBO = new AccountBO();
    private UserBO userBO = new UserBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "loginForm":
                    displayLoginForm(request, response);
                    break;
                case "logout":
                    logout(request, response);
                    break;
                case "delete":
                    break;
                case "search":
                    break;
                default:
                    session.setAttribute("changePage", "home");
                    response.sendRedirect("/");
                    break;
            }
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "login":
                    checkLogin(request, response);
                    break;
                case "delete":
                    break;
                case "search":
                    break;
                default:
                    session.setAttribute("changePage", "home");
                    response.sendRedirect("/");
                    break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void displayLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login-form.jsp");
        rd.forward(request, response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("checkLogin", false);
        session.setAttribute("changePage", "home");
        response.sendRedirect("/");
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (accountBO.checkLogin(request.getParameter("username"), request.getParameter("password"))) {
            session.setAttribute("checkLogin", true);
            User userNow = userBO.getUserByIdaccount(accountBO.findAccountByUsername(request.getParameter("username")).getIdaccount());
            session.setAttribute("userNow", userNow);
            session.setAttribute("changePage", "home");
            response.sendRedirect("/");
        } else {
            session.setAttribute("checkLogin", false);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login-form.jsp");
            rd.forward(request, response);
        }
    }
}

