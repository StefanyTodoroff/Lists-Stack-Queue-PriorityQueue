package generics;
import java.util.LinkedList;

public class PerformanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> numbers = new LinkedList<>();
		for( int i = 0; i < 5_000_000; i++) {
			numbers.add(i);
		}
		int a = 0;
		for(Integer number: numbers) {
			a = number;
		}
		System.out.print(a);

	}

}
