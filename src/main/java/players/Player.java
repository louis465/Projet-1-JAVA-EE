package players;

import game.GameInfo;

/**
 * set Players behaviors
 */
public abstract class Player {
    public abstract GameInfo initGame(int nbGame, int combiSize);
    public abstract void  makeATry (GameInfo gameInfo);
    public abstract void tellUpDownOk (GameInfo gameInfo);
}
