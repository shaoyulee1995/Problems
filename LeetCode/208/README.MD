# Implement Trie (Prefix Tree)

## insert

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of word

## search

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of word

## startsWith

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of prefix

```java
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a'] == null){
                return false;
            }
            node = node.children[c-'a'];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            if(node.children[c-'a'] == null){
                return false;
            }
            node = node.children[c-'a'];
        }
        return true;
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isWord;
    public TrieNode(){
        children = new TrieNode[26];
    }
}

```

```
Your Trie object will be instantiated and called as such:
Trie obj = new Trie();
obj.insert(word);
boolean param_2 = obj.search(word);
boolean param_3 = obj.startsWith(prefix);
```
