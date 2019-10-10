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

    /**
     * Make IA set a new combinaison
     * @param nbGame
     * @param combiSize
     * @return parametresMakeATry [] = {intDefinedComibinaison,combiSize,nbGame};
     */
    @Override
    public int [] initGame(int nbGame, int combiSize) {
        String definedCombinaison = "";
        if (nbGame == 1 || nbGame ==2) {
            System.out.println("Quel est la taille de la combinaison que vous souhaitez trouver ?  ");
            do {
                combiSize = gameMethode.scanAnInt();
            } while (combiSize <= 1);
        } else if (nbGame == 3 ) {
            combiSize = combiSize;
        }
        definedCombinaison = gameMethode.setRandomCombinaison(combiSize);
        nbmaxTry = combiSize *2;
        System.out.println("Vous allez devoir trouver une combinaison de "+ combiSize +" chiffre en "+nbmaxTry+" essais");
        if ( config.developerMode ) {
            System.out.println(definedCombinaison);
        }
        int intDefinedComibinaison = Integer.parseInt(definedCombinaison);
        int parametresMakeATry [] = {intDefinedComibinaison,combiSize,nbGame};
        return parametresMakeATry;
    }

    /**
     * Make IA make a try according to humananswer. First it set a new random combinaison
     * @param intDefinedCombinaison
     * @param combiSize
     * @param nbGame
     * @param nbTry
     * @param answer ==> answer from other player
     * @param oldTentative ==> old tentative
     * @return ForTellUpDownOk [] = {oldTentative,definedCombinaison, strNbTry, strNbTryMax };
     */
    @Override
    public String [] makeATry(int intDefinedCombinaison, int combiSize, int nbGame, int nbTry, String answer, String oldTentative ) {
        int nbTryMax= combiSize*2;
        String definedCombinaison = String.valueOf(intDefinedCombinaison);
        System.out.println("Tentative de l'ordinateur n°" + nbTry + " :");
        if (answer.equals("") == true) {
            oldTentative = gameMethode.setRandomCombinaison(definedCombinaison.length());
            System.out.println(oldTentative);
        } else {
            String newTentative = gameMethode.newTentativeFromAnswer(oldTentative, answer);
            oldTentative = newTentative;
            System.out.println(oldTentative);
        }
            String strNbTry = String.valueOf(nbTry);
            String strNbTryMax = String.valueOf((nbTryMax));
            String ForTellUpDownOk [] = {oldTentative,definedCombinaison, strNbTry, strNbTryMax };
            return ForTellUpDownOk;
        }

    /**
     * Make IA give answer ><= from a combinaison
     * @param tentative
     * @param definedCombinaison
     * @return returnTellUpDownOk [] = {answer, tentative};
     */
    @Override
    public String [] tellUpDownOk( String tentative, String definedCombinaison) {
        String answer = gameMethode.comparingCombi(tentative, definedCombinaison);
        System.out.println("La réponse de l'ordianteur: "+ answer);
        String returnTellUpDownOk [] = {answer, tentative};
        return returnTellUpDownOk;
    }

}