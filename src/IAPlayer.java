import java.util.Scanner;

public class IAPlayer extends Player {
    Scanner sc = new Scanner(System.in);
    Config config = new Config();
    Gamechoice gameEndChoice = new Gamechoice();
    GameMethode gameMethode = new GameMethode();
    Player humanPlayer = new HumanPlayer();

    /**
     * Make IA set a new combinaison
     * @param nbGame
     * @return parametresMakeATry [] = {intDefinedComibinaison,combiSize,nbGame};
     */
    @Override
    public GameInfo initGame(int nbGame, int combiSize) {
        String definedCombinaison = "";
        if (nbGame == 1 || nbGame ==2) {
            System.out.println("Quel est la taille de la combinaison que vous souhaitez trouver ?  ");
            do {
                combiSize = gameMethode.scanAnInt();
            } while (combiSize <= 1);
        } else if (nbGame == 3 ) {
            combiSize = combiSize;
        }
        definedCombinaison = GameMethode.setRandomCombinaison(combiSize);
        int nbmaxTry = combiSize *2;
        System.out.println("Vous allez devoir trouver une combinaison de "+ combiSize +" chiffre en "+nbmaxTry+" essais");
        if ( config.developerMode ) {
            System.out.println(definedCombinaison);
        }
        GameInfo gameInfo = new GameInfo(definedCombinaison, combiSize,nbGame);
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
            String tentative = gameMethode.setRandomCombinaison(definedCombinaison.length());
            gameInfo.setTentative(tentative);
            System.out.println(tentative);
        } else {
            String newTentative = gameMethode.newTentativeFromAnswer(gameInfo.getTentative(), gameInfo.getAnswer());
            gameInfo.setTentative(newTentative);
            System.out.println(newTentative);
        }
        }

    /**
     * Make IA give answer ><= from a combinaison
     */
    @Override
    public void tellUpDownOk(GameInfo gameInfo) {
        String answer = gameMethode.comparingCombi(gameInfo.getTentative(), gameInfo.getDefinedCombinaison());
        gameInfo.setAnswer(answer);
    }

}