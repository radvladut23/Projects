package Model;

public class Task {
    private int id;
    private int arrivalTime;
    private int serviceTime;

    public Task(int i, int arrivalTime, int serviceTime) {
        this.id=id;
        this.arrivalTime=arrivalTime;
        this.serviceTime=serviceTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public int getArrivalTime()
    {
        return arrivalTime;
    }

    public void setTaskId(int i) {
        this.id=i;
    }



    public int getId() {
        return id;
    }

    public void setServiceTime(int i)
    {
        this.serviceTime = i;
    }
}
