package Stream;



import java.util.*;
import java.util.stream.*;

public class l14l7 {
	
	
	public static void main(String[] args) {
		Stream<String[]> strArr = Stream.of(
				new String[] {"abc", "def","jkl"},
				new String[] {"ABC", "DEF","JKL"}
				);
		
		
		
		Stream<String> strStream = strArr.flatMap(Arrays::stream);
		
		strStream.map(String::toLowerCase)
		         .distinct()
		         .sorted()
		         .forEach(System.out::println);
		System.out.println();
		
		String[] lineArr= {
				"믿든 말던 이건 진짜다",
				"하거나 하지말거나 시도할수없다"
				
		};
		
		
		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" +")))
			.map(String::toLowerCase)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		System.out.println();
	}
}
