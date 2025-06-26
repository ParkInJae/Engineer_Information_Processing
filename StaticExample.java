class Static{
    public int a = 20;
    public int b = 0;
}


public class StaticExample{

    public static void main(String[]args){
        int a =10;

        Static st = new Static();
        st.b =a;
        System.out.println(st.b++);
        System.out.println(st.b);
        System.out.println(a);
        
        System.out.println(st.a);
    }
}