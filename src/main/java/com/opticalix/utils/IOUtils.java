package com.opticalix.utils;

import java.io.Closeable;
import java.io.IOException;

public class IOUtils {

    public static void closeSliently(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
