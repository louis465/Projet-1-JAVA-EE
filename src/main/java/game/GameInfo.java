package game;

import java.util.ArrayList;

// classe servant a stocker les données de jeu et à y acceder ou à les modifier au besoin
public class GameInfo {
    private String definedCombinaison;
    private int combiSize;
    private String answer;
    private String tentative;
    private int nbTry = 1;
    private ArrayList<Integer> minNumber;
    private ArrayList<Integer> maxNumber;
    private Boolean developerMode ;
    private int nbMaxTry;

    public GameInfo(String definedCombinaison, int combiSize, boolean developerMode, int nbMaxTry) {
        this.definedCombinaison = definedCombinaison;
        this.combiSize = combiSize;
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

    public void setCombiSize(int combiSize) {
        this.combiSize = combiSize;
    }

    public Boolean getDeveloperMode() {
        return developerMode;
    }

    public void setDeveloperMode(Boolean developerMode) {
        this.developerMode = developerMode;
    }

    public String getDefinedCombinaison() {
        return definedCombinaison;
    }

    public void setDefinedCombinaison(String definedCombinaison) {
        this.definedCombinaison = definedCombinaison;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTentative() {
        return tentative;
    }

    public void setTentative(String tentative) {
        this.tentative = tentative;
    }

    public int getNbTry() {
        return nbTry;
    }

    public void setNbTry(int nbTry) {
        this.nbTry = nbTry;
    }


    public int getCombiSize() {
        return combiSize;
    }
}


