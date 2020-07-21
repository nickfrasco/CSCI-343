package hw2;


//Used some help from online in terms of prime number formulas

import java.util.*;
public class PrimeNumbers {
    public static void main(String[] args){
    	
    	Scanner in = new Scanner(System.in);
    	int x;
    	int r=0;
    	int number = in.nextInt();
        
    	for(int i=0;i<number;i++){
        	x = in.nextInt();
        	
        	if (x==2||x==3){
        		r++; }
        	
        	for (int p=2;p*p<x;p++){
        		
        		if(x%p==0){
        			break; }
        		
        		else if((p+1)*(p+1)>x){
        			r++; }
        	}
        }
        System.out.println(r);

    }
}