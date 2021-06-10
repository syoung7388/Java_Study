package Stream;



import java.io.*;
import java.util.stream.*;
public class l14l6 {
	
	
	public static void main(String[] args) {
		
		File[] fileArr = {
				new File("1.java"), new File("1.bak"), new File("2.java"),new File("Ex1"),new File("Ex1.txt")
		};
		
		Stream<File> fileStream = Stream.of(fileArr);
		
		Stream<String> filenameStream = fileStream.map(File::getName);
		filenameStream.forEach(System.out::println);
		
		fileStream = Stream.of(fileArr);
		
		fileStream.map(File::getName)
			.filter(s -> s.indexOf('.')!= -1) // ?
			.map(s-> s.substring(s.indexOf('.')+1))
			.map(String::toUpperCase)
			.distinct()
			.forEach(System.out::println);
		
		
		System.out.println();
		
	}

}
