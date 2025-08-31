package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * FAULTY "Singleton": public constructor, getInstance() returns a NEW instance each time,
 * not thread-safe, reload allowed anytime, mutable global state, reflection+serialization-friendly.
 */
public class AppSettings implements Serializable {
    private final Properties props = new Properties();
    private static AppSettings instance;

    private AppSettings() { 
        if (instance != null) {
            throw new RuntimeException("Use getInstance()!");
        }
    } // should not be public for true singleton

    public static AppSettings getInstance() {
        if(instance == null) {
            synchronized(AppSettings.class) {
                if(instance == null) {
                    instance = new AppSettings();
                }
            }
        }
        return instance; // returns a fresh instance (bug)
    }

    protected Object readResolve() {
        return instance;
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}
