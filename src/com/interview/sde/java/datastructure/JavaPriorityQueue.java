package com.interview.sde.java.datastructure;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-priority-queue/problem
class Student implements Comparable<Student> {
    String name;
    double cgpa;
    int id;

    public Student(String name, double cgpa, int id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Student student) {
        int compareResult = Double.compare(student.getCgpa(), getCgpa());
        if (compareResult == 0) {
            compareResult = this.getName().compareTo(student.getName());
            if (compareResult == 0) {
                compareResult = Double.compare(getId(), student.getId());
            }
        }
        return compareResult;
    }
}

class Priorities {
    public ArrayList<Student> getStudents(List<String> events) {
        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>();
        for (String event : events) {
            String[] s = event.split("\\s");
            if (s.length > 1) {
                studentPriorityQueue.add(new Student(s[1], Double.parseDouble(s[2]), Integer.parseInt(s[3])));
            } else {
                studentPriorityQueue.poll();
            }
        }
        while (studentPriorityQueue.size() > 1) {
            System.out.println(studentPriorityQueue.poll().getName());
        }
        return new ArrayList<>(studentPriorityQueue);
    }
}

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}



