package controller;

import model.bean.Playlist;
import model.bean.Song;
import model.bean.User;
import model.bo.PlaylistBO;
import model.bo.SongBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@WebServlet(name = "PlaylistServlet", value = "/PlaylistServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,    // 2 MB
        maxFileSize = 1024 * 1024 * 50,        // 50 MB
        maxRequestSize = 1024 * 1024 * 100)
public class PlaylistServlet extends HttpServlet {
    private PlaylistBO playlistBO = new PlaylistBO();
    private SongBO songBO = new SongBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        try {
//            switch (action) {
//                case "generalPlaylist":
//                    displayGeneralPlaylist(request, response);
//                    break;
//                case "detailList":
//                    displayDetailList(request, response);
//                    break;
//                case "detailPage":
//                    displayDetailPage(request,response);
//                    break;
//                case "delete":
//                    break;
//                case "search":
//                    break;
//                default:
//                    break;
//            }
//        } catch (ServletException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        try {
//            switch (action) {
//                case "generalPlaylist":
//                    displayGeneralPlaylist(request, response);
//                    break;
//                case "detailList":
//                    displayDetailList(request, response);
//                    break;
//                case "detailPage":
//                    displayDetailPage(request,response);
//                    break;
//                case "delete":
//                    break;
//                case "create":
//                    break;
//                default:
//                    break;
//            }
//        } catch (ServletException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

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
            Playlist playlistNow = playlistBO.getPlaylistByID(request.getParameter("detailList"));
            HttpSession session = request.getSession();
            session.setAttribute("playlistSong", playlistSong);
            session.setAttribute("idPlaylistNow", playlistNow.getIdList());
            session.setAttribute("playlistNow", playlistNow);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/detail-list.jsp");
            rd.forward(request, response);
        } else if (request.getParameter("action").equals("yourPlaylist")) {
            HttpSession session = request.getSession();
            User userNow = (User) session.getAttribute("userNow");
            ArrayList<Playlist> yourPlaylist = playlistBO.getPlayListofUser(userNow.getIduser());
            session.setAttribute("yourPlaylist", yourPlaylist);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/your-playlist.jsp");
            rd.forward(request, response);
        } else if (request.getParameter("action").equals("detailPage")) {
            HttpSession session = request.getSession();
            SongBO songBO = new SongBO();
            int idPLaylistNow = (int)session.getAttribute("idPlaylistNow");
            String idSongNow = request.getParameter("idSongNow");
            session.setAttribute("idSongNow", idSongNow);
            session.setAttribute("songNow",  songBO.getSongById(Integer.parseInt(idSongNow)));
            ArrayList<Song> list = playlistBO.getAllSongByIDList(idPLaylistNow);
            session.setAttribute("playlistDetailNow", list);
            response.sendRedirect("/detail-page.jsp");
        } else if (request.getParameter("action").equals("addPlaylist")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/add-form.jsp");
            rd.forward(request, response);

        } else if (request.getParameter("action").equals("editDetailList")) {
            String idUpdate = request.getParameter("idDetailList");
            HttpSession session = request.getSession();
            session.setAttribute("idUpdate", idUpdate);
            session.setAttribute("nameUpdate", playlistBO.getPlaylistByID(idUpdate).getNameList());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/edit-form.jsp");
            rd.forward(request, response);

        } else if (request.getParameter("updatePlaylist") != null) {
            HttpSession session = request.getSession();
            String txt = request.getParameter("txtUpdate");
            String idListUpdate = request.getParameter("updatePlaylist");
            int iduser = ((User) session.getAttribute("userNow")).getIduser();
            playlistBO.updatePlayList(Integer.parseInt(idListUpdate), iduser, txt);
            User userNow = (User) session.getAttribute("userNow");
            ArrayList<Playlist> yourPlaylist = playlistBO.getPlayListofUser(userNow.getIduser());
            session.setAttribute("yourPlaylist", yourPlaylist);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/your-playlist.jsp");
            rd.forward(request, response);
        } else if (request.getParameter("action").equals("createNewPlaylist")) {
            HttpSession session = request.getSession();
            int iduser = ((User) session.getAttribute("userNow")).getIduser();
            playlistBO.addPlayList(iduser, request.getParameter("nameList"), "");
            response.sendRedirect("/PlaylistServlet?action=yourPlaylist");
        }else if(request.getParameter("action").equals("search")){
            HttpSession session = request.getSession();
            int idPLaylistNow = (int)session.getAttribute("idPlaylistNow");
            String idSongNow = request.getParameter("idSongNow");
            ArrayList<Song> list = songBO.searchSong(request.getParameter("search_txt"),idPLaylistNow);
            session.setAttribute("playlistSong", list);
//            response.sendRedirect("/detail-list.jsp");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/detail-list.jsp");
            rd.forward(request, response);
        }
    }

    //    private void displayGeneralPlaylist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        session.setAttribute("changePage", "generalPlaylist");
//        ArrayList<Playlist> allPlaylist = playlistBO.getAllPlaylist();
//        session.setAttribute("allPlaylist", allPlaylist);
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/general-playlist.jsp");
//        rd.forward(request, response);
//    }
//
//    private void displayDetailList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println(Integer.parseInt(request.getParameter("detailList")));
//        ArrayList<Song> playlistSong = playlistBO.getAllSongByIDList(Integer.parseInt(request.getParameter("detailList")));
//        HttpSession session = request.getSession();
//        session.setAttribute("playlistSong", playlistSong);
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/detail-list.jsp");
//        rd.forward(request, response);
//    }
//    private void displayDetailPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println(Integer.parseInt(request.getParameter("detailList")));
//        ArrayList<Song> playlistSong = playlistBO.getAllSongByIDList(Integer.parseInt(request.getParameter("detailList")));
//        HttpSession session = request.getSession();
//        session.setAttribute("playlistSong", playlistSong);
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/detail-list.jsp");
//        rd.forward(request, response);
//    }
//    private static String getValue(Part part) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
//        StringBuilder value = new StringBuilder();
//        char[] buffer = new char[1024];
//        for (int length = 0; (length = reader.read(buffer)) > 0; ) {
//            value.append(buffer, 0, length);
//        }
//        return value.toString();
//    }
//
//    private String extractFileName(Part part) {
//        String contentDisp = part.getHeader("content-disposition");
//        String[] items = contentDisp.split(";");
//        for (String s : items) {
//            if (s.trim().startsWith("filename")) {
//                return s.substring(s.indexOf("=") + 2, s.length() - 1);
//            }
//        }
//        return "";
//    }
//
//    public File getFolderUpload() {
//        File folderUpload = new File("C:/Users/vinhn/Máy tính/JSP/JSP-WebMusic/JSP-WebMusic/src/main/webapp/Media/PlaylistIMG");
//        if (!folderUpload.exists()) {
//            folderUpload.mkdirs();
//        }
//        return folderUpload;
//    }
}