package edu1;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        showMovies();
//        getMovieByKey("asasd");
//        getMovieByKey("Good");
//        getMovieByKey("Good omens");
//        sortByYear();
//        sortByName();
//        sortByDirector();
//        sortByDirectorReverse();
//        sortByNameReverse();
//        sortByYearReverse();
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
                if (check) {
                    System.out.println("There is no such movie!");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sortByYear() {
        try {
            Map<String, Movie> movieMap = JsonSerializer.getMovies();
            List<Movie> movies = new ArrayList<>();
            for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                movies.add(m.getValue());
            }
            movies.sort(Comparator.comparing(Movie::getYear));
            for (Movie m : movies) {
                System.out.println("Year: " + m.getYear() + ", Name: " + m.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortByName() {
        try {
            Map<String, Movie> movieMap = JsonSerializer.getMovies();
            List<Movie> movies = new ArrayList<>();
            for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                movies.add(m.getValue());
            }
            movies.sort(Comparator.comparing(Movie::getName));
            for (Movie m : movies) {
                System.out.println("Name: " + m.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortByDirector() {
        try {
            Map<String, Movie> movieMap = JsonSerializer.getMovies();
            List<Movie> movies = new ArrayList<>();
            for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                movies.add(m.getValue());
            }
            movies.sort(Comparator.comparing(Movie::getDirector));

            for (Movie m : movies) {
                System.out.println("Director: " + m.getDirector());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortByDirectorReverse() {
        try {
            Map<String, Movie> movieMap = JsonSerializer.getMovies();
            List<Movie> movies = new ArrayList<>();
            for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                movies.add(m.getValue());
            }

            Comparator cmp = Comparator.comparing(Movie::getDirector);
            movies.sort(cmp.reversed());

            for (Movie m : movies) {
                System.out.println("Director: " + m.getDirector());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortByNameReverse() {
        try {
            Map<String, Movie> movieMap = JsonSerializer.getMovies();
            List<Movie> movies = new ArrayList<>();
            for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                movies.add(m.getValue());
            }
            Comparator cpm = Comparator.comparing(Movie::getName);
            movies.sort(cpm.reversed());
            for (Movie m : movies) {
                System.out.println("Name: " + m.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortByYearReverse() {
        try {
            Map<String, Movie> movieMap = JsonSerializer.getMovies();
            List<Movie> movies = new ArrayList<>();
            for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                movies.add(m.getValue());
            }
            movies.sort(Comparator.comparing(Movie::getYear).reversed());
            for (Movie m : movies) {
                System.out.println("Year: " + m.getYear() + ", Name: " + m.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

