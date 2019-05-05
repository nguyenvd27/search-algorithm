package sequentialSearch;

import java.util.ArrayList;

import shape.CircleK;

public class SequentialSearch {
	public int sequentialSearch(ArrayList<CircleK> arrayCircleK, int x) {
		int n = arrayCircleK.size(); 
	    for(int i = 0; i < n; i++) 
	    { 
	        if(arrayCircleK.get(i).getNumber() == x) 
	            return i; 
	    } 
	    return -1; 
	}
}
