import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
            logger.info("Début d'une nouvelle partie");
            Gamechoice modeChoice = new Gamechoice();
            modeChoice.runGame ();
        }
    }

