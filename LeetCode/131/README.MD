# Palindrome Partitioning

# Backtrack

- Time Complexity: O(N\*2^N)
- Space Complexity: O(N^2)
  - N as length of s

```
class Solution {
    List<List<String>> list = new ArrayList();
    LinkedList<String> path = new LinkedList();
    public List<List<String>> partition(String s) {
        if(s.length() == 0 || s == null){
            return list;
        }
        partitions(s, 0);
        return list;
    }
    public void partitions(String s, int index){
        if(index == s.length()){
            list.add(new ArrayList(path));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(!isPanlindrome(s, index, i)){
                continue;
            }
            path.add(s.substring(index, i + 1));
            partitions(s, i + 1);
            path.removeLast();
        }
    }
    public boolean isPanlindrome(String s, int low, int high){
        while(low < high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
```
