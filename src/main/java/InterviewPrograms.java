import java.util.Scanner;



/*
 * 1. pyramidPrinitng
 * 2. 
 * */
public class InterviewPrograms {

	public void pyramidPrinitng() {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" "); // play with space to rearrange pattern
			}
			for (int k = 0; k < 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("Try programiz.pro");
	}
	
	public void armstrongNumber() {
	    Scanner sc = new Scanner(System.in);
	    int l,num,n = sc.nextInt();
	    num=n;
	    l=String.valueOf(n).length();
	    int sum =0;
	    while(n!=0){
	        sum = sum + (int)(Math.pow(n%10,l));
	        n = n/10;
	    }
	    
	    if(sum==num){
	        System.out.println(n);
	        System.out.println(sum);
	        System.out.println("Armstrong");
	    }
	    else{
	        System.out.println(n);
	        System.out.println(sum);
	        System.out.println("Not a Armstrong");
	    }
	        System.out.println("Try programiz.pro");
	}
	
}
