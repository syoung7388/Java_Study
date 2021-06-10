package Stream;

import java.util.Optional;
import java.util.stream.*;

public class Match {
	
	public static void main(String[] args) {
		
		
		Stream<Integer> score = Stream.of(new Integer[]{10,20,30,100,150}); 
		
		boolean result = score.anyMatch(s-> s <= 100);
		
		System.out.println("result:"+result );
		
		Stream<Integer> score1 = Stream.of(new Integer[]{10,20,30,100,150}); 
		Optional<Integer> opt1 = score1.filter(s->s<=100).findFirst();
		
		Stream<Integer> score2 = Stream.of(new Integer[]{10,20,30,100,150}); 
		Optional<Integer> opt2 = score2.filter(s->s<=100).findAny();-
		
		
		System.out.println(opt1);
		System.out.println(opt2);
		
		
		
	}

	
}
