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
    static int value;
    int increment;
    
    public Lab5(int v){
        increment = v;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        // increment value
        value += increment;
        // 
        //return the thread name executing this callable task
        return ""+value;
    }
    
    public static void main(String args[]){
        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<Future<String>>();
        
        List<Integer> ints = Arrays.asList(5,3,-4, 6, 2);
        
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
    }

}