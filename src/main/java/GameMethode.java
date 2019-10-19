import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

class GameMethode {
    private static final Logger logger = LogManager.getLogger(GameMethode.class.getName());
    static Scanner sc = new Scanner(System.in);

    /**
     * Téléchargement des données de config
     * @return config datas
     */
    static ArrayList<String> loadConfigFile () {
        ArrayList<String> configData = new ArrayList<>();
        String defaultCombiSize = "";
        String defaultNbTry = "";
        String developermode = "";
        try (
                InputStream input = GameInfo.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            prop.load(input);
            defaultCombiSize = prop.getProperty("nbX");
            defaultNbTry = prop.getProperty("nbTry");
            developermode = prop.getProperty("developerMode");
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
        configData.add(defaultCombiSize);
        configData.add(defaultNbTry);
        configData.add(developermode);
        return configData;
    }
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
     * Compare two combinaison with -+=
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
                answer += "+";
            } else if (testedTentativeNumber > testedDefinedNumber) {
                answer += "-";
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
                logger.info ("Saisie utilisateur :" + intToImplement);
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez saisir un chiffre");
                sc.next();
                logger.error("Erreur :" + ime);
            } catch (Exception e) {
                System.out.println("Erreur inconnue");
                logger.error("Erreur :" + e);
            }
        } while (intToImplement == -1);
        return intToImplement;
    }

    /**
     * Scan a String with exception gestion
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
                logger.error("Erreur :" + ime);
            } catch (Exception e) {
                System.out.println("Erreur inconnue");
            }
        } while (StrToImplement.equals("") );
        return StrToImplement;

    }

    /**
     * Scan a String who can only be a number
     * @return
     */
    static String scanAnStringWithOnlyNumber () {
        int intNumber = 0;
        String strNumber = "";
            do {
                try {
                    strNumber = sc.nextLine();
                    for (int i = 0; i <strNumber.length(); i++) {
                        if (!String.valueOf(strNumber.charAt(i)).matches("[0-9]+")) {
                            throw new BadCharException();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Veuillez saisir des chiffres");
                    strNumber = "";
                    logger.error("Erreur :" + e);
                }
            } while (strNumber.equals(""));
        return strNumber;
    }


    /**
     * set a new tentative from an answer ><=
     * @param gameInfo
     * @return newTentative
     */
    static String newTentativeFromAnswer (GameInfo gameInfo) {
        String newTentative = "";
        String answer = gameInfo.getAnswer();
        String tentative = gameInfo.getTentative();
        for (int i = 0; i < answer.length(); i++) {
            if (String.valueOf(answer.charAt(i)).equals("=")) {
                newTentative += String.valueOf(tentative).charAt(i);
            } else if (String.valueOf(answer.charAt(i)).equals("+")) {
                gameInfo.minNumber.remove(i);
                gameInfo.minNumber.add(i,Integer.parseInt(String.valueOf(tentative.charAt(i))) + 1);
                newTentative += setRandomNumber(Integer.parseInt(String.valueOf(tentative.charAt(i))) + 1, gameInfo.maxNumber.get(i));
            } else {
                gameInfo.maxNumber.remove(i);
                gameInfo.maxNumber.add(i,Integer.parseInt(String.valueOf(tentative.charAt(i))) - 1 );
                newTentative += setRandomNumber(gameInfo.minNumber.get(i), Integer.parseInt(String.valueOf(tentative.charAt(i))) - 1);
            }
        }
        return newTentative;
    }
}

