# HashMap
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> firstOccurance = new HashMap();
        for(int i = 0; i < s.length(); i++){
            firstOccurance.putIfAbsent(s.charAt(i), i);
        }
        int res = -1;
        for(int j = s.length()-1; j >= 0; j--){
            char c = s.charAt(j);
            if(firstOccurance.containsKey(c)){
                res = Math.max(res, j-firstOccurance.get(c)-1);
            }
        }
        return res;
    }
}
```
# Counting Array
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of s
```
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] cnt = new int[26];
        int res = -1;
        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            if(cnt[idx] > 0){
                res = Math.max(res, i-cnt[idx]);
            }else{
                cnt[idx] = i+1;
            }
        }
        return res;
    }
}
```