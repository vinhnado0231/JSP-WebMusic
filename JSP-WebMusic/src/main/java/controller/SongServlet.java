package controller;

import model.bean.User;
import model.bo.PlaylistBO;
import model.bo.SongBO;
import model.bo.UserBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/SongServlet1")
public class SongServlet extends HttpServlet {
    private SongBO songBO = new SongBO();
    private UserBO userBO = new UserBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("VAo");
        User user = userBO.getUserByIdaccount(1);
        System.out.println(user.getName());
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        System.out.println("VAo post");
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
                try {
                    displayDetailForm(request, response);
                } catch (Exception e) {

                }
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

    private void displayDetailForm(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        SongBO songBO = new SongBO();
        PlaylistBO playlistBO = new PlaylistBO();

        String idPLaylistNow = (String) session.getAttribute("idPlaylistNow");

        String idSongNow = request.getParameter("idSongNow");
        session.setAttribute("idSongNow",idSongNow);

        session.setAttribute("songNow",  songBO.getSongById(Integer.parseInt(idSongNow)));
        session.setAttribute("playlistNow", playlistBO.getPlaylistByID(idPLaylistNow));

        response.sendRedirect("/detail-page.jsp");
    }



}
