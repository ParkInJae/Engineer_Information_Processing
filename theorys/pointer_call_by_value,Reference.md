C언어에서는 함수에 넘기는 모든 인자는 call by value로 전달이 됨

포인터란?? 다른 변수, 혹은 그 변수의 메모리 공간 주소를 가리키는 변수를 의미함 
즉 포인터 변수는 &(주소)와 값을 갖고 있으며, 포인터의 값에는 다른 변수의 주소가 존재한다. 

call by value(값 전달) : 함수에 넘기는 모든 인자는 값이 복사되어 전달
기본타입뿐만 아니라 포인터 변수도 "포인터가 담고 있는 주소의 값"이 복사됨

매개 변수의 타입이 타입명 *변수(Node *node) 또는 타입명 변수명 (Node node)와 같은 형식

call by reference(주소 전달) :  변수의 주소를 넘겨서 호출자의 실제 변수를 수정할 수 있음 


call by value

```
void insertWrong(Node *L, Node *p, int x) {
    Node* newNode = malloc(sizeof(Node));
    newNode->data = x;     
    newNode->link = L;     // newNode->link 에 복사된 L(=old head) 저장
    L = newNode;           // L(복사본)만 재할당 → 호출자 head는 변화 없음
}

```

-> L 자체가 “복사된 포인터”이기 때문에

-> L = newNode; 해 봐야 함수 안 L만 새 노드를 가리키고,

-> 호출자 쪽 head 포인터는 전혀 건드리지 못합니다.

=>즉, 리스트 헤드가 바뀌지 않음


call by reference

```

void insert(Node **L, Node *p, int x) {
    Node* newNode = malloc(sizeof(Node));
    newNode->data = x;
    // 빈 리스트거나 맨 앞 삽입
    if (*L == NULL || p == NULL) {
        newNode->link = *L;  // newNode->link 에 “옛날 헤드” 저장
        *L = newNode;        // 실제 head 변수의 값을 변경 → 호출자에 반영
    }
    else {
        // 중간 삽입 로직…
    }
}

```


-> L 은 “헤드 포인터 변수(head)의 주소”를 담고 있고,

-> *L 은 “실제 head 포인터 변수” 자신을 가리킵니다.

-> *L = newNode; 는

-> 호출자 영역에 있는 head 변수의 값을 직접 덮어쓰기 하는 것과 같아서

-> 함수가 끝난 뒤에도 헤드가 새 노드를 가리킵니다.

=> 리스트 헤드가 실제로 바뀜

<hr>
<h1>정리 </h1>

<h1>call by value , call by reference  구별하기 </h1>

1. 함수 시그니처만 보고 판단하기 

<h3>call-by-value</h3>


```
void insertWrong(Node *L, …)
```
L은 Node * 타입이지만 , 포인터의 값(주소)이 복사되어 들어오는 매개변수이므로 항상 call-by-value임.


<h3>call-by-reference</h3>

```
void insert(Node **L, …)
```

L은 포인터 변수를 담고 있는 메모리의 주소를 복사해 받음
즉  *L에 임의의 값을 대입해서 원본 포인터 변수(head)를 건드릴 수 있음 (원본 포인터 변수의 '값'을 건드릴 수 있음 )


<h3>call-by-value 예시</h3>

```
#include <stdio.h>
#include <stdlib.h>

void operator (int a){
  int b = a+3;  
} 
int main(){
    int MA = 1; 

    operator(MA);
    printf(MA);;  // 1 , call-by-value이다.
    printf(b);   // b는 지역변수라서 찾을 수 없음 -> 즉 에러 발생함
}

```
