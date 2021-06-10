package Stream;



import java.util.*;
import java.util.stream.*;
public class l14l9 {
	
	public static void main(String[] args) {
		String[] strArr = {
				"Persistence", "Java", "Lambda", "Stream",
				"Optional", "IntStream", "count","sum"
		};
		
		Stream.of(strArr).forEach(System.out::println);
		
		boolean noEmptyStr = Stream.of(strArr).noneMatch(s-> s.length() == 0); // 모든 요소 불일치시 참
		
		Optional<String> sWorf = Stream.of(strArr)
				.filter(s->s.charAt(0)=='s').findFirst(); // s인 처음꺼 가져오기
		
		System.out.println("noEmptyStr="+noEmptyStr);
		System.out.println("sWorf="+sWorf.get());
		
		
		IntStream i1 = Stream.of(strArr).mapToInt(String::length); // 각각의 문자열을 길이로 반환
		IntStream i2 = Stream.of(strArr).mapToInt(String::length);
		IntStream i3 = Stream.of(strArr).mapToInt(String::length);
		IntStream i4 = Stream.of(strArr).mapToInt(String::length);
		
	
		int count = i1.reduce(0, (a,b)-> a+1); // a->0,1,2,3,4,...
		int sum = i2.reduce(0, (a,b)-> a+b); // a-> 11, 15,...
		
		System.out.println("count="+count);
		System.out.println("sum="+sum);
		
		
	
		
		OptionalInt max = i3.reduce(Integer::max);
		OptionalInt min = i4.reduce(Integer::min);
		
		System.out.println(max.getAsInt());
		System.out.println(min.getAsInt());
		
		
	}

}
