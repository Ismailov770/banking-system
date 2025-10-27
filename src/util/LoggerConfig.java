package util;

import java.io.IOException;
import java.util.logging.*;

public class LoggerConfig {
    public static final Logger LOGGER = Logger.getLogger("BankLogger");

    static {
        try {
            Handler fileHandler = new FileHandler("bank.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.INFO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

