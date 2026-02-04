package io.com_functional_testing.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
    public static  Logger logger = LogManager.getLogger();
    public static void logInfo(String log4jMessage){
         logger.info(log4jMessage);
    }


}
