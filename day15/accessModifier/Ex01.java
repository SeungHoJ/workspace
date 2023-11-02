package accessModifier;


class Test1{
	
	private int n1 = 10;
	int n2 =20;					// 같은 패키지 내부이므로, Ex01에서는 Test1의 n2에 접근할 수 있다
	protected int n3 = 30;		// 다른 패키지에있는 상속관계 클래스 간의 접근 허용
	public int n4 = 40;
	
	public int getN1() {
		return n1;
	}

	// getter의 필요성이 가장 큰 접근제한자는 private이다
	
}


public class Ex01 {
	public static void main(String[] args) {
		
		Test1 ob = new Test1();
//		System.out.println("ob.n1 : " + ob.n1);
		System.out.println("ob.n1 : " + ob.getN1());
		System.out.println("ob.n2 : " + ob.n2);
		System.out.println("ob.n3 : " + ob.n3);
		System.out.println("ob.n4 : " + ob.n4);
		System.out.println();
		
		
		
		
	}
}
