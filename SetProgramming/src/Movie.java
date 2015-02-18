/**
 * Created by AmaninderSingh on 1/22/15.
 */
public class Movie {
    // has things (fields, instance variables)
    private String name;
    private int year;


    // can do things (methods, behaviors)
    public Movie(String name, int year){
        this.name = name;
        this.year = year;
    }
    public String getName(){
        return this.name;
    }
    public int getYear(){
        return this.year;
    }
    // this allows a movie to be printed to the console like operator overloading in c++
    public String toString(){
        String result = name + " (" + year + ") ";
        return result;
    }

    // equals because strings are object in java you can't use ==
    public boolean equals(Movie otherMovie){
        if(this.name.equals(otherMovie.name) &&
                this.year == otherMovie.year) {
            return true;
        }
        return false;
    }
}
