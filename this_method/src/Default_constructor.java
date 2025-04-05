class ParentClass {

    public ParentClass(){

        System.out.println("부모 생성자 호출");
    }

    public ParentClass(String ParentsString){

        System.out.println("매개변수 있는 부모 생성자 호출");

    }

    public void ParentClassMethod(String ParentsString){

    }
}

class ChildClass extends ParentClass{
    String a = " " ; // 필드 선언 및 초기화 

    public ChildClass(){
        this("기본값"); // this()는 같은 클래스의 생성자를 호출하는데 사용
       // super(); // 기본 생성자의 경우에는 super()가 명시되지 않아도 자동으로 부모 기본 생성자를 호출함 
        System.out.println("자식 기본 생성자 호출 ");
    }
    
    public ChildClass(String Childstring){
        System.out.println("기본 생성자가 아닌 매개변수가 존재하는 생성자 호출");
        
    }
    public void ChildClassMethod(String Childstring){
        
        this.a = Childstring;
        System.out.println(a);

    }

}

public class Default_constructor {
    public static void main(String []args){

        String messeage = "매개변수 존재하는 String문"; 
        System.out.println("------------------------------------");
        ParentClass pc =  new ChildClass();
        System.out.println("------------------------------------");
        ChildClass ch = new ChildClass(messeage);
    }
    
}
