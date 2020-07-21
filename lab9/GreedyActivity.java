
import java.io.*;
import java.util.*;


public class GreedyActivity { 
	
	
	public static void activity_selection(float[] start, float[] end, float n)
   
	{
      System.out.print("Selected activity indices: ");
      System.out.print("0 "); 
      
      float j,i=0;
      
      for (j=1; j< n; j++)
         if (start[(int) j] >= end[(int) i])
             {
               System.out.print(j+" "); //the activity j is printed
               i=j;
             }
   }
 
public static void main(String args[])
   {
      Scanner sc = new Scanner(System.in);   
      
      float i;
      
      System.out.print("Enter size of list: ");
      
      float n = sc.nextFloat();
      
      float[] start = new float[(int) n];
      float[] end = new float[(int) n];
      
      System.out.println("Enter elements with time ");
      System.out.println("Enter start time and end time simultaneously: '(start time)  (end time)' ");
      
      for(i=0;i< n;i++)
            {
               start[(int) i] = sc.nextInt();
               end[(int) i] = sc.nextInt();
            }
      activity_selection(start,end,n);
      
   }
}
