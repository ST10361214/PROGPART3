/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

import javax.swing.JOptionPane;

/**
 *
 * @author lab_services_student
 */
public class UserLogin {
    private String storedUsername;
    private String storedPassword;
    private String firstName;
    private String lastName;

    public UserLogin() {}

    public static void main(String[] args) {
        UserLogin userLogin = new UserLogin();
        userLogin.showMenu();
    }

    public void showMenu() {
        String[] options = {"Register", "Login", "Exit"};
        String choice = (String) JOptionPane.showInputDialog(null, "Login Management System Menu", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        switch (choice) {
            case "Register":
                UserRegistration userRegistration = new UserRegistration();
                userRegistration.registerUser();
                break;
            case "Login":
                authenticateUser();
                break;
            case "Exit":
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                showMenu();
                break;
        }
    }

    private void authenticateUser() {
        String inputUsername = JOptionPane.showInputDialog(null, "Enter Your Username:");
        String inputPassword = JOptionPane.showInputDialog(null, "Enter Your Password:");
        if (inputUsername.equals(storedUsername) && inputPassword.equals(storedPassword)) {
            JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName + "! It is great to see you again.");
            boolean keepRunning = true;
            while (keepRunning) {
                String[] loggedInOptions = {"Add Tasks", "Show Task Status", "Quit"};
                String loggedInChoice = (String) JOptionPane.showInputDialog(null, "Logged In Menu", "Menu", JOptionPane.PLAIN_MESSAGE, null, loggedInOptions, loggedInOptions[0]);
                switch (loggedInChoice) {
                    case "Add Tasks":
                        TaskManager taskManager = new TaskManager();
                        taskManager.addTasks(lastName);
                        break;
                    case "Show Task Status":
                        TaskManager taskStatus = new TaskManager();
                        taskStatus.displayTaskStatus();
                        break;
                    case "Quit":
                        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Quit", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            keepRunning = false;
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                        break;
                }
            }
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
            showMenu();
        }
    }
}