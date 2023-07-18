import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public int[][] transpose(int[][] array) {
    	/*
        	Implement your method here
        */
        for(int i=0;i<array[0].length;i++){
            for(int j=0;j<array[0].length;j++){
                if(i<j){
                    array[i][j]=array[i][j]^array[j][i];
                    array[j][i]=array[i][j]^array[j][i];
                    array[i][j]=array[i][j]^array[j][i];
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");;
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty()){
            arr = new int[]{};
            System.out.print("[[]]");
            System.exit(0);
        }
        else {
            
            for(int i = 0; i < s.length; ++i)
               arr[i] = Integer.parseInt(s[i]);
        }
        int n = (int)Math.sqrt(arr.length);
        int[][] square = new int[n][n];
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                square[i][j]=arr[index++];
            }
        }
        int[][] res = new Solution().transpose(square);
        System.out.print("[");
        for(int i=0;i<n;i++) {
            System.out.print("[");
            for(int j=0;j<n;j++){
                System.out.print(square[i][j]);
                if(j != n-1)
                    System.out.print(", ");
            }
            System.out.print("]");
            if(i != n-1)
                System.out.print(", ");
        }
        System.out.print("]");
    }
}