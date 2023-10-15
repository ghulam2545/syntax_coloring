package com.ghulam;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader {
    public static String read(String[] args) {
        if (args.length < 1) {
            System.out.println("ERROR: please give a file.");
            System.exit(1);
        }

        String filename = args[0];
        byte[] bytes = {};
        try {
            bytes = Files.readAllBytes(Paths.get(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new String(bytes);
    }
}
