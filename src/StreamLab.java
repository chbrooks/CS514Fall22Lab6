import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class StreamLab {

    List<String> stringList;

    public StreamLab() {
        stringList = new LinkedList<String>();

    }

    /* populate the list with some strings, then convert the list to a stream using toStream
        and get the count of elements.
     */
    public void task2() {
        stringList.add("cat");
        stringList.add("dog");
        stringList.add("llama");
        stringList.add("kangaroo");

        Stream<String> stream = stringList.stream();
        System.out.printf("There are %d elements in the stream\n", stream.count());

    }

    /* let's get a stream of lines from a file */
    public void task3() {
        try {
            Stream<String> fileLines = Files.lines(Paths.get("movieReviews.txt"));
            System.out.printf("%d", fileLines.count());
        } catch (IOException e) {
            System.out.println("unable to open file.");
        }
        /* Extend this to count the number of words. */

    }

    /* extend task3 to filter out the lines that begin with 1. Count the total number of lines that begin with 1. */
    public void task4() {
        try {
            Stream<String> fileLines = Files.lines(Paths.get("movieReviews.txt"));
            /* filter here */


        } catch (IOException e) {
            System.out.println("unable to open file.");
        }
    }

/* Let's extend task4 to split each line into words. This splits the lines
 */

    public void task5() {
        try {
            Stream<String> fileLines = Files.lines(Paths.get("movieReviews.txt"));
            fileLines
                    .flatMap(line -> Arrays.stream(line.split(" "))).count();
        } catch (IOException e) {
            System.out.println("unable to open file.");
        }
    }

    /* now let's use streams to filter out all the words that are junk words. */
    public void task6() {

    }

    /* now let's make isJunk a Predicate */
    public void task7() {

    }

    /* now let's map everything to lower case */
    public void task8() {

    }

    /* now let's trim punctuation */
    public void task9() {

    }

    /* let's sort everything alphabetically */

    public void task10() {

    }
    /* now let's store the results in a Set, to remove duplicates.
     * we could also use distinct()
     * */
    public void task11() {

    }

    public static void main(String[] args) {
        StreamLab s = new StreamLab();
        /* task 2 here */
    }

}
