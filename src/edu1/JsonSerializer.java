package edu1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonSerializer {
    public static Map<String, Movie> getMovies() throws IOException {
        Gson gson = new Gson();
        Reader reader = new FileReader("movies.json");
        try (reader) {
            List<Movie> movies = gson.fromJson(reader, new TypeToken<List<Movie>>() {
            }.getType());
            Map<String, Movie> movieMap = new HashMap<>();
            for (int i = 0; i < movies.size(); i++) {
                movieMap.put(movies.get(i).getName(), movies.get(i));
            }
            return movieMap;
        }
    }
}
