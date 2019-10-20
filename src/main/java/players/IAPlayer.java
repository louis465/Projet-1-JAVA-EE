package players;

import affichage.Affichage;
import game.GameInfo;
import game.GameMethode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class IAPlayer extends Player {
    private static final Logger logger = LogManager.getLogger(HumanPlayer.class.getName());
    public static final String LOG_COMBISIZE = "Définition de la taille de combinaison souhaité : #1";
    Scanner sc = new Scanner(System.in);

    /**
     * Make IA set a new combinaison
     * @param nbGame
     * @return parametresMakeATry [] = {intDefinedComibinaison,combiSize,nbGame};
     */
    @Override
    public GameInfo initGame(int nbGame, int combiSize) {
        ArrayList<String> configData =   GameMethode.loadConfigFile();
        int defaultcombiSize = Integer.parseInt(configData.get(0));
        int defaultNbMaxTry = Integer.parseInt(configData.get(1));
        Boolean developerMode = Boolean.getBoolean(configData.get(2));
        int nbmaxTry =0;
        // Cas classique , l'humain défini la taille de la combinaison.
        // Dans l'autre cas on est en mode duel et la taille de la combinaison (définie préalablement par l'autre joueur) est en parametre
        if (nbGame == 1 || nbGame ==2) {
            Affichage.affichage(Affichage.INIT_COMBISIZE);
            do {
                combiSize = GameMethode.scanAnInt();
                logger.info(LOG_COMBISIZE.replace("#1", String.valueOf(combiSize)));
            } while (combiSize <= 1);
        }
        nbmaxTry = defaultNbMaxTry;
        String definedCombinaison = GameMethode.setRandomCombinaison(combiSize);
        logger.info("Combinaison définie par l'IA : " + definedCombinaison );
        System.out.println("Vous allez devoir trouver une combinaison de "+ combiSize +" chiffre en "+nbmaxTry+" essais");
        if ( developerMode ) {
            System.out.println(definedCombinaison);
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
        System.out.println("Tentative de l'ordinateur n°" + nbTry + " :");
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
            System.out.println(tentative);
            logger.info("Tentative de l'IA : " + tentative );
            // Les tentatives suivantes, basées sur la réponse de l'autre joueur
        } else {
            System.out.println(gameInfo.getMinNumber());
            System.out.println(gameInfo.getMaxNumber());
            String newTentative = GameMethode.newTentativeFromAnswer(gameInfo);
            gameInfo.setTentative(newTentative);
            System.out.println(newTentative);
            logger.info("Tentative de l'IA : " + newTentative );
        }
        }

    /**
     * Make IA give answer -+= from a combinaison
     */
    @Override
    public void tellUpDownOk(GameInfo gameInfo) {
        String answer = GameMethode.comparingCombi(gameInfo.getTentative(), gameInfo.getDefinedCombinaison());
        logger.info("Réponse de l'IA : " + answer);
        gameInfo.setAnswer(answer);
    }

}