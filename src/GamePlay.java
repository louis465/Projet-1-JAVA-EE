public class GamePlay {

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
        GameInfo gameInfo = new GameInfo ("", 0, nbGame);
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
        } else {
            System.out.println("Le defenseur a gagné");
        }
    }

    /**
     * GamePlay duel
     * @param joueur1
     * @param joueur1
     * @param nbGame
     */
    public void duelGamePlay (Player joueur1, Player joueur2, int nbGame) {
        String tentativeJ1= "";
        String answerJ1 = "";
        String tentativeJ2 = "";
        String answerJ2 = "";

        // Le joueur2 défini sa combinaison
        GameInfo gameInfo = joueur2.initGame(nbGame,0 );
        String definedCombinaison = gameInfo.getDefinedCombinaison();
        int Combisize = gameInfo.getCombiSize();

        // Le joueur 1 défini sa combinasion (meme taille que le premier)
        gameInfo = joueur1.initGame(nbGame,Combisize);
        String definedCombinaison2 = gameInfo.getDefinedCombinaison();

        int nbTryMax = gameInfo.getCombiSize()*2;
        int nbTry = gameInfo.getNbTry();
        do {
            // essai du joueur 1
            gameInfo.setDefinedCombinaison(definedCombinaison);
            gameInfo.setAnswer(answerJ2);
            gameInfo.setTentative(tentativeJ1);
            joueur1.makeATry(gameInfo);
            joueur2.tellUpDownOk(gameInfo);
            System.out.println("La réponse : "+ gameInfo.getAnswer());
            tentativeJ1 = gameInfo.getTentative();
            answerJ2 = gameInfo.getAnswer();
            if (gameInfo.getTentative().equals(gameInfo.getDefinedCombinaison()) ) {
                System.out.println("Le joueur 1 a gagné !");
                break;
            }

            // essai du joueur 2
            gameInfo.setDefinedCombinaison(definedCombinaison2);
            gameInfo.setAnswer(answerJ1);
            gameInfo.setTentative(tentativeJ2);
            joueur2.makeATry(gameInfo);
            joueur1.tellUpDownOk(gameInfo);
            System.out.println("La réponse : "+ gameInfo.getAnswer());
            tentativeJ2 = gameInfo.getTentative();
            answerJ1 = gameInfo.getAnswer();
            if (gameInfo.getTentative().equals(gameInfo.getDefinedCombinaison()) ) {
                System.out.println("Le joueur 2 a gagné !");
                break;
            }

            nbTry ++;
            gameInfo.setNbTry(nbTry);

        } while (nbTry <= nbTryMax);
        if (nbTry > nbTryMax) {
            System.out.println("Vous etes tous les deux mauvais ! Ce trésor restera caché !");
        }
    }
}
