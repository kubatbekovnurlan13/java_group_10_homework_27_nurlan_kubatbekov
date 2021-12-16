package edu1;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        showMovies();
        getMovieByKey("asasd");
        getMovieByKey("Good");
        getMovieByKey("Good omens");
    }

    public static void showMovies() {
        try {
            Map<String, Movie> movieMap = JsonSerializer.getMovies();
            print("Name:", "Description:");
            for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                print(m.getKey(), m.getValue().getDescription());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print(String name, String desc) {
        String format = "| %-45s => %-15s |\n";
        System.out.printf(format, name, desc);
    }

    public static void getMovieByKey(String name) {
        try {
            Map<String, Movie> movieMap = JsonSerializer.getMovies();
            if (movieMap.get(name) != null) {
                print(movieMap.get(name).getName(), movieMap.get(name).getDescription());
            } else {
                boolean check = true;
                for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                    if (m.getKey().contains(name)) {
                        print(m.getKey(), m.getValue().getDescription());
                        check = false;
                    }
                }
                if(check){
                    System.out.println("There is no such movie!");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

