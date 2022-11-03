class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity, count;
    private Map<Integer, Node> map;
    private Node head, tail;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
        this.capacity = capacity;
    }
    
    public void addNode(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            int result = node.value;
            
            // delete the node, and add it again, so it can be the next node of head
            deleteNode(node);
            addNode(node);
            return result;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            node.value = value;
            addNode(node);
        }
        else {
            Node node = new Node(key, value);
            if(map.size() == capacity) {
                System.out.println("capacity: "+ capacity);
                System.out.println("size: "+ map.size());
                map.remove(tail.prev.key);
                System.out.println("oversize");
                deleteNode(tail.prev);
            }
            addNode(node);
            map.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */