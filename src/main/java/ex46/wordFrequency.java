
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Kelli Howard
 */
package ex46;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class wordFrequency {

    public static ArrayList<String> str = new ArrayList<>();
    public static ArrayList<String> strNew = new ArrayList<>();
    public static ArrayList<String> uniques = new ArrayList<>();
    public static ArrayList<Integer> uniquesCounter = new ArrayList<>();


    public static void string_counter() {
        int counters = 0;

        for (String unique : uniques) {
            for (String s : strNew) {
                if (unique.equals(s)) {
                    counters++;
                }
            }
            uniquesCounter.add(counters);
            counters = 0;
        }

        for(int i = 0; i < uniques.size(); i++) {
            System.out.print(uniques.get(i)+" ");
            for(int j = 0; j < uniquesCounter.get(i); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void unique_list_builder() {

        // Loop through the ArrayList str which holds the initial scrape of the text file
        for (String s : str) {

            // Each line is stored individually, so we split them by spaces
            String[] splitted = s.split("\\s+");

            // Once split, we store each string individually in a new ArrayList
            Collections.addAll(strNew, splitted);
        }

        // Loop through the new ArrayList and add all unique words to another new ArrayList
        for (String s : strNew) {
            if (uniques.contains(s)) {
            } else {
                uniques.add(s);
            }
        }

        string_counter();
    }

    public static void file_pull() {
        // Try to open the file
        try {
            FileInputStream fstream = new FileInputStream("exercise46_input.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            // Try reading the file line by line
            try {
                while ((strLine = br.readLine()) != null)   {
                    str.add(strLine);
                }

                // If successful above, parse the newly read data
                unique_list_builder();

            }
            catch(IOException ex){
                System.out.println(ex);
            }

            try {
                fstream.close();
            }
            catch(IOException ex) {
                System.out.println(ex);
            }
        }
        catch(FileNotFoundException ex){
            System.out.println(ex);
        }
    }

    public static void main(String[] arg){
        file_pull();
    }
}
