package affichage;

import java.util.*;

public class Affichage {
    public static final String INIT_COMBISIZE = "Quel est la taille de la combinaison que vous souhaitez trouver ?  ";
    public static final String GOODBYE = "Au revoir, à la prochaine";
    public static final String MODE_CHOICE_ERROR = "Vous n'avez pas choisi de modes parmi ceux proposés";
    public static final String VICTORY_FOR = "#2 a gagné !";
    public static final String ANSWER_IS = "La réponse est : #2";
    public static final String SET_COMBISIZE = "Veuillez saisir la combinaison que l'ordinateur devra trouver :";
    public static final String RESUME_SETCOMBINAISON = "La combinaison définie est #1. Au tour de l'ordinateur qui aura #2 essais!";
    public static final String TENTATIVE_NUMBER = " Tentative n° : #1";
    public static final String MAKE_CORRECT_TRY = "Veuillez saisir une combinaison avec le bon nombre de chiffre";
    public static final String GIVE_AN_ANSWER = "A votre tour (+-=):";
    public static final String GIVE_CORRECT_ANSWER = "Hum, êtes-vous sûr de votre réponse ? ";
    public static final String RESUME_GAMEPLAY = "Vous allez devoir trouver une combinaison de #1 chiffres en #2 essais";
    public static final String EMPTY_TEXTE = "#1";

    public static final String CONFIG_FILE_ERROR = "Sorry, unable to find config.properties";
    public static final String INT_INPUT_ERROR = "Veuillez saisir un chiffre";
    public static final String UNKNOW_ERROR = "Erreur inconnue";
    public static final String STRING_INPUT_ERROR = "Veuillez vérifier votre saisie";


    public static void affichage(String texte) {
        System.out.println(texte);
    }

    static void affichages (List <String> textes) {
        for (String texte : textes ) {
            System.out.println(texte);
        }
    }

}

