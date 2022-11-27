<%@ page import="com.example.jspwebmusic.model.bean.Playlist" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jspwebmusic.model.bean.Song" %><%--
  Created by IntelliJ IDEA.
  User: Huu Phuc
  Date: 11/27/2022
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <form action="PlaylistServlet" method="post">
        <table>
            <%
                ArrayList<Song> playList = (ArrayList<Song>)request.getAttribute("playList");
                for(int i =0;i<playList.size();i++){
            %>
            <tr>
            <tr	> <%=	playList.get(i).getIdSong() %></tr> <br>
            <tr	> <%=	playList.get(i).getTenBaiHat() %></tr><br>
            <tr	> <%=	playList.get(i).getCaSi() %></tr><br>
            </tr>
            <%}%>
        </table>


    </form>
</body>
</html>
