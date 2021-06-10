package Stream;


import java.util.function.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student3{
	String name;
	boolean isMale;
	int hak;
	int ban;
	int score;
	
	
	Student3(String name, boolean isMale,int hak,int ban,int score){
		this.name = name;
		this.hak = hak;
		this.isMale = isMale;
		this.ban = ban;
		this.score = score;
	}
	
	String getName() {return name;}
	boolean isMale() {return isMale;}
	int getHak() {return hak;}
	int getBan() {return ban;}
	int getScore() {return score;}
	
	
	public String toString() {
		return String.format("[%s, %s, %d학년, %d반, %3d점]", name, isMale? "남":"여", hak, ban, score);
	}
	
	enum Level {High, Mid, Low}
}


public class groupingBy {
	
	
	public static void main(String[] args) {
		
		Student3[] s_Arr = {
				new Student3("김수영",false, 1, 1, 300),
				new Student3("장보영",true, 1, 1, 250),
				new Student3("김구라",false, 1, 1, 200),
				new Student3("한민지",true, 1, 2, 150),
				new Student3("임다솔",true, 1,2, 150),
				new Student3("김윤주",false, 1, 2, 150),
				
				new Student3("히든",false, 2, 1, 400),
				new Student3("새",true, 2, 1, 200),
				new Student3("이민호",false, 2, 2, 200),
				new Student3("키",true, 2, 3, 150),
				new Student3("태민",true, 2,2, 150),
				new Student3("온유",false, 2, 3, 150)
		};
		
		
		System.out.println("1. 단순 그룹화 (반별로)");
		Map<Integer, List<Student3>> sBan = Stream.of(s_Arr).collect(groupingBy(Student3::getBan));
		for(List<Student3> ban: sBan.values()) {
			for(Student3 s : ban) {
				System.out.println(s);
			}
		}
		System.out.println();
		
		
		System.out.println("2. 단순 그룹화 (성적별로)");
		
		Map<Student3.Level, List<Student3>> sLvel = Stream.of(s_Arr).collect(groupingBy(s->{
			if(s.getScore() >= 250) return Student3.Level.High;
			else if(s.getScore() >= 200) return Student3.Level.Mid;
			else						return Student3.Level.Low;
		}));
		
		TreeSet<Student3.Level> keySet = new TreeSet<>(sLvel.keySet());
		
		for(Student3.Level key : keySet) {
			System.out.println("["+key+"]");
			
			for(Student3 s : sLvel.get(key))
				System.out.println(s);
			System.out.println();
		}
		System.out.println();
		
		
		
		System.out.println("3. 성적별 학생수");
		Map<Student3.Level, Long> LvelNum = Stream.of(s_Arr)
				.collect(groupingBy(s->{
					if(s.getScore() >= 250) return Student3.Level.High;
					else if(s.getScore() >= 200) return Student3.Level.Mid;
					else return Student3.Level.Low;
				}, counting()));
		for(Student3.Level key : LvelNum.keySet())
			System.out.println("["+key+"]:"+ LvelNum.get(key));
		System.out.println();
		
		
		System.out.println("4. 다중 그룹화(학년, 반별)");
		Map<Integer, Map<Integer, List<Student3>>> s_h_b 
		= Stream.of(s_Arr).collect(groupingBy(Student3::getHak,groupingBy(Student3::getBan)
				));
		

		for(Map<Integer, List<Student3>> hak : s_h_b.values()) {

			for (List<Student3> ban : hak.values()) {
				System.out.println();
				for(Student3 s : ban)
					System.out.println(s);
			}
		}
		System.out.println();
		
		
		
		System.out.println("5. 학년, 반별 1등");
		
		Map<Integer, Map<Integer, Student3>> top = 
				Stream.of(s_Arr)
				.collect(groupingBy(Student3::getHak, 
							groupingBy(Student3::getBan, 
									collectingAndThen(
											maxBy(comparingInt(Student3::getScore)), Optional::get
											)
									)
						));
		for(Map<Integer, Student3> ban : top.values())
			for (Student3 s: ban.values())
				System.out.println(s);
		
		
		
		System.out.println();
		
		
		
		System.out.println("6. 학년별 반별 성적그룹");
		
		
		Map<String, Set<Student3.Level>> Lv = Stream.of(s_Arr)
				.collect(groupingBy(s-> s.getHak()+"-"+s.getBan(),
					mapping(s->{
						
						if(s.getScore() >= 250) return Student3.Level.High;
						else if(s.getScore() >= 200) return Student3.Level.Mid;
						else						return Student3.Level.Low;
						
					}, toSet())

		));
		
		
		Set<String> keys = Lv.keySet();
		for(String key : keys) {
			System.out.println("["+key+"]"+Lv.get(key));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	


}
