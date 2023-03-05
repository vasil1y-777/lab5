package classes.collection;

import classes.movie.Movie;

import java.util.ArrayList;
import java.util.UUID;

public class CollectionManager {
    private static ArrayList<Movie> collection = null;

    public CollectionManager() {
        if (CollectionManager.collection == null)
            CollectionManager.collection = new ArrayList<>();
    }

    public ArrayList<Movie> getCollection() {
        return CollectionManager.collection;
    }

    public void addMovie(Movie movie) {
        CollectionManager.collection.add(movie);
    }

    public void removeMovie(UUID MovieId) {
        for (Movie movie : CollectionManager.collection) {
            if (movie.getId() == MovieId) {
                CollectionManager.collection.remove(movie);
                break;
            }
        }
    }

    public void removeMovie(Movie movie) {
        collection.remove(movie);
    }

    public void removeMovie(int movieIndex) {
        collection.remove(movieIndex);
    }

    public void clear(){
        collection.clear();
    }
}
