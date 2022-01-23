package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

	Student student1 = new Student("Ion", 20, 332, "0730556651");
	Student student2 = new Student("Alex", 30, 332, "0730556651");
	Student student3 = new Student("Andrei", 25, 332, "0730556651");
	Student student4 = new Student("Stefan", 18, 332, "0730556651");

	ArrayList<Student> studentList = new ArrayList<>();
	studentList.add(student1);
	studentList.add(student2);
	studentList.add(student3);
	studentList.add(student4);

	Teacher teacher1 = new Teacher("Ioana", 1000);
	Teacher teacher2 = new Teacher("Dana", 2000);
	Teacher teacher3 = new Teacher("Iulia", 3000);

	ArrayList<Teacher> teacherList = new ArrayList<>();
	teacherList.add(teacher1);
	teacherList.add(teacher2);
	teacherList.add(teacher3);

	School upb = new School(teacherList);

	teacher1.receiveSalary(teacher1.getSalary());

	Student.writeFilesWithStudentName("D:\\Downloads\\CIMProject\\src\\com\\company\\listOfStudents.txt");

	System.out.println(upb);
	System.out.println(new Student().readNumberOfStudentsFromFile("D:\\Downloads\\CIMProject\\src\\com\\company\\listOfStudents.txt"));

		for (Student testStudent: Student.listOfStudentsWithAgesBetween(studentList, 20, 26)) {
			System.out.println(testStudent);
		}


    }
}
