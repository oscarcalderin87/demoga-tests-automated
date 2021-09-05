package framework.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {
    private static final Logger LOGGER = Logger.getLogger(Utils.class.getName());

    public static String applyDefaultIfMissing(String argument, String defaultValue) {
        if (argument == null) {
            argument = defaultValue;
            LOGGER.log(Level.INFO, "Default " + defaultValue + " execution was applied since was not provided");
        }

        return argument;
    }
}
