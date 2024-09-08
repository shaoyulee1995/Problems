# Sum of Prefix Scores of Strings

- insert
  - Time Complexity: O(NW)
  - Space Complexity: O(NW)
- search
  - Time Complexity: O(NW)
  - Space Complexity: O(NW)
- N as length of words
- W as max length of word

```java
class Solution {
    TrieNode root;
    public int[] sumPrefixScores(String[] words) {
        root = new TrieNode();
        for(String word: words){
            insert(word);
        }
        int[] res = new int[words.length];
        for(int i = 0; i < words.length; i++){
            res[i] = search(words[i]);
        }
        return res;
    }

    public void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
            node.cnt++;
        }
    }

    public int search(String prefix){
        TrieNode node = root;
        int res = 0;
        for(char c: prefix.toCharArray()){
            if(node.children[c-'a'] == null){
                return res;
            }
            node = node.children[c-'a'];
            res += node.cnt;
        }
        return res;
    }
}

class TrieNode{
    TrieNode[] children;
    int cnt;
    public TrieNode(){
        children = new TrieNode[26];
    }
}
```
