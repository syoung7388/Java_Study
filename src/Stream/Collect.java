package Stream;


import java.util.*;
import java.util.stream.*;

public class Collect { // 최종 연산자 collect(), Collectors
	public static void main(String[] args) {
		
		Stream<Student> s_Stream = Stream.of(
				
				new Student("김수영", 1, 100),
				new Student("장보영", 2, 90),
				new Student("김구라", 3, 80),
				new Student("한민지", 4, 80),
				new Student("임다솔", 9, 98),
				new Student("김윤주", 1, 70)
				
				);
		
		
		
		
		 
		List<String> names = s_Stream.map(Student::getName)
				.collect(Collectors.toList());
		System.out.println("names="+names);
		
		
		
		
		ArrayList<String> list = names.stream().collect(Collectors.toCollection(ArrayList::new));
	
		System.out.println("list="+list);
	
		
		
		Stream<Student> p_Stream = Stream.of(
				
				new Student("김수영", 1, 100),
				new Student("장보영", 2, 90),
				new Student("김구라", 3, 80),
				new Student("한민지", 4, 80),
				new Student("임다솔", 9, 98),
				new Student("김윤주", 1, 70)
				
				);
		
		Map<Object, Object> map = p_Stream.collect(Collectors.toMap(p-> p.getName(), p->p));
		
		System.out.println("map="+map);
		
		
		
		Stream<Student> k_Stream = Stream.of(
				
				new Student("김수영", 1, 100),
				new Student("장보영", 2, 90),
				new Student("김구라", 3, 80),
				new Student("한민지", 4, 80),
				new Student("임다솔", 9, 98),
				new Student("김윤주", 1, 70)
				
				);
		
		
		Student[] StuName = k_Stream.toArray(Student[]::new);
		//Student[] StuName = k_Stream.toArray();X
		//Object[] k_Stream = k_Stream.toArray();O
		System.out.println("StuName="+ StuName);
		
	}
	

}
