/* https://www.hackerrank.com/challenges/new-year-chaos/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
      // Write your code here
      int swapCounter = 0;
      for (int i = q.size() - 1; i >= 0; i--) {
          if (q.get(i) != i + 1) {
              if ((i - 1 >= 0) && q.get(i - 1) == i + 1) {
                  swapCounter++;
                  Collections.swap(q, i, i - 1);
              } else if ((i - 2 >= 0) && q.get(i - 2) == i + 1) {
                  swapCounter += 2;
                  Collections.swap(q, i - 1, i - 2);
                  Collections.swap(q, i, i - 1);
              } else {
                  System.out.println("Too chaotic");
                  return;
              }
          }
      }
      System.out.println(swapCounter);
    }
}

public class NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
