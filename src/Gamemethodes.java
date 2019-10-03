import java.util.InputMismatchException;
import java.util.Scanner;

public class Gamemethodes  {
    Config config =new Config ();
    Scanner sc = new Scanner(System.in);
    int nbX = config.nbX;
    Gamemodechoice gamemodechoice = new Gamemodechoice();

    public void initGameByIA () {

    }

    public void initGameByPlayer() {

    }

    public void startGameIA () {

    }

    public void startGamePlayer () {

    }
    public void displayEndGameChoice () {
        System.out.println("La partie est terminée ! Que souhaitez-vous faire ? :");
        System.out.println("1- Rejouer au meme mode");
        System.out.println("2- Jouer à un autre mode.");
        System.out.println(("3- Quitter le jeu"));
        System.out.println("");
    }

    public void endGameChoice (int gameMode) {
        int nbChoice = 0;
        do {
            this.displayEndGameChoice();
            try {
                nbChoice = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez saisir un chiffre");
                sc.next();
                continue;
            } catch (Exception e) {
                System.out.println("Erreur inconnu");
            }
            switch (nbChoice) {
                case 1:
                    switch (gameMode) {
                        case 1:

                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        default:
                            System.out.println("Mode inconnu");
                            break;
                    }
                    break;
                case 2:
                    Gamemodechoice gamemodechoice = new Gamemodechoice();
                    gamemodechoice.runGame();
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
