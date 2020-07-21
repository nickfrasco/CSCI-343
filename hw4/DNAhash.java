package hw4;

//Used a ton of help from the web this assignment/lab including:
//Oracle, repl.it, nudge-apm, geeksforgeeks, w3schools
//I apologize if this is sloppy. It was much clearer in my head!

import java.util.*;


	public class DNAhash {
	    public static int hash(String st, int b){
	        String base = "AGCT"; 								//base string value
	        														
	        int m = 1;											
	        int idHash = 0;
	        
	        for (int w = 0; w < b; w++){
	            int context = base.indexOf(st.charAt(w));
	            idHash += context * m;
	            m *= 4; }
	        return idHash;
	    }

	    public static void main(String[] args) {
	      
	    	 
	      Scanner in = new Scanner(System.in);
	      int alpha = in.nextInt();
	      int beta = in.nextInt();
	      int size = (int)Math.pow(4,beta);
	      String countS = in.next();
	      int count = 0;
	      
	     
	      Hashtable tableOne = new Hashtable();
	      Hashtable two = new Hashtable();
	      
	      for ( int i = 0; alpha <= countS.length(); i++){
	        String ss = countS.substring(i,alpha);
	        tableOne.put(ss, i);
	        alpha++;
	        count++; }

	      int keyValueForInt = 0;
	      
	      Enumeration<String> all = tableOne.keys();
	      
	      while(all.hasMoreElements()){
	        String key = all.nextElement();

	        keyValueForInt = hash(key,beta);
	          if (two.containsKey(keyValueForInt)){
	              int vl = Integer.parseInt(String.valueOf(two.get(keyValueForInt)));
	              two.put(keyValueForInt,vl+1); } 
	          else{
	              int value = 1;
	              two.put(keyValueForInt, value);
	          }
	      }
	        System.out.print(size + " "+ two.size());
	    }
	}