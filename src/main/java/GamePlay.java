import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GamePlay {

    private static final Logger logger = LogManager.getLogger(GamePlay.class.getName());


    /**
     * start a new game depending on game mode, attacker and defender
     * @param defenseur
     * @param attaquant
     * @param nbGame
     */
    public void launchGame(Player defenseur, Player attaquant, int nbGame) {
        if (nbGame == 1 || nbGame == 2) {
            this.standardGamePlay(defenseur, attaquant, nbGame);
        } else {
            this.duelGamePlay(defenseur, attaquant, nbGame);
        }
        Gamechoice gameEndChoice = new Gamechoice();
        gameEndChoice.endGameChoice(nbGame);
    }

    public void standardGamePlay  (Player defenseur, Player attaquant, int nbGame){
        GameInfo gameInfo = defenseur.initGame(nbGame, 0 );
        int nbTryMax = gameInfo.getCombiSize()*2;
        int nbTry = gameInfo.getNbTry();
        do {
            attaquant.makeATry(gameInfo);
            defenseur.tellUpDownOk(gameInfo);
            String answer = gameInfo.getAnswer();
            System.out.println("La réponse du défenseur: "+ answer);
            nbTry ++;
            gameInfo.setNbTry(nbTry);
            if (gameInfo.getTentative().equals(gameInfo.getDefinedCombinaison())) {
                break;
            }
        } while (nbTry <= nbTryMax);

        if (gameInfo.getTentative().equals(gameInfo.getDefinedCombinaison())) {
            System.out.println("L'attaquant a gagné !");
            logger.info("Victoire de l'attaquant");
        } else {
            System.out.println("Le defenseur a gagné");
            logger.info("Victoire du défenseur");
        }
    }

    /**
     * GamePlay duel
     * @param joueur1
     * @param joueur2
     * @param nbGame
     */
    private void duelGamePlay(Player joueur1, Player joueur2, int nbGame) {
        // Le joueur2 défini sa combinaison
        GameInfo gameInfo = joueur2.initGame(nbGame,0 );
        int Combisize = gameInfo.getCombiSize();
        // Le joueur 1 défini sa combinasion (meme taille que le premier)
        GameInfo gameInfo2 = joueur1.initGame(nbGame,Combisize);
        int nbTryMax = gameInfo.getCombiSize()*2;
        int nbTry = gameInfo.getNbTry();
        do {
            // essai du joueur 1
            duelPlayFactor(joueur1, joueur2, gameInfo);
            if (gameInfo.getTentative().equals(gameInfo.getDefinedCombinaison()) ) {
                System.out.println("Le joueur 1 a gagné !");
                logger.info("Victoire joueur 1");
                break;
            }
            // essai du joueur 2
            duelPlayFactor( joueur2, joueur1, gameInfo2);
            if (gameInfo2.getTentative().equals(gameInfo2.getDefinedCombinaison()) ) {
                System.out.println("Le joueur 2 a gagné !");
                logger.info("Victoire joueur 2");
                break;
            }
            nbTry ++;
            gameInfo.setNbTry(nbTry);
            gameInfo2.setNbTry(nbTry);
        } while (nbTry <= nbTryMax);
        if (nbTry > nbTryMax) {
            System.out.println("Vous etes tous les deux mauvais ! Ce trésor restera caché !");
            logger.info("Match nul");
        }
    }

    private void duelPlayFactor(Player joueur1, Player joueur2 ,GameInfo gameInfo) {
        joueur1.makeATry(gameInfo);
        joueur2.tellUpDownOk(gameInfo);
        System.out.println("La réponse : "+ gameInfo.getAnswer());
    }


}
