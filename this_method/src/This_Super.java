class ParentClass {
    int x1;

    public ParentClass() {
        System.out.println("ParentClass 기본 생성자 호출");
    }

    public ParentClass(int x) {
        this.x1 = x;
        System.out.println("ParentClass(int x) 생성자 호출: x1 = " + x1);
    }
}

/* this는 생성자 내부에서만 호출할 수 있으며, 해당 클래스의 다른 생성자만 호출할 수 있다. 
 * 즉 메소드를 호출하는 것이 아닌 생성자끼리 호출하는 역할을 함
 * 
 */
class ChildClass extends ParentClass {

    public ChildClass() { // 기본 생성자 
        this(10); // ChildClass(int x) 생성자를 호출
        System.out.println("ChildClass 기본 생성자 호출");
        
    }

    public ChildClass(int x) {
        super(x); // ParentClass(int x) 호출
        System.out.println("ChildClass(int x) 생성자 호출");
        System.out.println("this() 메소드는 같은 클래스의 다른 생성자를 호출할 때 사용 가능함 ");
        System.out.println("this()로는 일반 메소드를 호출할 수 없음 ");
        System.out.println("--------------------------");
        this.childMethod();
    }

    public void childMethod(){
        System.out.println("this.메소드명()을 이용해서 함수를 호출 할 수 있음");
    }

}

/*
자바에서는 클래스 안에 여러가지의 클래스를 선언할 수 있음 
  자바에서 public class가 잇는 경우 파일명과 반드시 일치해야함  
 this()  -> this()는 같은 클래스의 생성자를 호출할 때 사용함
 super() -> 상속 관계에서 부모 클래스의 생성자를 호출함.
 this와 super는 같이 사용할 수 없음 
  
 */
public class This_Super { 
    public static void main(String[] args) {
        System.out.println("=== 첫 번째 객체 생성 ===");
        ChildClass obj1 = new ChildClass(); // 기본 생성자 실행

        System.out.println("\n=== 두 번째 객체 생성 ===");
        ChildClass obj2 = new ChildClass(20); // 매개변수 있는 생성자 실행
    }
}
 