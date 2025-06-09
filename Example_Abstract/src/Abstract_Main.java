public class Abstract_Main {

    class EA extends Example_Abstract{
        public void fn(){
            System.out.println("EA클래스가 추상 메소드를 오버라이딩 하여 구현하였습니다.");
        }

    }

    public static void main(String[] args) throws Exception {
        
        // Example_Abstract a = new EA(); // 에러 발생 
        // 에러 해결 방법은 README.ad에 작성하였음 
        
        Example_Abstract b = new B_AbstractClass();
        Example_Abstract c = new C_AbstractClass();
        b.fn();
        c.fn();
    }



}