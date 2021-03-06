<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                <label for="nom">Adresse login <span class="requis">*</span></label>
                <input type="login" id="login" name="login" value="<c:out value="${utilisateur.login}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['login']}</span>
                

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>

                <label for="lastname">Lastname <span class="requis">*</span></label>
                <input type="lastname" id="lastname" name="lastname" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['lastname']}</span>
                
                <label for="firstname">Firstname <span class="requis">*</span></label>
                <input type="firstname" id="firstname" name="firstname" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['firstname']}</span>

                <input type="submit" value="Inscription" class="sansLabel" />
                
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
                <%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse login. --%>
                    <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.login}</p>
                </c:if>
            </fieldset>
        </form>
    </body>
</html>