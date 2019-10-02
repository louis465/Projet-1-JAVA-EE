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
    }




    /**
     * Run asking process for a Game.
     * @return gameMode selected
     */
    String runGame() {
        int nbGame = 0;
        String gameMode = new String("");
        do {
            this.displayAvailableGame();
            try {
                nbGame = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez saisir un chiffre");
                sc.next();
                continue;
            } catch (Exception e) {
                System.out.println("Erreur inconnu");
            }
            switch (nbGame) {
                case 1:
                    gameMode = ("challenger");
                    System.out.println("Vous avez choisi le mode: " + gameMode);
                    Startgamechallengeur newChall = new Startgamechallengeur();
                    newChall.displayRulesChallenger();
                    break;
                case 2:
                    gameMode = ("defenseur");
                    System.out.println("Vous avez choisi le mode: " + gameMode);
                    Startgamedefenseur newDef = new Startgamedefenseur();
                    newDef.displayRulesDefenseur();
                    break;
                case 3:
                    gameMode = ("duel");
                    System.out.println("Vous avez choisi le mode: " + gameMode);
                    Startgameduel newduel = new Startgameduel();
                    newduel.displayRulesDuel();
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