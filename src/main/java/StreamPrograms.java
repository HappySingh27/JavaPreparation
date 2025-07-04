/*
 * 1. Given a list of integers, separate odd and even numbers?
 * 2. How do you remove duplicate elements from a list using Java 8 streams?
 * 3. How do you find frequency of each character in a string using Java 8 streams?
 * 4. How do you find frequency of each element in an array or a list?
 * 5. How do you sort the given list of decimals in reverse order?
 * 6. Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
 * 7. From the given list of integers, print the numbers which are multiples of 5?
 * 8. Given a list of integers, find maximum and minimum of those numbers?
 * 9. How do you merge two unsorted arrays into single sorted array using Java 8 streams?
 * 10) How do you merge two unsorted arrays into single sorted array without duplicates?
 * 11) How do you get three maximum numbers and three minimum numbers from the given list of integers?
 * 12) Java 8 program to check if two strings are anagrams or not?
 * 13) Find sum of all digits of a number in Java 8?
 * 14) Find second largest number in an integer array?
 * 15) Given a list of strings, sort them according to increasing order of their length?
 * 16) Given an integer array, find sum and average of all elements?
 * 17) How do you find common elements between two arrays?
 * 18) Reverse each word of a string using Java 8 streams?
 * 19) How do you find sum of first 10 natural numbers?
 * 20) Reverse an integer array
 * 21) Print first 10 even numbers
 * 22) How do you find the most repeated element in an array?
 * 23) Palindrome program using Java 8 streams
 * 24) Given a list of strings, find out those strings which start with a number?
 * 25) How do you extract duplicate elements from an array?
 * 26) Print duplicate characters in a string?
 * 27)Find first repeated character in a string?
 * 28)Find first non-repeated character in a string?
 * 29) Fibonacci series
 * 29) Fibonacci series
 * 31) How do you get last element of an array?
 * 32. Sort Map based on Keys using stream
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.util.stream.Collectors;

public class StreamPrograms {

	public static void main(String[] args) {

	} // main method

	// 1. Given a list of integers, separate odd and even numbers?
	public void StreamOddEvenInteger() {

		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

		Map<Boolean, List<Integer>> map = listOfIntegers.stream().collect(Collectors.partitioningBy(x -> x % 2 == 1));

		map.entrySet().stream().forEach(x -> {
			System.out.println("-------------");
			System.out.println(x.getKey() ? "Even Numbers" : "Odd Numbers");
			System.out.println("-------------");
			x.getValue().forEach(System.out::println);
		});

	}

	// 2. How do you remove duplicate elements from a list using Java 8 streams?
	public void StreamDistinctStringsInList() {

		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");

		listOfStrings.stream().distinct().forEach(System.out::println);

	}

	// 3. How do you find frequency of each character in a string using Java 8
	// streams?
	public void StreamOccurenceOfCharacters() {

		String str = "palindrooome";

		Map<Character, Long> map = str.chars().mapToObj(x -> (char) x)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(map);
	}

	// 4. How do you find frequency of each element in an array or a list?
	public void StreamFrequencyElementInList() {

		List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler",
				"Note Book", "Pencil");

		Map<String, Long> map = stationeryList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(map);
	}

	// 5. How do you sort the given list of decimals in reverse order?
	public void StreamSortDecimalList() {

		List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

		decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

	}

	// 6. Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as
	// suffix
	// and ‘,’ as delimiter?
	public void StreamJoinStringWithPrefixSuffixDelim() {

		List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");

		String str = listOfStrings.stream().collect(Collectors.joining(",", "[", "]"));

	}

	// 7. From the given list of integers, print the numbers which are multiples of
	// 5?
	public void StreamPrintMultiplesOfFive() {

		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

		listOfIntegers = listOfIntegers.stream().filter(x -> x % 5 == 0).toList();

		System.out.println(listOfIntegers);
	}

	// 8. Given a list of integers, find maximum and minimum of those numbers?
	public void StreamMinMaxFromList() {

		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

		Optional<Integer> op = listOfIntegers.stream().max(Comparator.naturalOrder());
		System.out.println("Max : " + op.get());

		int min = listOfIntegers.stream().max(Comparator.reverseOrder()).get();
		System.out.println("Min : " + min);

	}

	// 9. How do you merge two unsorted arrays into single sorted array using Java 8
	// streams?
	public void streamMergeTwoUnsortedArrayIntoOne() {

		int[] a = new int[] { 4, 2, 7, 1 };
		int[] b = new int[] { 8, 3, 9, 5 };

		List<Integer> list = Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed()).sorted().toList();

		System.out.println(list);

	}

	// 10) How do you merge two unsorted arrays into single sorted array without
	// duplicates?
	public void streamMergeAndSortTwoUnsortedIntegerArray(String[] args) {

		int[] a = new int[] { 4, 2, 5, 1 };

		int[] b = new int[] { 8, 1, 9, 5 };

		int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().toArray();

		System.out.println(Arrays.toString(c));
		System.out.println("Try programiz.pro");
	}

	// 11) How do you get three maximum numbers and three minimum numbers from the
	// given list of integers?
	public void streamMinMax3(String[] args) {

		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

		List<Integer> min3 = listOfIntegers.stream().sorted().limit(3).toList();
		System.out.println(min3);

		listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);

		System.out.println("Try programiz.pro");
	}

	// 12) Java 8 program to check if two strings are anagrams or not?
	public void streamAnagram(String[] args) {

		String s1 = "RaceCar";
		String s2 = "CarRace";

		s1 = s1.chars().mapToObj(x -> String.valueOf((char) x)).sorted().collect(Collectors.joining());
		s2 = Stream.of(s2.split("")).sorted().collect(Collectors.joining());

		System.out.println(s1.equals(s2));

	}

	// 13) Find sum of all digits of a number in Java 8?
	public void streamSumOfDigitsofANumber(String[] args) {

		int i = 15623;

		int l = Stream.of(String.valueOf(i).split("")).map(Integer::parseInt).collect(Collectors.summingInt(x -> x));

		System.out.println(l);
		System.out.println("Try programiz.pro");
	}

	// 14) Find second largest number in an integer array?
	public void streamSecondLargestNumberInAnIntegerArray() {
		int[] a = new int[] { 34, 12, 54, 89, 9, 90, 8, 5 };

		Integer b = Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

		System.out.println(b);
		System.out.println("Try programiz.pro");

	}

	// 15) Given a list of strings, sort them according to increasing order of their
	// length?
	public void streamSortListOfStringByLength() {
		List<String> listOfStrings = Arrays.asList("Z", "Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");

		listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

		System.out.println("Try programiz.pro");

		// default sorting order of list/array of string of stream - Lexicographically
	}

	// 16) Given an integer array, find sum and average of all elements?
	public void streamGetSumAverageOfIntStream() {

		int[] a = new int[] { 45, 12, 56, 15, 24, 75, 31, 89 };

		int sum = Arrays.stream(a).sum();

		Double avg = Arrays.stream(a).average().getAsDouble();

		System.out.print("Sum : " + sum + " | Average : " + avg);
	}

	// 17) How do you find common elements between two arrays?
	public void streamCommonElementsBtTwoArrays() {

		List<Integer> l = Arrays.asList(71, 21, 34, 89, 56, 28);
		List<Integer> m = Arrays.asList(12, 56, 17, 21, 94, 34);

		l.stream().filter(x -> m.contains(x)).forEach(System.out::println);

		System.out.println("Try programiz.pro");
	}

	// 18) Reverse each word of a string using Java 8 streams?
	public void streamReverseEachWordOfAStream() {

		String str = "Java Concept Of The Day";

		str = Arrays.stream(str.split(" ")).map(x -> new StringBuilder(x).reverse()).collect(Collectors.joining(" "));

		System.out.println(str);
		System.out.println("Try programiz.pro");
	}

	// 19) How do you find sum of first 10 natural numbers?
	public void streamFirstTenNaturalNoSum() {

		int sum = IntStream.range(1, 11).sum();

		System.out.println(sum);
		System.out.println("Try programiz.pro");
	}

	// 20) Reverse an integer array
	public void streamReverseIntegerArray() {

		int[] array = new int[] { 5, 1, 7, 3, 9, 6 };

		List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList()); // returns mutable list
		// Arrays.stream(array).boxed().toList(); // without collect toList returns
		// Immutable List.

		Collections.reverse(list);
		System.out.println("Reverse using Stream<T> : " + list);

		int[] array1 = IntStream.rangeClosed(1, array.length).map(x -> array[array.length - x]).toArray();
		// array = IntStream.rangeClosed(1, array.length).map(x -> array[array.
		// length - x]).toArray(); cannot be used like this because local variable used
		// inside
		// lambda expression should be final or effectively final

		System.out.println("Reverse using IntStream : " + Arrays.toString(array1));
	}

	// 21) Print first 10 even numbers
	public static void streamEvenNumbers() {

		int[] evenArr = IntStream.rangeClosed(2, 20).filter(x -> x % 2 == 0).toArray();
		System.out.println("Int[]    :" + Arrays.toString(evenArr));

		Object[] evenArr1 = Stream.iterate(2, x -> x + 2).limit(10).toArray();
		System.out.println("Object[] :" + Arrays.toString(evenArr1));
	}

	// 22) How do you find the most repeated element in an array?
	public static void streamMostFrequentWord() {

		String[] str = { "Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil" };

		List<String> list = new ArrayList<>(Arrays.asList(str));

		// Map<String,Long> map =
		Map.Entry<String, Long> l = list.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()))
				.entrySet().stream().sorted((a, b) -> (int) (b.getValue() - a.getValue())).findFirst().get();

		// Above can also be acheived using .max(Map.Entry.comparingByValue())

		System.out.println(l.getKey() + " : " + l.getValue());
	}

	// 23) Palindrome program using Java 8 streams
	public static void streamPalindrome() {

	}

	// 24) Given a list of strings, find out those strings which start with a
	// number?
	public void streamStringStartingWithDigit() {

		List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");

		listOfStrings.stream().filter(x -> Character.isDigit(x.charAt(0))).forEach(System.out::println);

		System.out.println("Try programiz.pro");
	}

	// 25) How do you extract duplicate elements from an array?

	public void streamExtractDupElement() {
		List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222, 111);

		listOfIntegers.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() > 1).forEach(x -> System.out.println(x.getKey()));

		listOfIntegers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.forEach((key, count) -> {
					if (count > 1) {
						System.out.println(key);
					}
				});

		Set<Integer> uniqueElements = new HashSet<>();
		Set<Integer> duplicateElements = listOfIntegers.stream().filter(i -> !uniqueElements.add(i))
				.collect(Collectors.toSet());
		System.out.println(duplicateElements);
	
	// ------------------------------------------------------//	
        int[] arr = new int[] {23,45,67,76,1,2,1,89,45,90};
        Set<Integer> set = new HashSet<>();
        
        arr =
        Arrays.stream(arr).filter(x -> !set.add(x)).toArray();
    
        System.out.println(Arrays.toString(arr));
        
    // ------------------------------------------------------//	
        
   
		System.out.println("Try programiz.pro");

	}

	// 26) Print duplicate characters in a string?

	public void streamDuplicateCharacterInString() {

		String inputString = "Java Concept Of The Daay";

		inputString = inputString.replaceAll(" ", "").toLowerCase();

		Set<String> set = new HashSet<>();
		Set<String> set1 = new HashSet<>();

		Object[] arr = Arrays.stream(inputString.split("")).filter(x -> !set.add(x)).distinct().toArray();

		set1 = Arrays.stream(inputString.split("")).filter(x -> !set.add(x)).collect(Collectors.toSet());

		System.out.println("distinct : " + Arrays.toString(arr));
		System.out.println("toSet    : " + Arrays.toString(arr));
		System.out.println("Try programiz.pro");

	}

	// 27)Find first repeated character in a string?
	public void streamFirstRepeatedCharacterInString() {

		String inputString = "Java Concept Of The Daay";

		inputString = inputString.replaceAll(" ", "").toLowerCase();

		Set<String> set = new HashSet<>();
		Set<String> set1 = new HashSet<>();

		Object[] arr = Arrays.stream(inputString.split("")).filter(x -> !set.add(x)).limit(1).toArray();

		set.clear();
		set1 = Arrays.stream(inputString.split("")).filter(x -> !set.add(x)).limit(1).collect(Collectors.toSet());

		System.out.println("distinct : " + Arrays.toString(arr));
		System.out.println("toSet    : " + set1);
		System.out.println("Try programiz.pro");

		/*
		 * String inputString = "Java Concept Of The Day".replaceAll("\\s+",
		 * "").toLowerCase();
		 * 
		 * Map<String, Long> charCountMap = Arrays.stream(inputString.split(""))
		 * .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
		 * Collectors.counting()));
		 * 
		 * String firstRepeatedChar = charCountMap.entrySet() .stream() .filter(entry ->
		 * entry.getValue() > 1) .map(entry -> entry.getKey()) .findFirst() .get();
		 * 
		 * System.out.println(firstRepeatedChar);
		 */
	}

	// 28)Find first non-repeated character in a string?

	public void streamFindFirstNonRepetitiveCharacter() {

		String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();

		String nR = Arrays.stream(inputString.split(""))
				.collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() == 1).findFirst().get().getKey();

		System.out.println(nR);
		System.out.println("Try programiz.pro");

	}

	// 29) Fibonacci series
	public void streamFibonacciSeries() {

		Stream.iterate(new int[] { 0, 1 }, x -> new int[] { x[1], x[0] + x[1] }).map(x -> x[0]).limit(10)
				.forEach(x -> System.out.println(x));

	}

	// 30) First 10 odd numbers
	public void streamFirst10oddNumbers() {

		Stream.iterate(1, x -> x + 2).limit(10).forEach(System.out::println);
	}

	// 31) How do you get last element of an array?
	public void streamLastElementOFArray() {
		List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");

		String str = listOfStrings.stream().reduce((a, b) -> b).get();

		System.out.println(str);
		System.out.println("Try programiz.pro");

		/*
		 * String lastElement = listOfStrings.stream().skip(listOfStrings.size() -
		 * 1).findFirst().get(); System.out.println(lastElement);
		 * 
		 */
	}
	
    public void sortMapUsingStream() {
        
        Map<String, Integer> studentMap = new HashMap<String, Integer>();
         
        studentMap.put("Jyous", 87);
        studentMap.put("Klusener", 82);
        studentMap.put("Xiangh", 91);
        studentMap.put("Lisa", 89);
        studentMap.put("Narayan", 95);
        studentMap.put("Arunkumar", 86);
        
        Map<String,Integer> map = new LinkedHashMap<>();
        
        map = 
        studentMap.entrySet().stream().sorted((x,y) -> x.getKey().length() - y.getKey().length()).collect(
            Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (x,y) -> x,
                LinkedHashMap::new));
        
        System.out.println(map);
        
        System.out.println("Try programiz.pro");
        //----------------------------------------//
        

        //----------------------------------------//
    }
    
    public static void factorial() {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // reduce(1,(a,b) -> a*b)
        // a - accumulator
        // b - current item of stream
        // 1 - intial accumulator, changes it's value to see results for better understanding
        n = 
        IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
        System.out.println(n);
        
        System.out.println("Try programiz.pro");
    }

}
