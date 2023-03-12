package com.company;

import java.util.ArrayList; //imports array list library

public class Student {
    private String name; //Declares: 'name' private instance variable of type string
    private String department; //Declares: 'department' private instance variable as type string
    private int age; //Declares: 'age' private instance var as type integer
    private String userName; //Declares: 'username' private instance var as type string
    private long studentNumber; //Declares: 'student number' private instance var as type long
    private boolean fullTime; //Declares: 'full time or part time' private instance var as type boolean
    public ArrayList<Grade> grades;
    //Declares: a public ArrayList to the student class called grades. grades should store objects of the type Grade.

    //Constructor: sets each of the variables from the 'Student' class when a new student object is created
    public Student(String name, String department, int age, String userName, long studentNumber, boolean fullTime) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.userName = userName;
        this.studentNumber = studentNumber;
        this.fullTime = fullTime;
    }

    public String toString() {
        return "Name: " + name + "\n" + "Department: " + department.toUpperCase() + "\n" + "Age: " + age + "\n" + "Username: " + userName.toUpperCase() + "\n" + "Student Number: " + studentNumber + "\n" + "Full-Time: " + fullTime + "\n" + "\n" + "Module Scores & Grades (" + name + "): " + "\n" + "\n" + grades + "----------------------------------------------------------------" + "\n" + "\n";
        /*This method returns a string representation of the of the object. Which in this case is the objects in the
        Student class that i have put into this method (name, age, the output of the getAverageGrade method, and the
        students grades which is stored as type Grade in the contents of the "grades" array list.)*/
    }

    public Boolean hasFailed() {
        //This method returns true if the student has a score less than 40 on any module.
        for (Grade grade : this.grades) {
            if (grade.getScore() < 40) return true;
        }
        //Returns false if the student failed no modules.
        return false;
    }

    public char getAverageGrade() {
        double sum = 0;
        //Declares: a variable called sum of type double to store the combined scores of the student.
        for (Grade grade : this.grades) {
            sum += grade.getScore();    /*Adds all the students scores together into the variable "sum" by using the
            getScore method from the Grade class which is only accessible as we called the constructor Grade.*/
        }
        double avg = sum / this.grades.size();  //Declares: a new variable called avg of type double.
        // The variable "avg" is used to store the combined scores of each student after being divided by the amount
        // of modules that the student has in the grades array list.
        return Grade.getLetterGrade(avg);
        /* This private method in the Student class gets the average lettered grade of each student. It does this by
        returning the result of passing the students average score (avg) into the getLetterGrade method which is stored
        in the class Grade. */
    }

    public String getName() { //getter for name
        return this.name;
    }

    public void setName(String newName) { //setter for name
        this.name = newName;
    }

    public String getDepartment() { //getter for department
        return this.department;
    }

    public void setDepartment(String newDepartment) { //setter for department
        this.department = newDepartment;
    }

    public int getAge() { //getter for age
        return this.age;
    }

    public void setAge(int newAge) { //setter for age
        this.age = newAge;
    }

    public String getUserName() { //getter for username
        return this.userName;
    }

    public void setUserName(String newUserName) { //setter for username
        this.userName = newUserName;
    }

    public long getStudentNumber() { //getter for student number
        return this.studentNumber;
    }

    public void setStudentNumber(long newStudentNumber) { //setter for student number
        this.studentNumber = newStudentNumber;
    }

    public boolean getFullTime() { //getter for full-time/part-time
        return this.fullTime;
    }

    public void setFullTime(boolean newFullTime) { //setter for full-time/part-time
        this.fullTime = newFullTime;
    }
}