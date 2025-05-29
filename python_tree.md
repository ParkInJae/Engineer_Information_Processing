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