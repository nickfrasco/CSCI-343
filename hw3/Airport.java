//found a really pretty example of a function using booleans online and wanted to try it out. 
//Not sure if i implemented in correct way
//There's a lot of white space in my "if" functions just because it's easier for me to read while working!

package hw3;
import java.util.*;
public class Airport {
	
	public static void main(String[] args) {
		Random rn = new Random();
		
		Queue<String> takeoff = new LinkedList<>();
		Queue<String> landing = new LinkedList<>();
		
		
		int in = 0, out = 0, inAtTake = 0, outAtTake = 0, TimeTake = 0, TimeLand = 0, numberOfLand = 0, numberOfTakeoffs = 0;
		String plane = "Plane number";
		
		//boolean runway1availible = true;										//played around here
		//boolean runway2availible = true;										//
		
		
		for (int i =0 ; i<=120 ; i+=5) //120 minutes. change to simulate differently
		{
			if (rn.nextBoolean()) {												//next boolean function scans the next token of the input into a boolean value and returns that value
				landing.add(plane + i/5 + " @ time: "+ i); in = i; }			//change to @time
			
			if (rn.nextBoolean()) {
			takeoff.add(plane + i/5 + " @ time: "+ i);inAtTake = i; }			//change to @time
		
		if (i%15 == 0 ) 	
		{	
			if(landing.peek() != null) 
			{
				landing.poll();
				numberOfLand++;
			
		}
		
		else if (takeoff.peek() != null)
		{
			takeoff.poll();													//poll function returns the element at the front of the container or the head of the Queue
			numberOfTakeoffs++;												
		}
		
				}
				if(i%15 == 0 ) 	
				{	
					if(landing.peek() != null) 
					{
						landing.poll();
						numberOfLand++;
						out=i;
						
					}
					else if (takeoff.peek() != null)
					{
						takeoff.poll();
						numberOfTakeoffs++;
						out = i;
					}
					
					
				}
				TimeLand += in-out;
				TimeTake += inAtTake-outAtTake;
			}
		
			System.out.println("Total number of landings completed: " + numberOfLand);
			System.out.println("Total number of takeoffs completed: "+ numberOfTakeoffs);
			System.out.println("Average waiting time (Takeoff): " + TimeLand/numberOfLand);
			System.out.println("Average waiting time (Landings): " + TimeTake/numberOfTakeoffs);
			System.out.println("Landing number "+ landing);
			System.out.println("Takeoff number "+ takeoff);
		}

	}

