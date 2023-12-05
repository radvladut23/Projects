package Bussines_logic;

import Model.Server;
import Model.Task;

import java.util.List;

public class ConcreteStrategyTime implements Strategy{
    @Override
    public synchronized void addTask(List<Server> servers, Task task) {
        Server minServer = servers.get(0);
        double minEstimatedTime = minServer.getWaitingPeriod() + task.getServiceTime();
        for (Server server : servers) {
            double estimatedTime = server.getWaitingPeriod() + task.getServiceTime();
            if (estimatedTime < minEstimatedTime) {
                minEstimatedTime = estimatedTime;
                minServer = server;
            }
        }
        minServer.addTask(task);
    }
}
