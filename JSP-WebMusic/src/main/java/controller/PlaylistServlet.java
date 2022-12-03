package controller;

import model.bean.Playlist;
import model.bean.Song;
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
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlaylistBO playlistBO = new PlaylistBO();

       if(request.getParameter("action").equals("generalPlaylist")){
        ArrayList<Playlist> allPlaylist =playlistBO.getAllPlaylist();
        HttpSession session = request.getSession();
        session.setAttribute("allPlaylist",allPlaylist);
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/general-playlist.jsp");
        rd.forward(request,response);
       }else if(request.getParameter("action").equals("detaiList")){
           ArrayList<Song> playlistSong =playlistBO.getAllSongByIDList(11);
           HttpSession session = request.getSession();
           session.setAttribute("generalPlaylistSong",playlistSong);
           RequestDispatcher rd=getServletContext().getRequestDispatcher("/general-playlist.jsp");
           rd.forward(request,response);
       }
//        ArrayList<Song> playlistSong =playlistBO.getAllSongByIDList(11);
//        HttpSession session = request.getSession();
//        session.setAttribute("generalPlaylistSong",playlistSong);
//        RequestDispatcher rd=getServletContext().getRequestDispatcher("/general-playlist.jsp");
//        rd.forward(request,response);
    }
}
