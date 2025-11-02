<%-- src/main/webapp/resultat.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Résultat - Calculatrice</title>
</head>
<body>
    <h1>Résultat de l'opération</h1>

    <%--
      On vérifie si une erreur existe (le contrôleur nous enverra "messageErreur")
    --%>
    <c:if test="${not empty messageErreur}">
        <div style="color: red; border: 1px solid red; padding: 10px;">
            <h2>Erreur</h2>
            <%-- On affiche le message d'erreur fourni par le contrôleur --%>
            <p>${messageErreur}</p>
        </div>
    </c:if>

    <%--
      S'il n'y a PAS d'erreur, on affiche le résultat.
      Les variables ${...} sont fournies par le contrôleur.
    --%>
    <c:if test="${empty messageErreur}">
        <div>
            <p class="operande">Operande 1 : ${operande1}</p>
            <p class="operande">Operande 2 : ${operande2}</p>
            <p class="operation">Operateur : ${operation}</p>
            <p class="resultat"><b>Résultat : ${resultat}</b></p>
        </div>
    </c:if>


    <br>
    <a href="index.html">Retour à l'accueil</a>
</body>
</html>