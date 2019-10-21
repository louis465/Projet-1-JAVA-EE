package game;

import affichage.Affichage;
import affichage.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class GameMethode {
    private static final Logger logger = LogManager.getLogger(GameMethode.class.getName());
    static Scanner sc = new Scanner(System.in);

    /**
     * Téléchargement des données de config
     * @return config datas
     */
    public static ArrayList<String> loadConfigFile () {
        ArrayList<String> configData = new ArrayList<>();
        String defaultCombiSize = "";
        String defaultNbTry = "";
        String developermode = "";
        try (
                InputStream input = GameInfo.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                Affichage.affichage(Affichage.CONFIG_FILE_ERROR);
            }
            prop.load(input);
            defaultCombiSize = prop.getProperty("nbX");
            defaultNbTry = prop.getProperty("nbTry");
            developermode = prop.getProperty("developerMode");
        } catch (
                IOException ex) {
            ex.printStackTrace();
            logger.error(Log.logTexte(Log.LOG_ERROR.replace("#1", String.valueOf(ex))));
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
    public static String setRandomNumber(int min, int max) {
        Random ran = new Random();
        int x = ran.nextInt((max + 1 - min)) + min;
        return String.valueOf(x);
    }

    /**
     * Set a random combinaison of defined size
     * @param size
     * @return combi in String
     */
    public static String setRandomCombinaison(int size) {
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
    public static String comparingCombi(String tentative, String combinaison) {
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
    public static int scanAnInt() {
        int intToImplement = -1;
        do {
            try {
                intToImplement = sc.nextInt();
                logger.info (Log.logTexte(Log.USER_INPUT).replace("#1", String.valueOf(intToImplement)));
            } catch (InputMismatchException ime) {
                Affichage.affichage(Affichage.INT_INPUT_ERROR);
                sc.next();
                logger.error(Log.logTexte(Log.LOG_ERROR.replace("#1", String.valueOf(ime))));
            } catch (Exception e) {
                Affichage.affichage(Affichage.UNKNOW_ERROR);
                logger.error(Log.logTexte(Log.LOG_ERROR.replace("#1", String.valueOf(e))));
            }
        } while (intToImplement == -1);
        return intToImplement;
    }

    /**
     * Scan a String with exception gestion
     * @return
     */
    public static String scanAnString() {
        String StrToImplement = "";
        do {
            try {
                StrToImplement = sc.nextLine();
                logger.info (Log.logTexte(Log.USER_INPUT).replace("#1", StrToImplement));
            } catch (InputMismatchException ime) {
                Affichage.affichage(Affichage.STRING_INPUT_ERROR);
                sc.next();
                logger.error(Log.logTexte(Log.LOG_ERROR.replace("#1", String.valueOf(ime))));
            } catch (Exception e) {
                Affichage.affichage(Affichage.UNKNOW_ERROR);
                logger.error(Log.logTexte(Log.LOG_ERROR.replace("#1", String.valueOf(e))));
            }
        } while (StrToImplement.equals("") );
        return StrToImplement;

    }

    /**
     * Scan a String who can only be a number
     * @return
     */
    public static String scanAnStringWithOnlyNumber () {
        int intNumber = 0;
        String strNumber = "";
            do {
                try {
                    strNumber = sc.nextLine();
                    logger.info (Log.logTexte(Log.USER_INPUT).replace("#1", strNumber));
                    for (int i = 0; i <strNumber.length(); i++) {
                        if (!String.valueOf(strNumber.charAt(i)).matches("[0-9]+")) {
                            throw new BadCharException();
                        }
                    }
                } catch (Exception e) {
                    Affichage.affichage(Affichage.INT_INPUT_ERROR);
                    strNumber = "";
                    logger.error(Log.logTexte(Log.LOG_ERROR.replace("#1", String.valueOf(e))));
                }
            } while (strNumber.equals(""));
        return strNumber;
    }


    /**
     * set a new tentative from an answer ><=
     * @param gameInfo
     * @return newTentative
     */
   public static String newTentativeFromAnswer (GameInfo gameInfo) {
        String newTentative = "";
        String answer = gameInfo.getAnswer();
        String tentative = gameInfo.getTentative();
        for (int i = 0; i < answer.length(); i++) {
            if (String.valueOf(answer.charAt(i)).equals("=")) {
                newTentative += String.valueOf(tentative).charAt(i);
            } else if (String.valueOf(answer.charAt(i)).equals("+")) {
                gameInfo.getMinNumber().remove(i);
                gameInfo.getMinNumber().add(i,Integer.parseInt(String.valueOf(tentative.charAt(i))) + 1);
                newTentative += setRandomNumber(Integer.parseInt(String.valueOf(tentative.charAt(i))) + 1, gameInfo.getMaxNumber().get(i));
            } else {
                gameInfo.getMaxNumber().remove(i);
                gameInfo.getMaxNumber().add(i,Integer.parseInt(String.valueOf(tentative.charAt(i))) - 1 );
                newTentative += setRandomNumber(gameInfo.getMinNumber().get(i), Integer.parseInt(String.valueOf(tentative.charAt(i))) - 1);
            }
        }
        return newTentative;
    }
}

