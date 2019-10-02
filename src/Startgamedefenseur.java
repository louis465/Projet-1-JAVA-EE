
public class Startgamedefenseur {

    Config config =new Config ();

    void displayRulesDefenseur() {
        System.out.println("Voici les régles du mode Defenseur:");
        System.out.println("1- Tu vas devoir choisir une combinaison de "+config.nbX+" chiffres.");
        System.out.println("2- L'ordinateur va tenter de deviner cette combinaison en "+config.nbTry+" essais.");
        System.out.println("3- Aprés chaque tentative, tu devras indiquer à l'ordinateur pour chaque chiffre si il est =, > ou < au bon chiffre.");
        System.out.println("Si l'ordinateur ne trouve pas la solution le magot est à toi ! Si non, c'est la ruine.. Bon jeu !");
        this.gamePlayDefenseur();
    }

    private void gamePlayDefenseur() {
        System.out.println("C'est parti !");
    }
}
