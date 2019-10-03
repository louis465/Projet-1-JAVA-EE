public class Players {

    abstract class player {
        public abstract void initGame ();
        public abstract void makeATry ();
        public abstract void tellUpDownOk ();
    }

    class humanPlayer extends player {
        @Override
        public void initGame() {

        }

        @Override
        public void makeATry() {

        }

        @Override
        public void tellUpDownOk() {

        }
    }
    class IAPlayer extends player {
        @Override
        public void initGame() {

        }

        @Override
        public void makeATry() {

        }

        @Override
        public void tellUpDownOk() {

        }
    }
}
