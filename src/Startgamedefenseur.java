
public class Startgamedefenseur {

    Config config =new Config ();

    public void displayRulesDefenseur () {
        System.out.println("Voici les régles du mode Defenseur: %n");
        System.out.println("1- Tu vas devoir choisir une combinaison de "+config.nbX+" chiffres. %n");
        System.out.println("2- L'ordinateur va tenter de deviner cette combinaison en "+config.nbTry+" essais. %n");
        System.out.println("3- Aprés chaque tentative, tu devras indiquer à l'ordinateur pour chaque chiffre si il est =, > ou < au bon chiffre. %n");
        System.out.println("Si l'ordinateur ne trouve pas la solution le magot est à toi ! Si non, c'est la ruine.. Bon jeu ! %n");
        this.gamePlayDefenseur();
    }

    public void gamePlayDefenseur() {
        initGameByPlayer(config.nbX);
        startGameIA(config.nbTry);
    }
}
