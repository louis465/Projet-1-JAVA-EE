import java.util.InputMismatchException;
import java.util.Scanner;

public class IAPlayer extends Player {
    Scanner sc = new Scanner(System.in);
    int combiSize = 4;
    int nbmaxTry = combiSize*2;
    double combinaisonInit;
    int combinaison = 0;
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
        combinaison = (int)combinaisonInit;
        System.out.println("Vous allez devoir trouver une combinaison de "+combiSize+" en "+nbmaxTry+" essais");
        return combinaison;
    }

    @Override
    public void makeATry() {

    }

    @Override
    public void tellUpDownOk( int combinaison) {

    }
}