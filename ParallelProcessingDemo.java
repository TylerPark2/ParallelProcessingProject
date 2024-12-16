import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelProcessingDemo {

    public static void main(String[] args) {
        int numTasks = 4;
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 1; i <= numTasks; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is starting.");
                try {
                    Thread.sleep(2000); // Simulate a time-consuming task
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Task " + taskId + " was interrupted.");
                }
                System.out.println("Task " + taskId + " is complete.");
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all tasks to complete
        }
        System.out.println("All tasks completed.");
    }
}
