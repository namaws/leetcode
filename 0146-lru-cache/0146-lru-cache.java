class LRUCache {
    private final int capacity;

    class Node {
        int key, value;
        Node prev, next;
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node tail, head;
    Map<Integer, Node> map;

    //initialize LRUCache
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        tail = new Node(0, 0);
        head = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        //remove the exisiting key Node, then put the key Node at head
        Node node = map.get(key);
        remove(node);
        insertToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            node.value = value; //update the value -> don't need to update in the map, as object is by reference
            insertToHead(node);
            //map.put(key, node); //update in the map
        }
        else {
            if(map.size() == capacity) {
                map.remove(tail.prev.key);
                //remove the least recent used node at tail
                remove(tail.prev);
            }
            Node node = new Node(key, value);
            insertToHead(node);
            map.put(key, node);
        }
    }

    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void insertToHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */