/**
 * set Players behaviors
 */
public abstract class Player {
    public abstract GameInfo initGame(int nbGame, int combiSize);
    public abstract void  makeATry (GameInfo gameInfo);
    public abstract void tellUpDownOk (GameInfo gameInfo);
}

// paramétres makeatry : int definedCombinaison, int combiSize, int nbGame, int nbTry, String answer, String oldTentative
// paramétres tellupdownok : String tentative, String definedCombinaison