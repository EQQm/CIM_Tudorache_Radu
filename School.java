package com.company;

import java.util.List;

public class School {

    private List<Teacher> teachers;
    private static int totalSalariesPaid;

    public School(List<Teacher> teachers){
        this.teachers = teachers;
        totalSalariesPaid = 0;
    }

    public List<Teacher> getTeachers() {
        if(teachers != null) {
            return teachers;
        }
        else throw new NullPointerException();
    }

    public int getNumberOfTeachers() {
        if(teachers != null) {
            return teachers.size();
        }
        else return -1;
    }

    public void setTeachers(List<Teacher> teachers) {
        if(teachers!= null) {
            this.teachers = teachers;
        }
        else throw new NullPointerException();
    }

    public int getTotalSalariesPaid() {
        if(totalSalariesPaid < 0){
              return -1;
        } else {
            return totalSalariesPaid;
        }
    }

    public static void setTotalSalariesPaid(int totalSalariesPaid) {
        if(totalSalariesPaid < 0){
            School.totalSalariesPaid = -1;
        } else {
            School.totalSalariesPaid = totalSalariesPaid;
        }
    }

    @Override
    public String toString() {
        return "School{" +
                "teachers=" + teachers +
                "salariesPaid=" + getTotalSalariesPaid() +
                '}';
    }

    public static void updateTotalSalaries(int salary) {
        totalSalariesPaid+=salary;
        setTotalSalariesPaid(totalSalariesPaid);
    }
}
