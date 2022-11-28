package com.example.jspwebmusic.controller;

import com.example.jspwebmusic.model.bean.Song;
import com.example.jspwebmusic.model.bo.AccountBO;
import com.example.jspwebmusic.model.bo.SongBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SongServlet", value = "/SongServlet")
public class SongServlet extends HttpServlet {
    private SongBO songBO = new SongBO();
    private AccountBO accountBO = new AccountBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("song.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPlaylist = Integer.parseInt(request.getParameter("idPlaylist"));
////        ArrayList<Song> songList = songBO.searchSong("Bai Hat");
////        for (int i = 0; i < songList.size(); i++) {
////            System.out.println(songList.get(i).getTenBaiHat());
////            System.out.println(songList.get(i).getIdSong());
////            System.out.println(songList.get(i).getCaSi());
////            System.out.println(songList.get(i).getSangTac());
////            System.out.println(songList.get(i).getTarget());
////            System.out.println(songList.get(i).getThoiGian());
////            System.out.println(songList.get(i).getLoiBaiHat());
////    }
//
//        Song song = songBO.getSongById(idPlaylist);
//        song.setLoiBaiHat("VinhnadoPRO123");
//        songBO.updateSong(song);
////        songBO.addNewSong(song);
        


    }
}
