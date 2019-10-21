package game;

import affichage.Affichage;
import affichage.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import players.Player;

public class GamePlay {

    private static final Logger logger = LogManager.getLogger(GamePlay.class.getName());


    /**
     * start a new game depending on game mode, attacker and defender
     * @param defenseur
     * @param attaquant
     * @param nbGame
     */
    public void launchGame(Player defenseur, Player attaquant, int nbGame) {
        // lancement du game.GamePlay standard
        if (nbGame == 1 || nbGame == 2) {
            this.standardGamePlay(defenseur, attaquant, nbGame);
       // lancement du game.GamePlay Duel
        } else {
            this.duelGamePlay(defenseur, attaquant, nbGame);
        }
        Gamechoice gameEndChoice = new Gamechoice();
        gameEndChoice.endGameChoice(nbGame);
    }

    public void standardGamePlay  (Player defenseur, Player attaquant, int nbGame){
        // Le defenseur initie sa combinaison
        GameInfo gameInfo = defenseur.initGame(nbGame, 0 );
        int nbTryMax = gameInfo.getNbMaxTry();
        int nbTry = gameInfo.getNbTry();

        // L'attaquant fait ses essais et le défenseur lui répond par =+-
        do {
            attaquant.makeATry(gameInfo);
            defenseur.tellUpDownOk(gameInfo);
            Affichage.affichage(Affichage.ANSWER_IS.replace("#2", gameInfo.getAnswer()));
            nbTry ++;
            gameInfo.setNbTry(nbTry);
            if (gameInfo.getTentative().equals(gameInfo.getDefinedCombinaison())) {
                break;
            }
        } while (nbTry <= nbTryMax);

        if (gameInfo.getTentative().equals(gameInfo.getDefinedCombinaison())) {
            Affichage.affichage(Affichage.VICTORY_FOR.replace("#2","L'attaquant"));
            logger.info(Log.logTexte(Log.VICTORY_FOR.replace("#1", "L'attaquant")));
        } else {
            Affichage.affichage(Affichage.VICTORY_FOR.replace("#2","Le defenseur"));
            logger.info(Log.logTexte(Log.VICTORY_FOR.replace("#1", "Le défenseur")));
        }
    }

    /**
     * game.GamePlay duel
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
        int nbTryMax = gameInfo.getNbMaxTry();
        int nbTry = gameInfo.getNbTry();
        do {
            // essai du joueur 1
            duelPlayFactor(joueur1, joueur2, gameInfo);
            if (gameInfo.getTentative().equals(gameInfo.getDefinedCombinaison()) ) {
                Affichage.affichage(Affichage.VICTORY_FOR.replace("#2","le joueur 1"));
                logger.info(Log.logTexte(Log.VICTORY_FOR.replace("#1", "le joueur 1")));
                break;
            }
            // essai du joueur 2
            duelPlayFactor( joueur2, joueur1, gameInfo2);
            if (gameInfo2.getTentative().equals(gameInfo2.getDefinedCombinaison()) ) {
                Affichage.affichage(Affichage.VICTORY_FOR.replace("#2","le joueur 2"));
                logger.info(Log.logTexte(Log.VICTORY_FOR.replace("#1", "le joueur 2")));
                break;
            }
            nbTry ++;
            gameInfo.setNbTry(nbTry);
            gameInfo2.setNbTry(nbTry);
        } while (nbTry <= nbTryMax);
        if (nbTry > nbTryMax) {
            Affichage.affichage(Affichage.VICTORY_FOR.replace("#2","Personne n'"));
            logger.info(Log.logTexte(Log.VICTORY_FOR.replace("#1", "aucun des deux joueurs")));
        }
    }

    private void duelPlayFactor(Player joueur1, Player joueur2 ,GameInfo gameInfo) {
        joueur1.makeATry(gameInfo);
        joueur2.tellUpDownOk(gameInfo);
        Affichage.affichage(Affichage.ANSWER_IS.replace("#2", gameInfo.getAnswer()));
    }


}
