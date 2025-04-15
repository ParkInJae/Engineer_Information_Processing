```

class parent{
    int x = 100;

    parent(){
        this(500);
    }
    parent(int x){
        this.x = x;
    }
    int getX(){
        return x;
    }
}


class C extends parent{
    int x = 4000;
    C(){
        this(5000);
    }
    C(int x ){
        this.x= 4000;
    }
}

public class Question1 {
    public static void main(String[] args) throws Exception {
        C obj = new C();
        System.out.println(obj.getX());
    }
}

```

<h1>오답의 원인 </h1> 
100 이라고 생각했던 이유 >> → this(5000)을 보고, this와 super는 같이 사용할 수 없다고 판단했기 때문에, 부모 클래스의 기본 생성자에서 int x = 100이 적용된다고 생각함.

❗하지만 자바는 생성자 안에 super()가 명시되지 않으면 자동으로 추가되므로,
→ 부모의 생성자 로직(this(500) → parent(int x))이 실행되면서 x = 500으로 초기화됨.

<h1>로직의 순서.</h1>
1. main 먼저 실행
2. C obb = new C(); 실행 
3. C 클래스의 this(5000)적용
4. C 클래스의 매개변수 있는 생성자 실행 
5. C 클래스의 매개변수 있는 생성자의 this.x = 4000; 이 실행되기 전에, 생략되어있는 super(); 실행
6. super();의 실행으로 인해 부모 클래스 Parernt의 기본 생성자 실행 
7. parent() 기본 생성자의 this(500);가 실행 되며 매개변수가 존재하는 생성자로 이동
8. parent(int x)의 this.x = x;로 인해서 부모 클래스의 필드 x가 500으로 고정
9. C 클래스의 매개변수가 존재하는 생성자의 남은 코드 this.x = 4000; 실행 후 main코드의 C obj = new C(); 마무리 
10. System.out.println(obj.getX()); 코드로 자식 클래스에는 존재하지 않지만 상속으로 인해 부모 클래스의 getX()함수를 통해서 저장된 x(=500의 값을 가짐 )를 가져옴 