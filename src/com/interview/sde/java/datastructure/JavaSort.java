package com.interview.sde.java.datastructure;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-sort/problem
public class JavaSort {
    static class Student implements Comparable<Student> {
        private final int id;
        private final String fname;
        private final double cgpa;

        public Student(int id, String fname, double cgpa) {
            super();
            this.id = id;
            this.fname = fname;
            this.cgpa = cgpa;
        }

        public int getId() {
            return id;
        }

        public String getFname() {
            return fname;
        }

        public double getCgpa() {
            return cgpa;
        }

        @Override
        public int compareTo(Student student) {
            int compareResult = Double.compare(student.getCgpa(), getCgpa());
            if (compareResult == 0) {
                compareResult = this.fname.compareTo(student.fname);
                if (compareResult == 0) {
                    compareResult = Double.compare(getId(), student.getId());
                }
            }
            return compareResult;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        studentList.sort(Student::compareTo);
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}



