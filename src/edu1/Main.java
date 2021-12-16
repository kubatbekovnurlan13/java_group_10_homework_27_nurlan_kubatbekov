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
//        findByDirector("Peter Jackson");
//        findByYear(2019);
//        findByCast("Martin Freeman");
//        findByCastAndRole("Martin Freeman");
//        findAllCasts();
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

    public static void findByDirector(String directorName) {
        try {
            Map<String, Movie> movieMap = JsonSerializer.getMovies();
            List<Movie> movies = new ArrayList<>();
            System.out.println("Search by: " + directorName);

            for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                if (m.getValue().getDirector().equals(directorName)) {
                    movies.add(m.getValue());
                    System.out.println("Movie: " + m.getValue().getName());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void findByYear(int year) {
        try {
            Map<String, Movie> movieMap = JsonSerializer.getMovies();
            List<Movie> movies = new ArrayList<>();
            System.out.println("Search by: " + year);

            for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                if (m.getValue().getYear() == year) {
                    movies.add(m.getValue());
                    System.out.println("Movie: " + m.getValue().getName());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void findByCast(String name) {
        try {
            Map<String, Movie> movieMap = JsonSerializer.getMovies();
            List<Movie> movies = new ArrayList<>();
            System.out.println("Search by: " + name);

            for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                for (int i = 0; i < m.getValue().getCasts().length; i++) {
                    if (m.getValue().getCasts()[i].getFullName().equals(name)) {
                        movies.add(m.getValue());
                        System.out.println("Movie: " + m.getValue().getName() + ", cast: " + m.getValue().getCasts()[i].getFullName());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findByCastAndRole(String name) {
        try {
            Map<String, Movie> movieMap = JsonSerializer.getMovies();
            List<Movie> movies = new ArrayList<>();
            System.out.println("Search by: " + name);

            for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                for (int i = 0; i < m.getValue().getCasts().length; i++) {
                    if (m.getValue().getCasts()[i].getFullName().equals(name)) {
                        movies.add(m.getValue());
                        System.out.println("Movie: " + m.getValue().getName() + ", cast: " + m.getValue().getCasts()[i].getFullName());
                        System.out.println("Role: " + m.getValue().getCasts()[i].getRole());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findAllCasts() {
        try {
            Map<String, Movie> movieMap = JsonSerializer.getMovies();
            List<Movie> movies = new ArrayList<>();

            for (Map.Entry<String, Movie> m : movieMap.entrySet()) {
                System.out.println("Movie: " + m.getValue().getName());
                for (int i = 0; i < m.getValue().getCasts().length; i++) {
                    movies.add(m.getValue());
                    System.out.println("Cast: " + m.getValue().getCasts()[i].getFullName());
                    System.out.println("Role: " + m.getValue().getCasts()[i].getRole());
                }
                System.out.println("----------------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
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

