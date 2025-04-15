문제 1

```
class Car implements Runnable{
    int a ;
    public void run(){
        System.out.println("run");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(_________);
        thread.start();
    }
}

```
<h1>오답의 원인 </h1> 
thread.start()를 보고  Car 클래스는 run()을 오버라이딩으로 재정의 했지만, main에서는 thread.start()가 나왔기 때문에 Thread thread = new Thread(_________) 의 _________에 new Car를 작성하지 못했음


<h1>의문에 대한 정리</h1> 

1. _________ 에 new Car()가 가능한 이유 

**Runnable**
Runnable >> Runnable은 그냥 "일 시킬 때의 규칙"을 정한 인터페이스라고 볼 수 있음 
즉, 자바에서 어떤 코드를 실행할지 미리 정의 해두기 위한 역할

<h1>_________ 자리에 new Car()가 가능한 이유</h1> 
1. Car 클래스는 Runnable 인터페이스의 run()을 오버라이딩을 통해 구현하였음
2. new Car()은 Runnable을 구현하였기 때문에 Runnable 타입으로 사용할 수 있음 

**이때, Thread 클래스는 생성자에 Runnable을 넣을 수 있게 설계되어있음**

Thread는 실행만 해주는 도구이고, **진짜 실행할 작업(run)**은 Runnable 안에 
들어있음.


<h1>요약</h1> 

**Thread를 통해 작업을 실행하려면 Runnable이라는 인터페이스에서 정의한 run() 메서드를 구현해야 하고, Car 클래스가 Runnable을 구현하면서 run() 메서드를 오버라이딩했기 때문에, new Car()는 Runnable 타입으로 인정받아 Thread 생성자의 인자로 사용될 수 있기에 _________자리에 new Car()가 가능하다.**


<h1>정답</h1> 

```

Thread thread = new Thread (new Car());

```

