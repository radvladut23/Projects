package Bussines_logic;

import GUI.SimulationFrame;
import Model.Server;
import Model.Task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SimulationManager implements Runnable{

    public int timeLimit=16;
    public int maxProccessingTime=10;
    public int minProcessingTime=2;
    public int noOfClients=3;
    public int noOfServers=3;
    private int maxArrivalTime=10;
    private int minArrivalTime=1;
    public SelectionPolicy selectionPolicy=SelectionPolicy.SHORTEST_TIME;
    private Scheduler scheduler;
    private SimulationFrame frame;
    private List<Task> generatedTasks;
    private int maxTaskPerServer=1000;
    public SimulationManager(int noOfServers, int noOfClients, int timeLimit, int minArrival, int maxArrival, int minService, int maxService)
    {
        this.noOfServers=noOfServers;
        this.noOfClients=noOfClients;
        this.timeLimit=timeLimit;
        this.minArrivalTime=minArrival;
        this.maxArrivalTime=maxArrival;
        this.minProcessingTime=minService;
        this.maxProccessingTime=maxService;
        scheduler = new Scheduler(noOfServers, maxTaskPerServer);
        // Create and start numberOfServers threads
        for (int i = 0; i < noOfServers; i++) {
            Server server = new Server(maxTaskPerServer,i+1);
            Thread thread = new Thread(server);
            thread.start();
            scheduler.addServer(server);
        }
        // Initialize selection strategy
        Strategy selectionStrategy = new ConcreteStrategyTime();
        scheduler.changeStrategy(selectionPolicy);

        // Initialize frame to display simulation
        frame = new SimulationFrame();
        // Generate numberOfClients clients using generateNRandomTasks() and store them to generatedTasks
        generatedTasks = generateNRandomTasks(noOfClients);
    }
    public List<Task> generateNRandomTasks(int noOfClients)
    {
        List<Task> tasks = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < noOfClients; i++) {
            int arrivalTime = minArrivalTime+random.nextInt(maxArrivalTime-minArrivalTime);
            int serviceTime = minProcessingTime+random.nextInt(maxProccessingTime-minProcessingTime);
          tasks.add(new Task(i + 1, arrivalTime, serviceTime));
        }
        tasks.sort(Comparator.comparingInt(Task::getArrivalTime));
        int i=1;
        for(Task t:tasks)
        {
            t.setTaskId(i);
            i++;
        }
        return tasks;
    }

    @Override
    public void run() {
        int currentTime = 0;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("Output.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        while (currentTime < timeLimit) {
            List<Task> tasksToRemove = new ArrayList<>();
            Iterator<Task> iterator = generatedTasks.iterator();
            while (iterator.hasNext()){
                Task task = iterator.next();
                if (task.getArrivalTime() == currentTime) {
                    scheduler.dispatchTask(task);
                    tasksToRemove.add(task);
                }
            }
            generatedTasks.removeAll(tasksToRemove);
            frame.updateFrame(scheduler.getServers(), generatedTasks,bufferedWriter,currentTime);
            currentTime++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args)
    {
        new SimulationFrame();
    }
}
