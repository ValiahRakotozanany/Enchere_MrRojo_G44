<%-- 
    Document   : Inscrit
    Created on : 13 janv. 2023, 23:28:02
    Author     : ASUS
--%>
<%@page import="model.Genre"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Genre> genre = (Vector<Genre>) (request.getAttribute("genre"));
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inscrit</h1>
        <form action="C_Inscrit" method="post">
            <p>Nom :</p> 
            <p><input name="nom"></p>
            <p>Prenom </p>
            <p><input name="prenom"></p>
             <p>PSEUDO </p>
            <p><input name="pseudo"></p>
           
            <p>MDP </p>
            <p><input name="mdp" type="password"></p>
            <p>Date de Naissance</p>
            <input type="date" name="dtn">
            <p>GENRE</p>
            <p><select name="genre">
                    <%for (int i = 0; i < genre.size(); i++) { %>
                    <option value="<%out.print(genre.elementAt(i).getId());%>"><%out.print(genre.elementAt(i).getGenre());%></option>
                    <% }%>
            </select>
        </p>
        <p>TEXT MORS</p>
        <p><textarea name="textmors"></textarea></p>
        <p>Note MIn</p>
        <p><input type="text" name="notemin"></p>
        <p><input type="submit" name="valider"></p>
        </form>
            <p><a href="C_Inscrit?login=2">Connecter</a></p>
    </body>
</html>
