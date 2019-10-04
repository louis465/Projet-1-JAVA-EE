import java.util.InputMismatchException;
import java.util.Scanner;

    public class HumanPlayer extends Player {
        Scanner sc = new Scanner(System.in);
        Player IAPlayer = new IAPlayer();
        int definedCombinaison = 0;
        String upDownok = "";
        @Override
        public int initGame() {
            System.out.println("Veuillez saisir la combinaison que l'ordinateur devra trouver :");
            do {
                try {
                    definedCombinaison = sc.nextInt();
                } catch (InputMismatchException ime) {
                    System.out.println("Veuillez saisir un chiffre");
                    sc.next();
                } catch (Exception e) {
                    System.out.println("Erreur inconnu");
                    continue;
                }
            } while (definedCombinaison <=0);
            System.out.println("La combinaison définie est "+definedCombinaison+". Au tour de l'ordinateur !");
            return definedCombinaison;
        }
        @Override
        public int makeATry(int combinaison) {
                int nbTry = 1;
                int tentative = 0;
                do {
                    System.out.println("Tentative n°" + nbTry + " :");
                    try {
                        tentative = sc.nextInt();
                    } catch (InputMismatchException ime) {
                        System.out.println("Veuillez saisir un chiffre");
                        sc.next();
                    } catch (Exception e) {
                        System.out.println("Erreur inconnu");
                        continue;
                    }
                    Player IAPlayer = new IAPlayer();
                    IAPlayer.tellUpDownOk(tentative);
                    nbTry ++;
                } while (String.valueOf(tentative).length() < String.valueOf(combinaison).length() || tentative == combinaison)
                        ;
                if (String.valueOf(tentative).length() == String.valueOf(combinaison).length()) {
                    System.out.println("Dsl, t'es mauvais Jack ! ");
                } else {
                    System.out.println("Bravo, c'est gagné !");
                }
            return combinaison;
            }


        @Override
        public void tellUpDownOk(int tentative) {

        }
    }
