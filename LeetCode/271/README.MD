# Encode and Decode Strings

- Time Complexity
  - encode:O(MN)
  - decode:O(MN)
- Space Complexity
  - encode:O(MN)
  - decode:O(MN)
    - N as length of strs
    - M as length of str

```java
public class Codec {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
          sb.append(str.length()).append('/').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList();
        int i = 0;
        while(i < s.length()){
          int slash = s.indexOf('/', i);
          int size = Integer.valueOf(s.substring(i, slash));
          i = slash+1+size;
          res.add(s.substring(slash+1, i));
        }
        return res;
    }
}
```
```
Your Codec object will be instantiated and called as such:
Codec codec = new Codec();
codec.decode(codec.encode(strs));
```
