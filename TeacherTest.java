package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TeacherTest {

    Teacher teacher1 = new Teacher("Ioana", 1000);
    Teacher teacher2 = new Teacher("Dana", 2000);
    Teacher teacher3 = new Teacher("Iulia", 3000);
    ArrayList<Teacher> teacherList = new ArrayList<>(Arrays.asList(teacher1, teacher2, teacher3));

    @Test
    public void testReceiveSalary(){
        School school = new School(teacherList);
        teacher1.receiveSalary(2000);
        teacher2.receiveSalary(2000);
        teacher3.receiveSalary(2000);
        assertEquals(school.getTotalSalariesPaid(), 6000);
    }

    @Test(expected = ArithmeticException.class)
    public void testAESalary(){
        ArrayList<Teacher> teacherList2 = new ArrayList<>();
        teacherList2.add(teacher1);
        teacher1.receiveSalary(-2000);
    }

    @Test(expected = ArithmeticException.class)
    public void testAESalariesPaid(){
        School school = new School(teacherList);
        teacher1.receiveSalary(-2000);
        teacher2.receiveSalary(-2000);
        teacher3.receiveSalary(2000);
        school.getTotalSalariesPaid();
    }

    @Test(expected = ArithmeticException.class)
    public void setSalaryTest(){
        teacher1.setSalary(-1);
    }

    @Test(expected = NullPointerException.class)
    public void getNameNPETest(){
        Teacher teacherNPE = new Teacher(null, 2000);
        teacherNPE.getName();
    }

    @Test(expected = NullPointerException.class)
    public void setNameNPETest(){
        teacher1.setName(null);
    }

    @Test
    public void toStringTest(){
        assertEquals(teacher1.toString(), "Teacher{name='Ioana', salary=1000, salaryEarned=0}");
    }



}