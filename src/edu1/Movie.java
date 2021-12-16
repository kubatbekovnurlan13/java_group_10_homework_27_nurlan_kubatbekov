package edu1;

public class Movie {
    private String name;
    private int year;
    private String description;
    private Director director;
    private Cast[] casts;

    public Movie(
            String name,
            int year,
            String description,
            Director director,
            Cast[] casts
    ) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.casts = casts;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public Director getDirector() {
        return director;
    }

    public Cast[] getCasts() {
        return casts;
    }
}
