package inheritance;

class Parent2{
	// 상속에서의 생성자
	int n1,n2;
	
	Parent2(int n1,int n2){
		this.n1=n1;
		this.n2=n2;
	}
	
	void show() {
		System.out.printf("%d, %d\n",n1,n2);
	}
}

class Child2 extends Parent2{
	// 1) 서브클래스의 생성자는 반드시 슈퍼클래스의 생성자를 호출해야만한다
	// 2) 서브클래스의 생성자는 매개변수 형태가 같은 슈퍼클래스의 생성자를 호출하지 않아도 된다
	int n3;
	Child2(int n1,int n2,int n3){
		super(n1,n2);
		this.n3 = n3;
	}
	
	Child2() {
		super(10,20);
	}
}

public class Ex02 {
	public static void main(String[] args) {
		Child2 ob1 = new Child2();
		ob1.show();
		
		
	}
}
