import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class GameMethode {
    Scanner sc = new Scanner(System.in);

    static String setRandomNumber(int min, int max) {
        Random ran = new Random();
        int x = ran.nextInt((max + 1 - min)) + min;
        String y = String.valueOf(x);
        return y;
    }

    public String setRandomCombinaison(int size) {
        String strCombi = "";
        for (int i = 0; i < size; i++) {
            String number = this.setRandomNumber(1, 9);
            strCombi += number;
        }
        return strCombi;
    }

    public String comparingCombi(String tentative, String combinaison) {
        String answer = "";
        for (int i = 0; i < tentative.length(); i++) {
            int testedTentativeNumber = Integer.parseInt(String.valueOf(tentative.charAt(i)));
            int testedDefinedNumber = Integer.parseInt(String.valueOf(combinaison.charAt(i)));
            if (testedTentativeNumber < testedDefinedNumber) {
                answer += "<";
            } else if (testedTentativeNumber > testedDefinedNumber) {
                answer += ">";
            } else {
                answer += "=";
            }
        }
        System.out.println(answer);
        return answer;
    }

    public int scanAnInt() {
        int intToImplement = 0;
        do {
            try {
                intToImplement = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez saisir un chiffre");
                sc.next();
                continue;
            } catch (Exception e) {
                System.out.println("Erreur inconnue");
                continue;
            }
        } while (intToImplement == 0);
        return intToImplement;
    }

    public String scanAnString() {
        String StrToImplement = "";
        do {
            try {
                StrToImplement = sc.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez saisir un chiffre");
                sc.next();
                continue;
            } catch (Exception e) {
                System.out.println("Erreur inconnue");
                continue;
            }
        } while (StrToImplement.equals("") == true );
        return StrToImplement;
    }

    public String newTentativeFromAnswer (String tentative, String answer) {
        String newTentative = "";
        for (int i =0 ; i< answer.length(); i++) {
            if (String.valueOf(answer.charAt(i)).equals("=") ) {
                newTentative += String.valueOf(String.valueOf(tentative).charAt(i));
            } else if (String.valueOf(answer.charAt(i)).equals("<") ) {
                newTentative += this.setRandomNumber(Integer.parseInt(String.valueOf(String.valueOf(tentative).charAt(i)))+1, 9);
            } else  {
                newTentative += this.setRandomNumber(0, Integer.parseInt(String.valueOf(String.valueOf(tentative).charAt(i)))- 1);
            }
        }
        tentative = newTentative;
        return tentative;
    }
}

