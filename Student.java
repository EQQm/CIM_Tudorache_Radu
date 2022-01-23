package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String name;
    private int age;
    private int classNr;
    private String phoneNumber;

    public Student(String name, int age, int classNr, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.classNr = classNr;
        setPhoneNumber(phoneNumber);
    }

    public Student(){}

    public String getName() {
        if(name != null) {
            return name;
        }
        else throw new NullPointerException();
    }

    public void setName(String name) {
        if(name != null) {
            this.name = name;
        }
        else throw new NullPointerException();
    }

    public String getPhoneNumber() {
        if(phoneNumber != null) {
            return phoneNumber;
        }
        else throw new NullPointerException();
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid phone number");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 6 && age <30){
            this.age = age;
        } else {
            throw new ArithmeticException();
        }
    }

    public int getClassNr() {
        return classNr;
    }

    public void setClassNr(int classNr) {

        if(classNr > 0 && age <=12){
            this.classNr = classNr;
        } else {
            throw new ArithmeticException();
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", classNr=" + classNr +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static int readNumberOfStudentsFromFile(String fileName) throws FileNotFoundException {
        int numberOfEntries = 0;
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                numberOfEntries++;
            }
            myReader.close();

        return numberOfEntries;
    }

    public static ArrayList<String> readStudentsFromFile(String fileName) throws FileNotFoundException {
        ArrayList<String> nameStudents = new ArrayList<>();
        File myObj = new File(fileName);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            nameStudents.add(data);
        }
            myReader.close();

        return nameStudents;
    }

    public static void writeFilesWithStudentName(String filename) throws IOException {
        long startTime = System.nanoTime();
        ArrayList<String> studentsName = readStudentsFromFile(filename);
        for(String studentName: studentsName) {
                File myObj = new File(studentName+".txt");
                if (myObj.createNewFile()) {
                        FileWriter myWriter = new FileWriter(studentName + ".txt");
                        for (long i = 0; i < 100000000L; i++) {
                            myWriter.write(studentName);
                        }
                        myWriter.close();


                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }

            }
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
        }


    public static boolean validPhoneNumber(int phoneNumber){
        String phoneNumberString = Integer.toString(phoneNumber);
        return ((phoneNumber < 0) && (phoneNumberString.length() == 10));
    }

    public static int sumAgesOfTwoStudents(Student a, Student b){
        return a.getAge() + b.getAge();
    }

    public static int multiplyAgesOfTwoStudents(Student a, Student b){
        return a.getAge() * b.getAge();
    }

    public static int agesOpertions(Student a, Student b, String operator){
        int result = 0;
        switch (operator){
            case "+":
                result = a.getAge() + b.getAge();
                break;
            case "*":
                result = a.getAge() * b.getAge();
                break;
            case "-":
                result = Math.abs(a.getAge() - b.getAge());
                break;
            case "/":
                result = a.getAge() / b.getAge();;
                break;
            default:
                return -1;
        }
        return result;
    }

    public static Student getStudentNrX(ArrayList<Student> students, int number){
        ArrayList<Student> studentList = new ArrayList<>();
        return studentList.get(number);
    }

    public static ArrayList<Student> listOfStudentsWithAgesBetween(ArrayList<Student> students, int minimum, int maximum){
        ArrayList<Student> studentList = new ArrayList<>();
        for (Student s : students){
            if ((s.getAge() >= minimum && s.getAge() <=maximum)
            || (s.getAge() <= minimum && s.getAge() >=maximum)){
                studentList.add(s);
            }
        }
        return studentList;
    }
}
