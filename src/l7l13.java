
public class l7l13 {
	
	class InstanceInner{};
	static class StaticInner{};
	
	
	InstanceInner iv = new InstanceInner();
	static StaticInner cv = new StaticInner();
	
	
	static void staticMethod() {
		StaticInner obj2 = new StaticInner();
		
		l7l13 outer = new l7l13();
		InstanceInner obj1 = outer.new InstanceInner();	 // static ���� Instance ���� Ŭ���� ���ٹ� 
		
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
