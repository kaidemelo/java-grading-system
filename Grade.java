package com.company;

public class Grade {
    private String subject; //Declares: 'subject' private instance variable of type string
    private double score; //Declares: 'score' private instance variable of type int

    //Constructor: sets each of the variables from the 'Grade' Array List when a new grade object is created
    public Grade(String subject, double score) {
        this.subject = subject;
        this.score = score;
    }

    public String toString() {
        // public method that is used to get a string representation of the object and returns the letterGrades() method.
        return letterGrades();
    }

    public String letterGrades() {
        //Method to return the subject and grade of the user by using the getLetterGrade method, and the numberScores method.
        return "Subject: " + this.subject.toUpperCase() + "          " + " Grade: " + getLetterGrade(this.score) + "\n" + numberScores();
    }

    public String numberScores() {
        //Method to return the score of the student.
        return "                            " + " Score: " + this.score + "\n" + "\n";
    }

    public static char getLetterGrade(double score) {
        //Static method in the Grade class which returns a lettered grade of type char and passes the score in by value as a double
        char letterGrade; //Declares: 'letterGrade' variable to store the lettered grade of the student in.

        if (score >= 70) {
            //Logic to evaluate the grade the student should get from the numbered score that is entered into the method.
            letterGrade = 'A';
        } else if (score >= 60) {
            letterGrade = 'B';
        } else if (score >= 50) {
            letterGrade = 'C';
        } else if (score >= 40) {
            letterGrade = 'D';
        } else if (score < 0 || score > 100) {
            return 'E';
        } else {
            letterGrade = 'F';
        }
        return letterGrade;
        //Returns the lettered grade of the students score that was passed into the method if it has not already
    }

    public String getSubject() { //getter for subject
        return this.subject;
    }

    public void setSubject(String newSubject) { //setter for subject
        this.subject = newSubject;
    }

    public double getScore() { //getter for score
        return this.score;
    }

    public void setScore(double newScore) { //setter for score
        this.score = newScore;
    }
}