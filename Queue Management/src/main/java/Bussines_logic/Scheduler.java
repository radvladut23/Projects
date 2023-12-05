package Bussines_logic;

import Model.Server;
import Model.Task;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> servers;
    private int maxNoServers;
    private int maxTaskPerServer;
    private Strategy strategy;
     public Scheduler(int maxNoServers, int maxTaskPerServer)
     {
         servers = new ArrayList<>();
         strategy=new ConcreteStrategyTime();
     }

     public void changeStrategy(SelectionPolicy policy)
     {
       if(policy==SelectionPolicy.SHORTEST_QUEUE)
       {
           strategy=new ConcreteStrategyQueue();
       }
         if(policy==SelectionPolicy.SHORTEST_TIME)
         {
             strategy=new ConcreteStrategyTime();
         }
     }
     public synchronized void dispatchTask(Task t)
     {
         strategy.addTask(servers, t);
     }
     public List<Server> getServers()
     {
         return servers;
     }

    public void addServer(Server server)
    {
        servers.add(server);
    }

}
