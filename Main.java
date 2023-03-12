package com.company;

import java.util.ArrayList; //imports array list library
import java.util.Scanner; //imports scanner library

public class Main {
    public static final String RED = "\033[0;31m"; //Declares: 'RED' as private const which stores the red colour value.
    public static final String RESET = "\033[0m";  //Declares: 'RESET' as private const which stores the default colour value for text.
    private static ArrayList<Student> students = new ArrayList<Student>();
    //Declares: ArrayList as a private static variable in the main class
    private static Object[][] studentTestData = {
            //Nested multi-dimensional array containing each students data, and their scores for each subject
            {"Bert Smith", "computing", 21, "bsmit001", 12345, true, new Object[][]{
                    {"programming", 52},
                    {"web dev", 63},
                    {"maths", 76},
                    {"algorithms", 68}
            }},
            {"Olivia Green", "computing", 19, "ogree001", 12346, true, new Object[][]{
                    {"programming", 73},
                    {"web dev", 82},
                    {"maths", 72},
                    {"algorithms", 66}
            }},
            {"Eloise Jones", "computing", 18, "ejone001", 12347, true, new Object[][]{
                    {"programming", 65},
                    {"web dev", 63},
                    {"maths", 37},
                    {"algorithms", 40}
            }},
            {"Ben Bird", "computing", 42, "bbird001", 12348, false, new Object[][]{
                    {"programming", 55},
                    {"web dev", 29},
                    {"maths", 56},
                    {"algorithms", 38}
            }},
            {"Karen Brown", "computing", 25, "kbrow002", 12349, false, new Object[][]{
                    {"programming", 62},
                    {"web dev", 51},
                    {"maths", 43},
                    {"algorithms", 43}
            }}
    };

    public static void main(String[] args) {
        for (int i = 0; i < studentTestData.length; i++) {
            Object[] data = studentTestData[i];
            Object[][] gradesData = (Object[][]) data[6];
            Student student = new Student((String) data[0], (String) data[1], (Integer) data[2], (String) data[3], (Integer) data[4], (Boolean) data[5]);
            student.grades = new ArrayList<Grade>();

            for (int j = 0; j < gradesData.length; j++) {
                Object[] grade = gradesData[j];
                student.grades.add(new Grade((String) grade[0], (Integer) grade[1]));
            }
            students.add(student);
            //Loop to add the students in the student array list.
        }

        Scanner scanChoice = new Scanner(System.in);
        //Makes new object of the scanner class and stores it in the variable scanChoice
        int menuChoice;     //Declares: menuChoice as an variable of type integer in the main method of the main class.

        do {
            System.out.println("\n" + "1: Full Report Of All Students");
            System.out.println("2: Names Of All Students With A Failed Module");
            System.out.println("3: Average Grade For Each Student");
            System.out.println("4: Quit Program" + "\n");
            System.out.println("----------------------------------------------");
            System.out.println("Enter Option:  \"1\", \"2\", \"3\" or \"4\"");
            menuChoice = scanChoice.nextInt();
            //The menuChoice variable stores the next integer entered by the user and uses it for the switch statement

            //Switch statement for the student record systems menu
            switch (menuChoice) {
                case 1:
                    // Option 1
                    System.out.println("\n" + "Report Of All Students Including Lettered Grades For Each Module: " + "\n");
                    System.out.println("-----------------------------------------------------------------" + "\n");
                    System.out.println(students);
                    //Prints a report of all the students data including the lettered grades for each module score
                    /*By using a method called toString() where if the object reference is called, the method returns
                    a string representation of the object/s which in this case is the objects in the student class that
                    I have put in the toString() method.*/
                    break;
                case 2:
                    // Option 2
                    System.out.println("\n" + "All Students With Failed Modules:");
                    System.out.println("---------------------------------" + "\n");
                    for (Student student: students) {
                        if (student.hasFailed()) {
                        System.out.println(RED + student.getName() + RESET);
                        }
                    }
                    System.out.println("\n" + "---------------------------------");
                    /*Returns the names of all students with failed modules in red text by using the hasFailed() method
                    along with the getName() getter method, and the constants RED and RESET.
                     */
                    break;
                case 3:
                    // Option 3
                    System.out.println("\n" + "Average Grade For Each Student:");
                    System.out.println("---------------------------------" + "\n");
                    for (Student student: students) {
                            System.out.println(student.getName() + " - Average Grade: " + student.getAverageGrade());
                    }
                    System.out.println("\n" + "---------------------------------");
                    /*Prints the average grade for each student by using the getName() getter method and the
                    getAverageGrade() method to determine this.*/
                    break;
                case 4:
                    // Option 4
                    System.out.println("Bye...");
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 4.");
                    //Message output if the user input is not in the specified range or of the correct type.
            }
        } while (menuChoice != 4);
        /*This "Do While" loop means that when the variable menuChoice is not equal to 4 it will remain in the
        switch statement (4 is the option in the menu to quit)*/
    }
}