package com.ccyang.array.util;

/**
 * @author ccyang
 * @date 2018/8/19 21:22
 */
public class Student {
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score:%s)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> arrs = new Array<>();
        arrs.addLast(new Student("cc1", 60));
        arrs.addLast(new Student("cc2", 80));
        arrs.addLast(new Student("cc3", 70));
        System.out.println(arrs);
    }
}
