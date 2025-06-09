```
public class ExceptionHandling {
  public static void main(String[] args) {
      int sum = 0;
      try {
          func();
      } catch (NullPointerException e) {
          sum = sum + 1;
      } catch (Exception e) {
          sum = sum + 10;
      } finally {
          sum = sum + 100;
      }
      System.out.print(sum);
  }
 
  static void func() throws Exception {
      throw new NullPointerException(); 
  }
}
```

<h1>틀린 이유 </h1>

해당 코드에서 throws Exception을 보고 
func()를 호출할 때, 발생하는 NPE가 throws Exception을 통해서 자동으로 넘기기에, try-catch에 존재하는 catch문에 잡히지 않을 것이라고 생각했다. 

<h1>오답 정리 </h1>

1. 해당 코드는 try-catch문 안에 존재하는 func()가 호출됨
2. func가 호출되면서 NPE 발생 
3. NPE가 발생했을 때 func()의 throws Exception이 발생하면서 NPE를 main함수에 넘김

**호출한 쪽(main함수)에서는 반드시 try-catch로 처리하거나, 또다시 throws로 넘겨야함**

4. 그러나 main함수에 throw를 통해서 넘기는 문장이 존재하지 않기에, catch문에서 걸리게 된다. 
5. 결과적으로 아래 코드가 실행되고 finally에 의해 출력시 101이 나옴 
```
 catch(NullPointerException e){
    sum = sum + 10;
} finally {
          sum = sum + 100;
      }
```


