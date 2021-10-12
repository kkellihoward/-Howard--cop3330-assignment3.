/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Kelli Howard
 */


package ex45;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// class named Modify_Example45

public class wordFinder {

    // main method

    public static void main(String[] args) throws IOException {

        // pass the path to the file as a parameter
        // make sure that path of file should be correct
        File file = new File("C:\\IdeaProjects\\assignment 3\\src\\exercise45_input.txt");
        FileWriter writer;
        try (Scanner sc = new Scanner(file)) {

            // create another Scanner object to prompt input from user via console

            Scanner s = new Scanner(System.in);

            // prompt the name of Output File from user

            System.out.print("\nEnter the name of Output File : ");

            String outputfile = s.next();

            // create a FileWriter object to write into a file
            // make sure that path of file should be correct

            writer = new FileWriter(outputfile);


            // use try to block handle exception

            try {

                // using while loop read file

                while (sc.hasNext()) {

                    // read whole line

                    String user = sc.nextLine();

                    // replace utilize by use

                    user = user.replaceAll("utilize", "use");

                    // and write into outputfile

                    writer.write(user);

                    writer.write("\n");


                }
            } finally {
                sc.close();
            }
        }

        // and close the writer file

        writer.close();

        System.out.println("\nSuccessfully Modified!!");

    }

}