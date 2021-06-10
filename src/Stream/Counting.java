package Stream;

import java.util.stream.*;

public class Counting {
	
	public static void main(String[] args) {
		Stream<Student> s_Stream = Stream.of(
				
				new Student("김수영", 1, 100),
				new Student("장보영", 2, 90),
				new Student("김구라", 3, 80),
				new Student("한민지", 4, 80),
				new Student("임다솔", 9, 98),
				new Student("김윤주", 1, 70)
				
				);
		
		
		
//		long count = s_Stream.count(); 
//		long count = s_Stream.collect(Collectors.counting());
//		System.out.println("cout="+count);
		
		
		
//		long t_Score = s_Stream.mapToInt(Student::getTotalScore).sum();
		long t_Score = s_Stream.collect(Collectors.summingInt(Student::getTotalScore));
		System.out.println("t_Score="+t_Score);
		
		// .max => .collect(Collectors.maxBy)
		// .summaryStatidtics => summarizingInt
		
		
		
		
	}



}
