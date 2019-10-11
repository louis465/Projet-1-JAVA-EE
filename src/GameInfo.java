public class GameInfo {
    private String definedCombinaison;
    private int combiSize;
    private int nbGame;
    private String answer;
    private String tentative;
    private int nbTry = 1;

    public GameInfo(String definedCombinaison ,int combiSize, int nbGame) {
        this.definedCombinaison= definedCombinaison;
        this.combiSize = combiSize;
        this.nbGame = nbGame;
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

    public void setCombiSize(int combiSize) {
        this.combiSize = combiSize;
    }

    public int getNbGame() {
        return nbGame;
    }

    public void setNbGame(int nbGame) {
        this.nbGame = nbGame;
    }
}
