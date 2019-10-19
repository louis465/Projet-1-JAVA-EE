import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

// classe servant a stocker les données de jeu et à y acceder ou à les modifier au besoin
public class GameInfo {
    private static final Logger logger = LogManager.getLogger(GameMethode.class.getName());
    private String definedCombinaison;
    private int combiSize;
    private int nbGame;
    private String answer;
    private String tentative;
    private int nbTry = 1;
    public ArrayList<Integer> minNumber;
    public ArrayList<Integer> maxNumber;
    private Boolean developerMode ;
    private int nbMaxTry;

    GameInfo(String definedCombinaison, int combiSize, int nbGame, boolean developerMode, int nbMaxTry) {
        this.definedCombinaison = definedCombinaison;
        this.combiSize = combiSize;
        this.nbGame = nbGame;
        this.developerMode = developerMode;
        this.nbMaxTry = nbMaxTry;
    }


    public ArrayList<Integer> getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(ArrayList<Integer> minNumber) {
        this.minNumber = minNumber;
    }

    public ArrayList<Integer> getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(ArrayList<Integer> maxNumber) {
        this.maxNumber = maxNumber;
    }

    void setCombiSize(int combiSize) {
        this.combiSize = combiSize;
    }

    Boolean getDeveloperMode() {
        return developerMode;
    }

    void setDeveloperMode(Boolean developerMode) {
        this.developerMode = developerMode;
    }

    String getDefinedCombinaison() {
        return definedCombinaison;
    }

    void setDefinedCombinaison(String definedCombinaison) {
        this.definedCombinaison = definedCombinaison;
    }


    String getAnswer() {
        return answer;
    }

    void setAnswer(String answer) {
        this.answer = answer;
    }

    String getTentative() {
        return tentative;
    }

    void setTentative(String tentative) {
        this.tentative = tentative;
    }

    int getNbTry() {
        return nbTry;
    }

    void setNbTry(int nbTry) {
        this.nbTry = nbTry;
    }


    int getCombiSize() {
        return combiSize;
    }
}


