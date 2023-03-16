package com.alfabank.qapp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ValidationInputData {

    protected static final Logger log = LoggerFactory.getLogger(ValidationInputData.class);

    private ValidationInputData() {
    }

    public static boolean areSymbolsValid(String str) {
        boolean matches = str.matches("[A-Za-z\\s.,/'_-]{3,50}");

        if (!matches) {
            log.info("ExceptValue");
            return false;
        }

        return true;
    }

    public static String replaceAllInvalidSymbols(String str) {
        String replacedStr = str;
        boolean matches = areSymbolsValid(str);

        if (!matches) {
            replacedStr = str.replaceAll("[^A-Za-z\\s.,/'_-]{1,50}", "");
            log.info("ExceptValue");
        }

        return replacedStr;
    }

    public static String getRandomString(String symbols, int stringLength) {
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        Random random = new Random();

        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(symbols.charAt(random.nextInt(symbols.length())));
        }
        return stringBuilder.toString();
    }
}
