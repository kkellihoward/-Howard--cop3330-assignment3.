
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Kelli Howard
 */


package ex43;

import java.io.*;
import java.util.Scanner;
public class WebsiteGenerator
{
    public static void main(String[] args)
    {

        //setting scanner
        Scanner input = new Scanner(System.in);

        //setting sitename as a string and reading user input of site name
        System.out.print("Site name: ");
        String siteName = input.nextLine();

        //setting string and reading user input on author name
        System.out.print("Author: ");
        String author = input.nextLine();

        //setting variable and reading in into for js
        System.out.print("Do you want a folder for JavaScript? ");
        char javascript = input.next().charAt(0);

        //setting variable and reading in into for css
        System.out.print("Do you want a folder for CSS? ");
        char css = input.next().charAt(0);

        //setting directory
        String Path = System.getProperty("user.dir");
        Path += "\\"+siteName;

        File website = new File(Path);

        //creating new website directory
        boolean websiteCreated = website.mkdir();

        //using if statement to print out base on user input or print out folder not created
        if(websiteCreated)
        {
            System.out.println("Created " + Path);
            try
            {
                //using skeleton write to create outline for web
                FileWriter skeletonWriter = new FileWriter(Path+"\\index.html");


                skeletonWriter.write("<doctype html>\n<html lang=\"en\">\n<head>\n");

                skeletonWriter.write("\t<author=\""+author+"\">\n");

                //writing the title w site name formatted
                skeletonWriter.write("\t<title>"+siteName+"</title>\n");

                skeletonWriter.write("</head>\n<body>\n\n</body>\n</html>");

                skeletonWriter.close();

                //printing out succesful path for the skeleton
                System.out.println("Created " + Path+"\\index.html");

                //if user inputs yes, create java folder
                if(javascript == 'y' || javascript == 'Y')
                {
                    File javascriptFolder = new File(Path+"\\JavaScript");
                    //creating js folder path
                    boolean javascriptCreated = javascriptFolder.mkdir();
                    if(javascriptCreated)
                    {
                        System.out.println("Created " + javascriptFolder+"\\");
                    }
                    //if user does not type yes using else statemnt to print folder is not created
                    else
                    {
                        System.out.println("JavaScript folder not created!!");
                    }
                }
                //if statement to print out css file or not
                if(css == 'y' || css == 'Y')
                {
                    File cssFolder = new File(Path+"\\css");
                    //creating css folder path
                    boolean cssCreated = cssFolder.mkdir();
                    if(cssCreated)
                    {
                        //if path is valid print createde css folder
                        System.out.println("Created " + cssFolder+"\\");
                    }
                    else
                    { //if not, print not created
                        System.out.println("CSS folder not created!!");
                    }
                }
            }


            catch(IOException e)
            {
                System.out.println("index.html not created as required!!");
            }
        }
        else
        {
            //printing out flolder not created if not following directory
            System.out.println("Website folder not created!!");
        }
        input.close();
    }
}