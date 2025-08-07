
import java.util.*;
import java.util.stream.Collectors;

public class DevCodingQuestions {

	public static void groupAnagramsInSubList() {

		List<String> input = List.of("eat", "tea", "tan", "ate", "nat", "bat");

		Map<String, List<String>> map = new HashMap();

		map = input.stream().collect(Collectors.groupingBy(x -> {
			char[] ch;
			ch = x.toCharArray();
			Arrays.sort(ch);
			return String.valueOf(ch);
		}));

		// map.values() returns Collection<T>
		// in below case it return Collection<List<String>>
		List<List<String>> listOfAnagrams = new ArrayList(map.values());

		listOfAnagrams.forEach(System.out::println);

		System.out.println("Try programiz.pro");
	}

	public static void HighestSumOfSubArray(String[] args) {

		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		int currentMax = nums[0];
		int maxSoFar = nums[0];

		for (int i = 1; i < nums.length; i++) {
			currentMax = Math.max(currentMax + nums[i], nums[i]);
			maxSoFar = Math.max(currentMax, maxSoFar);
		}

		System.out.println(maxSoFar);

		System.out.println("Try programiz.pro");
	}

	public static void HighestSumOfSubArrayAndPrintSubArray() {

		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		int currentMax = nums[0];
		int maxSoFar = nums[0];

		int start = 0;
		int end = 0;

		for (int i = 1; i < nums.length; i++) {

			if (currentMax + nums[i] > nums[i]) {
				currentMax = currentMax + nums[i];
			} else {
				currentMax = nums[i];
				start = i;
			}

			if (currentMax > maxSoFar) {
				maxSoFar = currentMax;
				end = i;
			}

		}

		System.out.println(maxSoFar);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, start, end + 1)));

		System.out.println("Try programiz.pro");
	}

	public static void FindLengthAndPrintLongestSubString() {

		String str = "abcabcbb";

		int left = 0;
		int start = 0;
		int maxLen = 0;

		Set<Character> seen = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {

			while (seen.contains(str.charAt(i))) {
				seen.remove(str.charAt(left));
				left++;
			}
			seen.add(str.charAt(i));

			if (i - left + 1 > maxLen) {
				maxLen = i - left + 1;
				start = left;

			}
		}
		System.out.println(str.substring(start, start + maxLen));
		System.out.println(maxLen);

		System.out.println("Try programiz.pro");
	}

	public static void parenthesisValidator() {
		String str = "";

		Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');

		Deque<Character> stack = new ArrayDeque<>();
		boolean isValid = true;

		for (char ch : str.toCharArray()) {
			if (map.containsValue(ch)) {
				stack.push(ch); // opening bracket
			} else if (map.containsKey(ch)) {
				// closing bracket
				if (stack.isEmpty() || stack.peek() != map.get(ch)) {
					isValid = false;
					break;
				}
				stack.pop();
			}
		}

		System.out.println(isValid && stack.isEmpty() ? "True" : "False");
	}

	public static void maximumSumOfSubArrayOfSizeK(String[] args) {
		int[] arr = { 2, 1, 5, 1, 3, 2 };
		int maxSum = 0;
		int windowSum = 0;
		int k;

		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();

		for (int i = 0; i < k; i++) {
			maxSum = maxSum + arr[i];
		}

		windowSum = maxSum;
		for (int j = k; j < arr.length; j++) {
			windowSum = windowSum + arr[j] - arr[j - k];
			if (windowSum > maxSum) {
				maxSum = windowSum;
			}
		}

		System.out.println(maxSum);
		System.out.println("Try programiz.pro");
	}

	public static void shortedSubArrayWhereSumGreterThanEqualToTarget() {

		int[] a = { 2, 3, 1, 2, 4, 3 };
		int t = 7;
		int left = 0;
		int sum = 0;
		int wSum = 0;
		int size = 0;

		for (int i = 0; i < a.length; i++) {

			wSum = wSum + a[i];

			while (wSum >= t) {
				if (i - left + 1 < size || size == 0) {
					sum = wSum;
					size = i - left + 1;
				}
				wSum = wSum - a[left];
				left++;
			}

		}

		System.out.println(sum);
		System.out.println(size);
		System.out.println("Try programiz.pro");
	}

	public static void longestSubStringWithUtmostKcharacters(String[] args) {
		String str = "eceba";
		int k = 2;

		// Everything in a single method
		if (str == null || str.isEmpty() || k == 0) {
			System.out.println("");
			return;
		}

		int l = 0; // Left pointer
		int s = 0; // Start index of longest substring
		int size = 0; // Length of longest substring
		Map<Character, Integer> map = new HashMap<>();

		for (int r = 0; r < str.length(); r++) {
			map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 0) + 1);

			// Shrink window until at most k distinct characters remain
			while (map.size() > k) {
				char leftChar = str.charAt(l);
				map.put(leftChar, map.get(leftChar) - 1);
				if (map.get(leftChar) == 0)
					map.remove(leftChar);
				l++;
			}

			// Update maximum window size
			if (r - l + 1 > size) {
				size = r - l + 1;
				s = l;
			}
		}

		System.out.println(str.substring(s, s + size));
	}
	
    public static void longestSubstringWithEachCharacterRepeatingAtomstKtimes(String[] args) {
        
        //Longest Substring with All characters repeating at most k times
        // Example to test:
        // Input:  "aaabbc", k = 2
        // Expected Output: "aabbc" (length = 5)
        
        String str = "aaabbc";
        
        int l=0;
        int s=0;
        int k=2;
        int size=0;
        
        Map<Character,Integer> map = new HashMap();
        
        for(int r=0;r<str.length();r++){
            char ch = str.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            while(map.get(ch)>k){
                char left = str.charAt(l);
               map.put(left,map.getOrDefault(left,0)-1); 
               l++;
            }
            
            if(r-l+1>size){
                size=r-l+1;
                s=l;
            }
        }
        
        System.out.println(str.substring(s,s+size));
        System.out.println("Try programiz.pro");
    }
    
public static void main(String[] args) {
        
        //int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] arr = {1,2,3,4,5,6,7,8};
        int k=3;
        
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for(int r=0;r<arr.length;r++){
            
            while(!deque.isEmpty() && deque.peekFirst()<=r-k){
                deque.pollFirst();
            }
            
            while(!deque.isEmpty() && arr[deque.peekLast()]<arr[r]){
                System.out.println(deque);
                deque.pollLast();
                System.out.println(deque);
            }
            
            deque.addLast(r);
            
            if(r>=k-1){
                list.add(arr[deque.peekFirst()]);
            }
            
        }
        
        System.out.println(list);
        System.out.println("Try programiz.pro");
    }

}
