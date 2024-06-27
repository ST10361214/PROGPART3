/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lab_services_student
 */
class TaskManager {
    private int taskCounter = 0;
    private List<String> taskDevelopers = new ArrayList<>();
    private List<String> taskTitles = new ArrayList<>();
    private List<String> taskIds = new ArrayList<>();
    private List<Integer> taskDurations = new ArrayList<>();
    private List<String> taskStatuses = new ArrayList<>();

    public void addTasks(String userLastName) {
        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of tasks you wish to enter:"));
        for (int i = 0; i < numberOfTasks; i++) {
            String taskTitle = JOptionPane.showInputDialog(null, "Enter Task Title:");
            String taskDescription = JOptionPane.showInputDialog(null, "Enter Task Description (max 50 characters):");
            while (taskDescription.length() > 50) {
                taskDescription = JOptionPane.showInputDialog(null, "Description should not exceed 50 characters. Please re-enter Task Description:");
            }
            if (taskDescription.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No description was added. Task not captured.");
                continue;
            }
            String taskAuthor = JOptionPane.showInputDialog(null, "Enter Author of the Task:");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Task Duration (in hours):"));
            String[] statuses = {"To Do", "Doing", "Done"};
            String selectedStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status", "Task Status", JOptionPane.PLAIN_MESSAGE, null, statuses, statuses[0]);
            taskCounter++;
            String taskId = generateTaskId(taskTitle, taskCounter, userLastName);

            taskDevelopers.add(taskAuthor);
            taskTitles.add(taskTitle);
            taskIds.add(taskId);
            taskDurations.add(taskDuration);
            taskStatuses.add(selectedStatus);

            StringBuilder taskInfo = new StringBuilder("Task ID: " + taskId + "\n");
            taskInfo.append("Title: ").append(taskTitle).append("\n");
            taskInfo.append("Description: ").append(taskDescription).append("\n");
            taskInfo.append("Status: ").append(selectedStatus).append("\n");
            taskInfo.append("Author: ").append(taskAuthor).append("\n");
            taskInfo.append("Duration: ").append(taskDuration).append(" hours\n");
            JOptionPane.showMessageDialog(null, "Task successfully captured!\n\n" + taskInfo.toString());
        }
    }

    public void displayTaskStatus() {
        String[] statuses = {"To Do", "Doing", "Done"};
        String selectedStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status", "Task Status", JOptionPane.PLAIN_MESSAGE, null, statuses, statuses[0]);
        StringBuilder taskList = new StringBuilder("Tasks in " + selectedStatus + ":\n");
        for (int i = 0; i < taskTitles.size(); i++) {
            if (taskStatuses.get(i).equals(selectedStatus)) {
                taskList.append("Task Title: ").append(taskTitles.get(i)).append("\n");
                taskList.append("Developer: ").append(taskDevelopers.get(i)).append("\n");
                taskList.append("Duration: ").append(taskDurations.get(i)).append(" hours\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, taskList.toString());
    }

    private String generateTaskId(String taskTitle, int taskNumber, String userLastName) {
        return taskTitle.substring(0, Math.min(taskTitle.length(), 3)).toUpperCase() + ":" + taskNumber + ":" + userLastName.substring(Math.max(0, userLastName.length() - 3)).toUpperCase();
    }
}