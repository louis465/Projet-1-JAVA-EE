import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

    public class HumanPlayer extends Player {
        private static final Logger logger = LogManager.getLogger(HumanPlayer.class.getName());
        Scanner sc = new Scanner(System.in);

        /**
         * make human player set a combinaison
         * @param nbGame
         * @param combiSize
         * @return parametres [] = {intDefinedCombinaison,combiSize,nbGame};
         */
        @Override
        public GameInfo initGame(int nbGame, int combiSize) {
            ArrayList<String> configData =   GameMethode.loadConfigFile();
            Boolean developerMode = Boolean.getBoolean(configData.get(2));
            System.out.println("Veuillez saisir la combinaison que l'ordinateur devra trouver :");
            String definedCombinaison = GameMethode.scanAnStringWithOnlyNumber();
            logger.info("Combinaison définie : " + definedCombinaison);
            combiSize = definedCombinaison.length();
            int nbmaxTry = combiSize*2;
            System.out.println("La combinaison définie est "+definedCombinaison+". Au tour de l'ordinateur qui aura " +nbmaxTry+ " essais!");
            GameInfo gameInfo = new GameInfo(definedCombinaison, combiSize,nbGame, developerMode, nbmaxTry);
            return gameInfo;
        }

        /**
         * Make human player try a combinaison
         */
        @Override
        public void makeATry(GameInfo gameInfo) {
            String tentative = "";
            int nbTry =gameInfo.getNbTry();
            String definedCombinaison = gameInfo.getDefinedCombinaison();
            System.out.println("Votre tentative n°" + nbTry + " :");
            do {
                tentative = GameMethode.scanAnStringWithOnlyNumber();
                logger.info("Tentative n°" +nbTry+" du joueur :"+tentative);
                if (tentative.length() != definedCombinaison.length()) {
                    System.out.println("Veuillez saisir une combinaison avec le bon nombre de chiffre");
                }
            } while (tentative.length() != definedCombinaison.length());
            gameInfo.setTentative(tentative);
            }

        /**
         * Make human player give an answer to IA combinaison

         */
        @Override
        public void tellUpDownOk(GameInfo gameInfo) {
            String answer = GameMethode.comparingCombi(gameInfo.getTentative(), gameInfo.getDefinedCombinaison());
            System.out.println(answer);
            String humananswer = "";
            System.out.println("A votre tour (+-=):");
            do {
                humananswer = GameMethode.scanAnString();
                logger.info("Réponse du joueur: " + humananswer );
                if (humananswer.equals(answer) != true) {
                    System.out.println("Hum, êtes-vous sûr de votre réponse ? ");
                }
            } while (humananswer.equals(answer) != true);
            gameInfo.setAnswer(answer);
        }
    }
