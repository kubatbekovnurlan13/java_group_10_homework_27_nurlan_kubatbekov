package edu1;

public class Movie implements Comparable<Movie> {
    private String name;
    private int year;
    private String description;
    private Director director;
    private Cast[] cast;

    @Override
    public int compareTo(Movie o) {
        if (this.getName().equals(o.getName())) {
            return this.getDirector().compareTo(o.getDirector());
        }
        return this.getName().compareTo(o.getName());
    }

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
        this.cast = casts;
    }

    @Override
    public String toString() {
        return "name: " + name + ", year: " + year + ", desc: " + description
                +", casts: " + cast;
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

    public String getDirector() {
        return director.getFullName();
    }

    public Cast[] getCasts() {
        return cast;
    }
}
