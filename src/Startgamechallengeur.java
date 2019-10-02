
public class Startgamechallengeur {
    Config config =new Config ();

    void displayRulesChallenger() {
        System.out.println("Voici les régles du mode Challenger:");
        System.out.println("1- L'ordinateur va choisir une combinaison de "+config.nbX+" chiffres.");
        System.out.println("2- Tu vas devoir tenter de deviner cette combinaison en "+config.nbTry+" essais.");
        System.out.println("3- Aprés chaque tentative, l'ordinateur te dira pour chaque chiffre si il est =, > ou < au bon chiffre");
        System.out.println("Attention si tu ne trouves pas la solution le coffre s'autodétruira ! Bon jeu !");
        this.gamePlayChallenger();
    }

    private void gamePlayChallenger() {
        Gamemethodes gamemethodes = new Gamemethodes();
        int gameMode=1;
        System.out.println("C'est parti !");
        gamemethodes.endGameChoice(gameMode);
    }

}
