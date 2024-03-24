package com.reto.ClientePersona.utils;


import org.apache.tomcat.util.codec.binary.Base64;

import java.util.Random;

public class Util {
    public static String encodePassword(String rawPassword) {
        return Base64.encodeBase64String(rawPassword.getBytes());
    }

    public static boolean checkPassword(String rawPassword, String encodedPassword) {
        return Base64.encodeBase64String(rawPassword.getBytes()).equals(encodedPassword);
    }

    public static String generateRandomId(int length) {
        Random random = new Random();
        int maxNumber = (int) Math.pow(10, length) - 1; // Calculate the maximum number with the given length
        return String.format("%0" + length + "d", random.nextInt(maxNumber));
    }
}
