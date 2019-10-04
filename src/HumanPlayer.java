import java.util.InputMismatchException;
import java.util.Scanner;

    public class HumanPlayer extends Player {
        Scanner sc = new Scanner(System.in);
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
            do {
                int nbTry = 1;
                int tentative = 0;
                System.out.println("Tentative n°" + nbTry + " :");
                do {
                    try {
                        tentative = sc.nextInt();
                    } catch (InputMismatchException ime) {
                        System.out.println("Veuillez saisir un chiffre");
                        sc.next();
                    } catch (Exception e) {
                        System.out.println("Erreur inconnu");
                        continue;
                    }
                } while (String.valueOf(tentative).length() < String.valueOf(combinaison).length() || tentative == combinaison)
                        ;
            }
        }

        @Override
        public void tellUpDownOk(int combinaison) {

        }
    }
