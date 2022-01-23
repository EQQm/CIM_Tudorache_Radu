package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SchoolTest {

    Teacher teacher1 = new Teacher("Ioana", 1000);
    Teacher teacher2 = new Teacher("Dana", 2000);
    Teacher teacher3 = new Teacher("Iulia", 3000);

    ArrayList<Teacher> teacherList = new ArrayList<>(Arrays.asList(teacher1,teacher2,teacher3));

    School upb = new School(teacherList);

    @Test
    public void testUpdateTotalSalaries() {
        School.updateTotalSalaries(2000);
    }

    @Test
    public void testGetTotalSalariesPaidNegative(){
        upb.setTotalSalariesPaid(-1);
        assertEquals(upb.getTotalSalariesPaid(), -1);
    }

    @Test
    public void toStringTest(){
        assertTrue(upb.toString().contains("Dana"));
        assertTrue(upb.toString().contains("Ioana"));
        assertTrue(upb.toString().contains("Iulia"));
    }

    @Test(expected = NullPointerException.class)
    public void NPESetTeachersTest(){
        upb.setTeachers(null);
    }

    @Test
    public void getNumberOfTeachersTest(){
        int numberOfTeachers = upb.getNumberOfTeachers();
        assertEquals(numberOfTeachers, 3);
    }

    @Test
    public void testSetTotalSalariesPaidNegative(){
        upb.setTotalSalariesPaid(-1);
    }

    @Test
    public void getNumberOfTeachersEmptyTest(){
        ArrayList<Teacher> teacherList2 = null;
        School upb2 = new School(teacherList2);
        int numberOfTeachers = upb2.getNumberOfTeachers();
        assertEquals(numberOfTeachers, -1);
    }


}