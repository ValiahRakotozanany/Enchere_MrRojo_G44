<%-- 
    Document   : Home
    Created on : 14 janv. 2023, 12:25:38
    Author     : ASUS
--%>
<%
    int idutilisateur=Integer.parseInt((request.getAttribute("idutilisateur")).toString());
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Home</h1>
        <p><a href="C_AjoutCritere?information=1&&idutilisateur=<%out.print(idutilisateur);%>"><button>Ajout_Critere</button></a></p>
        <p><a href="C_CritereRecherche?recherche=1&&idutilisateur=<%out.print(idutilisateur);%>"><button>Ajout_Critere_Amis</button></a></p>
        <p><a href=""><button>Voir Liste Compatible</button></a></p>
    </body>
</html>
