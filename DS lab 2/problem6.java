import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public int fibonacci(int n) {
    	// Implement your method here.
        if(n==1)
            return 0;
        else if(n==3 || n==2)
            return 1;
        else
            return fibonacci(n-1)+fibonacci(n-2);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(new Solution().fibonacci(n));
    }
}