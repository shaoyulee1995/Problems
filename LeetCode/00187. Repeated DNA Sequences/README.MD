# HashSet
* Time Complexity: O(NL)
* Space Complexity: O(NL)
	* N as length of s
	* L as length of DNA
```
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet(),
                        duplicated = new HashSet();
        for(int i = 0; i + 9 < s.length(); i++){
            String temp = s.substring(i, i+10);
            if(seen.contains(temp)){
                duplicated.add(temp);
            }
            seen.add(temp);
        }
        return new ArrayList(duplicated);
    }
}
```