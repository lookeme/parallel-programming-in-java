package edu.coursera.parallel;

import java.util.Arrays;
import org.modelmapper.internal.Pair;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class ThenCombineExample {
    public static void main(String[] args) {
        int[] x  = new int[5];
        int[] y = new int[5];
        int[] z = new int[5];
        int[] w = new int[5];
       IntStream.rangeClosed(0, 4).forEach(i -> {
           x[i] = i;
           y[i] = i + 1;
           z[i] = i + 2;
           w[i] = i + 3;
       });

       

//        System.out.println(Arrays.toString(x));
//        System.out.println(Arrays.toString(y));
//        System.out.println(Arrays.toString(z));
//        System.out.println(Arrays.toString(w));

//        for (int i=0; i <= 3; i++) {
//            x[i] = x[i] + y[i];
//            y[i+1] = w[i] + z[i];
//        }

//        c = 0;
//        forall (i : [0 : N]) {
//            c = c + a[i];
//        }
//        println("c = " + c);


        final int[] c = {0};
        IntStream.rangeClosed(0, 3).parallel().forEach(i -> {
           c[0] = c[0] + y[i];
        });

        System.out.println(Arrays.toString(c));


//        System.out.println(Arrays.toString(x));
//        System.out.println(Arrays.toString(y));
//        System.out.println(Arrays.toString(z));
//        System.out.println(Arrays.toString(w));



    }


}
