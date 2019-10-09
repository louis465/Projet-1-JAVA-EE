public class GamePlay {
    public void launchGame(Player defenseur, Player attaquant, int nbGame) {
        if (nbGame == 1 || nbGame == 2) {
            String returnMakeATry [] = new String [4];
            int forMakeATry[] = defenseur.initGame(nbGame);
            attaquant.makeATry(forMakeATry[0], forMakeATry[1], forMakeATry[2]);
            do {
                System.out.println("Tentative n°" + Integer.parseInt(returnMakeATry[2]) + " :");
                String returnMakeATry2 [] = attaquant.makeATry(forMakeATry[0], forMakeATry[1], forMakeATry[2]);
                returnMakeATry = returnMakeATry2;
                defenseur.tellUpDownOk(returnMakeATry[0], returnMakeATry[1]);
                if (returnMakeATry[0].equals(returnMakeATry[1]) == true) {
                    break;
                }
            } while (Integer.parseInt(returnMakeATry[2]) <= Integer.parseInt(returnMakeATry[3]));
            if (returnMakeATry[0].equals(returnMakeATry[1]) == true) {
                System.out.println("Bravo, c'est gagné !");
            } else {
                System.out.println("Dsl, t'es mauvais Jack !");
            }
            Gamechoice gameEndChoice = new Gamechoice();
            gameEndChoice.endGameChoice(nbGame);
        }
    }
}
