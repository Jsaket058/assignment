public class MultiThread{
    public static void main(String[] args) {
        Task t1 = new Task("Thread 1");
        Task t2 = new Task("Thread 2");

        t1.start();
        t2.start();
    }
}
class Task extends Thread {
    private String taskName;
    
    public Task(String name) {
        this.taskName = name;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " - Step " + i);
            try {
                Thread.sleep(500); // Simulates delay
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

