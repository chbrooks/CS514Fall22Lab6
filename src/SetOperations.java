import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    /* you implement this using the set interface */
    /* create a SetOperationsTest using JUnit to test this. */

    public static Set<String> union(Set<String> s1, Set<String> s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException();
        }
        Set<String> returnSet = new HashSet<>();
        returnSet.addAll(s1);
        returnSet.addAll(s2);
        return returnSet;
    }


    /* then do intersection and set difference. */

    public static Set<String> intersection(Set<String> s1, Set<String> s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException();
        }
        return null;


    }

    public static Set<String> setDifference(Set<String> s1, Set<String> s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException();
        }
        return null;

    }

}
