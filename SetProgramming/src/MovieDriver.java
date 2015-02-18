import java.util.*;

/**
 * Created by AmaninderSingh on 1/22/15.
 */
public class MovieDriver {

    public static void main(String[] args) {

        System.out.println("Welcome to Moviefone");

        Movie m1 = new Movie("Frozen", 2014);
        Movie m2 = new Movie("Star Trek", 1979);
        Movie m3 = new Movie("Rumble in the Bronx", 1996);
        Movie m4 = new Movie("Inception", 2012);
        Movie m5 = new Movie("Intersteller", 2014);
        Movie m6 = new Movie("Dark Knight", 2008);
        Movie m7 = new Movie("Dumb and Dumber To", 2014);

        Set<Movie> library = new HashSet<Movie>();  // HashSet or Tree Set
        Set<Movie> favorites = new HashSet<Movie>();
        Set<Movie> watched = new HashSet<Movie>();
        Set<Movie> comedy = new HashSet<Movie>();
        Set<Movie> drama = new HashSet<Movie>();
        Set<Movie> SciFi = new HashSet<Movie>();


        library.add(m1);
        library.add(m2);
        library.add(m3);
        library.add(m4);
        library.add(m5);

        favorites.add(m2);
        favorites.add(m3);
        favorites.add(m7);

        SciFi.add(m4);
        SciFi.add(m5);
        SciFi.add(m6);

        System.out.println();
        Iterator<Movie> currentFav = favorites.iterator();
        System.out.println("Favorite Movies:");
        while(currentFav.hasNext()){
            System.out.println(currentFav.next());
        }

        watched.add(m1);
        watched.add(m3);
        watched.add(m4);
        watched.add(m6);

        comedy.add(m1);
        comedy.add(m3);
        comedy.add(m7);

        drama.add(m2);
        drama.add(m4);

        System.out.println();
        System.out.println("Library is " + library);
        System.out.println("Comedies is " + comedy);

        //favorites.clear(); // empty out the favorite set and memory is freed

        // object for set helper.
        SetHelper helper = new SetHelper();

        // calc the intersection of watched and dramas.
        Set<Movie> watchedDramas = helper.intersect(watched, drama);

        // Movies that I haven't watched.
        Set<Movie> unwatched = helper.differences(library, watched);

        // comedies that i haven't seen
        Set<Movie> unwatchedComs = helper.differences(unwatched, comedy);

        //favorite comedies.
        System.out.println();
        Set<Movie> favComs = helper.intersect(favorites, comedy);

        Iterator<Movie> favComedies = favComs.iterator();
        System.out.println("Favorite Comedies:");
        while(favComedies.hasNext()){
            System.out.print(favComedies.next());
        }

        // movies after 2010 that I haven't watched
        Set<Movie> unwatchedNewReleases = new HashSet<Movie>();
        Iterator<Movie> currMovie = unwatched.iterator();
        while (currMovie.hasNext()) {
            Movie temp = currMovie.next();
            if (temp.getYear() >= 2010) {
                unwatchedNewReleases.add(temp);
            }
        }

        // Movies before 1990 that I haven't watched.
        Set<Movie> watchedMovies = new HashSet<Movie>();
        Iterator<Movie> movieIterator = unwatched.iterator();
        while (movieIterator.hasNext()) {
            Movie temp = movieIterator.next();
            if (temp.getYear() <= 1990) {
                watchedMovies.add(temp);
            }
        }

        System.out.println();
        // SciFi and comedy movies that I haven't seen.
        System.out.println("Unwatched SciFi and comedy movies");
        Set<Movie> sciComUnwatched = helper.union(SciFi, comedy);
        System.out.println("SciFi and Comedy " + sciComUnwatched);
        sciComUnwatched = helper.differences(sciComUnwatched,watched);
        System.out.println("Unwatched SciFi and Comedy " + sciComUnwatched);

        // Map.
        Map<Movie, Integer> watchedCount = new HashMap<Movie, Integer>();
        watchedCount.put(m3, 5);
        watchedCount.put(m5, 1);
        watchedCount.put(m1, 0);
        watchedCount.put(m1, 6);

        int howManyTimes = watchedCount.get(m1);
        System.out.println();
        System.out.println("I have seen " + m1 + howManyTimes + " times.");
        watchedCount.clear();

        // Queue
        Queue<Movie> playList = new LinkedList<Movie>();
        playList.add(m3);
        playList.add(m2);
        playList.add(m1);

        // Peek at the first movie in the playlist
        Movie firstToPlay = playList.element();
        System.out.println("First movie in the playlist: " + firstToPlay);


        // Remove the first movie in the the playList
        playList.remove();

        // Peek at the second movie in the playList queue
        Movie secondToPlay = playList.element();
        System.out.println("Second movie in the playlist: " + secondToPlay);


        // Remove the first movie in the the playList
        playList.remove();

        // Peek at the second movie in the playList queue
        Movie thirdToPlay = playList.element();
        System.out.print("Third movie in the playlist: " + thirdToPlay);


    }

}