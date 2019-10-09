import java.util.InputMismatchException;
import java.util.Scanner;

    public class HumanPlayer extends Player {
        Scanner sc = new Scanner(System.in);
        Config config = new Config();
        GameMethode gameMethode = new GameMethode();
        String definedCombinaison = "";
        int combiSize = config.nbX;
        int nbmaxTry = config.nbTry;

        @Override
        public int[] initGame(int nbGame, int combiSize) {
            Player IAPlayer = new IAPlayer();
            int intDefinedCombinaison =0;
            System.out.println("Veuillez saisir la combinaison que l'ordinateur devra trouver :");
            do {
                intDefinedCombinaison = gameMethode.scanAnInt();
                definedCombinaison = String.valueOf(intDefinedCombinaison);
            } while (intDefinedCombinaison <= 0);
            combiSize = definedCombinaison.length();
            nbmaxTry = combiSize*2;
            System.out.println("La combinaison définie est "+definedCombinaison+". Au tour de l'ordinateur qui aura " +nbmaxTry+ " essais!");
            int parametres [] = {intDefinedCombinaison,combiSize,nbGame};
            return parametres;
        }
        @Override
        public String [] makeATry(int intDefinedCombinaison, int combiSize, int nbGame, int nbTry, String answer, String oldTentative) {
            Player IAPlayer = new IAPlayer();
            int nbTryMax = combiSize*2;
            int tentative = 0;
            definedCombinaison = String.valueOf(intDefinedCombinaison);
            System.out.println("Votre tentative n°" + nbTry + " :");
            do {
                tentative = gameMethode.scanAnInt();
                if (String.valueOf(tentative).length() != definedCombinaison.length()) {
                    System.out.println("Veuillez saisir une combinaison avec le bon nombre de chiffre");
                }
            } while (String.valueOf(tentative).length() != definedCombinaison.length());
            nbTry++;
            String strNbTry = String.valueOf(nbTry);
            String strNbTryMax = String.valueOf((nbTryMax));
            String ForTellUpDownOk [] = {String.valueOf(tentative),definedCombinaison, strNbTry, strNbTryMax };
        return ForTellUpDownOk;
            }


        @Override
        public String [] tellUpDownOk(String tentative, String definedCombinaison) {
            String answer = gameMethode.comparingCombi(tentative, definedCombinaison);
            String humananswer = "";
            System.out.println("A votre tour (+-=):");
            do {
                humananswer = gameMethode.scanAnString();
                if (humananswer.equals(answer) != true) {
                    System.out.println("Hum, êtes-vous sûr de votre réponse ? ");
                }
            } while (humananswer.equals(answer) != true);
            String returnTellUpDownOk [] = {humananswer, tentative};
            return returnTellUpDownOk;
        }
    }
