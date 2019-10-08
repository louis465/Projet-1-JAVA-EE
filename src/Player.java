public abstract class Player {
    public abstract String initGame (int nbGame);
    public abstract String makeATry (String combinaison, int combiSize, int nbGame);
    public abstract String tellUpDownOk (String tentative, String definedCombinaison);
}