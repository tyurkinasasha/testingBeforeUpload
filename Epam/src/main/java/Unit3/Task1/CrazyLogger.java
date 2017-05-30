package Unit3.Task1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Tyurkina Alexandra on 5/29/2017.
 */
public class CrazyLogger {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY : hh-mm");
    private StringBuilder logs;
    private String[] strings;

    public CrazyLogger() {
        logs = new StringBuilder();
        logs
                .append(dateFormat.format(Calendar.getInstance().getTime()))
                .append(" Logging has started...\n");
    }

    public void addToLog(String s) {
        logs.append(dateFormat.format(Calendar.getInstance().getTime()) + "  " + s + "\n");
    }

    public void printLogs() {
        System.out.println(logs.toString());
    }
    public String getLogs(){
        return  logs.toString();
    }

    public String searchForLog(String s) {
        if (logs.toString().length() == 0) return "";
        strings = logs.toString().split("\n");
        for (String string : strings) {
            if (string.contains(s)) return string;
        }
        return ("Log \"" + s + "\" not found");
    }

    public void printLog(String s) {
        System.out.println(searchForLog(s));
    }
    public void startNewLog(){
        logs.append("Logging has stopped");
        printLogs();
        //this=new CrazyLogger();
    }
}

