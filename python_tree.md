<h2> 1번 </h2>

```
class Node:
    def __init__(self, value):
        self.value = value
        self.children = []

def build_tree(li):
    nodes = [Node(i) for i in li]
    for i in range(1, len(li)):
        nodes[(i - 1) // 2].children.append(nodes[i])
    return nodes[0]

def sum_even_levels(node, level=0):
    if node is None:
        return 0
    total = node.value if level % 2 == 0 else 0
    for child in node.children:
        total += sum_even_levels(child, level + 1)
    return total

li = [4, 7, 1, 9, 3, 5]
root = build_tree(li)
print(sum_even_levels(root))
```



# 해설 
-> li의 처음 인덱스 기준으로 완전 이진 트리를 생성 후 , sum_even_levels를 통해 level % 2 가 0이면 해당 노드의 값들을 더하는 로직
다라서 0번 2번 레벨의 노드인 , 4 + 9 + 3 + 5 -> 21  정답 


<hr>
<h2> 2번 </h2>

```
class Node:
    def __init__(self, value):
        self.value = value
        self.children = []

def make_tree(arr):
    nodes = [Node(x) for x in arr]
    for i in range(1, len(arr)):
        nodes[(i - 1) // 2].children.append(nodes[i])
    return nodes[0]

def product_odd_levels(node, level=0):
    if node is None:
        return 1
    prod = node.value if level % 2 == 1 else 1
    for c in node.children:
        prod *= product_odd_levels(c, level + 1)
    return prod

arr = [2, 3, 4, 5, 6, 7, 8]
root = make_tree(arr)
print(product_odd_levels(root))

```

# 해설 
make_tree를 통해 트리를 생성 이때 아래의 코드로 인해서 완전 이진트리의 형태로 생성됨

```  
nodes[(i - 1) // 2].children.append(nodes[i]) 
```

또한 하래의 코드로 인해서 , node가 존재하지 않을시에, 1을 반환하며, 트리의 레벨이 1일 경우 해당 노드의 값을 prod에 담으며, 홀수 레벨에서의 prod를 곱한 값을 반환하는 것을 알 수 있다. 

```
def product_odd_levels(node, level=0):
    if node is None:
        return 1
    prod = node.value if level % 2 == 1 else 1
    for c in node.children:
        prod *= product_odd_levels(c, level + 1)
    return prod
```


따라서 홀수 레벨인 3과 4가 해당이 되며, 3 x 4인 12가 정답이 된다. 


<hr>
<h2> 3번 </h2>

```
class Node:
    def __init__(self, value):
        self.value = value
        self.children = []

def gen_tree(li):
    nodes = [Node(v) for v in li]
    for i in range(1, len(li)):
        nodes[(i - 1) // 2].children.append(nodes[i])
    return nodes[0]

def sum_leaves(node):
    if node is None:
        return 0
    if not node.children:  # 리프 노드
        return node.value
    return sum(sum_leaves(c) for c in node.children)

li = [10, 20, 30, 40, 50]
root = gen_tree(li)
print(sum_leaves(root))

```

# 해설 
트리 구조 
index : 0   1   2   3   4
value :10  20  30  40  50

트리 구조:
         10
       /    \
     20      30
    /  \
  40   50


```
if not node.children:  
    return node.value
```

* node.children -> 현재 노드의 자식 노드들의 리스트를 의미 

// node.childern -> 2가지로 볼 수 있음

 1) node.children에 자식이 있는 경우  : 파이썬에서 빈 리스트는 False

 2) node.children에 자식이 없는 경우 : 파이썬에서 원소가 존재하는 리스트는 True 

즉, 해당 코드의 if not node.children: 
    return node.value는 
    원소가 존재할 경우에는 not 연산으로 인해 False 처리 되며, 실행되지 않고, 
    원소가 존재하지 않는 빈 리스트의 경우에는 not 연산으로 인해 True 처리되어, 해당 노드의 원소값을 전달하게 된다. 




```
return sum(sum_leaves(c) for c in node.children) 
```

node.children::현재 노드의 자식 노드들의 리스트 
c :: 리스트의 레벨에 해당하는 노드들
 
따라서 return sum (sum_leaves(c) for c in node.children)을 통해서, 현재 노드의 자식 노드가 존재하는지 존재하지 않는지 확인 후 존재하는 경우 해당 노드를 sum_leaves(c)를 통해 확인하는 재귀함수가 반영된 트리 문제이다. 




<hr>
<h2> 4번 </h2>

```
class Node:
    def __init__(self, val):
        self.val = val
        self.children = []

def create_tree(data):
    nodes = [Node(d) for d in data]
    for i in range(1, len(data)):
        nodes[(i - 1) // 2].children.append(nodes[i])
    return nodes[0]

def find_max(node):
    if node is None:
        return float('-inf')
    current = node.val
    for child in node.children:
        current = max(current, find_max(child))
    return current

data = [11, 6, 14, 1, 7, 13, 15]
root = create_tree(data)
print(find_max(root))

```

<hr>
<h2> 5번 </h2>

```
from collections import defaultdict

class Node:
    def __init__(self, v):
        self.v = v
        self.children = []

def build(li):
    nodes = [Node(x) for x in li]
    for i in range(1, len(li)):
        parent = (i - 1) // 2
        nodes[parent].children.append(nodes[i])
    return nodes[0]

def level_sums(node, level=0, acc=None):
    if acc is None:
        acc = defaultdict(int)
    if node is None:
        return acc
    acc[level] += node.v
    for c in node.children:
        level_sums(c, level + 1, acc)
    return acc

li = [5, 9, 2, 4, 7, 1, 3, 8]
root = build(li)
sums = level_sums(root)
# 레벨 순서대로 리스트로 변환
result = [sums[i] for i in range(max(sums.keys()) + 1)]
print(result)

```