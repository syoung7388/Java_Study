
class OuterClass {
	class InstanceInner {
		int iv = 100;
	}

	static class StaticInner {
		int iv = 200;
		static int cv = 300;
	}

	void myMethod() {
		class LocalInner {
			int iv = 400;
		}
	}
}

class l7l15 {
	public static void main(String[] args) {

		OuterClass oc = new OuterClass();
		OuterClass.InstanceInner ic = oc.new InstanceInner();
		System.out.println("ic.iv" + ic.iv); // I클래스 인스턴스 변수 호출 방법 
		
		System.out.println("l7l15.StaticInner.cv" + OuterClass.StaticInner.cv);// S클래스 스태틱  변수 호출 방법 
		
		//System.out.println("l7l15.StaticInner.cv" + OuterClass.StaticInner.iv); 오류
		
		OuterClass.StaticInner si = new OuterClass.StaticInner();
		System.out.println("si.iv" + si.iv);// S클래스 인스턴스  변수 호출 방법 

	}
}