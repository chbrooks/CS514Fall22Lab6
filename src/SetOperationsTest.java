import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SetOperationsTest {
    Set<String> s1 = new HashSet<>();
    Set<String> s2 = new HashSet<>();
    Set<String> res1 = new HashSet<>();

    @BeforeEach
    void setUp() {
        s1.add("cat");
        s2.add("dog");
    }

    @org.junit.jupiter.api.Test
    void union() {
        s2.add("s1");
        res1 = SetOperations.union(s1,s2);
        assertEquals(res1.size(), 2);
    }

    @org.junit.jupiter.api.Test
    void unionNull() {
        s1 = null;
        s2 = null;
        SetOperations.union(s1,s2);
    }


    @org.junit.jupiter.api.Test
    void intersection() {
        s2.add("cat");
        res1 = SetOperations.intersection(s1,s2);
        assertEquals(res1.size(), 1);


    }



}