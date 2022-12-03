package controller;

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
        PlaylistBO playListBO=new PlaylistBO();
        SongBO songBO=new SongBO();
        ArrayList<Song> playList=playListBO.getAllSongByIDList(1);
        playListBO.removeSongFromPlayList(4,1);
        request.setAttribute("playList",playList);
        destination="/ViewListTest.jsp";
        RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
        rd.forward(request,response);
       if(request.getAttribute("generalPlaylist")!=null){
//           ArrayList<Song> playlistSong =songBO.get();
           request.setAttribute("playList",playList);
           RequestDispatcher rd=getServletContext().getRequestDispatcher("/general-playlist.jsp");
           rd.forward(request,response);
       }
    }
}
