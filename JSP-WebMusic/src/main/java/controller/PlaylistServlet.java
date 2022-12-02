package controller;

import model.bean.Song;
import model.bo.PlaylistBO;

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
        String destination = null;
        ArrayList<Song> playList=playListBO.getAllSongByIDList(1);
        playListBO.updatePlayList(4,1,"Nhac POP");
        request.setAttribute("playList",playList);
        destination="/ViewListTest.jsp";
        RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
        rd.forward(request,response);
    }
}
