package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
    private BlockingQueue<Task> tasks;
    private  AtomicInteger waitingPeriod;
    private int server_id;
    public Server(int maxTaskPerServer,int id)
    {
      this.waitingPeriod=new AtomicInteger(0);
      tasks=new LinkedBlockingQueue<>(maxTaskPerServer);
        server_id=id;
    }
    public synchronized void addTask(Task newTask)
    {
      tasks.add(newTask);
      waitingPeriod.addAndGet(newTask.getServiceTime());
    }
    public int getWaitingPeriod()
    {
        return waitingPeriod.get();
    }

    public void run() {
        while (true) {
            synchronized (tasks) {
                if (!this.tasks.isEmpty()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Task task = tasks.peek();
                    waitingPeriod.addAndGet(-1);
                    task.setServiceTime(task.getServiceTime() - 1);
                    if (task.getServiceTime() == 0)
                        tasks.remove(task);
                }
            }
        }
    }
    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

    public int getId() {
        return server_id;
    }
}
