
class Outer1{
	int value=10;
	
	class Inner{
		int value = 20;
		
		
		void method1() {
			int value = 30;
			System.out.println("value:"+value);
			System.out.println("this.value:"+this.value);
			System.out.println("Outer1.this.value:"+Outer1.this.value);
		}
		
	}
}


public class l7l16 {
	public static void main(String[] args) {
		Outer1 outer = new Outer1();
		Outer1.Inner inner = outer.new Inner();
		inner.method1();
		
	}

}
