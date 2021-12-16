package edu1;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        showMovies();
    }

    public static void showMovies() {
        try {
            Map<String, Movie> movieMap = JsonSerializer.getMovies();
            print("Name:","Description:");
            for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                print(m.getKey(),m.getValue().getDescription());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print(String name, String desc) {
        String format = "| %-45s => %-15s |\n";
        System.out.printf(format, name, desc);
    }


}
