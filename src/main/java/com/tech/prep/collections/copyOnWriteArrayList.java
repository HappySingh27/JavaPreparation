package com.tech.prep.collections;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class copyOnWriteArrayList {
	
    public static void main(String[] args) {
    	
    	coptOnWriteArrayList();
    	listConcurrentReadWrite();    	

    } //main
    
    static void coptOnWriteArrayList() {

        
        List<String> list = new CopyOnWriteArrayList<>(Arrays.asList("Banana","Milk","Tea","Bread","Wheat"));
        
        for(String str : list){
            if(str.equals("Milk")){
                list.add("Shampoo");
            }
            
        }
        

        System.out.println("coptOnWriteArrayList");
    	
    } //coptOnWriteArrayList
    
     static void listConcurrentReadWrite() {
    	
    	
        List<String> list = new ArrayList<>(Arrays.asList("Banana","Milk","Tea","Bread","Wheat"));
        
        
        for(String str : list){
            if(str.equals("Milk")){
                list.add("Shampoo");
            } //if
            
        } //for
    	
    } // listConcurrentReadWrite

} // class
