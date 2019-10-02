public class Startgameduel {
    Config config =new Config ();

    public void displayRulesDuel () {
        System.out.println("Voici les régles du mode Duel: %n");
        System.out.println("1- L'ordinateur et toi allez devoir choisir une combinaison de "+config.nbX+" chiffres. %n");
        System.out.println("2- Tour à tour, vous allez tenter de deviner la combinaison de l'autre en "+config.nbTry+" essais maximum. %n");
        System.out.println("3- Aprés chaque tentative, tu devras indiquer à l'ordinateur pour chaque chiffre si il est =, > ou < au bon chiffre. Il fera de meme. %n");
        System.out.println("Que le meilleur gagne ! Bon jeu ! %n");
        this.gamePlayDuel();
    }

    public void gamePlayDuel() {
        initGameByPlayer(config.nbX);
        startGameIA(config.nbTry);
    }
}
