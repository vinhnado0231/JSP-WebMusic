package controller;

import model.bean.Playlist;
import model.bean.Song;
import model.bean.User;
import model.bo.PlaylistBO;
import model.bo.SongBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PlaylistServlet", value = "/PlaylistServlet")
public class PlaylistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlaylistBO playlistBO = new PlaylistBO();


        if (request.getParameter("action").equals("generalPlaylist")) {
            HttpSession session = request.getSession();
            session.setAttribute("changePage", "generalPlaylist");
            ArrayList<Playlist> allPlaylist = playlistBO.getAllPlaylist();
            session.setAttribute("allPlaylist", allPlaylist);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/general-playlist.jsp");
            rd.forward(request, response);
        } else if (request.getParameter("action").equals("detailList")) {
            ArrayList<Song> playlistSong = playlistBO.getAllSongByIDList(Integer.parseInt(request.getParameter("detailList")));
            Playlist playlistNow=playlistBO.getPlaylistByID(request.getParameter("detailList"));
            HttpSession session = request.getSession();
            session.setAttribute("playlistSong", playlistSong);
            session.setAttribute("idPlaylistNow", playlistNow.getIdList());
            session.setAttribute("playlistNow", playlistNow);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/detail-list.jsp");
            rd.forward(request, response);
        }else if(request.getParameter("action").equals("yourPlaylist")){
            HttpSession session=request.getSession();
            User userNow = (User) session.getAttribute("userNow");
            ArrayList<Playlist> yourPlaylist=playlistBO.getPlayListofUser(userNow.getIduser());
            session.setAttribute("yourPlaylist", yourPlaylist);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/your-playlist.jsp");
            rd.forward(request, response);
        }else if(request.getParameter("action").equals("etailPage")){
            String idSongNow=request.getParameter("idSongNow");
            HttpSession session=request.getSession();
            session.setAttribute("idSongNow",idSongNow);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/detail-page.jsp");
            rd.forward(request, response);
        }

    }
}