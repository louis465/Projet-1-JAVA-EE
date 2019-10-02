public class Startgameduel {
    Config config =new Config ();

    public void displayRulesDuel () {
        System.out.println("Voici les régles du mode Duel:");
        System.out.println("1- L'ordinateur et toi allez devoir choisir une combinaison de "+config.nbX+" chiffres.");
        System.out.println("2- Tour à tour, vous allez tenter de deviner la combinaison de l'autre en "+config.nbTry+" essais maximum.");
        System.out.println("3- Aprés chaque tentative, tu devras indiquer à l'ordinateur pour chaque chiffre si il est =, > ou < au bon chiffre. Il fera de meme.");
        System.out.println("Que le meilleur gagne ! Bon jeu !");
        this.gamePlayDuel();
    }

    public void gamePlayDuel() {
        System.out.println("C'est parti !");
    }
}
