package com.company;

public class Teacher {
    private String name;
    private int salary;
    private static int salaryEarned;

    public Teacher(String name, int salary){
        this.name = name;
        this.salary = salary;
        this.salaryEarned = 0;
    }

    public String getName(){
        if(name != null) {
            return name;
        }
        else throw new NullPointerException();
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        if (salary>=0) {
            this.salary = salary;
        }
        else throw new ArithmeticException();
    }

    public void setName(String name){
        if(name != null) {
            this.name = name;
        }
        else throw new NullPointerException();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", salaryEarned=" + salaryEarned +
                '}';
    }

    public static void receiveSalary(int salary){
        if(salary < 0){
            throw new ArithmeticException();
        } else {
            salaryEarned += salary;
            School.updateTotalSalaries(salary);
        }
    }
}
