import java.util.InputMismatchException;
import java.util.Scanner;

    public class HumanPlayer extends Player {
        Scanner sc = new Scanner(System.in);
        int definedCombinaison = 0;
        String upDownok = "";
        @Override
        public int initGame(int nbGame) {
            Player IAPlayer = new IAPlayer();
            System.out.println("Veuillez saisir la combinaison que l'ordinateur devra trouver :");
            do {
                try {
                    definedCombinaison = sc.nextInt();
                } catch (InputMismatchException ime) {
                    System.out.println("Veuillez saisir un chiffre");
                    sc.next();
                } catch (Exception e) {
                    System.out.println("Erreur inconnu");
                    continue;
                }
            } while (definedCombinaison <=0);
            int combiSize = String.valueOf(definedCombinaison).length();
            System.out.println(combiSize);
            System.out.println("La combinaison définie est "+definedCombinaison+". Au tour de l'ordinateur !");
            System.out.println(definedCombinaison);
            IAPlayer.makeATry(definedCombinaison,combiSize, nbGame);
            return definedCombinaison;
        }
        @Override
        public int makeATry(int definedCombinaison, int combiSize, int nbGame) {
                Player IAPlayer = new IAPlayer();
                int nbTry = 1;
                int tentative = 0;
                int nbTryMax = combiSize*2;
                    do {
                        do {
                            System.out.println("Tentative n°" + nbTry + " :");
                            try {
                                tentative = sc.nextInt();
                            } catch (InputMismatchException ime) {
                                System.out.println("Veuillez saisir un chiffre");
                                sc.next();
                                continue;
                            } catch (Exception e) {
                                System.out.println("Erreur inconnu");
                                sc.next();
                                continue;
                            }
                            if (String.valueOf(tentative).length() != String.valueOf(definedCombinaison).length()) {
                                System.out.println("Veuillez saisir une combinaison valide");
                            }
                        } while (String.valueOf(tentative).length() != String.valueOf(definedCombinaison).length());
                        nbTry++;
                        IAPlayer.tellUpDownOk(tentative, definedCombinaison);
                        if (tentative == definedCombinaison) {
                            break;
                        }
                    } while (nbTry <= nbTryMax );
                if (tentative == definedCombinaison) {
                    System.out.println("Bravo, c'est gagné !");
                } else {
                    System.out.println("Dsl, t'es mauvais Jack !");
                }
                GameEndChoice gameEndChoice = new GameEndChoice();
                gameEndChoice.endGameChoice(nbGame);
            return definedCombinaison;
            }


        @Override
        public String tellUpDownOk(int tentative, int definedCombinaison) {
            String answer = "";
            String strTentative = String.valueOf(tentative);
            String strDefinedCombinaison = String.valueOf(definedCombinaison);
            for (int i = 0 ; i < strTentative.length(); i++) {
                int testedTentativeNumber = Integer.parseInt(String.valueOf(strTentative.charAt(i)));
                int testedDefinedNumber = Integer.parseInt(String.valueOf(strDefinedCombinaison.charAt(i)));
                if (testedTentativeNumber<testedDefinedNumber) {
                    answer += "<";
                } else if (testedTentativeNumber>testedDefinedNumber) {
                    answer +=">";
                } else {
                    answer += "=";
                }
            }
            System.out.println(answer);
            System.out.println("A votre tour (+-=):");
            String humananswer = "";
            do {
                try {
                    answer = sc.nextLine();
                } catch (InputMismatchException ime) {
                    System.out.println("Veuillez saisir les bons symboles");
                    sc.nextLine();
                    continue;
                } catch (Exception e) {
                    System.out.println("Erreur inconnue");
                    continue;
                }
                if (humananswer.compareTo(answer) != 0) {
                    System.out.println("Hum, êtes-vous sûr de votre réponse ? ");
                }
            } while (humananswer.compareTo(answer) != 0);
            return humananswer;
        }
    }
