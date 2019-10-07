public abstract class Player {
    public abstract int initGame (int nbGame);
    public abstract int makeATry (int combinaison, int combiSize, int nbGame);
    public abstract String tellUpDownOk (int tentative, int definedCombinaison);
}