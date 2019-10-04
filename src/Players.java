import java.util.InputMismatchException;
import java.util.Scanner;

public class Players {
    Scanner sc = new Scanner(System.in);
    abstract class player {
        public abstract int initGame ();
        public abstract void makeATry ();
        public abstract void tellUpDownOk (int combinaison);
    }

    class humanPlayer extends player {
        int combinaison = 0;
        int humanTry = 0;
        String upDownok = "";
        @Override
        public int initGame() {
            System.out.println("Veuillez saisir la combinaison que l'ordinateur devra trouver :");
            do {
                try {
                    combinaison = sc.nextInt();
                } catch (InputMismatchException ime) {
                    System.out.println("Veuillez saisir un chiffre");
                    sc.next();
                } catch (Exception e) {
                    System.out.println("Erreur inconnu");
                    continue;
                }
            } while (combinaison <=0);
            System.out.println("La combinaison définie est "+combinaison+". Au tour de l'ordinateur !");
            return combinaison;
        }
        @Override
        public void makeATry() {

        }

        @Override
        public void tellUpDownOk(int combinaison) {

        }
    }
    class IAPlayer extends player {
        int combiSize = 0;
        double combinaisonInit;
        int combinaison = 0;
        int humanTry = 0;
        String upDownok = "";
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
            return combinaison;
        }

        @Override
        public void makeATry() {

        }

        @Override
        public void tellUpDownOk( int combinaison) {

        }
    }
}
