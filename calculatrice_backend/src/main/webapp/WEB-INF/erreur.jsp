<%-- 
    Document   : erreur
    Created on : 6 nov. 2025, 20:15:12
    Author     : narz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Erreur - Calculatrice</title>
        <style>
            body { font-family: Arial, sans-serif; margin: 40px; }
            .error-box { 
                border: 2px solid red; 
                background: #fff0f0; 
                padding: 20px; 
                border-radius: 8px; 
                max-width: 600px;
            }
            h1 { color: #D8000C; }
        </style>
    </head>
    <body>
        <div class="error-box">
        <h1>Oups, une erreur est survenue</h1>
        
        <p>Voici le détail de l'erreur :</p>
        
        <%-- 
          On affiche le message d'erreur que le ErrorHandler
          nous a envoyé via 'setAttribute'.
        --%>
        <h3>${messageErreur}</h3>
        
        <br>
        <a href="index.html">Retour à l'accueil</a>
        </div>
    </body>
</html>
