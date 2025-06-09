class GenericExample {
 
  public static class Collection<T>{
    T value;
 
    public Collection(T t){
        value = t;
    }
 
    public void print(){
       new Printer().print(value);
    }
 
   class Printer{
      void print(Integer a){
        System.out.print("A" + a);
      }
      void print(Object a){
        System.out.print("B" + a);
      } 
      void print(Number a){
        System.out.print("C" + a);
      }
   }
 }
 
  public static void main(String[] args) {
      new Collection<>(0).print();
  }
  
}


/*
1. 컴파일이 런타임보다 먼저 발생함 

2 컴파일시 제네릭 소거 발생 > T value가 컴파일 시점에  T value가 Object value;로 전환

3. 런타임시, new Collection <> (0)는 Integer 타입으로 자동적으로 박싱되어 변경됨
 그러나 Object 타입이 Integer 타입의 부모이기 때문에, Printer()함수에서는 매개변수가 Object인 함수가 선택이 됨
 따라서 B0이 정답임
 */