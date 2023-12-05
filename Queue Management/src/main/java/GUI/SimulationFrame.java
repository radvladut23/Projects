package GUI;

import Bussines_logic.SimulationManager;
import Model.Server;
import Model.Task;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationFrame {
    private JFrame frame;
    private JTextArea serverTextArea;
    private JTextArea taskTextArea;
    private JTextField noOfServersTextField;
    private JTextField noOfClientsTextField;
    private JTextField timeLimitTextField;
    private JTextField minArrivalTextField;
    private JTextField maxArrivalTextField;
    private JTextField minServiceTextField;
    private JTextField maxServiceTextField;
    public SimulationFrame() {
        frame = new JFrame("Simulation Frame");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel serverPanel = new JPanel(new GridLayout(0, 1));
        serverTextArea = new JTextArea();
        serverTextArea.setEditable(false);
        serverPanel.add(new JLabel("Servers:"));
        serverPanel.add(serverTextArea);

        JPanel taskPanel = new JPanel(new BorderLayout());
        taskTextArea = new JTextArea();
        taskTextArea.setEditable(false);
        taskPanel.add(new JLabel("Generated Tasks:"), BorderLayout.NORTH);
        taskPanel.add(new JScrollPane(taskTextArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 5));
        noOfServersTextField = new JTextField("");
        noOfClientsTextField = new JTextField("");
        timeLimitTextField = new JTextField("");
        minArrivalTextField = new JTextField("");
        maxArrivalTextField = new JTextField("");
        minServiceTextField = new JTextField("");
        maxServiceTextField = new JTextField("");
        inputPanel.add(new JLabel("Number of servers:"));
        inputPanel.add(noOfServersTextField);
        inputPanel.add(new JLabel("Number of clients:"));
        inputPanel.add(noOfClientsTextField);
        inputPanel.add(new JLabel("Time limit:"));
        inputPanel.add(timeLimitTextField);
        inputPanel.add(new JLabel("Minimum arrival time:"));
        inputPanel.add(minArrivalTextField);
        inputPanel.add(new JLabel("Maximum arrival time:"));
        inputPanel.add(maxArrivalTextField);
        inputPanel.add(new JLabel("Minimum service time:"));
        inputPanel.add(minServiceTextField);
        inputPanel.add(new JLabel("Maximum service time:"));
        inputPanel.add(maxServiceTextField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int noOfServers = Integer.parseInt(noOfServersTextField.getText());
                int noOfClients = Integer.parseInt(noOfClientsTextField.getText());
                int timeLimit = Integer.parseInt(timeLimitTextField.getText());
                int minArrival = Integer.parseInt(minArrivalTextField.getText());
                int maxArrival = Integer.parseInt(maxArrivalTextField.getText());
                int minService = Integer.parseInt(minServiceTextField.getText());
                int maxService = Integer.parseInt(maxServiceTextField.getText());
                SimulationManager gen= new SimulationManager(noOfServers, noOfClients, timeLimit, minArrival, maxArrival, minService, maxService);
                Thread t= new Thread(gen);
                t.start();
            }
        });
        buttonPanel.add(startButton);

        mainPanel.add(serverPanel, BorderLayout.WEST);
        mainPanel.add(taskPanel, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void updateFrame(List<Server> servers, List<Task> generatedTasks, BufferedWriter bufferedWriter, int currentTime) {
        StringBuilder serverTextBuilder = new StringBuilder();
        serverTextBuilder.append("Time " + currentTime + "\n");
        for (Server server : servers) {
            serverTextBuilder.append("Server ").append(server.getId())
                    .append(": ");
            if (server.getTasks().size() == 0) {
                serverTextBuilder.append("closed");
            } else {
                for (Task task : server.getTasks()) {
                    serverTextBuilder.append("(" + task.getId() + "," + task.getArrivalTime() + "," + task.getServiceTime() + ") ");
                }
            }
            serverTextBuilder.append("\n");
        }
        serverTextArea.setText(serverTextBuilder.toString());
        try {
            bufferedWriter.write("\n" + serverTextBuilder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuilder taskTextBuilder = new StringBuilder();
        for (Task task : generatedTasks) {
            taskTextBuilder.append("Task ").append(task.getId())
                    .append(": arrival time=").append(task.getArrivalTime())
                    .append(", service time=").append(task.getServiceTime()).append("\n");
        }
        taskTextArea.setText(taskTextBuilder.toString());
        try {
            bufferedWriter.write("\n" + taskTextBuilder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
