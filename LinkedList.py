class ListNode:
    prev = None
    next = None
    data = None

    def __init__(self, prev, next, data):
        self.prev = prev
        self.next = next
        self.data = data

class LList:
    head = ListNode(None,None,None)
    tail = ListNode(None,None,None)

    def __init__(self, startdata):
        startnode = ListNode(self.tail,self.head,startdata)
        self.head.next = startnode
        self.tail.prev = startnode

    def addFirst(self, data):
        node = ListNode(self.head, self.head.next, data)
        self.head.next.prev = node
        self.head.next = node

    def add(self, data):
        node = ListNode(self.tail.prev, self.tail, data)
        self.tail.prev.next = node
        self.tail.prev = node

    def addIn(self, index, data):
        count = 0
        current = self.head.next
        while count != index:
            current = current.next
            count += 1
        node = ListNode(current.prev, current, data)
        current.prev.next = node
        current.prev = node

    def addAll(self, collection):
        for data in collection:
            self.add(data)

    def addAllIn(self, index, collection):
        for data in collection:
            self.add(index, data)
            index += 1

    def contains(self,data):
        current = self.head.next
        while current.next != self.tail:
            if current.data == data:
                return True
            current = current.next
        return False

    def get(self, index):
        count = 0
        current = self.head.next
        while count != index:
            current = current.next
            count += 1
        return current

    def getFirst(self):
        return self.head.next

    def getLast(self):
        return self.tail.prev

    def indexOf(self, data):
        index = 0
        current = self.head.next
        while current != self.tail:
            if current.data == data:
                return index
            current = current.next
            index += 1
        return -1

    def print(self):
        current = self.head.next
        while current != self.tail:
            print(current.data)
            current = current.next

    def lastindexOf(self, data):
        index = -1
        count = 0
        current = self.head.next
        while current != self.tail:
            if data == current.data:
                index = count
            current = current.next
            count += 1
        return index


linked = LList(1)
linked.addAll([2,3,4,5,6,7,8,9,10])
linked.print()