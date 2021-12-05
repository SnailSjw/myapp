package com.snailjw.demo;

import java.util.ArrayList;

/**
 * 员工类
 *
 * @author : snail
 * @date : 2021-12-03 22:55
 **/
public class Employee {
    private static int nextId = 1;

    private String name;
    private int id;
    private double salary;

    public Employee(String name,double salary) {
        setId();
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void main(String[] args) {
        Employee tim = new Employee("Tim",12000);
        Employee hary = new Employee("Hary",14000);
        swap(tim,hary);
        /**
         * 如果Java中的引用类型是按照地址引用的话，那应该在交换了两个对象的引用后，他们的引用会变，但实际上没变。
         *
         */
        System.out.println("--------------------");
        System.out.println("tim = " + tim);
        System.out.println("hary = " + hary);

        ArrayList<Employee> employees = new ArrayList<>(100);
        employees.add(hary);
        employees.set(0,tim);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }

    /**
     * 交换两个对象的引用
     * @param a
     * @param b
     */
    public static void swap(Employee a, Employee b){
        System.out.println(a);
        System.out.println(b);
        Employee temp;
        temp = a;
        a =b;
        b = temp;
        System.out.println("========================");
        System.out.println(a);
        System.out.println(b);
    }
}
