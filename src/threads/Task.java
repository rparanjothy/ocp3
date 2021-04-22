package threads;

public class Task implements Runnable{


    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println("I am Task"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
