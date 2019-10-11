import java.awt.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class GameMethode {
    static Scanner sc = new Scanner(System.in);

    /**
     * set a random number from a range
     * @param min
     * @param max
     * @return randomNumber
     */
    static String setRandomNumber(int min, int max) {
        Random ran = new Random();
        int x = ran.nextInt((max + 1 - min)) + min;
        return String.valueOf(x);
    }

    /**
     * Set a random combinaison of defined size
     * @param size
     * @return combi in String
     */
    static String setRandomCombinaison(int size) {
        String strCombi = "";
        for (int i = 0; i < size; i++) {
            String number = setRandomNumber(0, 9);
            strCombi += number;
        }
        return strCombi;
    }

    /**
     * Compare two combinaison with ><=
     * @param tentative
     * @param combinaison
     * @return answer
     */
    static String comparingCombi(String tentative, String combinaison) {
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
        return answer;
    }

    /**
     * Scan an int with exception gestion
     * @return
     */
    static int scanAnInt() {
        int intToImplement = -1;
        do {
            try {
                intToImplement = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez saisir un chiffre");
                sc.next();
            } catch (Exception e) {
                System.out.println("Erreur inconnue");
            }
        } while (intToImplement == -1);
        return intToImplement;
    }

    /**
     * Scan an String with exception gestion
     * @return
     */
    static String scanAnString() {
        String StrToImplement = "";
        do {
            try {
                StrToImplement = sc.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez saisir un chiffre");
                sc.next();
            } catch (Exception e) {
                System.out.println("Erreur inconnue");
            }
        } while (StrToImplement.equals("") );
        return StrToImplement;

    }

    static String scanAnStringWithOnlyNumber () {
        String strNumber = "";
        do {
            try {
                strNumber = sc.nextLine();
                int intNumber = Integer.parseInt(strNumber);
                } catch (NumberFormatException nfe) {
                    System.out.println("Veuillez saisir des chiffres");
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez saisir un chiffre");
                    sc.next();
                } catch (Exception e) {
                    System.out.println("Erreur inconnue");
                }
            } while (strNumber.equals("")) ;
            return strNumber;
        }

    /**
     * set a new tentative from an answer ><=
     * @param oldTentative
     * @param answer
     * @return newTentative
     */
    static String newTentativeFromAnswer (String oldTentative, String answer) {
        String newTentative = "";
        for (int i =0 ; i< answer.length(); i++) {
            if (String.valueOf(answer.charAt(i)).equals("=") ) {
                newTentative += String.valueOf(oldTentative).charAt(i);
            } else if (String.valueOf(answer.charAt(i)).equals("<") ) {
                newTentative += setRandomNumber(Integer.parseInt(String.valueOf(oldTentative.charAt(i)))+1, 9);
            } else  {
                newTentative += setRandomNumber(0, Integer.parseInt(String.valueOf(oldTentative.charAt(i)))- 1);
            }
        }
        return newTentative;
    }

    public static void resetGameInfo() {
    }
}

