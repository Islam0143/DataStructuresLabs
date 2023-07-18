import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.System;
public class Solution {
	public int[] moveValue(int[] array, int value) {
    	/*
        	Implement your method here
        */
        int counter=0;
        for(int i=0;i<array.length-counter;i++){
            if(array[i]==value){
                for(int j=i;j<array.length-1;j++){
                    array[j]=array[j+1];
                }
                array[array.length-1-counter]=value;
                counter++;
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
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            
            for(int i = 0; i < s.length; ++i)
               arr[i] = Integer.parseInt(s[i]);
        }
        int value = sc.nextInt();
        int[] res = new Solution().moveValue(arr,value);
        res = new Solution().moveValue(arr,value);
        System.out.print("[");
          for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i]);
            if(i != arr.length - 1)
              System.out.print(", ");
        }
        System.out.print("]");
    }
}