import java.util.Scanner;

    public class HumanPlayer extends Player {
        Scanner sc = new Scanner(System.in);
        Config config = new Config();
        GameMethode gameMethode = new GameMethode();
        int combiSize = config.nbX;
        int nbmaxTry = config.nbTry;

        /**
         * make human player set a combinaison
         * @param nbGame
         * @param combiSize
         * @return parametres [] = {intDefinedCombinaison,combiSize,nbGame};
         */
        @Override
        public GameInfo initGame(int nbGame, int combiSize) {
            Player IAPlayer = new IAPlayer();
            String definedCombinaison ="";
            System.out.println("Veuillez saisir la combinaison que l'ordinateur devra trouver :");
            definedCombinaison = gameMethode.scanAnString();
            this.combiSize = definedCombinaison.length();
            nbmaxTry = this.combiSize *2;
            System.out.println("La combinaison définie est "+definedCombinaison+". Au tour de l'ordinateur qui aura " +nbmaxTry+ " essais!");
            GameInfo gameInfo = new GameInfo(definedCombinaison, this.combiSize,nbGame);
            return gameInfo;
        }

        /**
         * Make human player try a combinaison
         */
        @Override
        public void makeATry(GameInfo gameInfo) {
            String tentative = "";
            int nbTry =gameInfo.getNbTry();
            String definedCombinaison = gameInfo.getDefinedCombinaison();
            System.out.println("Votre tentative n°" + nbTry + " :");
            do {
                tentative = gameMethode.scanAnString();
                if (tentative.length() != definedCombinaison.length()) {
                    System.out.println("Veuillez saisir une combinaison avec le bon nombre de chiffre");
                }
            } while (tentative.length() != definedCombinaison.length());
            gameInfo.setTentative(tentative);
            }

        /**
         * Make human player give an answer to IA combinaison

         */
        @Override
        public void tellUpDownOk(GameInfo gameInfo) {
            String answer = gameMethode.comparingCombi(gameInfo.getTentative(), gameInfo.getDefinedCombinaison());
            String humananswer = "";
            System.out.println("A votre tour (+-=):");
            do {
                humananswer = gameMethode.scanAnString();
                if (humananswer.equals(answer) != true) {
                    System.out.println("Hum, êtes-vous sûr de votre réponse ? ");
                }
            } while (humananswer.equals(answer) != true);
            gameInfo.setAnswer(answer);
        }
    }
