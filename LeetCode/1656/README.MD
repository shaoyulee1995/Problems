# Design an Ordered Stream

# Pointer

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class OrderedStream {
    int ptr = 0;
    String[] strs;
    public OrderedStream(int n) {
        strs = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        List<String> list = new ArrayList();
        strs[idKey-1] = value;
        while(ptr < strs.length && strs[ptr] != null){
            list.add(strs[ptr]);
            ptr++;
        }
        return list;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
```
