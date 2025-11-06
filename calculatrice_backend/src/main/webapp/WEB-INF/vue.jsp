<%-- 
    Document   : vue
    Created on : 4 nov. 2025, 12:07:30
    Author     : narz

@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- c'est mon fichier vue.jsp (ou resultat.jsp) --%>

<%-- la config de base de ma page. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 
  ah, c'est la ligne super importante.
  c'est elle qui dit à la page "tu as le droit d'utiliser les balises <c:if>".
  sans ça, le serveur ne comprend pas et plante le déploiement.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Résultat - Calculatrice</title>
</head>
<body>
    <h1>Résultat de l'opération</h1>

    <%--
      bon, ici je vérifie.
      est-ce que le contrôleur m'a envoyé un truc qui s'appelle "messageErreur" ?
      (en gros, est-ce qu'il y a eu une erreur ?)
    --%>
    <c:if test="${not empty messageErreur}">
        <%-- 
          oui, il y a une erreur.
          donc j'affiche ce bloc div rouge.
        --%>
        <div style="color: red; border: 1px solid red; padding: 10px;">
            <h2>Erreur</h2>
            <%-- j'affiche le texte de l'erreur que le contrôleur m'a donné. --%>
            <p>${messageErreur}</p>
        </div>
    </c:if>

    <%--
      et ici, je fais l'inverse.
      je vérifie s'il n'y a PAS de "messageErreur" (si c'est vide ou null).
    --%>
    <c:if test="${empty messageErreur}">
        <%-- 
          cool, pas d'erreur.
          j'affiche le bloc de résultat normal.
        --%>
        <div>
            <%-- 
              les ${...} c'est magique.
              je récupère les "attributs" que le contrôleur a mis dans la requête.
            --%>
            <p class="operande">Operande 1 : ${operande1}</p>
            <p class="operande">Operande 2 : ${operande2}</p>
            <p class="operation">Operateur : ${operation}</p>
            <p class="resultat"><b>Résultat : ${resultat}</b></p>
        </div>
    </c:if>


    <br>
    <%-- un simple lien pour retourner à la page d'accueil (index.html) --%>
    <a href="index.html">Retour à l'accueil</a>
</body>
</html>