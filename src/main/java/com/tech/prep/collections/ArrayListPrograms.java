package com.tech.prep.collections;

import java.util.*;

public class ArrayListPrograms {

  public static void main(String[] args){

    
  }

  /*
  This method would do the following
    a. Convert a array into ArrayList.
    b. Remove duplicates from ArrayList.
    c. Count frequency of each element in ArrayList.
    d. Sort ArrayList
    e. Reverse ArrayList
  */
  public void ALremoveDupsSortandReverse(){

        Integer[] a = {23,23,5,1,2,398,89,34,56,65,5,398,1};
        
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a));
        
        
        Set<Integer> lhset = new LinkedHashSet<>();
        
        lhset.addAll(list);
        
        list.clear();
        
        list.addAll(lhset);
        
        Collections.reverse(list);
        Collections.sort(list);
        
        System.out.println(list);
    
  }

}
