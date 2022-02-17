# HashSet
* Time Complexity: O(SW)
* Space Complexity: O(A)
	* S as length of strs
	* A as length of A
	* W as length of word
```
class Solution {
    public int countConsistentStrings(String A, String[] strs) {
        HashSet<Character> set = new HashSet();
        for(char c: A.toCharArray()){
            set.add(c);
        }
        int cnt = 0;
        for(String word: strs){
            cnt++;
            for(char c: word.toCharArray()){
                if(!set.contains(c)){
                    cnt--;
                    break;
                }
            }
        }
        return cnt;
    }
}
```