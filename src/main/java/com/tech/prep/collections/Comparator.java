package com.tech.prep.collections;

import java.util.*;

public class Comparator {
	
	
	public static void main(String[] args) {
		
		ComparatorUsingLambda1();



	}
	
	public static void ComparatorUsingLambda1() {
		
		class Employee {
			int id;
			String name;
			Integer salary;

			// Constructor, Getters, Setters, and toString()
			Employee(int id, String name, Integer salary) {
				this.id = id;
				this.name = name;
				this.salary = salary;
			}

			Integer getSalary() {
				return salary;
			}

			String getName() {
				return name;
			}
		}

		ArrayList<Employee> emp = new ArrayList<>();
		emp.add(new Employee(1, "Ajey", 24500));
		emp.add(new Employee(2, "Sanu", 45000));
		emp.add(new Employee(3, "Ranu", 70000));
		emp.add(new Employee(4, "Vaibhav", 73400));
		emp.add(new Employee(5, "Swalina", 30000));

		emp.sort((a, b) -> a.getSalary() - b.getSalary());
		
		/*
		 * Sorting based on Name:-
		 * emp.sort((a, b) -> {return a.name.compareTo(b.name);});
		 * if 2 employees have same name sort based on salary
		 * */ 
		

		for (Employee e : emp) {
			System.out.println(e.getName() + " : " + e.getSalary());
		}
		
	} // ComparatorUsingLambda
} // Comparator - MainClass
