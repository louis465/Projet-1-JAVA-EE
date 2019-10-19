import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class IAPlayer extends Player {
    private static final Logger logger = LogManager.getLogger(HumanPlayer.class.getName());
    Scanner sc = new Scanner(System.in);
    Config config = new Config();

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
        if (nbGame == 1 || nbGame ==2) {
            System.out.println("Quel est la taille de la combinaison que vous souhaitez trouver ?  ");
            do {
                combiSize = GameMethode.scanAnInt();
                logger.info("Définition de la taille de combinaison souhaité : " + combiSize);
            } while (combiSize <= 1);
        }
        nbmaxTry = combiSize *2;
        String definedCombinaison = GameMethode.setRandomCombinaison(combiSize);
        logger.info("Combinaison définie par l'IA : " + definedCombinaison );
        System.out.println("Vous allez devoir trouver une combinaison de "+ combiSize +" chiffre en "+nbmaxTry+" essais");
        if ( developerMode ) {
            System.out.println(definedCombinaison);
        }
        GameInfo gameInfo = new GameInfo(definedCombinaison, combiSize,nbGame, developerMode, nbmaxTry);
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
     * Make IA give answer ><= from a combinaison
     */
    @Override
    public void tellUpDownOk(GameInfo gameInfo) {
        String answer = GameMethode.comparingCombi(gameInfo.getTentative(), gameInfo.getDefinedCombinaison());
        logger.info("Réponse de l'IA : " + answer);
        gameInfo.setAnswer(answer);
    }

}