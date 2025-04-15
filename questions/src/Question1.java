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

/*  100 이라고 생각했던 이유 >> 27번의 코드에서 this(5000)을 보고, this와 super는 같이 사용할 수 없다고
판단했기 때문에 , 로직의 순서대로 100이 나온다고 생각했는데 어느 부분에서 논리의 오류가 발생하였는지 궁금
*/
