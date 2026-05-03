package org.example;
public class Movie implements Identifiable {
    String id;
    String name;

    public Movie(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o.equals(id)))return false;
        Movie movie = (Movie) o;
        return id.equals(movie.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
