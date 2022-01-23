package com.company;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;


public class StudentTest {


    @Rule
    public ExpectedException exception = ExpectedException.none();


    Student student1 = new Student("Ion", 20, 332, "0730556651");
    Student student2 = new Student("Alex", 30, 332, "0730556651");
    Student student3 = new Student("Andrei", 25, 332, "0730556651");
    Student student4 = new Student("Stefan", 18, 332, "0730556651");


    @Test
    public void sumAgesOfStudents(){
        int sumAges = Student.sumAgesOfTwoStudents(student1, student2);
        assertThat(sumAges, equalTo(50));
    }

    @Test
    public void sumAgesCrossCheck(){
        int sumAges = Student.sumAgesOfTwoStudents(student3, student4);
        int sumAgesSwitch = Student.agesOpertions(student3,student4,"+");
        assertEquals(sumAges, sumAgesSwitch);
    }

    @Test
    public void checkSumByDifference(){
        int sum = Student.agesOpertions(student1, student2, "+");
        assertEquals(sum-student1.getAge(), student2.getAge());
    }

    @Test
    public void timeElapsedIsLowerThan20secs() throws IOException {
        long startTime = System.nanoTime();
        Student.writeFilesWithStudentName("D:\\Downloads\\CIMProject\\src\\com\\company\\listOfStudents.txt");
        long stopTime = System.nanoTime();
        assertTrue(stopTime-startTime < 20000000000L);
    }

    @Test
    public void checkIfFilesCreated(){
        File file1 = new File("D:\\Downloads\\CIMProject\\Alex.txt");
        File file2 = new File("D:\\Downloads\\CIMProject\\Gabi.txt");
        File file3 = new File("D:\\Downloads\\CIMProject\\Ion.txt");
        File file4 = new File("D:\\Downloads\\CIMProject\\Stefan.txt");
        assertTrue(file1.exists());
        assertTrue(file2.exists());
        assertTrue(file3.exists());
        assertTrue(file4.exists());
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        ArrayList<Student> studentList = new ArrayList<>();
        Student.getStudentNrX(studentList, 0);
    }

    @Test
    public void testPhoneNumberBig(){
        assertFalse(Student.validPhoneNumber(07305566511));
    }

    @Test
    public void testPhoneNumberSmall(){
        assertFalse(Student.validPhoneNumber(073055));
    }

    @Test
    public void testPhoneNumberNull(){
        assertFalse(Student.validPhoneNumber(-1231231231));
    }

    @Test(expected = FileNotFoundException.class)
    public void fileNotFoundReadStudents() throws FileNotFoundException {
        Student.readStudentsFromFile("blabla.txt");
    }

    @Test(expected = FileNotFoundException.class)
    public void fileNotFoundReadNumberOfStudents() throws FileNotFoundException {
        Student.readNumberOfStudentsFromFile("blabla.txt");
    }

    @Test(expected = NullPointerException.class)
    public void NPEReadNumberOfStudents() throws FileNotFoundException {
        Student.readNumberOfStudentsFromFile(null);
    }

    @Test
    public void readNumberOfStudentFromFile() throws FileNotFoundException {
        int nrOfStudents = Student.readNumberOfStudentsFromFile
                ("D:\\Downloads\\CIMProject\\src\\com\\company\\listOfStudents.txt");
        assertEquals(nrOfStudents, 4);
    }

    @Test(expected = NullPointerException.class)
    public void NPEReadStudents() throws FileNotFoundException {
        Student.readStudentsFromFile(null);
    }

    @Test
    public void readStudentFromFile() throws FileNotFoundException {
        ArrayList<String> students = Student.readStudentsFromFile("D:\\Downloads\\CIMProject\\src\\com\\company\\listOfStudents.txt");
        List<String> studentList = Arrays.asList("Ion", "Alex", "Gabi", "Stefan");
        assertEquals(students,studentList);
    }

    @Test
    public void listOfStudentsTest(){
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        assertEquals(Student.listOfStudentsWithAgesBetween(studentList, 0, 100).size(),4);
    }


    @Test(expected = FileNotFoundException.class)
    public void writeFilesWithWrongName() throws IOException {
        Student.writeFilesWithStudentName("blabla.txt");
    }

    @Test(expected = NullPointerException.class)
    public void NPElistOfStudentsTest(){
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        assertEquals(Student.listOfStudentsWithAgesBetween(null, 21, 19).size(),1);
    }

    @Test(expected = NullPointerException.class)
    public void writeFileWithNullName() throws IOException {
        Student.writeFilesWithStudentName(null);
    }


    @Test
    public void multiplyAgesOfTwoStudentsTest(){
        int multiply = Student.multiplyAgesOfTwoStudents(student1,student2);
        assertEquals(multiply, 600);
    }

    @Test(expected = NullPointerException.class)
    public void getPhoneNumberNPETest(){
        Student student = new Student("ionel", 23, 12, null);
        student.getPhoneNumber();
    }

    @Test(expected = NullPointerException.class)
    public void setNameNPETest(){
        Student student = new Student("ionel", 23, 12, "0730556651");
        student.setName(null);
    }

    @Test(expected = NullPointerException.class)
    public void getNameNPETest(){
        Student student = new Student(null, 23, 12, "0730556651");
        student.getName();
    }

    @Test(expected = ArithmeticException.class)
    public void setAgeBelowMinimum(){
        student1.setAge(5);
    }

    @Test(expected = ArithmeticException.class)
    public void setAgeAboveMaximum(){
        student1.setAge(31);
    }

    @Test(expected = ArithmeticException.class)
    public void setClassBelowMinimum(){
        student1.setClassNr(0);
    }

    @Test(expected = ArithmeticException.class)
    public void setClassAboveMinimum(){
        student1.setClassNr(13);
    }

    @Test
    public void additionAgesOperations(){
        assertEquals(Student.agesOpertions(student1, student2, "+"), 50);
    }

    @Test
    public void differenceAgesOperations(){
        assertEquals(Student.agesOpertions(student2, student3, "-"), 5);
    }

    @Test
    public void absoluteDifferenceAgesOperations(){
        assertEquals(Student.agesOpertions(student1, student2, "-"), 10);
    }

    @Test
    public void multiplyAgesOperations(){
        assertEquals(Student.agesOpertions(student1, student2, "*"), 600);
    }

    @Test
    public void divideAgesOperations(){
        assertEquals(Student.agesOpertions(student2, student1, "/"), 1);
    }

    @Test
    public void defaultAgesOperations(){
        assertEquals(Student.agesOpertions(student2, student1, "."), -1);
    }

    @Test
    public void listOfStudentsWithAgesBetweenTest(){
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        assertEquals(Student.listOfStudentsWithAgesBetween(studentList, 19, 21).size(),1);
    }

    @Test
    public void listOfStudentsWithAgesBetweenReversedTest(){
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        assertEquals(Student.listOfStudentsWithAgesBetween(studentList, 21, 19).size(),1);
    }


}