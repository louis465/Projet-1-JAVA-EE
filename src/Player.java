public abstract class Player {
    public abstract int[] initGame (int nbGame, int combiSize);
    public abstract String [] makeATry (int definedCombinaison, int combiSize, int nbGame, int nbTry, String answer, String oldTentative);
    public abstract String [] tellUpDownOk (String tentative, String definedCombinaison);
}