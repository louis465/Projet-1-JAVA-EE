package game;

import affichage.Affichage;
import affichage.Log;
import affichage.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import players.HumanPlayer;
import players.IAPlayer;
import players.Player;

import java.util.Scanner;

public class Gamechoice {
    private static final Logger logger = LogManager.getLogger(Gamechoice.class.getName());
    Scanner sc = new Scanner(System.in);

    /**
     * Run asking process for a Game mode.
     * @return gameMode selected
     */
    public void runGame() {
        GamePlay gamePlay = new GamePlay();
        Player IAPlayer = new IAPlayer();
        Player HumanPlayer = new HumanPlayer();
        int nbGame = 0;
        do {
            Menu.displayAvailableGame();
            nbGame = GameMethode.scanAnInt();
            logger.info(Log.logTexte(Log.START_MENU_CHOICE.replace("#1", String.valueOf(nbGame))));
            switch (nbGame) {
                case 1:
                    Menu.challengerRules();
                    gamePlay.launchGame(IAPlayer, HumanPlayer, nbGame);
                    break;
                case 2:
                    Menu.defenseurRules();
                    gamePlay.launchGame(HumanPlayer, IAPlayer, nbGame);
                    break;
                case 3:
                    Menu.duelRules();
                    gamePlay.launchGame(IAPlayer, HumanPlayer, nbGame);
                    break;
                case 4:
                    Affichage.affichage(Affichage.GOODBYE);
                    break;
                default:
                    Affichage.affichage(Affichage.MODE_CHOICE_ERROR);
                    break;
            }
        } while (nbGame < 1 || nbGame > 4);
    }

    /**
     * rue asking process for end game choice
     * @param nbGame
     */
    public void endGameChoice (int nbGame) {
        GamePlay gamePlay = new GamePlay();
        Player IAPlayer = new IAPlayer();
        Player HumanPlayer = new HumanPlayer();
        int nbChoice = 0;
        do {
            Menu.displayEndGameChoice();
            nbChoice = GameMethode.scanAnInt();
            logger.info(Log.logTexte(Log.END_MENU_CHOICE.replace("#1", String.valueOf(nbChoice))));
            switch (nbChoice) {
                case 1:
                    switch (nbGame) {
                        case 1:
                            gamePlay.launchGame(IAPlayer, HumanPlayer, 1);
                            break;
                        case 2:
                            gamePlay.launchGame(HumanPlayer, IAPlayer, 2);
                            break;
                        case 3:
                            gamePlay.launchGame(IAPlayer, HumanPlayer, 3);
                            break;
                    }
                    break;
                case 2:
                    this.runGame();
                    break;
                case 3:
                    Affichage.affichage(Affichage.GOODBYE);
                    break;
                default:
                    Affichage.affichage(Affichage.MODE_CHOICE_ERROR);
                    break;
            }
        } while (nbChoice < 1 || nbChoice > 3) ;
    }
}