Lab 6: Sets and Streams.

Due: Monday 11/14, Start of class.

In this lab, you'll get some practice working with Sets and using Streams to process text.

To submit: Please check this lab back into your GitHib repo by the due date.

The lab will be graded according to the specifications grading method described in the syllabus.

Specifically:

A completed, on-time lab is worth 2 points.

A lab that is late or incomplete is worth 1 point.

A lab that is missing is worth 0 points.

1. Sets. SetOperations is a class that will contain three static methods: union, intersection and setDifference.
I've provided union for you. Use the Set class' built-in methods to implement intersection and set difference. 

2. The remaining tasks are in the StreamLab class. Task 2 shows how to create a stream from a data structure. Add a main() that allows you to call task2. 

4. Task 3 shows how to use the Files class to get a stream from a file. Extend task3 to count the number of words in the input file. Getting a stream from a collection. Create a List, add some strings to it, and call toStream()
    
5. Task 4: Extend Task3 to filter out only the lines that begin with 1 and count them.

6. Task5 shows how to use a flatMap to split each line into separate words. Add a filter here to find words that begin with 'a'.

7. For task6, let's filter out all the junk words. 

8. For task 7, let's rewrite junkWord as a predicate.

9. Now let's use map to convert everything to lower case.

10. Then let's use map to remove trailing punctuation.

11. Let's sort everything alphabetically.

12. Then let's collect everything into a Set in order to remove duplicates.




