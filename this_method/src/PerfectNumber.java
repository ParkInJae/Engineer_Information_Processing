public class PerfectNumber {
// C언어 완전수 로직을 자바로 변환 
// 완전수 -> 어떤 수 n이 자기 자신을 제외한 모든 양의 약수들의 합이 n과 같을 때 완전수라고 함 
    static class A {
        public boolean test(int n) { // return 타입 boolean으로 선언 
            int sum = 0;
            for (int i = 1; i <= n / 2; i++) {  // 시간 복잡도와 비슷하지만 다름, n/2까지인 이유 > n의 약수 중 자기 자신을 제외한 가장 큰 수는 n/2
                if (n % i == 0) {  // i가 n의 약수인지 확인 
                    sum += i; // i가 약수일 경우, sum에 더함 
                }
            }
            return n == sum; // 만약 같다면, 완전수이고 true 반환, 다르면, 완전수가 아니기에 false 반환 
            // 자기 자신을 제외한 약수의 합이 자신과 같으면 완전수이다. 
        }
    }

    public static void main(String[] args) {
        int sum = 0;
        A a = new A();

        for (int i = 2; i <= 100; i++) {
            if (a.test(i)) {
                sum += i;
            }
        }

        System.out.println("완전수의 합 : " + sum);
/*  1~ 100까지 완전수 
    6,28
*/
/* 20000이하의 완전수 목록 
    번호	완전수
    1	6
    2	28
    3	496
    4	8128
 */
    }
}
