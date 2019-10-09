public class GamePlay {
    public void launchGame(Player defenseur, Player attaquant, int nbGame) {
        switch (nbGame) {
            case 1:
                this.challengerGamePlay(defenseur, attaquant, nbGame);
                break;
            case 2:
                this.defenseurGamePlay(defenseur, attaquant, nbGame);
                break;
            case 3:
                this.duelGamePlay(defenseur, attaquant, nbGame);
                break;
            default:
                System.out.println("Impossible");
        }
        Gamechoice gameEndChoice = new Gamechoice();
        gameEndChoice.endGameChoice(nbGame);
    }

    public void challengerGamePlay (Player defenseur, Player attaquant, int nbGame) {
        String returnMakeATry [] = new String[3];
        int returnInitGame[] = defenseur.initGame(nbGame, 0);
        int nbTry = 1;

        do {
            returnMakeATry = attaquant.makeATry(returnInitGame[0], returnInitGame[1], returnInitGame[2], nbTry, "", "");
            defenseur.tellUpDownOk(returnMakeATry[0], returnMakeATry[1]);
            nbTry ++;
            if (returnMakeATry[0].equals(returnMakeATry[1]) == true) {
                break;
            }
        } while (Integer.parseInt(returnMakeATry[2]) <= Integer.parseInt(returnMakeATry[3]));
        if (returnMakeATry[0].equals(returnMakeATry[1]) == true) {
            System.out.println("Bravo, c'est gagné !");
        } else {
            System.out.println("Dsl, t'es mauvais Jack !");
        }
    }

    public void defenseurGamePlay (Player defenseur, Player attaquant, int nbGame) {
        GameMethode gameMethode = new GameMethode();
        String returnMakeATry [] = new String[3];
        int returnInitGame[] = defenseur.initGame(nbGame, 0);
        int nbTry = 1;
        String humanAnswer = "";
        String oldTentative = "";
        do {
            returnMakeATry = attaquant.makeATry(returnInitGame[0], returnInitGame[1], returnInitGame[2], nbTry, humanAnswer, oldTentative );
            String returnTellUpDOwnOk [] = defenseur.tellUpDownOk(returnMakeATry[0], returnMakeATry[1]);
            nbTry ++;
            humanAnswer = returnTellUpDOwnOk[0];
            oldTentative = returnTellUpDOwnOk[1];
            if (returnMakeATry[0].equals(returnMakeATry[1]) == true) {
                break;
            }
        } while (Integer.parseInt(returnMakeATry[2]) < Integer.parseInt(returnMakeATry[3]));
        if (returnMakeATry[0].equals(returnMakeATry[1]) == false) {
            System.out.println("Bravo, c'est gagné !");
        } else {
            System.out.println("Dsl, t'es mauvais Jack !");
        }
    }

    public void duelGamePlay (Player defenseur, Player attaquant, int nbGame) {
            String humanReturnMakeATry [] = new String[3];
            String IAReturnMakeATry [] = new String [3];
            int humanReturnInitGame [] = attaquant.initGame(nbGame, 0);
            int IAReturnInitGame[] = defenseur.initGame(nbGame, humanReturnInitGame[1]);
            int nbTry = 1;
            do {
                humanReturnMakeATry = attaquant.makeATry(IAReturnInitGame[0], IAReturnInitGame[1], IAReturnInitGame[2], nbTry, "", "");
                defenseur.tellUpDownOk(humanReturnMakeATry[0], humanReturnMakeATry[1]);
                IAReturnMakeATry = defenseur.makeATry(humanReturnInitGame[0], humanReturnInitGame[1], IAReturnInitGame[2], nbTry, "", "");
                attaquant.tellUpDownOk(IAReturnMakeATry[0],IAReturnMakeATry[1]);
                nbTry ++;
                if (humanReturnMakeATry[0].equals(humanReturnMakeATry[1]) == true || IAReturnMakeATry[0].equals(IAReturnMakeATry[1]) == true) {
                    break;
                }
            } while (Integer.parseInt(IAReturnMakeATry[2]) < Integer.parseInt(IAReturnMakeATry[3]));
            if (humanReturnMakeATry[0].equals(humanReturnMakeATry[1]) == true) {
                System.out.println("Bravo, c'est gagné !");
            } else if (IAReturnMakeATry[0].equals(IAReturnMakeATry[1]) == true) {
                System.out.println("Dsl, t'es mauvais Jack !");
            } else {
                System.out.println("Vous etes tous les deux mauvais ! Ce trésor restera caché !");
            }
    }
}
