/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Kelli Howard
 */


package ex42;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class parsingData {

    public static ArrayList<String> str = new ArrayList<>();

    public static void file_pull() {
        try {
            int i = 0;
            FileInputStream fstream = new FileInputStream("C:\\IdeaProjects\\assignment 3\\src\\exercise42_input.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            try {
                while ((strLine = br.readLine()) != null)   {
                    str.add(strLine);
                    i++;
                }

                Collections.sort(str);

                System.out.print("Last\t" + "First\t" + "Salary\n");
                System.out.println("--------------------------");

                for(int j = 0; j < i; j++) {
                    System.out.println(str.get(j));
                }

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
