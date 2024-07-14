# Count Items Matching a Rule

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of items

```java
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int idx = 0;
        if(ruleKey.equals("color")){
            idx = 1;
        }else if(ruleKey.equals("name")){
            idx = 2;
        }
        int res = 0;
        for(List<String> item: items){
            if(item.get(idx).equals(ruleValue)){
                res++;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of items

```java
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        HashMap<String, Integer> map = new HashMap();
        map.put("type", 0);
        map.put("color", 1);
        map.put("name", 2);
        int idx = map.get(ruleKey);
        int res =0 ;
        for(List<String> item: items){
            if(item.get(idx).equals(ruleValue)){
                res++;
            }
        }
        return res;
    }
}
```
