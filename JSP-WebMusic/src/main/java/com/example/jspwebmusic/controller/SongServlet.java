package com.example.jspwebmusic.controller;

import com.example.jspwebmusic.model.bean.Song;
import com.example.jspwebmusic.model.bo.SongBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SongServlet", value = "/SongServlet")
public class SongServlet extends HttpServlet {
    private SongBO songBO = new SongBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("song.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPlaylist = Integer.parseInt(request.getParameter("idPlaylist"));
        ArrayList<Song> songList= songBO.getAllSongByPlaylist(idPlaylist);
        for (int i = 0; i < songList.size();i++)
        {
            System.out.println(songList.get(i).getTenBaiHat());
        }

    }
}
