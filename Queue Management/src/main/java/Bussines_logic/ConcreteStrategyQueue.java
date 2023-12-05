package Bussines_logic;

import Model.Server;
import Model.Task;

import java.util.List;

public class ConcreteStrategyQueue implements Strategy{

    @Override
    public void addTask( List<Server> servers, Task task) {

        Server minServer = servers.get(0);
        for (Server server : servers) {
            if (server.getWaitingPeriod() < minServer.getWaitingPeriod()) {
                minServer = server;
            }
        }
        if (minServer!=null)
        {
            System.out.println("Queue");
            minServer.addTask(task);
        }
    }
}
