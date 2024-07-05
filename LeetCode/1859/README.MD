# Sorting the Sentence

- Time Complexity: O(S)
- Space Complexity: O(S)
  - S as length of s

```
class Solution {
    public String sortSentence(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, String> map = new HashMap();
        for(String str: strs){
            int idx = str.charAt(str.length()-1)-'0';
            map.put(idx, str.substring(0, str.length()-1));
        }
        for(int i = 0; i < strs.length; i++){
            sb.append(map.get(i+1));
            if(i != strs.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
```

- Time Complexity: O(S)
- Space Complexity: O(S)
  - S as length of s

```
class Solution {
    public String sortSentence(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        String[] res = new String[strs.length];
        for(String str: strs){
            int idx = str.charAt(str.length()-1)-'0';
            res[idx-1] = str.substring(0, str.length()-1);
        }
        for(int i = 0; i < strs.length; i++){
            sb.append(res[i]);
            if(i != strs.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
```
