package players;

import affichage.Affichage;
import affichage.Log;
import game.GameInfo;
import game.GameMethode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class IAPlayer extends Player {
    private static final Logger logger = LogManager.getLogger(HumanPlayer.class.getName());
    Scanner sc = new Scanner(System.in);

    /**
     * Make IA set a new combinaison
     * @param nbGame
     * @return parametresMakeATry [] = {intDefinedComibinaison,combiSize,nbGame};
     */
    @Override
    public GameInfo initGame(int nbGame, int combiSize) {
        ArrayList<String> configData =   GameMethode.loadConfigFile();
        int defaultCombiSize = Integer.parseInt(configData.get(0));
        int nbmaxTry = Integer.parseInt(configData.get(1));
        Boolean developerMode = Boolean.valueOf(configData.get(2));
        // Cas classique , l'humain défini la taille de la combinaison.
        // Dans l'autre cas on est en mode duel et la taille de la combinaison (définie préalablement par l'autre joueur) est en parametre
        if (nbGame == 1 || nbGame ==2) {
            Affichage.affichage(Affichage.INIT_COMBISIZE);
            do {
                combiSize = GameMethode.scanAnInt();
                logger.info(Log.logTexte(Log.LOG_COMBISIZE.replace("#1", String.valueOf(combiSize))));
            } while (combiSize < 0);
            if (combiSize == 0) {
                combiSize = defaultCombiSize;
            }
        }
        String definedCombinaison = GameMethode.setRandomCombinaison(combiSize);
        logger.info(Log.logTexte(Log.SET_COMBINAISON).replace("#1", definedCombinaison));
        Affichage.affichage(Affichage.RESUME_GAMEPLAY.replace("#1", String.valueOf(combiSize)).replace("#2", String.valueOf(nbmaxTry)));
        if ( developerMode ) {
            Affichage.affichage(Affichage.EMPTY_TEXTE.replace("#1", definedCombinaison));
        }
        GameInfo gameInfo = new GameInfo(definedCombinaison, combiSize, developerMode, nbmaxTry);
        gameInfo.setDefinedCombinaison(definedCombinaison);
        return gameInfo;
    }

    /**
     * Make IA make a try according to humananswer. First it set a new random combinaison

     */
    @Override
    public void makeATry(GameInfo gameInfo) {
        String definedCombinaison = gameInfo.getDefinedCombinaison();
        int nbTry = gameInfo.getNbTry();
        Affichage.affichage(Affichage.TENTATIVE_NUMBER.replace("#1", String.valueOf(nbTry)));
        // cas du premier essai.
        // Je défini mes minNumber et maxNumber à 0 et 9
        if (gameInfo.getAnswer()== null || gameInfo.getAnswer().equals("")) {
            ArrayList<Integer> minNumber = new ArrayList<>(gameInfo.getCombiSize());
            ArrayList<Integer> maxNumber = new ArrayList<>(gameInfo.getCombiSize());
            for (int i =0; i<gameInfo.getCombiSize(); i++) {
                minNumber.add(0);
                maxNumber.add(9);
            }
            gameInfo.setMinNumber(minNumber);
            gameInfo.setMaxNumber(maxNumber);
            String tentative = GameMethode.setRandomCombinaison(definedCombinaison.length());
            gameInfo.setTentative(tentative);
            Affichage.affichage(Affichage.EMPTY_TEXTE.replace("#1", tentative));
            logger.info(Log.logTexte(Log.LOG_TENTATIVE.replace("#1", String.valueOf(nbTry)).replace("#2", "de l'IA").replace("#3", tentative)));
            // Les tentatives suivantes, basées sur la réponse de l'autre joueur
        } else {
            String newTentative = GameMethode.newTentativeFromAnswer(gameInfo);
            gameInfo.setTentative(newTentative);
            Affichage.affichage(Affichage.EMPTY_TEXTE.replace("#1", newTentative));
            logger.info(Log.logTexte(Log.LOG_TENTATIVE.replace("#1", String.valueOf(nbTry)).replace("#2", "de l'IA").replace("#3", newTentative)));
        }
        }

    /**
     * Make IA give answer -+= from a combinaison
     */
    @Override
    public void tellUpDownOk(GameInfo gameInfo) {
        String answer = GameMethode.comparingCombi(gameInfo.getTentative(), gameInfo.getDefinedCombinaison());
        logger.info(Log.logTexte(Log.LOG_ANSWER.replace("#1", "de l'IA").replace("#2", answer)));
        gameInfo.setAnswer(answer);
    }

}