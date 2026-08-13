class Node:
    def __init__(self, key, value):
        self.key, self.value = key, value
        self.prev = self.nxt = None

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.left = Node(0, 0)
        self.right = Node(0, 0)
        self.left.nxt = self.right
        self.right.prev = self.left

    def remove(self, node):
        prv, nxt = node.prev, node.nxt
        prv.nxt = nxt
        nxt.prev = prv
        del node
    
    def insert(self, node):
        prv = self.right.prev
        prv.nxt = node
        self.right.prev = node
        node.nxt = self.right
        node.prev = prv

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        self.remove(self.cache[key])
        self.insert(self.cache[key])
        return self.cache[key].value

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.remove(self.cache[key])
        node = Node(key, value)
        self.cache[key] = node
        self.insert(node)
        if len(self.cache) > self.capacity:
            to_remove = self.cache.pop(self.left.nxt.key)
            self.remove(to_remove)

