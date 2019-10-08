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
        public String initGame(int nbGame) {
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
            IAPlayer.makeATry(definedCombinaison,combiSize, nbGame);
            return definedCombinaison;
        }
        @Override
        public String makeATry(String definedCombinaison, int combiSize, int nbGame) {
                Player IAPlayer = new IAPlayer();
                int nbTry = 1;
                int nbTryMax = combiSize*2;
                int tentative = 0;
                    do {
                        do {
                            System.out.println("Tentative n°" + nbTry + " :");
                            tentative = gameMethode.scanAnInt();
                            if (String.valueOf(tentative).length() != definedCombinaison.length()) {
                                System.out.println("Veuillez saisir une combinaison avec le bon nombre de chiffre");
                            }
                        } while (String.valueOf(tentative).length() != definedCombinaison.length());
                        nbTry++;
                        IAPlayer.tellUpDownOk(String.valueOf(tentative), definedCombinaison);
                        if (String.valueOf(tentative).equals(definedCombinaison) == true) {
                            break;
                        }
                    } while (nbTry <= nbTryMax );
                if (String.valueOf(tentative).equals(definedCombinaison) == true) {
                    System.out.println("Bravo, c'est gagné !");
                } else {
                    System.out.println("Dsl, t'es mauvais Jack !");
                }
                Gamechoice gameEndChoice = new Gamechoice();
                gameEndChoice.endGameChoice(nbGame);
            return definedCombinaison;
            }


        @Override
        public String tellUpDownOk(String tentative, String definedCombinaison) {
            String answer = gameMethode.comparingCombi(tentative, definedCombinaison);
            String humananswer = "";
            System.out.println("A votre tour (+-=):");
            do {
                humananswer = gameMethode.scanAnString();
                if (humananswer.equals(answer) != true) {
                    System.out.println("Hum, êtes-vous sûr de votre réponse ? ");
                }
            } while (humananswer.equals(answer) != true);
            return humananswer;
        }
    }
