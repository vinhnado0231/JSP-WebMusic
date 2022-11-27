package com.example.jspwebmusic.controller;

import com.example.jspwebmusic.model.bean.Playlist;
import com.example.jspwebmusic.model.bean.Song;
import com.example.jspwebmusic.model.bo.PlaylistBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
        playListBO.addPlayList(1,"Nhac pop");
        request.setAttribute("playList",playList);
        destination="/ViewListTest.jsp";
        RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
        rd.forward(request,response);
    }
}
