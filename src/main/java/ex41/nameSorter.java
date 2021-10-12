/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Kelli Howard
 */



package ex41;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class nameSorter {

    // Unsorted string array
    public static ArrayList<String> str = new ArrayList<>();

    public static void file_pull() {
        try {
            int i = 0;


            FileInputStream fstream = new FileInputStream("C:\\IdeaProjects\\assignment 3\\src\\exercise41_input.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            try {
                while ((strLine = br.readLine()) != null)   {
//                    System.out.println (strLine);
                    str.add(strLine);
                    i++;
                }

                Collections.sort(str);

                //printing out format and title
                System.out.print("Total of ");
                System.out.print(i);
                System.out.println(" names");
                System.out.println("-------------");
//               System.out.println(str);

                //pritning out until i=amount of words
                for(int j = 0; j < i; j++) {
                    System.out.println(str.get(j));
                }

            }
            //catch error if sthere was
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
