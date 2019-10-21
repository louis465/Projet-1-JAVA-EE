package affichage;

public class Menu {
    /**
     * Display all available game type.
     */
    public static void displayAvailableGame() {
        System.out.println("Choix du jeu");
        System.out.println("1 - Challenger");
        System.out.println("2 - Défenseur");
        System.out.println("3 - Duel");
        System.out.println("4 - Quitter");
        System.out.println("A quel mode souhaitez-vous jouer?");
        System.out.println("");
    }

    public static void  challengerRules () {
        System.out.println("Vous avez choisi le mode: Challenger");
        System.out.println("Voici les régles :");
        System.out.println("1- L'ordinateur va choisir une combinaison de chiffres.");
        System.out.println("2- Tu vas devoir tenter de deviner cette combinaison en un nombre limité d'essais.");
        System.out.println("3- Aprés chaque tentative, l'ordinateur te dira pour chaque chiffre si il est =, > ou < au bon chiffre");
        System.out.println("Attention si tu ne trouves pas la solution le coffre s'autodétruira ! Bon jeu !");
        System.out.println("");
    }

    public static void defenseurRules () {
        System.out.println("Vous avez choisi le mode: Défenseur");
        System.out.println("Voici les régles:");
        System.out.println("1- Tu vas devoir choisir une combinaison de chiffres.");
        System.out.println("2- L'ordinateur va tenter de deviner cette combinaison en un nombre limité d'essais.");
        System.out.println("3- Aprés chaque tentative, tu devras indiquer à l'ordinateur pour chaque chiffre si il est =, > ou < au bon chiffre.");
        System.out.println("Si l'ordinateur ne trouve pas la solution le magot est à toi ! Si non, c'est la ruine.. Bon jeu !");
        System.out.println("");
    }

    public static void duelRules () {
        System.out.println("Vous avez choisi le mode Duel");
        System.out.println("Voici les régles:");
        System.out.println("1- L'ordinateur et toi allez devoir choisir une combinaison de chiffres.");
        System.out.println("2- Tour à tour, vous allez tenter de deviner la combinaison de l'autre en un nombre limité d'essais");
        System.out.println("3- Aprés chaque tentative, tu devras indiquer à l'ordinateur pour chaque chiffre si il est =, > ou < au bon chiffre. Il fera de meme.");
        System.out.println("Que le meilleur gagne ! Bon jeu !");
        System.out.println("");
    }

    /**
     * display end game choices
     */
    public static void displayEndGameChoice () {
        System.out.println("La partie est terminée ! Que souhaitez-vous faire ? :");
        System.out.println("1- Rejouer au meme mode");
        System.out.println("2- Jouer à un autre mode.");
        System.out.println(("3- Quitter le jeu"));
        System.out.println("");
    }
}
