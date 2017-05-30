package Unit3.Task1;

/**
 * Created by Tyurkina Alexandra on 5/29/2017.
 */
public class Main {
    public static void main(String[] args) {
        CrazyLogger logger=new CrazyLogger();
        logger.addToLog("hey");
        logger.getLogs();
        logger.addToLog("my name is sasha");
        logger.addToLog("bye");
        logger.getLogs();
        logger.printLog("hey");
        logger.searchForLog("bye");
        logger.printLogs();
    }
}
