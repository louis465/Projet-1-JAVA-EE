import java.util.ArrayList;

// classe servant a stocker les données de jeu et à y acceder ou à les modifier au besoin
public class GameInfo {
    private String definedCombinaison;
    private int combiSize;
    private String answer;
    private String tentative;
    private int nbTry = 1;
    ArrayList<Integer> minNumber;
    ArrayList<Integer> maxNumber;
    private Boolean developerMode ;
    private int nbMaxTry;

    GameInfo(String definedCombinaison, int combiSize, boolean developerMode, int nbMaxTry) {
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


