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

    @Override
    public String [] makeATry(int intDefinedCombinaison, int combiSize, int nbGame, int nbTry, String answer, String tentative ) {
        int nbTryMax= combiSize*2;
        String definedCombinaison = String.valueOf(intDefinedCombinaison);
        System.out.println("Tentative de l'ordinateur n°" + nbTry + " :");
        if (answer.equals("") == true) {
            tentative = gameMethode.setRandomCombinaison(definedCombinaison.length());
            System.out.println(tentative);
        } else {
            String newTentative = gameMethode.newTentativeFromAnswer(tentative, answer);
            tentative = newTentative;
            System.out.println(tentative);
        }
            String strNbTry = String.valueOf(nbTry);
            String strNbTryMax = String.valueOf((nbTryMax));
            String ForTellUpDownOk [] = {tentative,definedCombinaison, strNbTry, strNbTryMax };
            return ForTellUpDownOk;
        }


    @Override
    public String [] tellUpDownOk( String tentative, String definedCombinaison) {
        String answer = gameMethode.comparingCombi(tentative, definedCombinaison);
        System.out.println("La réponse de l'ordianteur: "+ answer);
        String returnTellUpDownOk [] = {answer, tentative};
        return returnTellUpDownOk;
    }

}