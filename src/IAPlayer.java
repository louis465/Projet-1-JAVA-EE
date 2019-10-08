import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IAPlayer extends Player {
    Scanner sc = new Scanner(System.in);
    Config config = new Config();
    Gamechoice gameEndChoice = new Gamechoice();
    GameMethode gameMethode = new GameMethode();
    Player humanPlayer = new HumanPlayer();
    int combiSize = config.nbX;
    int nbmaxTry = config.nbTry;

    @Override
    public String initGame(int nbGame) {
        String definedCombinaison = "";
        System.out.println("Quel est la taille de la combinaison que vous souhaitez trouver ?  ");
        do {
            combiSize = gameMethode.scanAnInt();
        } while (combiSize <=1);
        definedCombinaison = gameMethode.setRandomCombinaison(combiSize);
        nbmaxTry = combiSize *2;
        System.out.println("Vous allez devoir trouver une combinaison de "+ combiSize +" chiffre en "+nbmaxTry+" essais");
        if ( config.developerMode ) {
            System.out.println(definedCombinaison);
        }
        humanPlayer.makeATry(definedCombinaison, combiSize, nbGame);
        return definedCombinaison;
    }

    @Override
    public String makeATry(String definedCombinaison, int combiSize, int nbGame) {
        int nbTry = 1;
        int nbTryMax= combiSize*2;
        System.out.println("Tentative de l'ordinateur n°" + nbTry + " :");
        String tentative = gameMethode.setRandomCombinaison(combiSize);
        System.out.println(tentative);
        do {
            String humanAnswer = humanPlayer.tellUpDownOk(tentative, definedCombinaison);
            System.out.println(humanAnswer);
            nbTry ++;
            System.out.println("Tentative n°" + nbTry + " :");
            String newTentative = gameMethode.newTentativeFromAnswer(tentative, humanAnswer);
            tentative = newTentative;
            System.out.println(tentative);
            if (tentative.equals(definedCombinaison) == true) {
                break; }
        } while (nbTry < nbTryMax );
        if (tentative.equals(definedCombinaison) == true) {
            System.out.println("Dsl, t'es mauvais Jack !");
        } else {
            System.out.println("C'est gagné ! L'ordinateur n'a pas trouvé la combinaison");
        }
        gameEndChoice.endGameChoice(nbGame);
        return definedCombinaison;
    }

    @Override
    public String tellUpDownOk( String tentative, String definedCombinaison) {
        return gameMethode.comparingCombi(tentative, definedCombinaison);
    }

}