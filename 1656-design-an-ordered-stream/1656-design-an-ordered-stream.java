class OrderedStream {
    private int nextKey;
    private String[] arr;
    public OrderedStream(int n) {
        //use key as index, -> index start from 1
        this.nextKey = 1;
        arr = new String[n+1];
    }
    
    public List<String> insert(int idKey, String value) {
        arr[idKey] = value;
        List<String> answer = new ArrayList();
        int key = nextKey;
        while(key < arr.length && arr[key] != null) {
            answer.add(arr[key]);
            key++;
        }
        nextKey = key;
        return answer;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */