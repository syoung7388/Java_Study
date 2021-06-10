
public class l7l14 {
	
	private int outerIv =0;
	static int outerCv = 0;
	
	
	class InstanceInner{// I클래스 에서는 외클의 private , static 다 가능함
		int iiv = outerIv;
		int ccv = outerCv;
	}
	
	static class StaticInner{ //S클래스 에서는 static만 가능 
		static int scv = outerCv;
	
	}
	void myMethod() {
		int lv = 0;
		final int Lv = 0;
		
		
		
		class LocalInner{ //다 OK
			int liv = outerIv;
			int ccv = outerCv;
			int liv3 = lv;
			int liv4 = Lv;
			
			
		}
		
	}


}
