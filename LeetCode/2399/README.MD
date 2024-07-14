# Check Distances Between Same Letters

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public boolean checkDistances(String s, int[] distance) {
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, i+1);
            }else{
                if(distance[c-'a'] != i-map.get(c)){
                    return false;
                }
            }
        }
        return true;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public boolean checkDistances(String s, int[] distance) {
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int d = distance[c-'a'];
            if(d == -1){
                continue;
            }
            if(i+d+1 >= s.length() || c != s.charAt(i+d+1)){
                return false;
            }
            distance[c-'a'] = -1;
        }
        return true;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(arr[c-'a'] != -1 && i - arr[c-'a'] != distance[c-'a']){
                return false;
            }
            arr[c-'a'] = i+1;
        }
        return true;
    }
}
```
