package threads;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Ex1 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                System.out.println("Sleepi"+Thread.currentThread().getName());
                Thread.sleep(2000);
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 3";
            }
        });

        List<Future<String>> futures = executorService.invokeAll(callables);
        String futures1 = executorService.invokeAny(callables);

        for (Future<String> future : futures) {
            System.out.println("future.get = " + future.get());

        }
        System.out.println(futures1);


        executorService.shutdown();
    }
}