import java.util.InputMismatchException;
import java.util.Scanner;

public class IAPlayer extends Player {
    Scanner sc = new Scanner(System.in);
    Player humanPlayer = new HumanPlayer();
    int combiSize = 4;
    int nbmaxTry = combiSize*2;
    double combinaisonInit;
    int definedCombinaison = 0;
    int humanTry = 0;
    @Override
    public int initGame() {
        System.out.println("Quel est la taille de la combinaison que vous souhaitez trouver ?  ");
        do {
            try {
                combiSize = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez saisir un chiffre");
                sc.next();
            } catch (Exception e) {
                System.out.println("Erreur inconnu");
                continue;
            }
        } while (combiSize <=1);
        combinaisonInit = Math.random()*(10^combiSize);
        definedCombinaison = (int)combinaisonInit;
        System.out.println("Vous allez devoir trouver une combinaison de "+combiSize+" en "+nbmaxTry+" essais");
        return definedCombinaison;
    }

    @Override
    public int makeATry(int combinaison) {
        int nbTry = 1;
        int tentative = 0;
        int humanCombiSize = String.valueOf(tentative).length();
        String answer = "";
            System.out.println("Tentative de l'ordinateur n°" + nbTry + " :");
            double tentativeinit = Math.random()*(10^humanCombiSize);
            tentative = (int)tentativeinit;
            System.out.println(tentative);
            humanPlayer.tellUpDownOk(tentative);
            answer = sc.nextLine();
            nbTry ++;
            do {
                    String stringTentative = String.valueOf(tentative);
                    String newTentative = "";
                    int chiffre = 0;
                    for (int i = 0; i<answer.length(); i++) {
                        String symbole = String.valueOf(answer.charAt(i));
                        switch (symbole){
                            case "=":
                                newTentative += String.valueOf(stringTentative.charAt(i))   ;
                                break;
                            case ">":
                            Integer.valueOf(String.valueOf(stringTentative.charAt(i)));
                        }
                    }


            } while (String.valueOf(tentative).length() < String.valueOf(combinaison).length() || tentative == combinaison);


        return combinaison;
    }

    @Override
    public void tellUpDownOk( int combinaison) {

    }
}