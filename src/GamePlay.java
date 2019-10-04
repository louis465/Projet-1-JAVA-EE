public class GamePlay {
    public void launchGame (Player player, Player player1) {
        player.initGame();
        player1.makeATry(player.initGame());
    }
}
