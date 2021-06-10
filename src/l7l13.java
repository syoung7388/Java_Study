
public class l7l13 {
	
	class InstanceInner{};
	static class StaticInner{};
	
	
	InstanceInner iv = new InstanceInner();
	static StaticInner cv = new StaticInner();
	
	
	static void staticMethod() {
		StaticInner obj2 = new StaticInner();
		
		l7l13 outer = new l7l13();
		InstanceInner obj1 = outer.new InstanceInner();	 // static 에서 Instance 내부 클래스 접근법 
		
	}
	void instanceMethod() {
		InstanceInner obj1= new InstanceInner(); // I-O S-O L-X
		StaticInner obj2 = new StaticInner();
				
	}
	
	void myMethod() {
		
		class LocalInner{}
		LocalInner lo = new LocalInner();
		
		
		
	}

}
