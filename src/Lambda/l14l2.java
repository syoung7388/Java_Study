package Lambda;

import java.util.function.*;
import java.util.*;

public class l14l2 {
	
	public static void main(String [] args) {
		Supplier<Integer> s = () -> (int)(Math.random()*100)+1; //매개변수X, 반환값 O
		Consumer<Integer> c = i -> System.out.print(i+",");// 매개변수O, 반환값 X
		Predicate<Integer> p = i -> i%2 == 0; // boolean
		Function<Integer, Integer> f = i -> i/10*10; // 하나 받아서 하나 반환
		
		
		List<Integer> list = new ArrayList<>();
		
		
		makeRandomList(s, list);
		System.out.println(list);
		
		printEvenNum(p, c, list);
		
		
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
		
		
		
	}
	
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for(int i=0; i<10; i++) {
			list.add(s.get());
		}
	}
	
	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) { //2의배수면, c에 담기
		
		
		System.out.print("[");
		
		for(T i : list) {
			if(p.test(i))
				c.accept(i);
		}
		System.out.println("]");
		
	}
	
	static <T> List<T> doSomething(Function<T, T> f, List<T> list){
		
		List<T> newList = new ArrayList<T>(list.size());
		
		for(T i: list) {
			newList.add(f.apply(i));

		}
		
		return newList;
	}
}
