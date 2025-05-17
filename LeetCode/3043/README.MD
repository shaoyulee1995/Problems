# Find the Length of the Longest Common Prefix

- Time Complexity: O(Max(M, N)*L)
- Space Complexity: O(N*L)
  - M as length of arr1
  - N as length of arr2
  - L as number of digits

```java
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> seen = new HashSet();
        for(int num: arr1){
            String strNum = ""+num;
            StringBuilder prefix = new StringBuilder();
            for(char c: strNum.toCharArray()){
                prefix.append(c);
                seen.add(prefix.toString());
            }
        }
        int res = 0;
        for(int num: arr2){
            String strNum = ""+num;
            StringBuilder prefix = new StringBuilder();
            for(char c: strNum.toCharArray()){
                prefix.append(c);
                if(seen.contains(prefix.toString())){
                    res = Math.max(res, prefix.length());
                }
            }
        }
        return res;
    }
}
```

- Time Complexity: O(Max(M, N)*L)
- Space Complexity: O(N*L)
  - M as length of arr1
  - N as length of arr2
  - L as number of digits

```java
class Solution {
    class TrieNode{
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[10];
        }
    }

    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void insert(int num){
            TrieNode node = root;
            String strNum = ""+num;
            for(char c: strNum.toCharArray()){
                if(node.children[c-'0'] == null){
                    node.children[c-'0'] = new TrieNode();
                }
                node = node.children[c-'0'];
            }
        }

        public int getLength(int num){
            int res = 0;
            TrieNode node = root;
            String strNum = ""+num;
            for(char c: strNum.toCharArray()){
                if(node.children[c-'0'] == null){
                    break;
                }
                node = node.children[c-'0'];
                res++;
            }
            return res;
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        for(int num: arr1){
            trie.insert(num);
        }
        int res = 0;
        for(int num: arr2){
            res = Math.max(res, trie.getLength(num));
        }
        return res;
    }
}
```