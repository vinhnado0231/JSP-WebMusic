<%@ page import="com.example.jspwebmusic.model.bean.Playlist" %>
<%@ page import="java.util.ArrayList" %><%--
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
                ArrayList<Playlist> playList = (ArrayList<Playlist>)request.getAttribute("playList");
                for(int i =0;i<playList.size();i++){
            %>
            <tr>
            <tr	> <%=	playList.get(i).getIdList() %></tr> <br>
            <tr	> <%=	playList.get(i).getNameList() %></tr><br>
            <tr	> <%=	playList.get(i).getIdUser() %></tr><br>
            ]</tr>
            <%}%>
        </table>


    </form>
</body>
</html>
