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
            for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                System.out.println(m.getKey() + " : " + m.getValue().getDescription());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
