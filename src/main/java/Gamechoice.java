import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Gamechoice {
    private static final Logger logger = LogManager.getLogger(Gamechoice.class.getName());
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
     * Run asking process for a Game mode.
     * @return gameMode selected
     */
    String runGame() {
        GamePlay launchGame = new GamePlay();
        Player IAPlayer = new IAPlayer();
        Player HumanPlayer = new HumanPlayer();
        int nbGame = 0;
        String gameMode = new String("");
        do {
            this.displayAvailableGame();
            nbGame = GameMethode.scanAnInt();
            logger.info("Mode choisi par l'utilisateur : " + nbGame );
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
                    launchGame.launchGame(IAPlayer, HumanPlayer, nbGame);
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
                    launchGame.launchGame(HumanPlayer, IAPlayer, nbGame);
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
                    launchGame.launchGame(IAPlayer, HumanPlayer, nbGame);
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

    /**
     * display end game choices
     */
    public void displayEndGameChoice () {
        System.out.println("La partie est terminée ! Que souhaitez-vous faire ? :");
        System.out.println("1- Rejouer au meme mode");
        System.out.println("2- Jouer à un autre mode.");
        System.out.println(("3- Quitter le jeu"));
        System.out.println("");
    }

    /**
     * rue asking process for end game choice
     * @param nbGame
     */
    public void endGameChoice (int nbGame) {
        GamePlay launchGame = new GamePlay();
        Player IAPlayer = new IAPlayer();
        Player HumanPlayer = new HumanPlayer();
        int nbChoice = 0;
        do {
            this.displayEndGameChoice();
            nbChoice = GameMethode.scanAnInt();
            logger.info("Mode fin de jeu choisi :" + nbChoice);
            switch (nbChoice) {
                case 1:
                    switch (nbGame) {
                        case 1:
                            launchGame.launchGame(IAPlayer, HumanPlayer, 1);
                            break;
                        case 2:
                            launchGame.launchGame(HumanPlayer, IAPlayer, 2);
                            break;
                        case 3:
                            launchGame.launchGame(IAPlayer, HumanPlayer, 3);
                            break;
                        default:
                            System.out.println("Mode inconnu");
                            break;
                    }
                    break;
                case 2:
                    this.runGame();
                    break;
                case 3:
                    System.out.println("Merci d'avoir joué, au revoir");
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi de modes parmi ceux proposés");
                    break;
            }
        } while (nbChoice < 1 || nbChoice > 3) ;
    }
}