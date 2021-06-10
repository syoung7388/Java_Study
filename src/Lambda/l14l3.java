package Lambda;

import java.util.function.*;

public class l14l3 {
	
	public static void main (String[] args) {
		Predicate<Integer> p = i -> i <100;
		Predicate<Integer> q = i -> i <200;
		Predicate<Integer> r = i -> i%2 == 0;
		Predicate<Integer> notP = p.negate();
		
		
		Predicate<Integer> all = notP.and(q.or(r)); // i >= 100 && (i< 200 || i%2)
		System.out.println(all.test(150)); //true
		
		String s1 = "abc";
		String s2= "abc";
		
		Predicate<String> p2 = Predicate.isEqual(s1);
		boolean result = p2.test(s2);
		System.out.println(result);
	}

}
