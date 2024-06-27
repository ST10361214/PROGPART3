/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.registration;

import javax.swing.JOptionPane;

/**
 *
 * @author lab_services_student
 */
class UserRegistration {
    private String firstName;
    private String lastName;
    private String createdUsername;
    private String createdPassword;
    private String storedUsername;
    private String storedPassword;

    public void registerUser() {
        firstName = JOptionPane.showInputDialog(null, "Enter Your First Name");
        lastName = JOptionPane.showInputDialog(null, "Enter Your Last Name");
        createdUsername = JOptionPane.showInputDialog(null, "Create Username", "Enter Your Username: ");
        createdPassword = JOptionPane.showInputDialog(null, "Create Password", "Enter Your Password: ");
        storedUsername = createdUsername;
        storedPassword = createdPassword;
        JOptionPane.showMessageDialog(null, "Registration Successful! You can now login.");
        UserLogin userLogin = new UserLogin();
        userLogin.showMenu();
    }
}