import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

public class Service {

    public ArrayList<Movie> getAllMovie() {
        ArrayList<Movie> movies = new ArrayList<>();
        Gson gson = new Gson();

        try {
            FileReader reader = new FileReader("movie.json");
            Type type = new TypeToken<ArrayList<Movie>>() {
            }.getType();

            movies = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public void show(ArrayList<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public void sortYear(ArrayList<Movie> movies) {

        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getYear() - o2.getYear();
            }
        });
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public void sortName(ArrayList<Movie> movies) {

        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public void searchName(ArrayList<Movie> movies, String title) {

        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase(Locale.ROOT).contains(title.toLowerCase()))
                System.out.println(movie);
        }
    }

    public void index(ArrayList<Movie> movies) {
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o2.getView() - o1.getView();
            }
        });

        System.out.println(movies.get(0));
        System.out.println(movies.get(1));
        System.out.println(movies.get(2));
    }

    public void searchCategory(ArrayList<Movie> movies, String category) {

        for (Movie movie : movies) {
            for (String cate : movie.getCategory()) {
                if (cate.toLowerCase(Locale.ROOT).contains(category))
                    System.out.println(movie);
            }
        }
    }

}