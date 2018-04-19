package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lab5 implements Callable<String> {
    static volatile int value;
    int increment;
    
    public Lab5(int v){
        increment = v;
    }

    @Override
    public String call() throws Exception { 
        synchronized(Lab5.class){
            Thread.sleep(1000);
            int old = value;
            value += increment;
            return Thread.currentThread() + " old: " + old + "  increment: " + increment +
                    "  value: " + value;
        }
    }
    
    public static void main(String args[]){
        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executor = Executors.newFixedThreadPool(5);
        //create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<Future<String>>();
        
        List<Integer> ints = Arrays.asList(5,3,-4, 6, -2);
        
        for(int v : ints){
            //submit Callable tasks to be executed by thread pool
            Future<String> future = executor.submit(new Lab5(v));
            //add Future to the list, we can get return value using Future
            list.add(future);
        }
        
        for(Future<String> fut : list){
            try {
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                System.out.println(new Date()+ "::"+ fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();
        System.out.println("Final value: "+ value);
    }
}