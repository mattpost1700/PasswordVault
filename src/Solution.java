/*
 *   Christian Overton (cto5068@psu.edu) & Amish Prajapati (avp5564@psu.edu)
 *   Assignment 2
 *   CMPSC 444
 *   09/26/19
 */

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        PasswordVault passwordVault = new PasswordVault();

        System.out.println("Welcome to password master 5000 mark 24!");

        try {
            FileReader reader = new FileReader("data.txt");
            reader.close();
            passwordVault.login();
        } catch (FileNotFoundException e) {
            passwordVault.signUp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
