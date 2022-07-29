package sg.edu.rp.c346.id21018157.mymovies;

public class Movie {
    private int id;
    private String name;
    private String genre;
    private int year;
    private char rating;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Movie(int id, String name, String genre, int year, char rating) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public char getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRating(char rating) {
        this.rating = rating;
    }
}
