package br.com.meli.demo.utils;

import java.util.UUID;

public class GenerateRandomUUID {
    public static String generate() {
        return UUID.randomUUID().toString();
    }
}
