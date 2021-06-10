package Stream;

import java.util.function.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student2{
	String name;
	boolean isMale;
	int hak;
	int ban;
	int score;
	
	
	Student2(String name, boolean isMale,int hak,int ban,int score){
		this.name = name;
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
		return String.format("%s, %s, %d학년, %d반, %3d점]", name, isMale? "남":"여", hak, ban, score);
	}
	
	enum Level {High, Mid, Low}
}

public class partitioningBy {
	
	
	
	public static void main(String[] args) {
		
		Student2[] s_Arr = {
				new Student2("김수영",false, 1, 1, 300),
				new Student2("장보영",true, 1, 1, 250),
				new Student2("김구라",false, 1, 1, 200),
				new Student2("한민지",true, 1, 2, 150),
				new Student2("임다솔",true, 1,2, 150),
				new Student2("김윤주",false, 1, 2, 150),
				
				new Student2("히든",false, 2, 1, 400),
				new Student2("새",true, 2, 1, 200),
				new Student2("이민호",false, 2, 2, 200),
				new Student2("키",true, 2, 3, 150),
				new Student2("태민",true, 2,2, 150),
				new Student2("온유",false, 2, 3, 150)
		};
		
		
		System.out.println("1.단순 분할 (성별로 분할)");
		Map<Boolean, List<Student2>> MF = Stream.of(s_Arr).collect(partitioningBy(Student2::isMale));
		List<Student2> male = MF.get(true);
		List<Student2> female = MF.get(false);
		
		for(Student2 s: male) System.out.print(s.getName()+",");
		System.out.println();
		for(Student2 s: female) System.out.print(s.getName()+",");
		System.out.println();
		System.out.println();
		
		System.out.println("2. 단순분할+통계(성별 학생수)");
		
		Map<Boolean, Long> MFNum = Stream.of(s_Arr).collect(partitioningBy(Student2::isMale, counting()));
		System.out.println("남학생 수:"+ MFNum.get(true));
		System.out.println("여학생 수:"+ MFNum.get(false));
		System.out.println();
		
		System.out.println("3. 단순분할 + 통계(성별 1등)");
		
		Map<Boolean, Student2> MFTop = Stream.of(s_Arr)
				.collect(partitioningBy(Student2::isMale, collectingAndThen(
						maxBy(comparingInt(Student2::getScore)
							), Optional::get)
						));
		System.out.println("남학생 1등: "+MFTop.get(true));
		System.out.println("여학생 1등: "+MFTop.get(false));
		System.out.println();
		
		System.out.println("4. 다중분할(성별 불합격자, 150점 이하)");
		
		Map<Boolean, Map<Boolean, List<Student2> >> f_FM =  
				Stream.of(s_Arr).collect(partitioningBy(Student2::isMale, partitioningBy(s-> s.getScore() <= 150)));
		List<Student2> m_list = f_FM.get(true).get(true);
		List<Student2> f_list = f_FM.get(false).get(true);
		
		for(Student2 s: m_list) System.out.print(s.getName()+",");
		System.out.println();
		for(Student2 s: f_list) System.out.print(s.getName()+",");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
