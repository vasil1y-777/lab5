package testing_module;

import movie.Movie;
import movie.Movies;
import xml_manager.XMLMovieManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WriteReadTesting {
    public static void main(String[] args) {
        List<Movie> mmovies = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Movie m = new Movie();
            Random r = new Random();
            m.setBudget(r.nextInt(10000)); //[0;..]
            m.setId(r.nextInt(1000)); //[0;..]
            m.setName("Film" + i);
            mmovies.add(m);
        }
        Movies mmm = new Movies();
        mmm.setMovies(mmovies);
        System.out.println(XMLMovieManager.getInstance().readObjectFromXML("test.xml").toString());
        XMLMovieManager.getInstance().saveObjectToXML(mmm);

    }
}
