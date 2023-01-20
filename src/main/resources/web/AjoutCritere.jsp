<%-- 
    Document   : AjoutCritere
    Created on : 14 janv. 2023, 17:54:16
    Author     : ASUS
--%>
<%@page import="model.Couleur"%>
<%@page import="model.NiveauEtude"%>
<%@page import="model.Critere"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Critere> critere = (Vector<Critere>) (request.getAttribute("critere"));
    Vector<NiveauEtude> etude = (Vector<NiveauEtude>) (request.getAttribute("etude"));
    Vector<Couleur> couleur = (Vector<Couleur>) (request.getAttribute("couleur"));
    int idutil=Integer.parseInt((request.getAttribute("idutilisateur")).toString());
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ajout Critere</h1>
        <form action="C_AjoutCritere" method="post">
            <input type="hidden" name="idutilisateur" value="<%out.print(idutil);%>">
        <% for (int i = 0; i < critere.size(); i++) { %>
        <input type="hidden"value="<%out.print(critere.elementAt(i).getId());%>" name="critere<% out.print(critere.elementAt(i).getNom());%>">
        <%if (critere.elementAt(i).getTypecritereid() == 1) {%>
        <p><%out.print(critere.elementAt(i).getNom());%> : </p>
        <p>
            <select name="<%out.print(critere.elementAt(i).getNom());%>">
                <option value="0">Non</option>
                <option value="20">Oui</option>
            </select>
        </p>
        <% } %>
        <%if (critere.elementAt(i).getTypecritereid() == 2 || critere.elementAt(i).getTypecritereid() == 3) {%>
        <% if (!critere.elementAt(i).getNom().equalsIgnoreCase("niveau etude") && !critere.elementAt(i).getNom().equalsIgnoreCase("Couleur")) { %>
        <p><%out.print(critere.elementAt(i).getNom());%> : </p>
        <p><input type="text" name="<%out.print(critere.elementAt(i).getNom());%>">
            <%}%>
        </p>
        <% } %>

        <% } %>
        <p>Couleur</p>
        <select name="Couleur">
            <% for (int i = 0; i < couleur.size(); i++) {%>
            <option value="<%out.print(couleur.elementAt(i).getCouleur());%>"><%out.print(couleur.elementAt(i).getCouleur());%></option>
            <%} %>
        </select>
        <p>Niveau Etude</p>
        <select name="Niveau etude">
            <% for (int i = 0; i < etude.size(); i++) {%>
            <option value="<%out.print(etude.elementAt(i).getValeur());%>"><%out.print(etude.elementAt(i).getNiveau());%></option>
            <%}%>
        </select>
        <p><input type="submit" name="Valider"></p>
        </form>
    </body>
</html>
