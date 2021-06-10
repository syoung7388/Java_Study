package Stream;

import java.util.*;
import java.util.stream.*;

public class Reducing {
	
	
	
	public static void main(String[] args) {
		
		//1. resuce max
		IntStream intStream1 = new Random().ints(1,46).distinct().limit(6);
		OptionalInt max1 = intStream1.reduce(Integer::max);
		System.out.println("max1="+max1);
		
		IntStream intStrea2 = new Random().ints(1,46).distinct().limit(6);
		Optional<Integer> max2 = intStrea2.boxed().collect(Collectors.reducing(Integer::max)); 
		System.out.println("max2="+max2);
		
		//2 . reduce(0, (a,b)->a+b)
		IntStream Sum1 = new Random().ints(1,46).distinct().limit(6);
		int sum = Sum1.boxed().collect(Collectors.reducing(0, (a,b)->a+b));
		System.out.println("sum="+sum);
		
		//3. 2번 +
		Stream<Student> s_Stream = Stream.of(
				
				new Student("김수영", 1, 100),
				new Student("장보영", 2, 90),
				new Student("김구라", 3, 80),
				new Student("한민지", 4, 80),
				new Student("임다솔", 9, 98),
				new Student("김윤주", 1, 70)
				
				);
		
			//int grandTotal = s_Stream.map(Student::getTotalScore).reduce(0, Integer::sum); // 1)
		int grandTotal = s_Stream.collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum)); //2)
		System.out.println("grandTotal="+grandTotal);
		
		
		
		
		
	}
	

	

}
