package automation.utils;

import java.util.Random;

public class StringRandomGenerator {

    private static final String ALPHA_NUMERIC_STRING = "0123456789abcdefghijklmnopqrstuvxyz";
    private static final int DEFAULT_STRING_SIZE = 10;

    public static String generateString() {
        return generateString(DEFAULT_STRING_SIZE);
    }

    public static String generateString(int size) {
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {
            sb.append(ALPHA_NUMERIC_STRING.charAt(new Random().nextInt(ALPHA_NUMERIC_STRING.length())));
        }

        return sb.toString();
    }

    public static String getRandomEmail() {
        return getRandomEmail(DEFAULT_STRING_SIZE);
    }

    public static String getRandomEmail(int size) {
        return generateString(size) + "@gmail.com";
    }

}
