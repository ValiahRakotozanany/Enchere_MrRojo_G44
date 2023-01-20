<%-- 
    Document   : Critererecherche
    Created on : 14 janv. 2023, 21:53:55
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
    int idutil = Integer.parseInt((request.getAttribute("idutilisateur")).toString());
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>    Critere Recherche</h1>
        <form action="C_CritereRecherche" method="post">
            <input type="hidden" value="<%out.print(idutil);%>" name="idutilisateur">
            <% for (int i = 0; i < critere.size(); i++) { %>
            <input type="hidden"value="<%out.print(critere.elementAt(i).getId());%>" name="critere<% out.print(critere.elementAt(i).getNom());%>">
            <%if (critere.elementAt(i).getTypecritereid() == 1) {%>
            <p>
                <%out.print(critere.elementAt(i).getNom());%> : 
            </p>
            <p>
                <select name="<%out.print(critere.elementAt(i).getNom());%>">
                    <option value="0">Non</option>
                    <option value="20">Oui</option>
                </select>
                Coeff <input type="text" name="Coeff<%out.print(critere.elementAt(i).getNom());%>"></p>
        </p>
        <% } %>
        <%if (critere.elementAt(i).getTypecritereid() == 2) {%>
        <% if (!critere.elementAt(i).getNom().equalsIgnoreCase("niveau etude") && !critere.elementAt(i).getNom().equalsIgnoreCase("Couleur")) { %>
        <p><%out.print(critere.elementAt(i).getNom());%> : </p>
        <p><input type="text" name="<%out.print(critere.elementAt(i).getNom());%>">
            Coeff <input type="text" name="Coeff<%out.print(critere.elementAt(i).getNom());%>"></p>

        <%}%>
        <% if (critere.elementAt(i).getNom().equalsIgnoreCase("couleur")) { %>
        <p><%out.print(critere.elementAt(i).getNom());%> : </p>
        <p>
            <select name="Couleur">
                <% for (int n = 0; n < couleur.size(); n++) {%>
                <option value="<%out.print(couleur.elementAt(n).getCouleur());%>"><%out.print(couleur.elementAt(n).getCouleur());%></option>
                <%} %>
            </select>
            Coeff <input type="text" name="Coeff<%out.print(critere.elementAt(i).getNom());%>"></p>
    </p>
    <%}%>
    <% if (critere.elementAt(i).getNom().equalsIgnoreCase("Niveau etude")) { %>
    <p><%out.print(critere.elementAt(i).getNom());%> : 
        Coeff <input type="text" name="Coeff<%out.print(critere.elementAt(i).getNom());%>"></p>
        <%}%>

    <% } %>
    <%if (critere.elementAt(i).getTypecritereid() == 3) {%>
    <% if (!critere.elementAt(i).getNom().equalsIgnoreCase("niveau etude") && !critere.elementAt(i).getNom().equalsIgnoreCase("Couleur")) { %>
    <p><%out.print(critere.elementAt(i).getNom());%> : </p>
    <p><input type="text" placeholder="min" name="min<%out.print(critere.elementAt(i).getNom());%>"> 
        <input type="text" placeholder="max" name="max<%out.print(critere.elementAt(i).getNom());%>">
        Coeff <input type="text" name="Coeff<%out.print(critere.elementAt(i).getNom());%>"></p>
</p>
<%}%>
<% if (critere.elementAt(i).getNom().equalsIgnoreCase("niveau etude") && !critere.elementAt(i).getNom().equalsIgnoreCase("Couleur")) { %>
<p><%out.print(critere.elementAt(i).getNom());%> : </p>
<p><input type="text" name="<%out.print(critere.elementAt(i).getNom());%>"> </p>
    <%}%>

<% } %>
<% }%>
<input type="submit"name="Valider">
</form>
</body>
</html>
