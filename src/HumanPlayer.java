import java.util.InputMismatchException;
import java.util.Scanner;

    public class HumanPlayer extends Player {
        Scanner sc = new Scanner(System.in);
        int definedCombinaison = 0;
        String upDownok = "";
        @Override
        public int initGame() {
            Player IAPlayer = new IAPlayer();
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
            int combiSize = String.valueOf(definedCombinaison).length();
            System.out.println(combiSize);
            System.out.println("La combinaison définie est "+definedCombinaison+". Au tour de l'ordinateur !");
            IAPlayer.makeATry(definedCombinaison,combiSize);
            return definedCombinaison;
        }
        @Override
        public int makeATry(int definedcombinaison, int combiSize) {
                Player IAPlayer = new IAPlayer();
                int nbTry = 1;
                int tentative = 0;
                int nbTryMax = combiSize*2;
                do {
                    System.out.println(nbTryMax);
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
                    IAPlayer.tellUpDownOk(tentative);
                    nbTry ++;
                    // faire une deuxiéme bouvle pour le controle de la saisie :
                    // String.valueOf(tentative).length() < String.valueOf(definedcombinaison).length()
                } while ( nbTry >= nbTryMax || tentative != definedcombinaison)
                        ;
                if (tentative == definedcombinaison) {
                    System.out.println("Bravo, c'est gagné !");
                } else {
                    System.out.println("Dsl, t'es mauvais Jack !");
                }
            return definedcombinaison;
            }


        @Override
        public void tellUpDownOk(int tentative) {
            System.out.println("Human Méthode tellupdownok");
        }
    }
