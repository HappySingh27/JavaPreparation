package com.tech.prep.collections;



import java.util.*;
class comparableStudent implements Comparable<comparableStudent>{
	int roll_no;
	String name;
	Double cgpa;
	
	public comparableStudent(int roll_no, String name, Double cgpa) {
		super();
		this.roll_no = roll_no;
		this.name = name;
		this.cgpa = cgpa;
	}
	
	@Override
	public int compareTo(comparableStudent obj1){
	    return Double.compare(this.cgpa,obj1.cgpa);
	}
	
	@Override
	public String toString(){
	    return roll_no + ":" + name + ":" + cgpa;
	}
	
 public static void main(String[] args) {
     
     List<comparableStudent> list = new ArrayList<>();
     
     list.add(new comparableStudent(5,"Ajey",7.9));
     list.add(new comparableStudent(2,"Amar",7.8));
     list.add(new comparableStudent(1,"Jay",7.0));
     list.add(new comparableStudent(3,"Sunny",8.5));
     
     System.out.println("Before Sort : " + list);
     list.sort(null);
     //list.sort((a,b) -> a.roll_no - b.roll_no);
     System.out.println("After Sort  : " + list);
     
     System.out.println("Try programiz.pro");
 }
}
