package stefy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) { 
		PriorityQueue<String> queue1 = new PriorityQueue<>(Arrays.asList( 
				"George" , "Jim" , "John" , "Blake" , "Kevin" , "Michael"));
		PriorityQueue<String> queue2 = new PriorityQueue<>(Arrays.asList(
				"George" , "Katie" , "Kevin" , "Michelle" , "Ryan"));
		
		System.out.println("Set1:" + queue1);
		System.out.println("Set2:" + queue2);
		
		PriorityQueue<String> union = new PriorityQueue<>(queue1);
		union.addAll(queue2);
		
		PriorityQueue<String> intersection = new PriorityQueue<>(queue1);
		intersection.retainAll(queue2);
		
		PriorityQueue<String> difference = new PriorityQueue<>(union);
		difference.removeAll(intersection);
		
		System.out.println("Union: " + union);
		System.out.println("Intersection: " + intersection);
		System.out.println("Difference: " + difference);
		
		
	}

}
