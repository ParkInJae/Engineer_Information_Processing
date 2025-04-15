// 추상 클래스를 부모로 삼고 상속받을 경우 해당 추상 메소드를 반드시 구현하여야한다.
public class B_AbstractClass extends Example_Abstract{
    
    public void fn(){
        System.out.println("추상클래스의 메소드를 B클래스에서 오버라이딩을 사용해서 구현하였습니다.");
    }
}
