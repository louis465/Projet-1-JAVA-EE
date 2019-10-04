import java.util.InputMismatchException;
import java.util.Scanner;

public class Gamemodechoice {
    Scanner sc = new Scanner(System.in);

    /**
     * Display all available game type.
     */
    private void displayAvailableGame() {
        System.out.println("Choix du jeu");
        System.out.println("1 - Challenger");
        System.out.println("2 - Défenseur");
        System.out.println("3 - Duel");
        System.out.println("4 - Quitter");
        System.out.println("A quel mode souhaitez-vous jouer?");
        System.out.println("");
    }


    /**
     * Run asking process for a Game.
     * @return gameMode selected
     */
    String runGame() {
        int nbGame = 0;
        String gameMode = new String("");
        GamePlay gamePlay = new GamePlay();
        do {
            this.displayAvailableGame();
            try {
                nbGame = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez saisir un chiffre");
                sc.next();
                continue;
            } catch (Exception e) {
                System.out.println("Erreur inconnue");
            }
            switch (nbGame) {
                case 1:
                    gameMode = ("challenger");
                    System.out.println("Vous avez choisi le mode: " + gameMode);
                    System.out.println("Voici les régles du mode Challenger:");
                    System.out.println("1- L'ordinateur va choisir une combinaison de X chiffres.");
                    System.out.println("2- Tu vas devoir tenter de deviner cette combinaison en Y essais.");
                    System.out.println("3- Aprés chaque tentative, l'ordinateur te dira pour chaque chiffre si il est =, > ou < au bon chiffre");
                    System.out.println("Attention si tu ne trouves pas la solution le coffre s'autodétruira ! Bon jeu !");
                    System.out.println("");
                    GamePlay launchGame = new GamePlay();
                    break;
                case 2:
                    gameMode = ("defenseur");
                    System.out.println("Vous avez choisi le mode: " + gameMode);
                    System.out.println("Voici les régles du mode Defenseur:");
                    System.out.println("1- Tu vas devoir choisir une combinaison de X chiffres.");
                    System.out.println("2- L'ordinateur va tenter de deviner cette combinaison en Y essais.");
                    System.out.println("3- Aprés chaque tentative, tu devras indiquer à l'ordinateur pour chaque chiffre si il est =, > ou < au bon chiffre.");
                    System.out.println("Si l'ordinateur ne trouve pas la solution le magot est à toi ! Si non, c'est la ruine.. Bon jeu !");
                    System.out.println("");
                    break;
                case 3:
                    gameMode = ("duel");
                    System.out.println("Vous avez choisi le mode: " + gameMode);
                    System.out.println("Voici les régles du mode Duel:");
                    System.out.println("1- L'ordinateur et toi allez devoir choisir une combinaison de X chiffres.");
                    System.out.println("2- Tour à tour, vous allez tenter de deviner la combinaison de l'autre en Y essais maximum.");
                    System.out.println("3- Aprés chaque tentative, tu devras indiquer à l'ordinateur pour chaque chiffre si il est =, > ou < au bon chiffre. Il fera de meme.");
                    System.out.println("Que le meilleur gagne ! Bon jeu !");
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Une autre fois, au revoir");
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi de modes parmi ceux proposés");
                    break;
            }
        } while (nbGame < 1 || nbGame > 4);
        return gameMode;
    }
}