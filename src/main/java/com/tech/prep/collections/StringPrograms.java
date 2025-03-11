package com.tech.prep.collections;

import java.util.*;

/*
 * 1. reverseStringUsing_charAt()
 * 2. reverseStringUsing_charAt()
 * 3. reverseStringUsing_stringBuilder()
 * 4. reverseStringwithoutChangingPositionOfWords
 * 5. palindrome()
 * 6. firstNonRepeatingChar_usingMap
 * 7. firstNonRepeatingChar_usingForLoop()
 * 8. countOccurenceOfCharacterInString
 * 9. anagram()
 * 10. removeDigitsFromString
 * 11. removeSpecialCharFromString
 * 12. stringContainsOnlyDigits
 * 13. removeDuplicatesFromString
 * 14. removeDuplicatesFromStringWithoutCollections
 * 15. removeAllOccurencesofACharFromString
 * 15. 
 * 16. 
 * */

public class StringPrograms {

	String st = "My name is Happy";
	int i, j;

	public static void main(String[] args) {

		StringPrograms sp = new StringPrograms();

		// Reversing the String using chatAt() method of String
		sp.palindrome();

	} // main

	void reverseStringUsing_charAt() {

		String rev = "";

		for (i = st.length() - 1; i >= 0; i--) {
			rev = rev + st.charAt(i);
		}

		System.out.println(rev);

	} // reverseStringUsing_charAt

	void reverseStringUsing_toCharArray() {

		char temp;

		String st = "My name is Happy";

		char[] rev = st.toCharArray();

		i = 0;
		j = rev.length - 1;

		while (i < j) {
			temp = rev[i];
			rev[i] = rev[j];
			rev[j] = temp;

			i++;
			j--;
		}

		System.out.println(rev);

	} // reverseStringUsing_toCharArray

	void reverseStringUsing_stringBuilder() {

		String st = "My name is Happy";

		String rev = new StringBuilder("My name is Happy").reverse().toString();

		System.out.println(st);

	} // reverseStringUsing_stringBuilder
	
	void reverseStringwithoutChangingPositionOfWords() {

		String str = "this is 2025 march";

		String[] strSplit = str.split(" ");

		int i = 0;
		for (String str1 : strSplit) {
			strSplit[i] = new StringBuilder(str1).reverse().toString();
			i++;
		}

		str = String.join(" ", strSplit);

		System.out.println(str);

	}

	void palindrome() {

		Scanner sc = new Scanner(System.in);

		String st = sc.nextLine();

		String rev = new StringBuilder(st).reverse().toString();

		if (st.equals(rev)) {
			System.out.println(st + " is a palindrome");
		} else {
			System.out.println(st + " is not a palindrome");
		}

	} // palindrome

	void firstNonRepeatingChar_usingMap() {
		String str = "swiwsis";

		char[] cha = str.toCharArray();

		Map<Character, Integer> map = new LinkedHashMap<>();

		for (char ch : cha) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		// Study Iterable()
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println(entry.getKey());
				break;

			} // if

		} // for
	} // firstNonRepeatingChar_usingMap

	void firstNonRepeatingChar_usingForLoop() {

		String st = "comedian";

		int i, j, flag;

		for (i = 0; i < st.length(); i++) {
			flag = 0;
			for (j = 0; j < st.length(); j++) {

				if ((st.charAt(i) == st.charAt(j)) && (i != j)) {

					flag = 1;
					break;
				}

			} // j

			if (flag == 0) {
				System.out.println(st.charAt(i));
				break;
			} // if

		} // i

	} // onRepeatingChar_usingForLoop

	void countOccurenceOfCharacterInString() {
		String str = "ComedianOfJungle";

		char[] chStr = str.toCharArray();

		Map<Character, Integer> map = new LinkedHashMap<>();

		for (char ch : chStr) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());

		}
		
		StringBuilder s = new StringBuilder();
	

	} // countOccurenceOfCharacterInString

	void anagram() {

		String str1 = "rescue";
		char[] ch1 = str1.toCharArray();
		String str2 = "secure";
		char[] ch2 = str2.toCharArray();

		Arrays.sort(ch1);
		Arrays.sort(ch2);

		if (Arrays.equals(ch1, ch2)) {
			System.out.println("Anagram");
		}

		str1 = new String(ch1);
		// ch1.toString(); -> this will not work
		str2 = new String(ch2);
		// ch2.toString(); -> this will not work

		if (str1.equals(str2))
			System.out.println("Anagram");

	} // anagram

	// Learn Regex, String operations becomes super easy using Regex.
	void removeDigitsFromString() {
		System.out.println("Hello World");

		String str = "4cejfj4ebDB4EDBfjebeiEFNEI463JCBEJR646b7";

		char[] chStr = str.toCharArray();

		for (char ch : chStr) {
			if (((int) (ch)) >= '0' && ((int) (ch)) <= '9') {
				// Strings are immutable in java, therefore need to store it again in a String
				str = str.replace(ch, ' ');
			} // if
		} // for

		// Strings are immutable in java, therefore need to store it again in a String
		str = str.replaceAll(" ", "");

		System.out.println(str);
	} // rremoveDigitsFromString

	void removeSpecialCharFromString() {

		String str = "aB1@dE3#fG$hI5^jK&LmN7*pO(Q)qR8_sT+UvW9=xY!zZ0";

		str = str.replaceAll("[^a-zA-Z0-9]", "");

		System.out.println(str);
	} // removeSpecialCharFromString

	void stringContainsOnlyDigits() {
		String str = "7653455679";
	

		// better way is to use str.matches() method
		str = str.replaceAll("^\\d+$", "");
		str = str.isEmpty() ? "Contains only Digits" : "Does not contains only Digits";

		System.out.println(str);

	} // stringContainsOnlyDigits

	void removeDuplicatesFromString() {

		String str = "ueytiuresjbjawuireyiwscsjuweirw";

		char[] chStr = str.toCharArray();

		Set<Character> set = new LinkedHashSet<>();

		for (char ch : chStr) {
			set.add(ch);
		}

		str = "";
		for (char ch : set) {
			str = str + ch;
		}

		System.out.println(str);

	}

	void removeDuplicatesFromStringWithoutCollections() {
		/*
		 * Complete this
		 */
	}

	void removeAllOccurencesofACharFromString() {
		/*
		 * Complete this
		 */
	}
	
	void findingAllsubStrings() {
		
        String str = "abc";
        int i,j;
        
        ArrayList<String> list = new ArrayList<>();
        
        for(i=0;i<str.length();i++){
            for(j=i+1;j<str.length()+1;j++){
                list.add(str.substring(i,j));
            } //j
        } //i
        
        for(String s : list){
            System.out.println(s);
        }
	}
	
	void findlongestPalindromeSubString() {

		String str = "ababa";
		String str1;
		int i, j;

		Map<String, Integer> map = new LinkedHashMap<>();

		for (i = 0; i < str.length(); i++) {
			for (j = i + 1; j < str.length() + 1; j++) {
				str1 = str.substring(i, j);
				if (new StringBuilder(str1).reverse().toString().equals(str1)) {
					map.put(str1, str1.length());
				}

			}
		}

		String maxKey = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

		System.out.println(maxKey);

	}



} // StringPrograms
