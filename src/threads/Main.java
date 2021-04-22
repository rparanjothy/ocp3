package threads;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Runnable lambda = () -> {
            while (true) {
                System.out.println("I am Running from a Runnable lambda in " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(() -> {
            var i = 0;
            while (i < 10) {
                try {
                    Thread.sleep(1000);
                    System.out.println("I am a lambda in " + Thread.currentThread().getName());
                    i++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        t1.setName("T1");
        t1.start();
//
        Thread t2 = new Thread(new Task());
//        t2.start();

//        A callable lambda that returns 100 after 2 secs
        Callable<Integer> taskRetInteger = () -> {
            Thread.sleep(1000);
            return 100;
        };

        ExecutorService es = Executors.newFixedThreadPool(5);
        es.execute(lambda);
        es.execute(t1);
        es.execute(t2);
//        using the same executor service, lets get a future
        Future<Integer> fromTaskRetInt = es.submit(taskRetInteger);

        Future<Integer> fromTaskRetInt1 = es.submit(() -> {
            System.out.println("I am going to sleep for 2 secs and return a value");
            Thread.sleep(2000);
            return 22;
        });

        Future<Integer> fromTaskRetIntInLine = es.submit(() -> {
            System.out.println("I am going to sleep for 2 secs and return a value");
            Thread.sleep(2000);
            return 32;
        });

        try {
            System.out.println("fromTaskRetInt: " + fromTaskRetInt.get(20, TimeUnit.SECONDS));
            System.out.println("returned value after 20 secs");

            System.out.println("--------------");
            Integer ret = fromTaskRetIntInLine.get(4, TimeUnit.SECONDS);
            System.out.println("Ret is " + ret);

            Integer ff = es.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(2000);
                    return 999;
                }
            }).get(10, TimeUnit.SECONDS);


            Integer ff1 = es.submit(() -> 1000
            ).get(10, TimeUnit.SECONDS);

            System.out.println("ff1: "+ff1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
