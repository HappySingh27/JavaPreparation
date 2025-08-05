
import java.util.*;

public class ArrayPrograms {

	/*
	 * 1.
	 * https://javaconceptoftheday.com/how-to-find-all-pairs-of-elements-in-an-array
	 * -whose-sum-is-equal-to-a-given-number/ 2. Occurrence of characters in String
	 * using Array
	 * 
	 */

	public static void main(String[] args) {

		// 1.
		int[] arr = { 12, 23, 125, 41, -75, 38, 27, 11 };
		int target = 50;
		findPairs(arr, target);

		// 2.
	}

	// 1.
	// https://javaconceptoftheday.com/how-to-find-all-pairs-of-elements-in-an-array-whose-sum-is-equal-to-a-given-number/
	public static void findPairs(int[] arr, int target) {
		Set<Integer> seen = new HashSet<>();
		Set<String> printed = new HashSet<>(); // To avoid printing duplicates

		for (int num : arr) {
			int complement = target - num;

			if (seen.contains(complement)) {
				// To ensure uniqueness, sort pair before adding to printed set
				int low = Math.min(num, complement);
				int high = Math.max(num, complement);
				String pair = low + "," + high;

				if (!printed.contains(pair)) {
					System.out.println("(" + low + ", " + high + ")");
					printed.add(pair);
				}
			}

			seen.add(num);
		}
	}

	// 2. Occurrence of characters in String using Array
	public static void characterOccurenceUsingArray(String[] args) {
		String str = "HanumanChaudhary".toLowerCase();

		int[] arr = new int[26];
		char ch;

		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (arr[i] != 0) {
				ch = (char) ('a' + i);
				System.out.print(ch + " = " + arr[i] + ", ");
			}
		}

	}

	// 3. Occurrence of characters in String using loops only and without using any
	// data structure not even Arrays
	public static void characterOccurenceUsingForLoopOnly(String[] args) {
		String str = "HanumanChaudhary".toLowerCase();

		for (char ch = 'a'; ch <= 'z'; ch++) {
			int count = 0;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ch) {
					count++;
				}
			}

			if (count > 0) {
				System.out.println(ch + " = " + count);
			}
		}
	}

	public static void firstNonRepeatingNumberInAnArray(String[] args) {

		int[] arr = { 12, 23, 44, 3, 22, 12, 23 };

		Map<Integer, Integer> map = new LinkedHashMap<>();

		for (int i : arr) {

			// int converted to Integer - Autoboxing
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {

				System.out.println(entry.getKey());
				break;
			}
		}

		System.out.println("Try programiz.pro");
	}

}
