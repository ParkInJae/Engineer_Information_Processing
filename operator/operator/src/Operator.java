public class Operator{

/*
 C언어에서 논리 연산자와 비트 연산자를 자바로 변환 

 * C언어는 &&나 ||을 사용할 때 "값이 0이냐, 아니냐"를 판단함 .
 * 0이 아닐 경우 1을 반환, 0일 경우 0을 반환 
  따라서 1 && 2 는 1이 0이 아니고, 2는 0이 아니기에  1 && 1이므로, 1을 반환한다. 
 */
    public static void main(String[] args) throws Exception {
        int a = 5;
        int b = 3;
        int c = 12;

        int t1 ,t2,t3;
        /*
         t1 = a && b;   -> a와 b 둘 다 0이 아니라면, t1의 값은 1이다.
         t2 = a || b;   -> a 또는 b 둘 중 하나가 1이라면, t2의 값은 1이다. 
         t3 = !c;       -> c의 값이 0이 아니라면, true 이지만 , 부정 연산자인 !로 인해서, false인 0이 나온다.
         위의 코드를 자바로 표현하면 아래의 코드로 생성할 수 있음 
         */

        t1 = (a !=0) && (b !=0) ? 1 : 0; // c 언어에서 a && b는 논리 연산자이며, 좌항과 우항 둘 다 0이 아닌 경우 1을 반환 
        t2 = (a != 0) || (b != 0) ? 1 : 0;
        t3 = (c != 0) ? 0 : 1;

        System.out.println();
        System.out.println(t1+t2+t3);


        int bitOP1 ,bitOP2, bitOP3;
        bitOP1 = (a & b);
        bitOP2 = (a | b);
        bitOP3 = ~c;
        System.out.println("비트연산한 bitOP1의 값 : "  + bitOP1);
        System.out.println("비트연산한 bitOP2의 값 : "  + bitOP2);
        System.out.println("비트연산한 bitOP3의 값 : "  + bitOP3);
    }
}

