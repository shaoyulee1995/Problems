class OrderedStream {
    
    int ptr;
    String[] str;
    public OrderedStream(int n) {
        str = new String[n];
        ptr = 0;
    }
    
    public List<String> insert(int idKey, String value) {
        str[idKey - 1] = value;
        List<String> list = new ArrayList<>();
       
        if(idKey - 1 > ptr){
            return list;
        }
        while(ptr < str.length && str[ptr] != null){
            list.add(str[ptr++]);
         
        }
        return list;
    }
}
/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
