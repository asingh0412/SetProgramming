import java.util.HashSet;
import java.util.Set;
import java.util.*;

/**
 * Created by AmaninderSingh on 1/22/15.
 */
public class SetHelper<E> {

    // no fields
    // only has methods
    public Set<E> intersect(Set<E> s1, Set<E> s2){
        Set<E> intersection = new HashSet<E>(s1);
        intersection.retainAll(s2);
        return intersection;
    }

    public  Set<E> union(Set<E> s1, Set<E> s2){
        Set<E> union = new HashSet<E>(s1);
        union.addAll(s2);
        return union;

    }


    public Set<E> differences(Set<E> s1, Set<E> s2){
        Set<E> differences = new HashSet<E>(s1);// remove everything that happens to
        differences.removeAll(s2);
        return differences;

    }

    public Set<E> symmetricDifference(Set<E> s1, Set<E> s2){
        Set<E> unionOfS1AndS2 = union(s1, s2);
        Set<E> intersectionS1AndS2 = intersect(s1, s2);
        Set<E> symmetricDifference = differences(unionOfS1AndS2, intersectionS1AndS2);

        return symmetricDifference;

    }

}
