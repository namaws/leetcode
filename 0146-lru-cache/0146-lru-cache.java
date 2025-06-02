class LRUCache {

    class Node {
        Node prev, next;
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    Node tail, head;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        map = new HashMap();
        tail = new Node(0, 0);
        head = new Node(0, 0);
        this.capacity = capacity;
        tail.next = null;
        tail.prev = head;
        head.prev = null;
        head.next = tail;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        //remove the existing key Node, then put the key Node at head
        Node node = map.get(key);
        removeNode(node);
        insertHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            node.value = value;
            insertHead(node);
        }
        else {
            if(map.size()==capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            Node node = new Node(key, value);
            insertHead(node);
            map.put(key, node);
        }
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void insertHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */