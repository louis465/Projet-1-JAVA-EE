public abstract class Player {
    public abstract int[] initGame (int nbGame);
    public abstract String [] makeATry (int definedCombinaison, int combiSize, int nbGame);
    public abstract String tellUpDownOk (String tentative, String definedCombinaison);
}