class Static{
    public int a = 20;
    public int b = 0;
}

public class s{
    public Static void main(String[]args){
        int a =10;
        Static.b =a;
        Static st = new Static();
        System.put.println(Static.b++);
        System.put.println(st.b);
        System.put.println(a);
        
        System.put.println(st.a);
    }
}