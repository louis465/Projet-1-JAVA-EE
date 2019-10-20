package affichage;

import java.util.*;

public class Affichage {
    public static final String INIT_COMBISIZE = "Quel est la taille de la combinaison que vous souhaitez trouver ?  ";
    public static void affichage(String texte) {
        System.out.println(texte);
    }

    static void affichages (List <String> textes) {
        for (String texte : textes ) {
            System.out.println(texte);
        }
    }

}

