import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IAPlayer extends Player {
    Scanner sc = new Scanner(System.in);
    Player humanPlayer = new HumanPlayer();
    int combiSize = 4;
    int nbmaxTry = 8;
    double combinaisonInit;
    int definedCombinaison = 0;
    int humanTry = 0;
    @Override
    public int initGame(int nbGame) {
        System.out.println("Quel est la taille de la combinaison que vous souhaitez trouver ?  ");
        do {
            try {
                combiSize = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez saisir un chiffre");
                sc.next();
                continue;
            } catch (Exception e) {
                System.out.println("Erreur inconnu");
                continue;
            }
        } while (combiSize <=1);
        do {
            combinaisonInit = Math.random() * (Math.pow(10, combiSize));
            definedCombinaison = (int) combinaisonInit;
        } while (String.valueOf(definedCombinaison).length() != combiSize);
        nbmaxTry = combiSize *2;
        System.out.println("Vous allez devoir trouver une combinaison de "+ combiSize +" chiffre en "+nbmaxTry+" essais");
        System.out.println(definedCombinaison);
        humanPlayer.makeATry(definedCombinaison, combiSize, nbGame);
        return definedCombinaison;
    }

    @Override
    public int makeATry(int definedCombinaison, int combiSize, int nbGame) {
        int nbTry = 1;
        int tentative = 0;
        double tentativeInit;
        String answer = "";
            System.out.println("Tentative de l'ordinateur n°" + nbTry + " :");
        do {
            tentativeInit = Math.random() * (Math.pow(10, combiSize));
            tentative = (int) tentativeInit;
        } while (String.valueOf(tentative).length() != combiSize);
            System.out.println(tentative);
            humanPlayer.tellUpDownOk(tentative, definedCombinaison);
            nbTry ++;

        GameEndChoice gameEndChoice = new GameEndChoice();
        gameEndChoice.endGameChoice(nbGame);
        return definedCombinaison;
    }

    @Override
    public String tellUpDownOk( int tentative, int definedCombinaison) {
        String answer = "";
        String strTentative = String.valueOf(tentative);
        String strDefinedCombinaison = String.valueOf(definedCombinaison);
        for (int i = 0 ; i < strTentative.length(); i++) {
            int testedTentativeNumber = Integer.parseInt(String.valueOf(strTentative.charAt(i)));
            int testedDefinedNumber = Integer.parseInt(String.valueOf(strDefinedCombinaison.charAt(i)));
            if (testedTentativeNumber<testedDefinedNumber) {
                answer += "<";
            } else if (testedTentativeNumber>testedDefinedNumber) {
                answer +=">";
            } else {
                answer += "=";
            }
        }
        System.out.println(answer);
    return answer;
    }

}