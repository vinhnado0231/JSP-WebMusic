package controller;

import model.bean.Song;
import model.bo.PlaylistBO;
import model.bo.SongBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "PlaylistServlet", value = "/PlaylistServlet")
public class PlaylistServlet extends HttpServlet {
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

    private void createPlaylistForm(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-form.jsp");
        dispatcher.forward(request, response);
        PlaylistBO playListBO=new PlaylistBO();
        SongBO songBO=new SongBO();
        ArrayList<Song> playList=playListBO.getAllSongByIDList(1);
       if(request.getAttribute("generalPlaylist")!=null){
//           ArrayList<Song> playlistSong =songBO.get();
           request.setAttribute("playList",playList);
           RequestDispatcher rd=getServletContext().getRequestDispatcher("/general-playlist.jsp");
           rd.forward(request,response);
       }
    }

    private void createPlaylist(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, SQLException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("add-form.jsp");
        dispatcher.forward(request, response);
    }

}
