class Car implements Runnable{
    int a ;
    public void run(){
        System.out.println("run");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Car());
        thread.start();
    }
}
/*
 new Thread (new Car())이라고 생각하지 못한 이유 
 thread.start()를 보고 
 Car 클래스는 run()을 오버라이딩으로 재정의 했지만, main에서는 thread.start()가 나왔기 때문에 Thread thread = new Thread(_________) 의 _________에 new Car를 작성하지 못했음 
 */