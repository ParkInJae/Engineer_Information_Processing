class Static{
    public int a = 20;
    static int b =0;
}


public class Question2 {
    public static void main(String[] args) {
        int a ;
        a = 10 ;
        Static.b = a; // b 값을 10으로 설정 
        Static st = new Static(); // 새로운  static 객체 생성 초기화로 인해 st.b는 10 
        System.out.println(Static.b++); //
        System.out.println(st.b);
        System.out.println(a);
        System.out.println(st.a);

    }
    
}
