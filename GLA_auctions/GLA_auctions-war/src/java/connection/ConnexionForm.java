/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.Users;
import persistence.UsersManagerBean;

public final class ConnexionForm {
    private static final String CHAMP_LOGIN  = "login";
    private static final String CHAMP_PASS   = "motdepasse";

    private String              resultat, login;
    private Map<String, String> erreurs      = new HashMap<String, String>();
    private UsersManagerBean usersManager = new UsersManagerBean();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Users connecterUtilisateur( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        this.login = getValeurChamp( request, CHAMP_LOGIN );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );

        Users utilisateur = new Users();

        /* Validation du champ login. */
        try {
            validationEmail( login );
        } catch ( Exception e ) {
            setErreur( CHAMP_LOGIN, e.getMessage() );
        }
        utilisateur.setLogin( login );

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
        utilisateur.setPassword( motDePasse );

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
        }

        return utilisateur;
    }

    /**
     * Valide l'adresse login saisie.
     */
    private void validationEmail( String login ) throws Exception {
        if ( login != null && !login.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) && usersManager.find("login",this.login)!= null) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String motDePasse ) throws Exception {
        System.out.println("verif");
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            } else {
                Users tmp = usersManager.getCustommerLogin(this.login);
                if(!motDePasse.equals(tmp.getPassword())){
                    throw new Exception( "Le mot de passe est incorrect." );
                }else System.out.println("connection");
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}