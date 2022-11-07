import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static void example1() {
        /* let's make some data */
        Random gen = new Random();
        List<Double> data = new ArrayList<Double>(1000);
        for (int i = 0; i < 1000;i++) {
            data.add(i,gen.nextDouble());
        }

        /* how many elements are in the list? */

        System.out.printf("Number of elements: %d\n",
                                    data.stream().count());

        /* What's the largest element? */

        /* max() returns an Optional object. */
        Optional<Double> o= data.stream().max(Double::compare);
        System.out.printf("Largest element: %f\n", o.get());

        /* What's the smallest element? */

        /* let's just call get() directly. */
        System.out.printf("smallest element: %f\n",
                data.stream().min(Double::compare).get());

        /* Let's get all the elements greater than 0.7 */

        List<Double> results = data.stream()
                .filter(n -> n > 0.7)
                .collect(Collectors.toList());
        for (Double d : results) {
            System.out.printf("%f ", d);
        }
        System.out.println();

    }

    public static void example2() {
        /* Let's work with a file. */

        try {
            Stream<String > fileLines = Files.lines(Paths.get("movieReviews.txt"));

                   /* How many lines are in the file? */
            System.out.printf("Number of lines in the file: %d\n",
                    fileLines.count());

            /* let's get the lines that are of length < 120. We have to reopen the stream */

            fileLines = Files.lines(Paths.get("movieReviews.txt"));
            List<String> results = fileLines
                    .filter(line -> line.length() > 120)
                    .collect(Collectors.toList());
            for (String line: results) {
                System.out.println(line);
            }

            /* Now let's get the lines with length < 40 that begin with 1 */
            fileLines = Files.lines(Paths.get("movieReviews.txt"));
            results = fileLines
                    .filter(line -> line.length() < 40)
                    .filter(line-> line.startsWith("1"))
                    .collect(Collectors.toList());
            for (String line: results) {
                System.out.println(line);
            }

            /* Now let's change them all to lower-case. To do this, we use a map. This is a function that
            tells us how to transform each object.
             */
            fileLines = Files.lines(Paths.get("movieReviews.txt"));
            results = fileLines
                    .map(line-> line.toLowerCase())
                    .collect(Collectors.toList());
            for (String line: results) {
                System.out.println(line);
            }

            /* now let's hook these together. */
            fileLines = Files.lines(Paths.get("movieReviews.txt"));
            results = fileLines
                    .filter(line -> line.length() < 40)
                    .filter(line-> line.startsWith("1"))
                    .map(line-> line.toLowerCase())
                    .collect(Collectors.toList());
            for (String line: results) {
                System.out.println(line);
            }


        } catch (IOException e) {
            System.out.println("File not found. " + e);
        }

    }

    public static void example3() {
        /* This time, let's get the words. */

        try {
            Stream<String > fileLines = Files.lines(Paths.get("movieReviews.txt"));

           /* To understand this, read it inside out.
                   split() returns an array of Strings.
                   Arrays.stream() converts that array into a stream.
                   This happens for each line in the file.
                   flatMap then appends (or flattens) them all together.
            */
            List<String> words = fileLines
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .collect(Collectors.toList());


            /* let's use this to find all the words that are of length > 6 and begin with d */
            fileLines = Files.lines(Paths.get("movieReviews.txt"));
            words = fileLines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .filter(word -> word.length() > 6 && word.startsWith("d"))
                    .collect(Collectors.toList());

            for (String word : words) {
                System.out.printf("%s ", word);
            }

            /* If our test is more complicated, we might want to pull it out into a separate predicate.

             */
            Predicate<String> complicatedPredicate =
                    (String s) ->
                    {
                        if (s.length() == 0 || s.length() == 7) {
                            if (s.startsWith("boo") && s.endsWith("rns")) {
                                return true;
                            } else if (s.contains("arf")) {
                                return true;
                            } else {
                                return false;
                            }
                        }  else {
                            if (s.contains("this")) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    };

            /* let's eliminate duplicates by using a set */
            fileLines = Files.lines(Paths.get("movieReviews.txt"));
            Set<String> wordSet = fileLines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .filter(word -> complicatedPredicate.test(word))
                    .collect(Collectors.toSet());

            System.out.println();
            for (String word : wordSet) {
                System.out.printf("%s ", word);
            }

        } catch (IOException e) {
            System.out.println("File not found. " + e);
        }

    }

    public static void example4() {
        /* let's make some more data */
        System.out.println();
        Random gen = new Random();
        List<Double> data = new ArrayList<Double>(1000);
        for (int i = 0; i < 1000;i++) {
            data.add(i,gen.nextDouble());
        }

        /* We can also reduce on a stream. This applies a function sequentially to the sequence
        and accumulates a result. For example, summing.
         */
        Double product = data.stream().reduce((x,y)-> x*y).get();
        System.out.printf("%f", product);
        System.out.println();

        /* If there's a builtin method, we can call that. */
        Double sum = data.stream().reduce(Double::sum).get();
        System.out.printf("%f\n", sum);

        /* We can also sort the elements by providing a comparator.
         */
        List<Double> sortedList = data.stream()
                .sorted((x,y) -> (x.compareTo(y)))
                .collect(Collectors.toList());
        for (Double item : sortedList) {
            System.out.printf("%f ", item);
        }
        System.out.println();




    }



    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
    }



}
