package players;

import affichage.Affichage;
import affichage.Log;
import game.GameInfo;
import game.GameMethode;
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
            // télechargement des données de config
            ArrayList<String> configData =   GameMethode.loadConfigFile();
            Boolean developerMode = Boolean.getBoolean(configData.get(2));
            int nbmaxTry = Integer.parseInt(configData.get(1));

            // saisie de la combinaison
            Affichage.affichage(Affichage.SET_COMBISIZE);
            String definedCombinaison = GameMethode.scanAnStringWithOnlyNumber();
            logger.info(Log.logTexte(Log.SET_COMBINAISON.replace("#1", definedCombinaison)));
            combiSize = definedCombinaison.length();
            Affichage.affichage(Affichage.RESUME_SETCOMBINAISON.replace("#1", definedCombinaison).replace("#2", String.valueOf(nbmaxTry)));
            GameInfo gameInfo = new GameInfo(definedCombinaison, combiSize, developerMode, nbmaxTry);
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
            // Saisie des tentatives
            Affichage.affichage(Affichage.TENTATIVE_NUMBER.replace("#1", String.valueOf(nbTry)));
            do {
                tentative = GameMethode.scanAnStringWithOnlyNumber();
                logger.info(Log.logTexte(Log.LOG_TENTATIVE.replace("#1", String.valueOf(nbTry)).replace("#2", "du joueur").replace("#3", tentative)));
                if (tentative.length() != definedCombinaison.length()) {
                    Affichage.affichage(Affichage.MAKE_CORRECT_TRY);
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
            Affichage.affichage(Affichage.GIVE_AN_ANSWER);
            do {
                humananswer = GameMethode.scanAnString();
                logger.info(Log.logTexte(Log.LOG_ANSWER.replace("#1", "du joueur").replace("#2", humananswer)));
                if (humananswer.equals(answer) != true) {
                    Affichage.affichage(Affichage.GIVE_CORRECT_ANSWER);
                }
            } while (humananswer.equals(answer) != true);
            gameInfo.setAnswer(answer);
        }
    }
