<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Web music</title>
        <link rel="stylesheet" href="./index.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;1,100;1,200;1,300;1,400;1,500;1,600&display=swap" rel="stylesheet">

        <style>
            * {
                box-sizing: border-box;
            }

            html {
                font-size: 62.5%;
                font-family: 'Nunito', sans-serif;
                background-image: url('./Media/background-image.avif');
                background-repeat: no-repeat;
                background-position: center;
                background-size: cover;
            }

            body {
                margin: 0;

            }

            frameset {
                width: 100%;

            }


        </style>
    </head>
        <frameset border="0" rows="100,*" name="app-content">
            <frame  src="./View/header.jsp" name="header"/>
            <frameset border="0" cols="150,*">
                <frame name="" src="./View/sub-info.jsp" />
                <frame name="main-content" src="./View/home.jsp" />
            </frameset>
        </frameset>

</html>


