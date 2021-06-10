
public class l7l12 {
	class InstanceInner{
		int iv = 100;
		final static int Const =100;
	}
	
	static class StaticInner {
		int iv =200;
		static int cv = 200;
		
	}
	void myMethod() {
		class LocalInner {
			int iv = 300;
			final static int Const = 300;
			
		}
	}
	
	
	public static void main(String args[]) {
		System.out.print(InstanceInner.Const);
		
		System.out.print(StaticInner.cv);
		
	}

}
