package com.jay.movieratingservice.model;

public class Rating {

    private String id;
    private int rating;

    public Rating() {
    }

    public Rating(String id, int rating) {
        this.id = id;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id='" + id + '\'' +
                ", rating=" + rating +
                '}';
    }
}
